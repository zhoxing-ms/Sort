package Sort;
public class MergeSort {
	
	public static void Merge(int []sr,int []tr,int i,int m,int n){
		//sr i..m sr m+1..n 归并为有序tr
		int j,k;
		for(k=i,j=m+1;i<=m&&j<=n;++k){
			if(sr[i]<sr[j])
				tr[k]=sr[i++];
			else
				tr[k]=sr[j++];
		}
		if(i<=m)                //sr i..m有剩余，把余下的给tr
			for(int last=k;last<=n;last++)
				tr[last]=sr[i++];
		else					//sr m+1..n有剩余，把余下的给tr
			for(int last=k;last<=n;last++)
				tr[last]=sr[j++];	    
	}
	
	public static void MSort(int []sr,int []tr1,int s,int t){
		//sr s..t 归并成tr1 s..t
		if(s==t)
			tr1[s]=sr[s];
		else{
			int m=(s+t)/2;
			int []tr2=new int[sr.length];
			//将sr一分为两个分别有序的序列，分别复制给tr2的 s..m 和 m+1..t
			MSort(sr,tr2,s,m);
			MSort(sr,tr2,m+1,t);
			//再将tr2的s..m 1..t归并成有序的tr1
			Merge(tr2,tr1,s,m,t);		
		}
	}
	
	public static void MergeSort(int []data){
		MSort(data,data,0,data.length-1);
	}

	public static void main(String[] args) {
		int[] c = {100, 4, 9, 23, 1, 45, 27, 5, 2 };
		MergeSort(c);
		for (int i = 0; i <c.length; i++)
			System.out.println("归并排序：" + c[i]);
	}
}
