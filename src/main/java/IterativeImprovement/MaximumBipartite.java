package IterativeImprovement;

import Entity.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 增益路径法构造二分图的最大匹配
 */

public class MaximumBipartite {
    public static int N = 11;  //N-1个点，0不用
    public static int[] flag = new int[N];  //标志
    public static Graph G = new Graph(N);
    public static List<Integer> V = new ArrayList<Integer>();
    public static List<Integer> U = new ArrayList<Integer>();
    public static int[][] M = new int[N][N];

    public static void main(String[] args){

        Init();
        MaximumBipartiteMatching();

        for(int i:V){
            System.out.println(i + " " + findMatch(i));
        }
    }

    public static void Init(){
        G.addEdge(1,6,1);
        G.addEdge(1,7,1);
        G.addEdge(2,6,1);
        G.addEdge(3,6,1);
        G.addEdge(3,8,1);
        G.addEdge(4,8,1);
        G.addEdge(4,9,1);
        G.addEdge(4,10,1);
        G.addEdge(5,9,1);
        G.addEdge(5,10,1);

        V.add(1);
        V.add(2);
        V.add(3);
        V.add(4);
        V.add(5);

        U.add(6);
        U.add(7);
        U.add(8);
        U.add(9);
        U.add(10);

        for(int i=0;i<N;i++)
            flag[i] = -1;
    }

    public static void MaximumBipartiteMatching(){
        Queue<Integer> Q = new LinkedList<Integer>();
        Q.offer(1);
        while(!Q.isEmpty()){
            int w = Q.poll();
            if(Belong(w).equals("V")){//如果属于V集合
                //对于w的每个邻接顶点u
                for(int u=Graph.FirstNeighbor(G,w);u>=0;u=Graph.NextNeighbor(G,w,u)){
                    //如果u是自由顶点
                    if(isFree(u)) {
                        //M+ wu
                        addMatch(w, u);
                        //v=w
                        int v = w;
                        //增益
                        while (flag[v] != -1) {
                            u = flag[v];
                            removeMatch(u, v);
                            v = flag[u];
                            addMatch(u, v);
                        }
                        //删除所有顶点的标记
                        for(int i=1;i<N;i++)
                            flag[i] = -1;
                        //用V中的所有自由顶点重新初始化Q
                        while(!Q.isEmpty())
                            Q.poll();
                        for(int i:V){
                            if(isFree(i))
                                Q.offer(i);
                        }
                        break;
                    }else{ //如果已经匹配,不是自由顶点
                        // wu不属于M 且u未被做标记
                        if(M[w][u]==0 && flag[u]==-1){
                            //用w标记u
                            flag[u] = w;
                            //入队u
                            Q.offer(u);
                        }
                    }
                }
            }else{//如果属于U集合
                //如果已经匹配
                if(!isFree(w)) {
                    //用w标记w的对偶v
                    int v = findMatch(w);
                    flag[v] = w;
                    //将v入队
                    Q.offer(v);
                }
            }
        }
    }

    public static void addMatch(int i,int j){
        M[i][j] = 1;
        M[j][i] = 1;
    }
    public static void removeMatch(int i,int j){
        M[i][j] = 0;
        M[j][i] = 0;
    }
    //判断是否自由顶点
    public static boolean isFree(int i){
        if(findMatch(i)==-1)
            return true;
        else
            return false;
    }

    public static String Belong(int i){
        for(int v:V){
            if(v == i)
                return "V";
        }
        return "U";
    }
    //求已匹配的i点的对偶顶点
    public static int findMatch(int i){
        for(int j=1;j<N;j++)
            if(M[i][j] == 1)
                return j;
        return -1;
    }
}
