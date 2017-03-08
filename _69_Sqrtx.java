package LeetCodeSolutions;

public class _69_Sqrtx {
    public int mySqrt(int x) {
        long left = 1;
        long right = x;
        long mid = (1 + right) / 2;
        while (left <= right) {
            mid = (left + right) / 2;
            long  powMid = mid*mid;
            if (powMid < x)
                left = mid + 1;
            else if (powMid > x)
                right = mid - 1;
            else return Math.toIntExact(mid);
        }
        return Math.toIntExact(right);
    }

    public static void main(String[] args) {
        _69_Sqrtx ss = new _69_Sqrtx();
        for (int i = 0; i < 20; i++) {
            System.out.println(i + " :" + ss.mySqrt(i));
        }
        System.out.println(ss.mySqrt(2147395599));
    }
}
