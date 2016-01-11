package Sort;
public class QuickSort {
	
	public static int Partition(Integer[] data,int low,int high){
		data[0]=data[low];
		int pivotkey=data[low];
		while(low<high){
			while(low<high&&data[high]>=pivotkey)   //从最后起有比枢轴小的，就赋值给前面的枢轴的位置
				high--;
			data[low]=data[high];
			while(low<high&&data[low]<=pivotkey)    //从最前起有比枢轴大的，就赋值给前一次交换过的枢轴的位置
				low++;
			data[high]=data[low];			
		}
		data[low]=data[0];
		return low;
	}

	public static void QSort(Integer[] data,int low,int high){
		if(low<high){
			int p=Partition(data,low,high);
			QSort(data,low,p-1);
			QSort(data,p+1,high);
		}
	}
	
	public static void QuickSort(Integer[] c){
		QSort(c,1,c.length-1);
	}
	
	public static void main(String[] args) {
		Integer[] c = {-1,23, 4, 9, 23, 1, 45, 27, 5, 2 };
		QuickSort(c);
		for (int i = 1; i <c.length; i++)
			System.out.println("快速排序：" + c[i]);
	}
}
