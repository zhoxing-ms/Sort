package Sort;

public class SelectSort {
	
	public static void SelectSort(Integer []data){
		int min=0,temp=-1;
		for(int i=0;i<data.length;i++){
			min=i;
			for(int j=i+1;j<data.length;j++)
				if(data[j]<data[min])
					min=j;	
			if(min!=i){
				temp=data[i];
				data[i]=data[min];
				data[min]=temp;
			}
		}
	}

	public static void main(String[] args) {
		Integer[] c = {4, 9, 23, 1, 45, 27, 5, 2 };
		SelectSort(c);
		for (int i = 1; i <c.length; i++)
			System.out.println("Ñ¡ÔñÅÅÐò£º" + c[i]);
	}
}
