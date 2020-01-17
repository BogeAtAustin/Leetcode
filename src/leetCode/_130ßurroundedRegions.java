package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class _130ßurroundedRegions {


    //BFS
    //有意思的地方在于这题标记的是所有不需要改变的（在边上的O）如果标记需要改变的（在里面的O）一旦BFS扫描到与边联通时，之前的标记过的都得改回来。
    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        Queue<Integer> queue = new LinkedList<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && (i == 0 || i == m - 1 || j == 0 || j == n - 1)) {

                    board[i][j] = 'T';
                    queue.offer(i * n + j);

                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int k = 0; k < size; k++) {
                            int index = queue.poll();
                            int x = index / n;
                            int y = index % n;

                            if (x - 1 >= 0 && board[x - 1][y] == 'O') {
                                board[x - 1][y] = 'T';
                                queue.offer((x - 1) * n + y);
                            }
                            if (x + 1 < m && board[x + 1][y] == 'O') {

                                board[x + 1][y] = 'T';
                                queue.offer((x + 1) * n + y);
                            }
                            if (y - 1 >= 0 && board[x][y - 1] == 'O') {

                                board[x][y - 1] = 'T';
                                queue.offer(x * n + y - 1);
                            }
                            if (y + 1 < n && board[x][y + 1] == 'O') {

                                board[x][y + 1] = 'T';
                                queue.offer(x * n + y + 1);
                            }
                        }

                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
