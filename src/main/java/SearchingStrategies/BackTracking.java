package SearchingStrategies;


/**
 * @ClassName BackTracking 回溯法求n皇后问题
 * @Description: TODO
 * @author ZJP
 * @date 18-10-22 上午9:10
 **/
public class BackTracking {
    //5-Queen 10
    //6 4
    //7 40
    //8 92
    //9 352
    public static int N = 8;
    public static int[] place = new int[N];   //第n行皇后的位置
    public static int cout = 0; //解的个数

    public static void main(String[] args){
        SearchQueen(0);
        System.out.println(cout);
    }

    public static void SearchQueen(int cur){
        if(cur == N){
            cout++;
        }else{
            for(int i=0;i<N;i++){
                boolean ok = true;
                place[cur] = i;
                for(int j=0;j<cur;j++){//检查是否产生冲突
                    //    0 0 0 0 0 0 0
                    //    0 0 0 0 0 0 0
                    //j   0 * 0 0 0 * 0
                    //    0 0 0 0 0 0 0
                    //cur 0 0 0 * 0 0 0
                    //    0 0 0 0 0 0 0
                    //    0 0 0 0 0 0 0
                    if(place[j]==place[cur] || cur-j==place[cur]-place[j] || cur-j==place[j]-place[cur]) {
                        ok = false;
                        break;
                    }
                }
                if(ok){
                    SearchQueen(cur+1);
                }
            }
        }
    }

    //通用模板
//    Bakctrack(X[1...i]){
//        if(X[1...i]是一个解)
//            wirteX[1....i]
//        else{
//            for(和X[1...i]及约束相容的每一个元素xi+1){
//                Xi+1 -> X[1....i+1]
//                Bakctrack(X[1....i+1])
//            }
//        }
//    }
}
