package Sort;

/**
 插入排序
 时间复杂度 平均o(n^2) 最好o(n) 最坏o(n^2)
 空间复杂度 o(1)
 稳定排序
**/
public class InsertSort {
	
    public static void insertSort(Comparable[] data) {
        for (int i = 1; i < data.length; i++) {
            if (data[i].compareTo(data[i - 1]) < 0) {
                Comparable tmp = data[i];
                int j = i - 1;
                for (; j >= 0 && tmp.compareTo(data[j]) < 0; j--) {
                    data[j + 1] = data[j];
                }
                data[j + 1] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] c = {4, 9, 23, 1, 45, 27, 5, 2};
        insertSort(c);
        Stream.of(c).forEach(System.out::println);
    }

}
