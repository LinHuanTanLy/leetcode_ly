package leeCode01.P07;

/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class P07 {
    public static void main(String[] args) {

//        int x = 1534236469;
        int x = -2147483648;
        int result = reverse(x);
        System.out.println(result);

    }


    public static int reverse(int x) {
        boolean ifNegative = false;
        if (x == 0) {
            return 0;
        }
        if (x == Integer.MIN_VALUE) {
            return 0;
        }
        if (x == Integer.MAX_VALUE) {
            return 0;
        }
        if (x < 0) {
            ifNegative = true;
            x = Math.abs(x);
        }
        char[] charArr = String.valueOf(x).toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = charArr.length - 1; i >= 0; i--) {
            if (charArr[i] == '0') {
                if (sb.length() > 0) {
                    sb.append(charArr[i]);
                }
            } else {
                sb.append(charArr[i]);
            }
        }
        if (ifNegative) {
            sb.insert(0, "-");
        }

//        try {
        long l = Long.parseLong(sb.toString());
        if (l > Integer.MAX_VALUE || l < Integer.MIN_VALUE) {
            return 0;
        } else {
            return (int) l;
        }
//        } catch (Exception e) {
//            return 0;
//        }
    }
}
