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


		String p1 = "0ababaca";
		String s1 = "0bacbabababacaab";
		int[] next1 = getNext2(p1.toCharArray());
		for(int i=1;i<next1.length;i++)
			System.out.print(next1[i] + " ");
		System.out.println();
		KMPMatch2(s1.toCharArray(),p1.toCharArray());

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
	/**
	 * @ClassName KMP 版本1  next[k]为k不匹配时，跳转到的下一个开始的匹配位置，从0开始
	 * @Description: TODO
	 * @author ZJP
	 * @date 18-10-31 上午9:11
	 **/
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

	/**
	 * @ClassName KMP 版本1  next[k]为k不匹配时，跳转到的下一个开始的匹配位置，从1开始
	 * @Description: TODO
	 * @author ZJP
	 * @date 18-10-31 上午9:11
	 **/
	public static int[] getNext1(char[] p){
		int[] next = new int[p.length];
		int k=0;
		int i=1;
		next[1] = 0;
		while(i<p.length-1){
			if(k==0||p[i]==p[k]){
				k++;
				i++;
				next[i] = k;
			}else
				k = next[k];
		}
		return next;
	}

	public static void KMPMatch1(char[] s,char[] p){
		int[] next = getNext(p);
		for(int i=1;i<next.length;i++)
			System.out.println(next[i]);
		int k=0;
		for(int i=1;i<p.length;i++){
			while(k>0&&p[k+1]!=s[i])
				k = next[k];
			if(p[k+1]==s[i])
				k++;
			if(k==p.length-1){
				System.out.println("Get it:" + (i-k));
				k = next[k];
			}
		}
	}
	/**  
	 * @ClassName KMP 版本2,next[k]表示包括第k位置在内的最大匹配前缀,从1开始
	 * @Description: TODO
	 * @author ZJP
	 * @date 18-10-31 上午9:44
	 **/
	public static int[] getNext2(char[] p){
		int[] next = new int[p.length];
		next[1] = 0;
		int k=0;
		for(int i=2;i<p.length;i++){
			while(k>0&&p[k+1]!=p[i])
				k = next[k];
			if(p[k+1]==p[i]) {
				k++;
				next[i] = k;
			}
		}
		return next;
	}

	public static void KMPMatch2(char[] s,char[] p){
		int[] next = getNext2(p);
		int k=0;
		for(int i=1;i<s.length;i++){
			while(k>0&&p[k+1]!=s[i])
				k = next[k];
			if(p[k+1]==s[i])
				k++;
			if(k==p.length-1){
				System.out.println("Get it:" + (i-k +1));
				k = next[k];
			}
		}
	}
}
