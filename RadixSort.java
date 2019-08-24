package Sort;

/**
 基数排序
 时间复杂度 平均 o(d(r+n)) 最优 o(d(r+n)) 最坏 o(d(r+n))  r是进制数,n是数组的大小
 空间复杂度 o(rd+n)
 稳定排序
 **/
public class RadixSort {
    /**
     * 基数排序从低位到高位进行，使得最后一次计数排序完成后，数组有序
     * 其原理在于对于待排序的数据，整体权重未知的情况下，先按权重小的因子排序，然后按权重大的因子排序
     * 例如比较时间，先按日排序，再按月排序，最后按年排序，仅需排序三次。但是如果先排序高位就没这么简单了
     */
    public static void radixSort(Integer[] array, int maxBit) {
        int weight = 1; // 当前处理的位 1表示个位 10表示十位 100表示百位
        List<Integer>[] buckets = new ArrayList[10]; // 第一维是各数字在weight位的值digit,第二维是该位是digit的数字列表
        for (int bit = 0; bit < maxBit; bit++) {
            for (int i = 0; i < 10; i++) { // 初始化或清空上一轮处理的结果
                buckets[i] = new ArrayList<>();
            }
            for (Integer num : array) {
                buckets[num / weight % 10].add(num); // 计算出该数字在weight位上的值digit
            }
            int index = 0;
            for (int i = 0; i < 10; i++) {   // 按照weight位的digit依次从低到高排序
                for (Integer num : buckets[i]) {
                    array[index++] = num;
                }
            }
            weight = weight * 10;
        }
    }

    private static int getMaxBit(Integer[] array) {
        int maxValue = array[0];
        for (int value : array) {
            maxValue = Math.max(value, maxValue);
        }
        int maxBit = 0;
        for (long temp = maxValue; temp > 0; temp /= 10) {
            maxBit++;
        }
        return maxBit;
    }

    public static void main(String[] args) {
        Integer[] data = {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100, 231, 900};
        radixSort(data, getMaxBit(data));
        Stream.of(data).forEach(System.out::println);
    }

}
