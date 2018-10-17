////////////////////
//////////////////
////////////////
/////////////存在问题/////////////////
/////////////////////////////////////

/**
 * Knapsack Problem(KP)
 * 背包功能和记忆化
 */
package DynamicProgramming;

public class Knapsack {

	static int n = 4;
	static int MaxWeight = 5;
	
	static int[] weight = {0,2,1,3,2};
	static int[] value = {0,12,10,20,15};
	static int[][] F = new int[n+1][MaxWeight+1];
	
	public static void main(String[] args) {
		System.out.println("记忆化-------");
		int maxValue = MFKnapsack(n,MaxWeight);
		for(int i=0;i<F.length;i++) {
			for(int j=0;j<F[0].length;j++) {
				if(i==0||j==0)
					F[i][j] = 0;
				else
					F[i][j] = -1;
			}
		}
		System.out.println("最大总价值为：" + maxValue);
		
		System.out.println("无记忆化------");
		KP();
		Tools.Tools.printMartix(F);
	}
	/**
	 * 背包问题  无记忆化
	 */
	static void KP() {
		for(int w=0;w<=MaxWeight;w++)
			F[0][w] = 0;
		for(int i=1;i<=n;i++) {
			F[i][0] = 0;
			for(int w=0;w<=MaxWeight;w++) {
				if(w-weight[i]>=0) {
					if(F[i-1][w]>value[i]+F[i-1][w-weight[i]])
						F[i][w] = F[i-1][w];
					else
						F[i][w] = value[i]+F[i-1][w-weight[i]];
				}else
					F[i][w] = F[i-1][w];
			}
		}
		System.out.println("最大总价值为：" + F[n][MaxWeight]);
	}
	/**
	 * 背包问题实现记忆功能
	 * @param i 前i个物品
	 * @param j 承重量
	 * @param 全局变量weight[1...n]、value[1...n]、F[0...n][0...W]
	 * F[0...n][0...W]除了行0和列0用0初始化以外，F的所有单元格用-1初始化
	 * @return 最大总价值
	 */
	static int MFKnapsack(int i,int j) {
		if(F[i][j]<0) {  //记忆化
			if(j<weight[i]) {
				F[i][j] = MFKnapsack(i-1,j);
			}else {
				int v1 = MFKnapsack(i-1,j);
				int v2 = value[i]+MFKnapsack(i-1,j-weight[i]);
				if(v1 > v2) {
					F[i][j] = v1;
				}else {
					F[i][j] = v2;
				}
			}
		}
		return F[i][j];
	}
	
}
