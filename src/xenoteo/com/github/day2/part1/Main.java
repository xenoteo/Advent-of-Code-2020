package xenoteo.com.github.day2.part1;


import xenoteo.com.github.day2.InputReader;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        reader.readInputFile("/home/xeno/xWs/Java/Advent-2020/src/xenoteo/com/github/day2/input.txt");
        System.out.println(new Solution()
                .countValidPasswords(
                        reader.getLowests(),
                        reader.getHighests(),
                        reader.getLetters(),
                        reader.getPasswords()
                ));
    }
}
