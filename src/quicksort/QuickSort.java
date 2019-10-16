package quicksort;

public class QuickSort {
    public static void qSort(int[] num, int low, int high) {
        if (low < high) {
            int pivot = partition(num, low, high);

            qSort(num, low, pivot - 1);
            qSort(num, pivot + 1, high);
        }
    }

    private static int partition(int[] num, int low, int high) {
        int pivotKey = num[low];

        while (low < high) {
            while (low < high && num[high] >= pivotKey) high--;
            swap(num, low, high);
            while (low < high && num[low] <= pivotKey) low++;
            swap(num, low, high);
        }

        return low;
    }

    private static void swap(int[] num, int low, int high) {
        int temp = num[low];
        num[low] = num[high];
        num[high] = temp;
    }

    public static void main(String[] args) {
        int[] num = {8, 7, 4, 3, 9, 7, 2, 6, 1, 5, 7};
        qSort(num, 0, num.length - 1);

        for (int i = 0; i < num.length; i++){
            System.out.println(num[i]);
        }
    }
}
