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
        data[0] = data[pivotKey];
        data[pivotKey] = data[low];
        while (low < high) {
            while (low < high && data[high] >= data[0]) {
                high--;
            }
            data[low] = data[high];
            while (low < high && data[low] <= data[0]) {
                low++;
            }
            data[high] = data[low];
        }
        data[low] = data[0];
        return low;
    }

    public static void Qsort(Integer[] data, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(data, low, high);
        Qsort(data, low, pivot - 1);
        Qsort(data, pivot + 1, high);
    }

    public static void QuickSort(Integer[] data) {
        Qsort(data, 0, data.length - 1);
    }

    public static void main(String[] args) {
        Integer[] c = {null, 23, 4, 9, 23, 1, 45, 27, 5, 2};
        QuickSort(c);
        Stream.of(c).skip(1).forEach(System.out::println);
    }

}
