package Sort;

public class InsertSort {
	
	public static void InsertSort(Comparable[] data){
		int i,j;
		for(i=2;i<data.length;i++){
			if(data[i].compareTo(data[i-1])<0){
				data[0]=data[i];
				data[i]=data[i-1];
				for(j=i-2;data[0].compareTo(data[j])<0;j--)
					data[j+1]=data[j];
				data[j+1]=data[0];								
			}
		}
	}

	public static void main(String[] args) {
		Integer[] c = {null, 4, 9, 23, 1, 45, 27, 5, 2 };
		InsertSort(c);
		for (int i = 1; i <c.length; i++)
			System.out.println("²åÈëÅÅÐò£º" + c[i]);
	}
}
