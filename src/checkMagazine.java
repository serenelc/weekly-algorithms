import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class checkMagazine {

    static void checkMagazine(String[] magazine, String[] note) {

        if (magazine.length < note.length) {
            System.out.println("No");
        } else {

            List<String> magazineList = new ArrayList<>(Arrays.asList(magazine));

            boolean found = true;
            for (String word : note) {
                if (magazineList.contains(word)) {
                    magazineList.remove(word);
                } else {
                    found = false;
                    break;
                }
            }

            if (found) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

    }
}
