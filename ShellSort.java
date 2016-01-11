package Sort;
public class ShellSort {
	
	public static <T extends Comparable<? super T>> void ShellInsert(Comparable[] array, int dk) { 
		int j,i;
        for(i=dk+1;i<array.length;i++){
        	if(array[i].compareTo(array[i-dk])<0){
        		array[0]=array[i];
        		for(j=i-dk;j>0&&array[0].compareTo(array[j])<0;j=j-dk)
        			array[j+dk]=array[j];
        		array[j+dk]=array[0];
        	}       		
        }
    }     
	 
	public static <T extends Comparable<? super T>> void ShellSort(Comparable[] array,Integer[] dlta) { 
		for(int k=0;k<dlta.length;++k)
			ShellInsert(array,dlta[k]);
    }   
	
	public static void main(String[] args) {
		Integer[] data = new Integer[] { 0,32,4, 3, 6, 2, 1, 9, 5, 8, 7,22,11 };
		Integer[] dlta = new Integer[] { 3,2,1 };
		ShellSort(data,dlta);
		for(int i=1;i<data.length;i++)
			System.out.println(data[i]);
	}

}
