package Sort;
/*
链接：https://www.jianshu.com/p/2e6eb7386cd3
來源：简书
简书著作权归作者所有，任何形式的转载都请联系作者获得授权并注明出处。
*/
public class Sunday {
	private static final int ASCII_SIZE = 126;   
	
	static int sundaySearch(char[] total,char[] part){
	        int tSize = total.length;
	        int pSize = part.length;
	        int[] move = new int[ASCII_SIZE];
	        //主串参与匹配最末位字符移动到该位需要移动的位数
	        for (int i= 0;i<ASCII_SIZE;i++){
	            move[i] = pSize+1;
	        }	       
	        for (int i = 0;i<pSize;i++){
	            move[part[i]] = pSize-i;
	        }	        
	        int s = 0;//模式串头部在字符串位        
	        int j;//模式串已经匹配了的长度	        
	        while(s<=tSize-pSize){//到达末尾之前
	            j = 0;
	            while(total[s+j]==part[j]){
	                j++;
	                if (j>=pSize){
	                    return s;
	                }
	            }
//	            int nextCompare = s+pSize; //跳到s+pSize，也就是模式串后的一个字符的位置
//	            int ascii_number = total[nextCompare];//获取转跳后位置的字符的ascii码值
//	            int moveLength = move[ascii_number];//根据ascii码值在move数组中查找模式串需要跳跃的长度
//	            s += moveLength; //让模式串首部在字符串的位置加上跳跃的长度，完成跳跃
	            s+=move[total[s+pSize]];
	        }
	        return -1;
	    }
	
	public static void main(String[] args) {
		 String str1 = "searching substring";
		 String str2 = "substr";
		 int index = sundaySearch(str1.toCharArray(),str2.toCharArray());
		 System.out.println(index);
	}
}
