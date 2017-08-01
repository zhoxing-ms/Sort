package Sort;

/**
 堆排序
 时间复杂度 平均 o(nlogn) 最好 o(nlogn) 最坏 o(nlogn)
 空间复杂度 o(1)
 **/
public class HeapSort {
	
    /**
     * 大顶堆调整
     */
    public static void HeadAdjust(Integer data[],int adjustIndex,int lastIndex){
        // 除s外均满足堆，调整s成大顶堆
        data[0] = data[adjustIndex];
        // 从s的孩子中找到s该插入的位置
        for(int i=2*adjustIndex; i<lastIndex ; i*=2){
            // 选择孩子中较大的那个
            if(i<lastIndex && data[i] < data[i+1]){
                i++;
            }
            // 如果孩子小于了adjustIndex,那么说明在大顶堆中adjustIndex应插入的位置
            if(data[i] < data[0]){
                break;
            }
            // 如果孩子大于adjustIndex,那么将孩子上移到双亲结点（adjustIndex记录了这次的i,也就是下一个孩子的双亲）
            else{
                data[adjustIndex] = data[i];
                adjustIndex = i;
            }
        }
        // adjustValue >= data[i],adjustIndex 排i顶上，因此i的父节点adjustIndex应该插入目标节点
        data[adjustIndex] = data[0];
    }

    public static void HeapSort(Integer data[]) {
        int temp;
        // 创建初始大顶堆,对非终端顶点排序
        for(int i = (data.length-1)/2 ; i>=1 ; i--){
            HeadAdjust(data,i,data.length-1);
        }
        // 对n-1个记录的堆不断筛选(最后一个不用筛选),用最后一个节点不断和根节点交换再调整出新的根节点
        for(int i = data.length-1 ; i>=2 ; i--){
            // 将顶堆与最后一个元素互换
            temp = data[i];
            data[i] = data[1];
            data[1] = temp;
            // 将参与堆排序的总数减少1,可让刚被换的堆顶不参与排序
            HeadAdjust(data,1,i-1);
        }
    }

    public static void main(String[] args) {
        Integer[] c = { null,29,4, 9, 23, 1, 45, 27, 5, 2 };
        HeapSort(c);
        Stream.of(c).skip(1).forEach(System.out::println);
    }
	
}
