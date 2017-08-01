package Sort;

/**
 希尔排序
 时间复杂度 平均o(n^1.3) 最好o(n) 最坏o(n^2)
 空间复杂度 o(1)
 不稳定排序
 **/
public class ShellSort {
	
     public static <T extends Comparable<? extends T>> void ShellInsert(Comparable[] array, Integer dk){
        int j,i;
        for(i = 1 + dk;i < array.length;i ++){
            if(array[i].compareTo(array[i-dk]) < 0){
                array[0] = array[i];
                array[i] = array[i - dk ];
                for(j= i - 2 * dk; j > 0 && array[0].compareTo(array[j]) < 0 ; j = j -dk){
                    array[j + dk] = array[j];
                }
                array[j + dk] = array[0];
            }
        }
    }

    public static <T extends Comparable<? super T>> void ShellSort(Comparable[] array,Integer[] dlta) {
        for (int k = 0; k < dlta.length; ++k){
            ShellInsert(array, dlta[k]);
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[] { 0,32,4, 3, 6, 2, 1, 9, 5, 8, 7,22,11 };
        Integer[] dlta = new Integer[] { 3,2,1 };
        ShellSort(data,dlta);
        Stream.of(data).skip(1).forEach(System.out::println);
    }

}
