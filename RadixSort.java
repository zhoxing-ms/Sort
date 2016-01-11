package Sort;
public class RadixSort {
	/**
	 * 基数排序从低位到高位进行，使得最后一次计数排序完成后，数组有序。
	          其原理在于对于待排序的数据，整体权重未知的情况下，
	          先按权重小的因子排序，然后按权重大的因子排序。
	          例如比较时间，先按日排序，再按月排序，最后按年排序，仅需排序三次。
	          但是如果先排序高位就没这么简单了。
	 * @param number
	 * @param d
	 */
	public static void RadixSort(int []number,int d){  //d表示最大的数有多少位
		int k=0; //数组计数器
		int n=1; //权重1表示个位 10表示十位 100表示百位
		int m=1; //控制键值排序依据在哪一位
		int [][]temp=new int[10][number.length];  //数组的第一维表示可能的余数0-9
		int []order=new int[10];  //数组order[i]用来表示该位是i的数的个数
		while(m<=d){   //从每个关键字权重遍历
			for(int i=0;i<number.length;i++){
				int lsd=((number[i]/n)%10);  //求出数字在该权重上的值
				temp[lsd][order[lsd]]=number[i];  //根据该权值上的值lsd，把number存在了temp[lsd][order[lsd]],表示余数为lsd的数组里记录的第lsd个是number[i]
				order[lsd]++; //余数为lsd的个数加1			
			}
			for(int i=0;i<10;i++){
				if(order[i]!=0){   //如果存在权值为i的数
					for(int j=0;j<order[i];j++)
						number[k++]=temp[i][j];   //将权值上为i的数字全部取出放在number[k]中,故number是按照某个权值排列的数字					
				}
				order[i]=0;  //权值个数计数器归0
			}		
			n*=10;  //权值位数提高1级
			k=0;    //数组计数器归0
			m++;    //控制位数+1
		}	
	}
	
	public static void main(String[] args){
        int[]data ={73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33,100,231,900};
        RadixSort.RadixSort(data,3);
        for(int i = 0;i < data.length; i++)
            System.out.print(data[i] +" ");
	}
}
