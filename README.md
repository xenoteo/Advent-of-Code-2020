# Advent 2020
[Advent od Code 2020](https://adventofcode.com/2020).

## Problems
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
