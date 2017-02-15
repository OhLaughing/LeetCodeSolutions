package LeetCodeSolutions;

import java.util.*;

public class _17_LetterCombinationsofaPhoneNumber {
    static Map<Character, List<Character>> charMaps = new HashMap<>();

    {
        List<Character> char1 = new ArrayList<>();
        List<Character> char2 = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
        List<Character> char3 = new ArrayList<>(Arrays.asList('d', 'e', 'f'));
        List<Character> char4 = new ArrayList<>(Arrays.asList('g', 'h', 'i'));
        List<Character> char5 = new ArrayList<>(Arrays.asList('j', 'k', 'l'));
        List<Character> char6 = new ArrayList<>(Arrays.asList('m', 'n', 'o'));
        List<Character> char7 = new ArrayList<>(Arrays.asList('p', 'q', 'r', 's'));
        List<Character> char8 = new ArrayList<>(Arrays.asList('t', 'u', 'v'));
        List<Character> char9 = new ArrayList<>(Arrays.asList('w', 'x', 'y', 'z'));
        List<Character> charStar = new ArrayList<>(Arrays.asList('+'));
        List<Character> char0 = new ArrayList<>(Arrays.asList(' '));
        List<Character> charSharp = new ArrayList<>(Arrays.asList('#'));

        charMaps.put('1', char1);
        charMaps.put('2', char2);
        charMaps.put('3', char3);
        charMaps.put('4', char4);
        charMaps.put('5', char5);
        charMaps.put('6', char6);
        charMaps.put('7', char7);
        charMaps.put('8', char8);
        charMaps.put('9', char9);
        charMaps.put('0', char0);
        charMaps.put('*', charStar);
        charMaps.put('#', charSharp);
    }

    //我的解决方法
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0)
            return result;

        char[] chars = digits.toCharArray();
        int index = 0;
        while (chars[index] == '1')
            index++;
        for (char c : charMaps.get(chars[index])) {
            result.add(String.valueOf(c));
        }

        for (int i = index + 1; i < chars.length; i++) {
            char theChar = chars[i];
            List<Character> tmpList = charMaps.get(theChar);

            List<String> tmpString = new ArrayList<>(result);
            result.clear();
            for (char c : tmpList) {
                for (String s : tmpString) {
                    s = s.concat(String.valueOf(c));
                    result.add(s);
                }
            }

        }
        return result;
    }


    //网上找的，比较难理解
    public List<String> letterCombinations1(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.isEmpty()) {
            result.add("");
            return result;
        }

        String[] map = new String[10];
        map[0] = "";
        map[1] = "";
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";

        int[] number = new int[digits.length()];	//存储digits中每个字符在循环中的编号，初始为0

        int k = digits.length()-1;
        while(k>=0) {
            k = digits.length()-1;
            char[] charTemp = new char[digits.length()];
            for(int i=0; i<digits.length(); i++) {
                charTemp[i] = map[digits.charAt(i)-'0'].charAt(number[i]);
            }
            result.add(new String(charTemp));
            while(k>=0) {
                if( number[k] < (map[digits.charAt(k)-'0'].length()-1) ) {
                    number[k]++;
                    break;
                } else {
                    number[k] = 0;
                    k--;
                }
            }
        }

        return result;
    }

    //网上的递归的方式，效率比较高
    public List<String> letterCombinations2(String digits) {
        List<String> result = new ArrayList<String>();
        if(digits.length()==0)
            return result;
        String[] map = new String[10];
        map[0] = "";
        map[1] = "";
        map[2] = "abc";
        map[3] = "def";
        map[4] = "ghi";
        map[5] = "jkl";
        map[6] = "mno";
        map[7] = "pqrs";
        map[8] = "tuv";
        map[9] = "wxyz";
        char[]	middleTemp = new char[digits.length()];
        dfsGetStr(digits, 0, middleTemp, map, result);
        return result;
    }

    private void dfsGetStr(String digits,int index,
                           char[] middleStr, String[] map, List<String> result) {
        if(index == digits.length()) {
            result.add(new String(middleStr));
            return ;
        }
        char strChar = digits.charAt(index);
        for(int i=0; i<map[strChar-'0'].length(); i++) {
            middleStr[index] = map[strChar-'0'].charAt(i);
            dfsGetStr(digits, index+1, middleStr, map, result);
        }
    }

    public static void main(String[] args) {
        String s = "";
        System.out.println(new _17_LetterCombinationsofaPhoneNumber().letterCombinations2(s));
    }
}


