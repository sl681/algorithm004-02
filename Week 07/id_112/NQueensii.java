package datastruct.bitOperation;

/**
 *
 * 52. N皇后 II
 * 使用 bitmap 回溯
 如果你是在面试中 - 使用方法 1。
 下面的算法有着相同的时间复杂度 \mathcal{O}(N!)O(N!)。但是由于使用了位运算，可以运行得更快。

 感谢这个算法的提出者 takaken.

 为了便于理解该算法，下面的代码进行了逐步解释。
 */
public class NQueensii {

    public int backtrack(int row, int hills, int next_row, int dales, int count, int n) {

        /**
         row: 当前放置皇后的行号
         hills: 主对角线占据情况 [1 = 被占据，0 = 未被占据]
         next_row: 下一行被占据的情况 [1 = 被占据，0 = 未被占据]
         dales: 次对角线占据情况 [1 = 被占据，0 = 未被占据]
         count: 所有可行解的个数
         */

        // 棋盘所有的列都可放置，
        // 即，按位表示为 n 个 '1'
        // bin(cols) = 0b1111 (n = 4), bin(cols) = 0b111 (n = 3)
        // [1 = 可放置]
        int columns = (1<<n) - 1;

        if (row == n) // 如果已经放置了 n 个皇后
            count++; // 累加可行解
        else {
            // 当前行可用的列
            // ! 表示 0 和 1 的含义对于变量 hills, next_row and dales的含义是相反的
            // [1 = 未被占据，0 = 被占据]
            int free_columns = columns & ~(hills|next_row|dales);

            // 找到可以放置下一个皇后的列
            while (free_columns != 0) {
                // free_columns 的第一个为‘1’的位
                // 在该列我们放置当前皇后
               int curr_column = -free_columns & free_columns;

               // 放置皇后
                // 并且排除对应的列
                free_columns ^= curr_column;

                count = backtrack(row +1,(hills | curr_column)<<1,next_row|curr_column,(dales|curr_column)>>1,count,n);

            }
        }
        return count;
    }

    public int totalNQueens(int n) {
        return backtrack(0,0,0,0,0,n);
    }

}
