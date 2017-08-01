package Sort;

/**
  折半插入排序
  时间复杂度 平均 o(n^2) 最好o(n) 最坏o(n^2)
  空间复杂度 o(1)
**/
public class BInsertSort {
	public static void BInsertSort(Comparable[] data){
		int i,j;
		for(i=2;i<data.length;i++){
			if(data[i].compareTo(data[i-1])<0){
				data[0]=data[i];
				int low=1,high=i-1,mid;
				while(low<=high){
					mid=(low+high)/2;
					if(data[0].compareTo(data[mid])>0)
						low=mid+1;
					else
						high=mid-1;
				}
				for(j=i-1;j>=high+1;j--)
					data[j+1]=data[j];
				data[high+1]=data[0];
			}
		}
	}
	
        public static void main(String[] args) {
        	Integer[] c = {null, 4, 9, 23, 1, 45, 27, 5, 2 };
        	BInsertSort(c);
        	Arrays.stream(c).forEach(System.out::println);
   	 }
	
}
