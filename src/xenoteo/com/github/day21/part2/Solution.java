package xenoteo.com.github.day21.part2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Each allergen is found in exactly one ingredient. Each ingredient contains zero or one allergen.
 * Allergens aren't always marked; when they're listed (as in (contains nuts, shellfish) after an ingredients list),
 * the ingredient that contains each listed allergen will be somewhere in the corresponding ingredients list.
 * However, even if an allergen isn't listed, the ingredient that contains that allergen could still be present:
 * maybe they forgot to label it, or maybe it was labeled in a language you don't know.
 *
 * Example of the list of foods:
 * <pre>
 *     mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
 *     trh fvjkl sbzzf mxmxvkd (contains dairy)
 *     sqjhc fvjkl (contains soy)
 *     sqjhc mxmxvkd sbzzf (contains fish)
 * </pre>
 *
 * Class arranging the ingredients alphabetically by their allergen and separating them by commas to produce
 * the canonical dangerous ingredient list.
 */
public class Solution {

    /**
     * Founded the dictionary from allergens to ingredients, arranges the ingredients alphabetically by their allergen
     * and separates them by commas to produce the canonical dangerous ingredient list.
     *
     * @param ingredients  the list of ingredients arrays in unknown language
     * @param allergens  the list of allergens arrays in English
     * @return the canonical dangerous ingredient list
     */
    public String canonicalDangerousIngredientList(List<String[]> ingredients, List<String[]> allergens){
        HashMap<String, String> dictionary = findDictionary(ingredients, allergens);
        return dictionary.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .map(Map.Entry::getValue)
                .collect(Collectors.joining(","));
    }

    /**
     * Finds a dictionary from allergens to ingredients containing them.
     *
     * @param ingredients  the list of ingredients arrays in unknown language
     * @param allergens  the list of allergens arrays in English
     * @return the dictionary from allergens to ingredients containing them
     */
    private HashMap<String, String> findDictionary(List<String[]> ingredients, List<String[]> allergens){
        HashMap<String, Set<String>> listDictionary = findListDictionary(ingredients, allergens);
        reduceAmbiguities(listDictionary);
        return convertListDictionaryToDictionary(listDictionary);
    }

    /**
     * Finds a dictionary from allergens to the set of ingredients that possibly can contain the allergen.
     *
     * @param ingredients  the list of ingredients arrays in unknown language
     * @param allergensList  the list of allergens arrays in English
     * @return the dictionary from allergens to the set of ingredients that possibly can contain the allergen
     */
    private HashMap<String, Set<String>> findListDictionary(List<String[]> ingredients, List<String[]> allergensList){
        HashMap<String, Set<String>> listDictionary = new HashMap<>();
        for (String[] allergens : allergensList) {
            Arrays.stream(allergens)
                    .filter(word -> !listDictionary.containsKey(word))
                    .forEach(word -> listDictionary.put(word, findCommonIngredients(ingredients, allergensList, word)));
        }
        return listDictionary;
    }

    /**
     * Reduces ambiguities from the list dictionary map,
     * that is leads to the situation where there is only one element in every set.
     *
     * @param listDictionary  the dictionary from allergens to the set of ingredients that possibly can contain the allergen
     */
    private void reduceAmbiguities(HashMap<String, Set<String>> listDictionary){
        while (listDictionary.values().stream().anyMatch(set -> set.size() > 1)){
            Set<String> uniqueWords = listDictionary.values().stream()
                    .filter(set -> set.size() == 1)
                    .map(set -> set.iterator().next())
                    .collect(Collectors.toSet());
            List<Set<String>> ambiguousSets = listDictionary.values().stream()
                    .filter(set -> set.size() > 1)
                    .collect(Collectors.toList());
            ambiguousSets.forEach(set -> set.removeAll(uniqueWords));
        }
    }

    /**
     * Converts a map of sets containing one string to a map of strings.
     *
     * @param listDictionary  the dictionary from allergens to the set of ingredients that possibly can contain the allergen
     * @return the dictionary from allergens to ingredients containing them
     */
    private HashMap<String, String> convertListDictionaryToDictionary(HashMap<String, Set<String>> listDictionary){
        HashMap<String, String> dictionary = new HashMap<>();
        listDictionary.keySet().forEach(key -> dictionary.put(key, listDictionary.get(key).iterator().next()));
        return dictionary;
    }

    /**
     * Finds a set of common ingredients for the products containing provided allergen.
     *
     * @param ingredients  the list of ingredients arrays in unknown language
     * @param allergens  the list of allergens arrays in English
     * @param allergen  the allergen
     * @return the set of common ingredients for the products containing provided allergen
     */
    private Set<String> findCommonIngredients(List<String[]> ingredients, List<String[]> allergens, String allergen){
        List<String[]> filteredList = ingredients.stream()
                .filter(words -> Arrays.asList(allergens.get(ingredients.indexOf(words)))
                        .contains(allergen))
                .collect(Collectors.toList());
        return filteredList.stream()
                .flatMap(Stream::of)
                .filter(word -> filteredList.stream().allMatch(array -> Arrays.asList(array).contains(word)))
                .collect(Collectors.toSet());
    }
}
