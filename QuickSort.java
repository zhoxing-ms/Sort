package Sort;

/**
 快速排序
 时间复杂度 平均o(nlogn) 最好o(nlogn) 最坏o(n^2)
 空间复杂度 o(nlogn)
 不稳定排序
**/
public class QuickSort {

    public static int partition(Integer[] data, int low, int high) {
        int pivotKey = (low + high) / 2;
        int pivot = data[pivotKey];
        data[pivotKey] = data[low];
        while (low < high) {
            while (low < high && data[high] >= pivot) {
                high--;
            }
            data[low] = data[high];
            while (low < high && data[low] <= pivot) {
                low++;
            }
            data[high] = data[low];
        }
        data[low] = pivot;
        return low;
    }

    public static void qSort(Integer[] data, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(data, low, high);
        qSort(data, low, pivot - 1);
        qSort(data, pivot + 1, high);
    }

    public static void quickSort(Integer[] data) {
        qSort(data, 0, data.length - 1);
    }

    public static void main(String[] args) {
        Integer[] c = {23, 4, 9, 23, 1, 45, 27, 5, 2};
        quickSort(c);
        Stream.of(c).forEach(System.out::println);
    }

}
