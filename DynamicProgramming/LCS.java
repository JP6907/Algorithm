/**
 * Longest Common Subsequence
 * 最长公共子序列
 */
package DynamicProgramming;

import Tools.Tools;

public class LCS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "providence";
		String str2 = "president";
		int[][] len = getLCS(str1,str2);
		
		Tools.printMartix(len);
		System.out.println("当前最大公共子序列长度为：" + len[str1.length()][str2.length()]);
	}

	static int[][] getLCS(String str1,String str2) {
		int[][] len = new int[str1.length()+1][str2.length()+1];
		String[][] flag = new String[str1.length()+1][str2.length()+1];
		//初始化边界
		for(int i=0;i<=str1.length();i++) {
			len[i][0] = 0;
		}
		for(int j=0;j<str2.length();j++) {
			len[j][0] = 0;
		}
		//填充矩阵
		for(int i=1;i<=str1.length();i++) {
			for(int j=1;j<=str2.length();j++) {
				//相等
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					len[i][j] = len[i-1][j-1] + 1;
					flag[i][j] = "left_up";
					System.out.println("(" + i + "," + j + ")" + ":" + str1.charAt(i-1));
				}else {
					//比较左边和上边
					if(len[i-1][j]>=len[i][j-1]) {//左边大 
						len[i][j] = len[i-1][j];
						flag[i][j] = "left   ";
					}else {
						len[i][j] = len[i][j-1];
						flag[i][j] = "up     ";
					}
				}
			}
		}
		Tools.printMartix(flag);
		return len;
	}
}
