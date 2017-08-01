package Sort;

/**
 选择排序
 时间复杂度 平均o(n^2) 最好o(n^2) 最坏o(n^2)
 空间复杂度 o(1)
 **/
public class SelectSort {
	
    public static void SelectSort(Integer []data){
        int minIndex,temp;
        for(int i=0; i< data.length ;i++){
            minIndex = i;
            for(int j=i+1;j < data.length;j++){
                if(data[j] < data[minIndex]){
                    minIndex = j;
                }
            }
            if(minIndex != i){
                temp = data[i];
                data[i] = data[minIndex];
                data[minIndex] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] c = {4, 9, 23, 1, 45, 27, 5, 2 };
        SelectSort(c);
        Stream.of(c).forEach(System.out::println);
    }
	
}
