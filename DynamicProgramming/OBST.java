/**
 * OptimalBST
 * 最优二叉搜索树
 */
package DynamicProgramming;

import Tools.Tools;

public class OBST {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		float[] P = {(float)0.1,(float)0.2,(float)0.4,(float)0.3};
		OptimanBST(P);
	}
	/**
	 * 动态规划求最优二叉搜索树
	 * @param P 一个n个键的有序列表的查找概率数组P[1...n-1]
	 */
	static void OptimanBST(float[] P) {
		int n = P.length;
		float[][] C = new float[n+2][n+1]; //主表，概率表
		int[][] R = new int[n+2][n+1]; //根表
		for(int i=1;i<=n;i++) {
			C[i][i-1] = 0;
			C[i][i] = P[i-1];
			R[i][i] = i;
		}
		C[n+1][n] = 0;
		for(int d=1;d<=n-1;d++) {
			for(int i=1;i<=n-d;i++) { //对角线计数
				int j = i+d;
				float minval = Integer.MAX_VALUE;
				int kmin = i;
				for(int k=i;k<=j;k++) {
					if((C[i][k-1]+C[k+1][j]) < minval) {
						minval = C[i][k-1]+C[k+1][j];
						kmin = k;
					}
				}
				R[i][j] = kmin;
				float sum = 0;
				for(int s=i;s<=j;s++) {
					sum += P[s-1];
				}
				C[i][j] = minval + sum;
				
			}
		}
		Tools.printMartix(C);
		Tools.printMartix(R);
	}
}
