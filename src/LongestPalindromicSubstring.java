/*
 * @lc app=leetcode id=5 lang=java
 *
 * [5] Longest Palindromic Substring
 */

// @lc code=start
class LongestPalindormicSubstring {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return "";
        }
        if(s.length() == 1){
            return s;
        }

        int startIndex = 0;
        int endIndex = 0;
        int longestLength = 0;
        for(int i = 0;i < s.length() - 1; i++){
            int l = i;
            int r = i;
            while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)){
                l--;
                r++;
            }
            if(r - l + 1 > longestLength){
                longestLength = r - l + 1;
                startIndex = l + 1;
                endIndex = r - 1;
            }

            if(s.charAt(i) == s.charAt(i + 1)){
                l = i;
                r = i + 1;
                while (l >= 0 && r <= s.length() - 1 && s.charAt(l) == s.charAt(r)){
                    l--;
                    r++;
                }
                if(r - l + 1 > longestLength){
                    longestLength = r - l + 1;
                    startIndex = l + 1;
                    endIndex = r - 1;
                }
            }
        }

        return s.substring(startIndex, endIndex + 1);
    }

}
// @lc code=end

