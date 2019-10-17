public class alternatingCharacters {

    static int alternatingCharacters(String s) {
        int numToRemove = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            String first = s.substring(i, i + 1);
            String second = s.substring(i + 1, i + 2);
            if (first.equals(second)) {
                numToRemove++;
            }
        }

        return numToRemove;
    }
}
