package com.itliusir.bit;

/**
 * 编写一个函数，输入是一个无符号整数，返回其二进制表达式中数字位数为 ‘1’ 的个数（也被称为汉明重量）。
 * <p>
 * 示例 1：
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 * <p>
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 * <p>
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *  
 * 提示：
 * <p>
 * 请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，
 * 因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
 * 在 Java 中，编译器使用二进制补码记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
 *
 * @author liugang
 * @since 2019/11/25
 */
public class NumberOfOneBits {

    public static void main(String[] args) {
        int n = 3;
        System.out.println(new NumberOfOneBits().hammingWeightTwo(n));
    }

    /**
     * method 1 -> time O(1) space O(1)
     * 
     * 遍历二进制中1的个数，每次通过与1的与运算来判断，下次循环重新移位
     * 
     * @author liugang
     * @date 2019-12-01 17:16:05
     */
    public int hammingWeight(int n) {
        int ones = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                ones++;
            }
            mask <<= 1;
        }
        return ones;
    }

    /**
     * method 2 -> time O(1) space O(1)
     *
     * 按需计算，性能更好
     *
     * @author liugang
     * @date 2019-12-01 17:18:50
     */
    public int hammingWeightTwo(int n) {
        int ones = 0;
        while (n != 0) {
            ones ++;
            n = n & (n - 1);
        }
        return ones;
    }
}
