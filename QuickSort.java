package Sort;

/**
 快速排序
 时间复杂度 平均o(nlogn) 最好o(nlogn) 最坏o(n^2)
 空间复杂度 o(nlogn)
 不稳定排序
**/
public class QuickSort {
	
    public static int Partition( Integer[] data,int low,int high){
       data[0] = data[low];
       int pivotkey = data[low];
       while(low < high){
           //从最后起有比枢轴小的，就赋值给前面的枢轴的位置
           while(low < high && data[high] >= pivotkey ){
                high--;
           }
           data[low] = data[high];
           //从最前起有比枢轴大的，就赋值给前一次交换过的枢轴的位置
           while(low < high && data[low] <= pivotkey ){
               low++;
           }
           data[high] = data[low];
       }
       data[low] = data[0];
       return low;
    }

    public static void QSort(Integer[] data,int low,int high){
        if(low < high){
            int p = Partition(data,low,high);
            QSort(data,low,p-1);
            QSort(data,p+1,high);
        }
    }

    public static void QuickSort(Integer[] c){
        QSort(c,1,c.length-1);
    }

    public static void main(String[] args) {
        Integer[] c = {null,23, 4, 9, 23, 1, 45, 27, 5, 2  };
        QuickSort(c);
        Stream.of(c).skip(1).forEach(System.out::println);
    }

}
