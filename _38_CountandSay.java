package LeetCodeSolutions;

public class _38_CountandSay {
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder();
        if (n == 1) {
            return "1";
        } else {
            String lastNum = countAndSay(n - 1);
            if (lastNum.length() == 1)
                return "1" + lastNum;
            char lastStr = lastNum.charAt(0);
            int count = 1;
            for (int i = 1; i < lastNum.length() - 1; i++) {
                if (lastNum.charAt(i) == lastStr) {
                    count++;
                    continue;
                } else {
                    sb.append(count);
                    sb.append(lastStr);
                    lastStr = lastNum.charAt(i);
                    count = 1;
                }
            }

            if (lastStr == lastNum.charAt(lastNum.length() - 1)) {
                sb.append(count + 1);
                sb.append(lastStr);
            } else {
                sb.append(count);
                sb.append(lastStr);
                sb.append(1);
                sb.append(lastNum.charAt(lastNum.length() - 1));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        _38_CountandSay ss = new _38_CountandSay();

        for (int i = 1; i < 10; i++) {
            System.out.println(ss.countAndSay(i));
        }
    }
}
