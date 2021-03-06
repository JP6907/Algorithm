package Entity;

/**  
 * @ClassName Heap 最小堆 和 降序堆排序
 * @Description: TODO
 * @author ZJP
 * @date 18-10-21 下午3:07
 **/
public class Heap {

	public static void main(String[] args) {
		int[] A = {0,45,2,68,-1,10,1};   //A[0]不参与排序
		HeapSort(A, A.length-1);
		for(int i=1;i<A.length;i++)
			System.out.print(A[i] + " ");
		System.out.println();

		int[] B = {0,-1,2,1,45,10,68,0};
		adjustUp(B,7);
		for(int i=1;i<B.length;i++)
			System.out.print(B[i]+" ");
		System.out.println();
	}
	//降序堆排序
	public static void HeapSort(int[] A,int n) {

		BuildMinHeap(A, n);
		for(int i=n;i>1;i--) {
			int temp = A[i];
			A[i] = A[1];
			A[1] = temp;
			adjustDown(A, 1, i-1);
		}
	}
	/**
	 * 构建最小堆
	 * @param A  1....n
	 * @param n
	 */
	public static void BuildMinHeap(int[] A,int n) {
		for(int i=n/2;i>0;i--)
			adjustDown(A, i, n);
	}
	/**
	 * A[1....n] 将k向下调整
	 * @param A
	 * @param k
	 * @param n
	 */
	public static void adjustDown(int[] A,int k,int n) {
		A[0] = A[k];
		for(int i=k*2;i<=n;i*=2) {
			if(i<n&&A[i+1]<A[i])
				i++;
			if(A[0]<A[i])
				break;
			else {
				A[k] = A[i];
				k = i;
			}
		}
		A[k] = A[0];
	}
	/**
	 * @Description: TODO
	 * @author ZJP
	 * @date 18-10-21 下午3:10
	 * @Param * @param null
	 * @return
	 **/
	public static void adjustUp(int[] A,int k) {
		for(int i=k/2;i>=1;i/=2) {
			if(A[k]<A[i]) {
				int temp = A[k];
				A[k] = A[i];
				A[i] = temp;
				k = i;
			}else
				break;
		}
	}
}
