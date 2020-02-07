package SpaceTimeTradeoffs;

public class BoyerMoore {
	
	private static final int ASCII_SIZE = 126;

	public static void main(String[] args) {
		String p = "BAOBAB";
		int[] badTc = badTc(p.toCharArray());
		for(int i=0;i<p.length();i++)
			System.out.print(badTc[p.charAt(i)] + " ");
		System.out.println();


	}
	
	public static void BMMatch(char[] s,char[]p) {
		
	}
	/**
	 * 计算求坏符号移动距离 t(c)-k 中的t(c)
	 * @param p
	 */
	public static int[] badTc(char[] p) {
		int[] t = new int[ASCII_SIZE];
		int len = p.length;
		
		for(int i=0;i<ASCII_SIZE;i++)
			t[i] = len;
		for(int i=0;i<len-1;i++) 
			t[p[i]] = len - i -1;
		return t;
	}
	/**
	 * 求坏移动表
	 * k 已经匹配的个数
	 */
	public static int badMove(int t,int k){
		return max(t-k,1);
	}

	private static int max(int a,int b){
		return a>b?a:b;
	}


}
