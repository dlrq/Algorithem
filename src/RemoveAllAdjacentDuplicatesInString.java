public class RemoveAllAdjacentDuplicatesInString{
    public static void main(String[] args){
        RemoveAllAdjacentDuplicatesInString r = new RemoveAllAdjacentDuplicatesInString();
        System.out.println(r.removeDuplicates("aaaaaaaaa"));
        System.out.println(r.removeDuplicates("aaaaaaaa"));
        System.out.println(r.removeDuplicates("ibfjcaffccadidiaidchakchchcahabhibdcejkdkfbaeeaecdjhajbkfebebfea"));
        System.out.println(r.removeDuplicates("accca"));
        System.out.println(r.removeDuplicates("adfgh"));
    }
    
    //very slow
    public String removeDuplicates1(String s) {
        StringBuilder sb = new StringBuilder(s);

    
            for(int i = 0;i < sb.length() - 1;){
                if(sb.charAt(i) == sb.charAt(i + 1)){
                    sb.delete(i, i + 2);
                    i = 0;
                    continue;
                
                }
                i++;
            }
        

        return sb.toString();
    }

    //fastest
    public String removeDuplicates(String s) {
        char[] charArray = s.toCharArray();
        int end = -1;
        for(char c : charArray){
            if(end > -1 && charArray[end] == c){
                end--;
            }else{
                charArray[++end] = c;
            }
        }

        return String.valueOf(charArray, 0, end + 1);
    }
}