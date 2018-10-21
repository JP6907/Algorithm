package SpaceTimeTradeoffs;
/**
 * <p>Title: Horspool</p>  
 * <p>Description: Horspool匹配算法</p>  
 * @author zjp
 * 2018年10月21日 上午10:59:56
 */
public class Horspool {
	private static final int ASCII_SIZE = 126;

	/**
	 * 计算跳转长度数组
	 * 
	 * @param str
	 * @return
	 */
	private static int[] getDis(String str) {
		int[] dis = new int[ASCII_SIZE];

		int len = str.length();
		for (int i = 0; i < ASCII_SIZE; i++) {
			dis[i] = len;
		}
		for (int i = 0; i < len - 1; i++) {
			dis[str.charAt(i)] = len - 1 - i;
		}
		return dis;
	}

	public static int horspoolSearch(String total, String part) {
		int tSize = total.length();
		int pSize = part.length();
		int[] move = getDis(part);

		int j = 0; // 模式串索引
		int pos = 0; // 主串索引
		while (pos <= tSize - pSize) {
			j = pSize - 1;
			while (j >= 0 && part.charAt(j) == total.charAt(pos + j)) {
				j--;
			}
			if (j == -1) {
				return pos;
			} else {
				pos = pos + move[total.charAt(pos + pSize - 1)];
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		String str1 = "searching substring";
		String str2 = "substr";
		int index = horspoolSearch(str1, str2);
		System.out.println(index);
	}
}
