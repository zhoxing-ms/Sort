package Sort;

/**
 基数排序
 时间复杂度 平均 o(d(r+n) 最优 o(d(r+n) 最坏 o(d(r+n))
 空间复杂度 o(rd+n)
 稳定排序
 **/
public class RadixSort {
	/**
	 * 基数排序从低位到高位进行，使得最后一次计数排序完成后，数组有序。
	   其原理在于对于待排序的数据，整体权重未知的情况下，先按权重小的因子排序，然后按权重大的因子排序。
	   例如比较时间，先按日排序，再按月排序，最后按年排序，仅需排序三次。但是如果先排序高位就没这么简单了。
	 * @param number
	 * @param d
	 */
	    public static void RadixSort(Integer []number,Integer maxPosition){
        // 数组计数器
        int count = 0;
        // 权重1表示个位 10表示十位 100表示百位
        int weight = 1;
        //排序的键值在的位数
        int bit = 1;
        // 数组的第一维表示该位上出现的数字 第二维表示该数字在该位第几次出现 值是出现的整体数据
        int [][]lsdAmout = new int[10][number.length];
        // 数组order[i]用来表示该位是i的数的个数
        int []lsdCount = new int[10];
        //从每个关键字权重遍历
        while(bit < maxPosition){
            for(int i=0;i<number.length;i++){
                //求出数字在该权重上的值
                int lsd = (number[i]/weight)%10;
                // 余数为lsd的lsdAmout数组里记录的第n( n=lsdCount[lsd]) 个数据是number[i]
                lsdAmout[lsd][lsdCount[lsd]] = number[i];
                // 余数为lsd的个数加1
                lsdCount[lsd]++;
            }
            for(int i=0; i<10; i++){
                // 如果存在权值为i的余数
                if(lsdCount[i] != 0){
                    // 将权值上为i的数字全部取出放在number[count]中,故number是按照某个权值排列的数字
                    for(int j=0; j < lsdCount[i]; j++){
                        number[count++] = lsdAmout[i][j];
                    }
                    //数字i在该权值出现次数的计数器归0
                    lsdCount[i] = 0;
                }
            }
            // 为下一位的计算进行初始化操作
            weight = weight * 10;
            count = 0;
            bit ++;
        }
    }

    public static void main(String[] args){
        Integer[]data ={73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33,100,231,900};
        RadixSort.RadixSort(data,3);
        Stream.of(data).forEach(System.out::println);
    }

}
