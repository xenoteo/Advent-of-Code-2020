package xenoteo.com.github.day21.part1;

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
 * The first step is to determine which ingredients can't possibly contain any of the allergens in any food in your list.
 *
 * Class determine which ingredients cannot possibly contain any of the allergens in your list and
 * counting how many times any of those ingredients appear.
 */
public class Solution {

    /**
     * Counts the occurrences of ingredients that cannot possibly contain any of the allergens in the english list of allergens.
     *
     * The array of ingredients at index i corresponds to the array of allergens at index i.
     *
     * @param ingredients  the list of ingredients arrays in unknown language
     * @param allergens  the list of allergens arrays in English
     * @return the number of occurrences of requested ingredients
     */
    public int countOccurrencesOfIngredientsNotFromEnglishList(List<String[]> ingredients, List<String[]> allergens){
        HashMap<String, String> dictionary = findDictionary(ingredients, allergens);
        return (int) ingredients.stream()
                .flatMap(Stream::of)
                .filter(ingredient -> !dictionary.containsValue(ingredient))
                .count();
    }

    /**
     * Finds a dictionary from ingredients to its allergens.
     *
     * @param ingredients  the list of ingredients arrays in unknown language
     * @param allergens  the list of allergens arrays in English
     * @return the dictionary from ingredients to its allergens
     */
    private HashMap<String, String> findDictionary(List<String[]> ingredients, List<String[]> allergens){
        HashMap<String, Set<String>> listDictionary = findListDictionary(ingredients, allergens);
        reduceAmbiguities(listDictionary);
        return convertListDictionaryToDictionary(listDictionary);
    }

    /**
     * Finds a dictionary from ingredients to the set of its possible allergens.
     *
     * @param ingredients  the list of ingredients arrays in unknown language
     * @param allergensList  the list of allergens arrays in English
     * @return the dictionary from ingredients to the set of its possible allergens
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
     * @param listDictionary  the dictionary from ingredients to the set of its possible allergens
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
     * @param listDictionary  the dictionary from ingredients to the set of its possible allergens
     * @return the dictionary from ingredient to its allergens
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
