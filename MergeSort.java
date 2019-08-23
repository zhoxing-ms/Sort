package Sort;

/**
 归并排序
 时间复杂度 平均o(nlogn) 最好o(nlogn) 最坏o(nlogn)
 空间复杂度 o(1)
 稳定排序
**/
public class MergeSort {
	
    public static void MergeSort(Integer[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(Integer[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) >> 1;
        sort(array, left, mid);
        sort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    public static void merge(Integer[] array, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int index = 0, p1 = left, p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            tmp[index++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }
        while (p1 <= mid) {
            tmp[index++] = array[p1++];
        }
        while (p2 <= mid) {
            tmp[index++] = array[p2++];
        }
        for (int i = 0; i < tmp.length; i++) {
            array[left + i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        Integer[] c = {100, 4, 9, 23, 1, 45, 27, 5, 2};
        MergeSort(c);
        Stream.of(c).forEach(System.out::println);
    }

}
