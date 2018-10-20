package SpaceTimeTradeoffs;
/**
 * <p>Title: KMP</p>  
 * <p>Description: KMP模式匹配算法</p>  
 * @author zjp
 * 2018年10月20日 下午4:30:26
 */
public class KMP {

	public static void main(String[] args) {
		String s = "bacbabababacaca";
		String p = "ababaca";
		int[] next = getNext(p.toCharArray());
		for(int i=0;i<next.length;i++)
			System.out.print(next[i] + " ");
		KMPMatch(s.toCharArray(),p.toCharArray());

	}
	
	public static void KMPMatch(char[] s,char[] p) {
		int[] next = getNext(p);
		int i=0,j=0;
		while(i<s.length) {
			while(p[j]==s[i]&&i<s.length&&j<p.length) {
				i++;
				j++;
			}
			if(i<s.length&&j<p.length&&p[j]!=s[i])
				j = next[j];
			if(j==p.length) {
				System.out.println("Get:" + (i-p.length));
				//j = next[j];
				break;
			}
		}
	}
	public static int[] getNext(char[] p) {
		int[] next = new int[p.length];
		next[0] = -1;
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
