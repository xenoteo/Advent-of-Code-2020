package xenoteo.com.github.day21.part2;

import xenoteo.com.github.day21.InputReader;

public class Main {
    public static void main(String[] args) {
        String filePath = "../input/input.txt";
        InputReader reader = new InputReader();
        reader.readInputFile(Main.class.getResource(filePath));
        System.out.println(new Solution()
                .canonicalDangerousIngredientList(
                        reader.getIngredients(),
                        reader.getAllergens()
                ));

    }
}
