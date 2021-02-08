# Advent of Code 2020
[Advent of Code 2020](https://adventofcode.com/2020).

## Project structure
<pre>
xenoteo.com.github
└── dayN
|   ├── input
|   |   └── input.txt
|   ├── part1
|   │   ├── Main.java
|   │   └── Solution.java
|   ├── part2
|   │   ├── Main.java
|   │   └── Solution.java
|   └── README.md
└── InputReader.java
</pre>
In `day` packages the one general structure is kept.  
  
In the `input` folder there always is the main `input.txt` file, but there could be more input samples in other files.  
  
In `part1` and `part2` folders there are `Main.java` and `Solution.java` files. The `Main` class is always responsible for displaying the problem’s solution. In `Solution` class the only public method is the main method implemented to solve the problem, the other methods (if there are) are helpers.  
  
There also provided a `README` file to each of the days.  
  
If some special input is provided, in the day package can be located the `InputReader.java` class responsible for reading data from the input file of the certain day.
  
Additionally in the day package (or part of the day package, depending on problem) some helpers classes can also be found.  
  
There is one general `InputReader` class, which reads simple input data and is used for many days.  

## Problems
Short descriptions of problems. Complete problem contents can be found in README files of day packages.
- \[[day 1](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day1)\]
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day1/part1/Solution.java)\] - finding the two entries that sum to x and then multiply those two numbers together.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day1/part2/Solution.java)\] - finding the three entries that sum to x and then multiply those three numbers together.
- \[[day 2](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day2)\] - each line gives the password policy and then the password. Counting how many passwords are valid according to the policies.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day2/part1/Solution.java)\] - the password policy indicates the lowest and highest number of times a given letter must appear for the password to be valid.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day2/part2/Solution.java)\] - each policy describes two positions in the password, where 1 means the first character. Exactly one of these positions must contain the given letter.
- \[[day 3](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day3)\] - having a map of the open squares (.) and trees (#). These aren't the only trees, though; the same pattern repeats to the right many times.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day3/part1/Solution.java)\] - counting how many trees can be encountered starting at the top-left corner of the map and following a slope of right 3 and down 1.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day3/part2/Solution.java)\] - counting how many trees can be encountered starting at the top-left corner of the map and following given slopes, and then multiplying founded results together.
- \[[day 4](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day4)\] - having a list of passport data counting how many from them are valid.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day4/part1/Solution.java)\] - passport is valid when all eight fields are present or when the only missing field is cid.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day4/part2/Solution.java)\] - passport is valid when all eight fields are present or when the only missing field is cid,and each field has strict rules about what values are valid for automatic validation
- \[[day 5](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day5)\] - decoding airplane pass. Instead of zones or groups, the airline uses binary space partitioning to seat people. A seat might be specified like FBFBBFFRLR, where F means "front", B means "back", L means "left", and R means "right".
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day5/part1/Solution.java)\] - finding the maximum pass ID from given passes.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day5/part2/Solution.java)\] - finding the only one free pass ID from given passes (not at the very front or back).
- \[[day 6](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day6)\] - the form asks a series of 26 yes-or-no questions marked a through z. Identifying the questions for which people from a group answered "yes".
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day6/part1/Solution.java)\] - finding a sum of group's counts of questions for which anyone in a group answered "yes".
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day6/part2/Solution.java)\] - finding a sum of group's counts of questions for which everyone in a group answered "yes".
- \[[day 7](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day7)\] - given rules specifying the required contents of colored bags (bags must be color-coded and must contain specific quantities of other color-coded bags).
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day7/part1/Solution.java)\] - counting how many bag colors can eventually contain at least one shiny gold bag.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day7/part2/Solution.java)\] - counting how many individual bags are required inside a single shiny gold bag.
- \[[day 8](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day8)\] - the boot code is represented as a text file with one instruction per line of text. Each instruction consists of an operation (acc, jmp, or nop) and an argument (a signed number like +4 or -20). Program contains infinite loop.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day8/part1/Solution.java)\] - finding what value is in the accumulator immediately before infinite loop starts.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day8/part2/Solution.java)\] - fixing a program and finding what the value of the accumulator is after the program terminates.
- \[[day 9](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day9)\] - XMAS (eXchange-Masking Addition System) starts by transmitting a preamble of 25 numbers. After that, each number should be the sum of any two of the 25 immediately previous numbers.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day9/part1/Solution.java)\] - finding the first invalid number, that is number that cannot be made by sum of any two of the 25 immediately previous numbers.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day9/part2/Solution.java)\] - finding encryption weakness, that is a sum of the smallest and largest number in a contiguous set of at least two numbers in a list which sum to the invalid number.
- \[[day 10](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day10)\] - given a list of all of the joltage adapters in a bag. Each of joltage adapters is rated for a specific output joltage. Any given adapter can take an input 1, 2, or 3 jolts lower than its rating and still produce its rated output joltage. In addition, the device has a built-in joltage adapter rated for 3 jolts higher than the highest-rated adapter in the bag. The charging outlet has an effective joltage rating of 0.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day10/part1/Solution.java)\] - finds the number of 1-jolt differences multiplied by the number of 3-jolt differences.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day10/part2/Solution.java)\] - counts the total number of distinct ways of adapter arrangements.
- \[[day 11](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day11)\] - the seat layout fits neatly on a grid. Each position is either floor (.), an empty seat (L), or an occupied seat (#). Running seats rearrangements according to required rules. Simulating the seating area by applying the seating rules repeatedly until no seats change state.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day11/part1/Solution.java)\] - all decisions are based on the number of occupied seats adjacent to a given seat.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day11/part2/Solution.java)\] - all decisions are based on the number of the first seats seen in each of eight directions.
- \[[day 12](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day12)\] - the navigation instructions consists of a sequence of single-character actions paired with integer input values. Finding the Manhattan distance between the final location and the ship's starting position.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day12/part1/Solution.java)\] - moving a ship according to provided list of actions.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day12/part2/Solution.java)\] - moving a ship with its waypoint according to provided list of actions.
- \[[day 13](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day13)\] - each bus has an ID number that also indicates how often the bus leaves for the airport.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day13/part1/Solution.java)\] - having the earliest timestamp you could depart on a bus, finding the ID of the earliest bus you can take to the airport multiplied by the number of minutes you'll need to wait for that bus.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day13/part2/Solution.java)\] - finding the earliest timestamp such that all of the listed bus IDs depart at offsets matching their positions in the list.
- \[[day 14](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day14)\] - the bitmask is always given as a string of 36 bits, written with the most significant bit on the left and the least significant bit on the right. A bitmask act as a decoder.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day14/part1/Solution.java)\] - the current bitmask is applied to values immediately before they are written to memory.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day14/part2/Solution.java)\] - immediately before a value is written to memory, each bit in the bitmask modifies the corresponding bit of the destination memory address.
- \[[day 15](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day15)\] - in the game, the players take turns saying numbers. Each turn consists of considering the most recently spoken number. Each turn results in that player speaking aloud either 0 (if the last number is new) or an age (if the last number is a repeat).
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day15/part1/Solution.java)\] - finding what number will be the 2020th number spoken.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day15/part2/Solution.java)\] - finding what number will be the 30000000th number spoken.
- \[[day 16](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day16)\] - the rules for ticket fields specify a list of fields that exist somewhere on the ticket and the valid ranges of values for each field. Each ticket is represented by a single line of comma-separated values.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day16/part1/Solution.java)\] - determining which tickets are completely invalid; these are tickets that contain values which aren't valid for any field. Adding together all of the invalid values.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day16/part2/Solution.java)\] - determining which field is which and finding a multiplication of 6 departure values.
- \[[day 17](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day17)\]
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day17/part1/Solution.java)\] - 3D Game of Life
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day17/part2/Solution.java)\] - 4D Game of Life
- \[[day 18](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day18)\] - expressions consist of addition (+), multiplication (\*), and parentheses ((...)). Just like normal math, parentheses indicate that the expression inside must be evaluated before it can be used by the surrounding expression. The rules of operator precedence have changed.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day18/part1/Solution.java)\] - the operators have the same precedence, and are evaluated left-to-right regardless of the order in which they appear.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day18/part2/Solution.java)\] - rather than evaluating multiplication before addition, addition is evaluated before multiplication.
- \[[day 19](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day19)\] - the rules for valid messages are numbered and build upon each other. Determining the number of messages that completely match rule 0.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day19/part1/Solution.java)\] - there are no loops in the rules.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day19/part2/Solution.java)\] - some of the rules do contain loops.
- \[[day 20](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day20)\] - the camera array consists of many cameras; rather than produce a single square image, they produce many smaller square image tiles that need to be reassembled back into a single image.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day20/part1/Solution.java)\] - multiplying together the IDs of the four corner tiles.
- \[[day 21](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day21)\] - given the list of ingredients in unknown language and the list of allergens contained by the ingredients in English.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day21/part1/Solution.java)\] - counting the occurrences of ingredients that cannot possibly contain any of the allergens in the english list of allergens.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day21/part2/Solution.java)\] - arranging the ingredients alphabetically by their allergen and separating them by commas to produce the canonical dangerous ingredient list.
- \[[day 22](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day22)\]
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day22/part1/Solution.java)\] - playing a game of Combat.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day22/part2/Solution.java)\] - playing a game of Recursive Combat.
- \[[day 23](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day23)\] - playing a game of Crab's mixing cups.
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day23/part1/Solution.java)\] - there are only 9 cups and 100 moves.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day23/part2/Solution.java)\] - there are 1000000 cups and 10000000 moves.
- \[[day 24](https://github.com/xenoteo/Advent-2020/tree/master/src/xenoteo/com/github/day24)\]
  - \[[part 1](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day24/part1/Solution.java)\] - flipping hexagonal tiles.
  - \[[part 2](https://github.com/xenoteo/Advent-2020/blob/master/src/xenoteo/com/github/day24/part2/Solution.java)\] - hexagonal Game of Life.
