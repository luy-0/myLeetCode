/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    private int[][] board;
    private int[] dx = { -1, -1, -1, 0, 0, 1, 1, 1 };
    private int[] dy = { -1, 0, 1, -1, 1, -1, 0, 1 };
    private int liveCells, rows, cols;

    public void gameOfLife(int[][] board) {
        /*
         * 状态说明 0: 00 死->死 1: 01 活->死 2: 10 死->活 3: 11 活->活
         */
        this.board = board;
        rows = board.length;
        cols = board[0].length;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                // 统计周围活细胞
                liveCells = countCells(row, col);
                // 更新当前状态
                // 如果细胞死亡,则0还是0,1还是1,无需转换
                if (liveCells < 2 || liveCells > 3) {
                    continue;
                }
                // 如果当前细胞继续存活,1->3
                if (board[row][col] == 1 && (liveCells == 2 || liveCells == 3)) {
                    board[row][col] = 3;
                }
                // 如果复活,0->2
                if (board[row][col] == 0 && liveCells == 3) {
                    board[row][col] = 2;
                }
            }
        }

        // 最后处理列表,01死23活
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                board[row][col] /= 2;
            }
        }

    }

    private int countCells(int row, int col) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nx = row + dx[i];
            int ny = col + dy[i];
            if (nx < 0 || nx >= rows || ny < 0 || ny >= cols) {
                continue;
            }
            // 状态为1或3时计数
            if (board[nx][ny] % 2 == 1) {
                count++;
            }
        }
        return count;
    }
}
// @lc code=end
