package IterativeImprovement;

import Entity.GraphD;
import Tools.Tools;

import javax.tools.Tool;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName  最大网络流问题
 * @Description: TODO 使用增益路径法求最大网络流
 * @author ZJP
 * @date 18-10-22 下午3:45
 **/
public class MaxFlow {

    public static int N = 6;  //顶点数量
    //public static int[][] R = new int[N][N];  //边未使用流量
    public static int[][] X = new int[N][N];  //边已使用流量
    public static int[][] U = new int[N][N];  //边最大流量
    //public static int[] L = new int[N];  //标记点还能增加多少流量
    public static int[][] Flag = new int[N][2];//还能增加的流量，另一个顶点编号


    public static void main(String[] args){
        GraphD G = new GraphD(6);
        G.addEdge(0, 1,2);
        G.addEdge(0, 3,3);
        G.addEdge(1, 4,3);
        G.addEdge(1, 2,5);
        G.addEdge(3, 2,1);
        G.addEdge(4, 5,4);
        G.addEdge(2, 5,2);

        InitNetwork( G);
        ShortestAugmentingPath(G);
    }


    public static void InitNetwork(GraphD G){
        for(int i=0;i<G.vertexNum;i++){
            Flag[i][1] = -1;
            for(int j=0;j<G.vertexNum;j++){
                if(G.Edge[i][j]>0){
                    U[i][j] = G.Edge[i][j];//初始化最大流量
                    X[i][j] = 0;
                }
            }
        }
        Flag[0][1] = -2;  //源点标记为-2,其他为-1
        Flag[0][0] = Integer.MAX_VALUE;
    }

    public static int ShortestAugmentingPath(GraphD G){
        int maxFlow = 0;

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);

        while(!queue.isEmpty()){
            int i = queue.poll();
            //从i到j每条边  前向边
            for(int j = G.FirstNeighbor(G, i);j>=0;j=G.NextNeighbor(G, i, j)){
                //如果j还未被标记
                if(Flag[j][1]==-1){
                    int r = U[i][j] - X[i][j];
                    if(r>0){
                        //标记j
                        Flag[j][0] = Tools.min(Flag[i][0],r);
                        Flag[j][1] = i;
                        queue.offer(j);
                    }
                }
            }
            //从j到i的每条边  后向边
            for(int j=G.FirstBackNeighbor(G,i);j>=0;j=G.NextBackNeighbor(G,i,j)){
                //如果j还未被标记
                if(Flag[j][1]==-1){
                    if(X[j][i]>0){
                        //标记j
                        Flag[j][0] = Tools.min(Flag[i][0],X[j][i]);
                        Flag[j][1] = 0-i;
                        queue.offer(j);
                    }
                }
            }
            //如果是汇点，从汇点开始方向移动增益
            if(G.FirstNeighbor(G,i)==-1){
                maxFlow +=  Flag[i][0]; //增加流量
                System.out.println("当前增益路径增加流量：" + Flag[i][0]);

                int j=i;
                i = Flag[j][1];
                while(j!=0){ //未到达源点
                    if(i>=0){ //标记是i+
                        X[i][j] +=Flag[j][0];
                        j = i;
                        i = Flag[j][1];
                    }else{ //标记是i-
                        X[j][-i] -=Flag[j][0];
                        j = -i;
                        i = Flag[j][1];
                    }
                }
                //回到源点之后，除源点擦去所有标记，用源点对队列重新初始化
                for(int k=1;k<G.vertexNum;k++){
                    Flag[k][0] = 0;
                    Flag[k][1] = -1;
                }
                while(!queue.isEmpty())
                    queue.poll();
                queue.offer(0);
            }
        }
        System.out.println("最大流量:" + maxFlow);

        return maxFlow;
    }

}

