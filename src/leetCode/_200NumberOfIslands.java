package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _200NumberOfIslands {

    //200 Number of Island
    //有三种方法，DFS用递归，BFS用队列Queue，相同的都是对edge case的处理
    //其中用Queue存index有两种方法，其一只存数字 i * n + j, 一种是存入一个index数组
    //Union Find 先把都是1的坐标用root数组初始化为坐标数字，意味着该元素的root是自身，
    //再重新扫描数组，把不同root但相连的元素root统一起来，最后剩下具有unique root的元素个数
    public int numIslands1(char[][] map){
        if(map == null || map.length == 0 || map[0].length == 0){
            return 0;
        }
        int result = 0;
        int m = map.length;
        int n = map[0].length;
        boolean[][] visited = new boolean[m][n];
        //Arrays.fill(visited,false);

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(map[i][j] == '1' && visited[i][j] == false){
                    dfs(visited, map, i, j);
                    result++;

                }
            }
        }
        return result;
    }

    private void dfs(boolean[][] visited, char[][] map, int x, int y){
        int m = map.length;
        int n = map[0].length;

        if(x < 0 || x == m || y < 0 || y == n || map[x][y] != '1' || visited[x][y] == true){
            return;
        }

        visited[x][y] = true;
        dfs(visited, map, x - 1, y);
        dfs(visited, map, x + 1, y);
        dfs(visited, map, x , y - 1);
        dfs(visited, map, x, y + 1);
    }

    //BFS using Queue
    public int numIslands2(char[][] grid) {
        // edge case 是必须的，尽管你可能这时纠结于主要思路
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    grid[i][j] = '0';
                    Queue<Integer> queue = new LinkedList<>();
                    //把二维坐标储存进container里，再还原出来
                    queue.add(i * n + j);
                    while(!queue.isEmpty()){
                        int idx = queue.poll();
                        int row = idx / n;
                        int col = idx % n;
                        if(row - 1 >= 0 && grid[row - 1][col] == '1'){
                            grid[row - 1][col] = '0';
                            queue.add((row - 1) * n + col);
                        }
                        if(row + 1 < m && grid[row + 1][col] == '1'){
                            grid[row + 1][col] = '0';
                            queue.add((row + 1) * n + col);
                        }
                        if(col - 1 >= 0 && grid[row][col -1] == '1'){
                            grid[row][col - 1] = '0';
                            queue.add(row * n + col - 1);
                        }
                        if(col + 1 < n && grid[row][col + 1] == '1'){
                            grid[row][col + 1] = '0';
                            queue.add(row * n + col + 1);
                        }
                    }
                }
            }
        }
        return count;
    }

    //BFS2
    public int numIslands3(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[] dr = {1, -1, 0 ,0};
        int[] dc = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    count++;
                    queue.offer(new int[]{i, j});
                    merge(grid, queue, dr, dc);
                }
            }
        }
        return count;
    }

    public void merge(char[][] grid, Queue<int[]> queue, int[] dr, int[] dc){
        int m = grid.length;
        int n = grid[0].length;

        while(!queue.isEmpty()){
            int[] point = queue.poll();
            for(int i = 0; i < 4; i++){
                int r = dr[i] + point[0];
                int c = dc[i] + point[1];

                if(r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != '1') continue;
                grid[r][c] = '0';
                queue.offer(new int[]{r, c});
            }
        }
    }

    //Union Find
    public int numIslands4(char[][] grid) {
        if(grid == null ||grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[] root = new int[m * n];
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    root[i * n + j] = i * n + j;
                    count++;
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    for(int k = 0; k < 4; k++){
                        int x = dr[k] + i;
                        int y = dc[k] + j;

                        if(x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != '1'){
                            continue;
                        }
                        int root1 = getRoot(root, i * n + j);
                        int root2 = getRoot(root, x * n + y);
                        if(root1 != root2){
                            root[root1] = root[root2];
                            count--;
                        }
                    }
                }
            }
        }
        return count;
    }
    private int getRoot(int[] root, int i){
        while(root[i] != i){
            i = root[i];
        }
        return i;
    }
}
