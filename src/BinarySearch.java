public class BinarySearch {
    public static int binarySearch(int[] num, int target) {
        int low = 0;
        int high = num.length - 1;

        while (low <= high) {
            int middle = (low + high) / 2;

            if (num[middle] == target) {
                return middle;
            } else if (middle > target) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        int index = binarySearch(num, 8);
        System.out.println(index);
    }
}
