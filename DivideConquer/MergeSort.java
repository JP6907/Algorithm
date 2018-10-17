package DivideConquer;

import java.util.ArrayList;
import java.util.List;

import Tools.Point;

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
	
	
	/**
	 * 按X坐标或Y坐标 归并排序
	 * @param list
	 * @param low
	 * @param high
	 * @param flag "X" 或 "Y"
	 */
	public static void PointMergeSort(List<Point> list,int low,int high,String flag) {
		if(list.size() > 1) {
			if(flag.equals("X") || flag.equals("Y")) {
				if(low<high) {
				int mid = (low+high) / 2;
					PointMergeSort(list,low,mid,flag);
					PointMergeSort(list,mid+1,high,flag);
					Merge(list,low,mid,high,flag);
				}
			}
		}
	}
	private static void Merge(List<Point> list,int low,int mid,int high,String flag) {
		List<Point> l = new ArrayList<Point>();
		for(int i=0;i<low;i++)
			l.add(new Point(-999,-999));
		for(int i=low;i<=high;i++)
			l.add(list.get(i));
		int i=low,j=mid+1,k=low;
		for(;i<=mid&&j<=high;k++) {
			//按x坐标升序排列，若x坐标相同，按y坐标升序排列
			if((flag.equals("X")&&(l.get(i).x<l.get(j).x ||(l.get(i).x==l.get(j).x&&l.get(i).y<l.get(j).y))) 
					|| (flag.equals("Y")&&(l.get(i).y<l.get(j).y || (l.get(i).y==l.get(j).y&&l.get(i).x<l.get(j).x))))
				list.set(k, l.get(i++));
			else
				list.set(k, l.get(j++));
		}
		while(i<=mid)
			list.set(k++, l.get(i++));
		while(j<=high)
			list.set(k++, l.get(j++));
	}
}
