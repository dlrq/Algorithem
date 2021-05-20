public class ReverseWordsInAString {

    /**
     * my solution, 2ms
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        if(s.isEmpty()){
            return s;
        }
        int length = s.length();
        char[] c = new char[length];
        for(int i = 0,j = length;i < length;){
            int wordStart = i;
            while (s.charAt(i) != ' '){
                i++;
                if(i >= length){
                    break;
                }
            }
            int wordEnd = i;
            for(int k = j - (wordEnd - wordStart), n = wordStart;k < j;){
                c[k++] = s.charAt(n++);
            }

            j -= wordEnd - wordStart;

            if(i < length){
                c[j - 1] = ' ';
                j--;

                while (s.charAt(i) == ' '){
                    i++;
                    if(i >= length){
                        break;
                    }
                }
            }
        }

        return new String(c).trim();
    }

    /**
     * best, 1ms
     * @param s
     * @return
     */
    public String reverseWordsBest(String s) {
        int j=0;StringBuilder sb= new StringBuilder();
        for(int i=s.length()-1 ;i>=0;i--){
            if(s.charAt(i)!=' '){
                j=i;
                i = s.lastIndexOf(' ',j);
                sb.append(s, i+1,j+1).append(' ');

            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args){
        String[] s = new String[]{"  ddd  a","a   ","a b", "a a b","I have    a  dream"};
        ReverseWordsInAString r = new ReverseWordsInAString();
        for (String str:s){
            System.out.println(r.reverseWords(str));
        }
    }
}
