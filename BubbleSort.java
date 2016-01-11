package Sort;
public class BubbleSort {
	public static void BubbleSort(Integer []data){
		int temp=0;
		for(int i=0;i<data.length;i++)
			for(int j=i+1;j<data.length;j++)
				if(data[i]>data[j]){
					temp=data[i];
					data[i]=data[j];
					data[j]=temp;
				}		
	}

	public static void main(String[] args) {
		Integer[] c = {4, 9, 23, 1, 45, 27, 5, 2 };
		BubbleSort(c);
		for (int i = 1; i <c.length; i++)
			System.out.println("Ã°ÅÝÅÅÐò£º" + c[i]);
	}
	
}
