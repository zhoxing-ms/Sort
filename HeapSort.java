package Sort;

public class HeapSort {
	
	public static void HeapAdjust(Integer data[], int s, int m) {
		// 除s外均满足堆，调整s成大顶堆
		int rc = data[s], j; // rc暂存s
		for (j = 2 * s; j < m; j *= 2) { // 从s的孩子中找到s该插入的位置
			if (j < m && data[j] < data[j + 1]) // 选择孩子中较大的那个
				j++;
			if (data[j] < rc) // 如果孩子小于了s,那么说明在大顶堆中s应插入的位置
				break;
			else { // 如果孩子大于s,那么将孩子上移到双亲结点（s记录了这次的j,也就是下一个孩子的双亲）
				data[s] = data[j];
				s = j;
			}
		}
		data[s] = rc; // rc>=data[j],rc排j顶上，因此j的双亲应该为rc
	}

	public static void HeapSort(Integer data[]) {
		int size = data.length - 1, temp;
		// 创建初始大顶堆,对非终端顶点排序
		for (int i = size / 2; i >= 0; i--) {
			HeapAdjust(data, i, size);
		}
		// 对n-1个记录的堆不断筛选(最后一个不用筛选)
		for (int i = size; i >= 1; --i) {
			// 将顶堆与最后一个元素互换
			temp = data[i];
			data[i] = data[0];
			data[0] = temp;
			// 将参与堆排序的总数减少1,可让刚被换的堆顶不参与排序
			HeapAdjust(data, 0, i - 1);
		}
	}

	public static void main(String[] args) {
		Integer[] c = { 4, 9, 23, 1, 45, 27, 5, 2 };
		HeapSort(c);
		for (int i = 0; i < c.length; i++)
			System.out.println("堆排序：" + c[i]);
	}
}
