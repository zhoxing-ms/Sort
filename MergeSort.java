package Sort;

/**
 归并排序
 时间复杂度 平均o(nlogn) 最好o(nlogn) 最坏o(nlogn)
 空间复杂度 o(1)
**/
public class MergeSort {
	
    public static void Merge(Integer []sourceArray,Integer []targetArray,int i,int mid,int n){
        //sourceArray i..mid  sourceArray mid+1..n  归并为有序targetArray
        int j,k;
        for(k=i,j=mid+1; i<=mid && j<=n ; ++k){
            if(sourceArray[i] < sourceArray[j]){
                targetArray[k] = sourceArray[i++];
            }else{
                targetArray[k] = sourceArray[j++];
            }
        }
        if(i <= mid){
            for(int last=k; last <= n; last++){
                targetArray[last] = sourceArray[i++];
            }
        }else{
            for(int last=k; last <= n; last++){
                targetArray[last] = sourceArray[j++];
            }
        }
    }

    public static void MSort(Integer []sourceArray,Integer []targetArray,int s,int t){
        if(s == t){
            targetArray[s] = sourceArray[s];
        }else{
            int mid = (s+t)/2;
            Integer []halfTagetAray = new Integer[sourceArray.length];
            MSort(sourceArray,halfTagetAray,s,mid);
            MSort(sourceArray,halfTagetAray,mid+1,t);
            Merge(halfTagetAray,targetArray,s,mid,t);
        }
    }

    public static void MergeSort(Integer []data){
        MSort(data,data,0,data.length-1);
    }

    public static void main(String[] args) {
        Integer[] c = {100, 4, 9, 23, 1, 45, 27, 5, 2 };
        MergeSort(c);
        Stream.of(c).forEach(System.out::println);
    }

}
