public class buildAList {

    public static void main(String args) {
        String str = "xyz";
        String[] res = combination(str, 0);
        //xy xz yz
    }

    private static String[] combination(String from, int startIndex) {
        String[] temp = new String[from.length()];
        int j = 0;

        for (int k = 0; k < from.length(); k++) {
            String first = String.valueOf(from.charAt(k));

            for (int i = k + 1; i < from.length(); i++) {
                String cont = first + from.charAt(i);
                temp[j] = cont;
                j++;
            }
        }

        return temp;
    }

    static String[] solve(String s) {
        char[] chars = s.toCharArray();
        int size = 0;
        for (int i = 1; i <= s.length(); i++) {
            size += nChooseR(s.length(), i);
        }
        String[] res = new String[size];
        String[] temp = new String[s.length()];

        String base = String.valueOf(chars[0]);
        temp[0] = base;
        for (int i = 1; i < s.length(); i++) {
            temp[i] = base + chars[i];
        }

//        for (int i = 0; i < s.length(); i++) {
//            String x = String.valueOf(chars[i]);
//        }

        return res;
    }

    /* arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Staring and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
    static int[] combinationUtil(int arr[], int data[], int start,
                                int end, int index, int r) {
        // Current combination is ready to be printed, print it
        int[] res = new int[r];
        if (index == r) {
            for (int j = 0; j < r; j++) {
                res[j] = data[j];
                System.out.print(data[j] + " ");
            }
            return res;
        }

        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element
        // at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end && end-i+1 >= r-index; i++) {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    static void printCombination(int arr[], int n, int r)
    {
        // A temporary array to store all combination one by one
        int data[] = new int[r];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, data, 0, n-1, 0, r);
    }

    /*Driver function to check for above function*/
    public static void main (String[] args) {
        int arr[] = {1, 2, 3, 4, 5};
        int r = 3;
        int n = arr.length;
        printCombination(arr, n, r);
    }

    private static int nChooseR(int n, int r) {
        return fact(n) / (fact(r) * fact(n - r));
    }

    // Returns factorial of n
    private static int fact(int n) {
        int res = 1;
        for (int i = 2; i <= n; i++)
            res *= i;
        return res;
    }

}
