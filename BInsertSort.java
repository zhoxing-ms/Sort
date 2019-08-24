package Sort;

/**
  折半插入排序
  时间复杂度 平均 o(n^2) 最好o(n) 最坏o(n^2)
  空间复杂度 o(1)
  稳定排序
**/
public class BInsertSort {
	
    public static void binsertSort(Comparable[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i].compareTo(data[i - 1]) > 0) {
                continue;
            }
            Comparable tmp = data[i];
            int low = 1, high = i - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (data[mid].compareTo(tmp) < 0) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            for (int j = i - 1; j > high; j--) {
                data[j + 1] = data[j];
            }
            data[high + 1] = tmp;
        }
    }

    public static void main(String[] args) {
        Integer[] c = {4, 9, 23, 1, 45, 27, 5, 2};
        binsertSort(c);
        Arrays.stream(c).skip(1).forEach(System.out::println);
    }

}
