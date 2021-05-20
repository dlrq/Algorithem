public class ToLowerCase {
    public static void main(String[] args) {
        System.out.println('A' - 'a');
        System.out.println(toLowerCase("GUDGDU,fwihowS"));
    }

    public static String toLowerCase(String str) {
        char[] array = str.toCharArray();

        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 'A' && array[i] <= 'Z') {
                array[i] += 32;
            }
        }

        return new String(array);
    }
}
