package search.linear;

public class LinearSearch {

    public static void main(String[] args) {

        int[] arr = {2, 5, 3, 7, 8, 10, 4, 6, 11, 1};
        int findNumber = 20;

        boolean found = false;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == findNumber) {
                found = true;
                break;
            }
        }

        System.out.println(found ? "YES" : "NO");
    }
}
