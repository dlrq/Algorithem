

import java.util.*;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args){
        List<String> res = letterCombinations("23");
        System.out.println(res);
    }

    public static Map<Character,List<Character>> map = new HashMap<>();

    static{
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
    }


    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return res;
        letter(digits, 0, new StringBuilder(), res);
        return res;
    }

    /**
     *
     * @param digits
     * @param i  digits中的第几位
     * @param s
     * @param res
     */
    public static void letter(String digits, int i, StringBuilder s, List<String> res){
        if(i >= digits.length() ){
            res.add(s.toString());
            return;
        }
        List<Character> list = map.get(digits.charAt(i));

        for(Character c:list){
            s.append(c);
            letter(digits, i + 1, s, res);
            s.deleteCharAt(s.length()-1);
        }

        return;
    }
}
