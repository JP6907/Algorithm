package SpaceTimeTradeoffs;

/**
 * <p>Title: KMP</p>  
 * <p>Description: KMP模式匹配算法</p>  
 * @author zjp
 * 2018年10月21日 上午10:26:36
 */
public class KMP {

	public static void main(String[] args) {
		String s = "bacbababadababacambabacaddababacasdsd";
		String p = "ababaca";
		int[] next = getNext(p.toCharArray());
		for(int i=0;i<next.length;i++)
			System.out.print(next[i] + " ");
		System.out.println();
		KMPMatch(s.toCharArray(),p.toCharArray());

	}
	
	public static void KMPMatch(char[] s,char[] p) {
		int[] next = getNext(p);
		int k = -1;
		for(int i=0;i<s.length;i++) { 
			while(k>-1&&p[k+1]!=s[i]) //s和p不匹配，且k>1，表明p和s有部分公共前缀
				k = next[k];  //往前回溯
			if(p[k+1]==s[i])
				k++;
			if(k==p.length-1) {
				System.out.println("Get it:" + (i-k)); 
				k = next[k]; //寻找下一个匹配串
			}
		}
	}
	public static int[] getNext(char[] p) {
		int[] next = new int[p.length];
		next[0] = -1; //next[0]初始化为-1，-1表示不存在相同的最大前缀和最大后缀
		int k=-1;
		for(int i=0;i<p.length-1;) {
			if(k==-1||p[i]==p[k]) {
				i++;
				k++;
				next[i] = k;
			}else {
				k = next[k];
			}
		}
		return next;
	}
}
