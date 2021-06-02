public class JewelsAndStones {

    public static void main(String[] args) {
        test("aA", "aAAbbbb");
        test("z", "ZZ");
    }

    public static void test(String J, String S) {
        int count = 0;
        char[] c = new char[128];

        for (char c1 : J.toCharArray()) {
            c[c1] = 1;
        }

        for (char c1 : S.toCharArray()) {
            if (c[c1] == 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}
