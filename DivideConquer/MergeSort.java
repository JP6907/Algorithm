package DivideConquer;

public class MergeSort {
	
	public static void main(String[] args) {
		int[] A = {10,5,11,4,56,0};
		mergeSort(A,0,A.length-1);
		for(int i=0;i<A.length;i++) {
			System.out.print(A[i]+ "  ");
		}
	}
	
	public static void mergeSort(int[] A,int low,int high) {
		if(low<high) {
			int mid = (low+high)/2;
			mergeSort(A, low, mid);
			mergeSort(A, mid+1, high);
			merge(A,low,mid,high);
		}
	}
	public static void merge(int[] A,int low,int mid,int high) {
		int[] B = new int[high+1];
		for(int k=low;k<=high;k++)
			B[k] = A[k];
		int i=low, j=mid+1;
		int k =low;
		for(;i<=mid&&j<=high;k++) {
			if(B[i]<=B[j])
				A[k] = B[i++];
			else
				A[k] = B[j++];
		}
		while(i<=mid)
			A[k++] = B[i++];
		while(j<=high)
			A[k++] = B[j++];
	}
}
