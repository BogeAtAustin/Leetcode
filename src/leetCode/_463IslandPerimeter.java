package leetCode;

import java.util.ArrayList;
import java.util.List;

public class _463IslandPerimeter {

    public int islandPerimeter(int[][] grid) {
        List<Integer> list = new ArrayList<>();
        int width = grid[0].length, len = grid.length;
        int total = 0;
        for(int i = 0; i < len; i++){
            for(int j = 0; j < width; j++){
                if(grid[i][j] == 1){
                    if(i == 0 || grid[i - 1][j] == 0) total++;
                    if(i == len - 1 || grid[i + 1][j] == 0) total++;
                    if(j == 0 || grid[i][j - 1] == 0) total++;
                    if(j == width - 1 || grid[i][j + 1] == 0) total++;
                }
            }
        }
        return total;
    }
}
