package Sort;

/**
 插入排序
 时间复杂度 平均o(n^2) 最好o(n) 最坏o(n^2)
 空间复杂度 o(1)
**/
public class InsertSort {
	
     public static void InsertSort(Comparable[] data){
        for(int i=2; i<data.length ;i++){
            if(data[i].compareTo(data[i-1]) < 0){
                data[0] = data[i];
                data[i] = data[i-1];
                int j;
                for(j=i-2; data[0].compareTo(data[j]) <0 ;j--){
                    data[j+1] = data[j];
                }
                data[j+1] = data[0];
            }
        }
    }

    public static void main(String[] args) {
        Integer[] c = {null, 4, 9, 23, 1, 45, 27, 5, 2 };
        InsertSort(c);
        Stream.of(c).skip(1).forEach(System.out::println);
    }

}
