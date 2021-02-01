package C_Search;

public class Bsearch {


    public static int bsearch(int[] arrays, int target) {

        int low = 0;
        int height = arrays.length - 1;
        while (low <= height) {
            int mid = low + ((height - low) >> 1);
            if (arrays[mid] == target) {
                return mid;
            } else if (arrays[mid] > target) {
                height = mid;
            } else if (arrays[mid] < target) {
                low = mid;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        int[] array = new int[]{8,11,19,23,27,33,45,55,67,98};
        int bsearch = bsearch(array, 99);
        System.out.println(bsearch);
    }
}


