package LeetCode.HashTable.P36_Valid_Sudoku;
import java.util.*;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    int cur_value = board[i][j];
                    String row_str = cur_value + " in row " + i;
                    String col_str = cur_value + " in col " + j;
                    String box_str = cur_value + " in box " + i/3 + "-" + j/3;
                    if(seen.contains(row_str) || seen.contains(col_str) || seen.contains(box_str)) return false;

                    seen.add(row_str);
                    seen.add(col_str);
                    seen.add(box_str);

                }
            }
        }

        return true;
    }
}
