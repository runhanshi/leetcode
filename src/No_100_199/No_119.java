package No_100_199;

import java.util.ArrayList;
import java.util.List;

// No.119.Pascal's Triangle II
// https://leetcode.com/problems/pascals-triangle-ii/
public class No_119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> curRow = new ArrayList<>();
        curRow.add(1);
        if(rowIndex == 0) return curRow;

        List<Integer> preRow = getRow(rowIndex - 1);
        for (int i = 0; i < preRow.size() - 1; i++){
            curRow.add(preRow.get(i) + preRow.get(i + 1));
        }
        curRow.add(1);
        return curRow;
    }
}
