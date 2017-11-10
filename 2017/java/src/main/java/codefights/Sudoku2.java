package codefights;// https://codefights.com/interview-practice/task/SKZ45AF99NpbnvgTn/description
/*
Sudoku is a number-placement puzzle.
The objective is to fill a 9 × 9 grid with numbers in such a way that each column,
 each row,
  and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from 1 to 9 one time.

Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle according
to the layout rules described above.

 Note that the puzzle represented by grid does not have to be solvable.

 Input/Output

[time limit] 3000ms (java)
[input] array.array.char grid

A 9 × 9 array of characters, in which each character is either a digit from '1' to '9' or a period '.'.

[output] boolean

Return true if grid represents a valid Sudoku puzzle, otherwise return false.
 */

public class Sudoku2 {
    boolean sudoku2(char[][] grid) {
        return checkAll3x3(grid) && checkLines(grid);
    }

    boolean checkLines(char[][] grid) {
        for (int i = 0; i < 9; i++) {
            if (!checkLine(grid, i, true) || !checkLine(grid, i, false)) {
                return false;
            }
        }

        return true;
    }

    boolean checkLine(char[][] grid, int i, boolean horizontal) {
        boolean duplicates[] = new boolean[9];

        int value;

        for (int j = 0; j < 9; j++) {
            if (horizontal) {
                value = value(grid[i][j]);
            } else {
                value = value(grid[j][i]);
            }

            if (value > 0) {
                if (isDuplicate(duplicates, value)) {
                    return false;
                } else {
                    duplicates[value - 1] = true;
                }
            }
        }

        return true;
    }


    boolean checkAll3x3(char[][] grid) {
        // 9 operations total here.
        //  O(1) time
        //  O(1) space as I did not create any var
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                if (!check3x3(grid, j, i)) {
                    return false;
                }
            }

        }
        return true;
    }

    boolean check3x3(char[][] grid, int x, int y) {
        // [['.', '.', '.', '1', '4', '.', '.', '2', '.'],
        // ['.', '.', '6', '.', '.', '.', '.', '.', '.'],
        // ['.', '.', '.', '.', '.', '.', '.', '.', '.'],
        // ['.', '.', '1', '.', '.', '.', '.', '.', '.'],
        // ['.', '6', '7', '.', '.', '.', '.', '.', '9'],
        // ['.', '.', '.', '.', '.', '.', '8', '1', '.'],
        // ['.', '3', '.', '.', '.', '.', '.', '.', '6'],
        // ['.', '.', '.', '.', '.', '7', '.', '.', '.'],
        // ['.', '.', '.', '5', '.', '.', '.', '7', '.']]

        // O(9) in space here
        boolean duplicates[] = new boolean[9];

        for (int i = x; i < x + 3; i++) {
            for (int j = y; j < y + 3; j++) {
                int value = value(grid[j][i]);
//                System.out.println(grid[j][i] + " " + i + ", " + j);
                if (value > 0) {
                    if (isDuplicate(duplicates, value)) {
                        return false;
                    } else {
                        duplicates[value - 1] = true;
                    }
                }
            }
        }

        return true;

        // grid[y][x];
        // grid[y][x+1];
        // grid[y][x+2];
        // grid[y+1][x];
        // grid[y+1][x + 1];
        // grid[y+1][x + 2];
        // grid[y+2][x];
        // grid[y+2][x + 1];
        // grid[y+2][x + 2];
    }

    boolean isDuplicate(boolean[] duplicates, int value) {
        return value > 0 && duplicates[value - 1];

    }

    int value(char c) {
        if (c != '.') {
            return c - 48;
        }
        return -1; // invalid value
    }
}
