package xenoteo.com.github.day21.part1;

import xenoteo.com.github.day21.InputReader;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        InputReader reader = new InputReader();
        reader.readInputFile(Main.class.getResource(filePath));
        System.out.println(new Solution()
                .countOccurrencesOfIngredientsNotFromEnglishList(
                        reader.getIngredients(),
                        reader.getAllergens()
                ));

    }
}
