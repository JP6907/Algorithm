package GreedyTechniques;

import Entity.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>ClassName: Prim</p>
 * <p>Description: </p>
 *
 * @author
 */
public class Prim {

    public static void main(String[] args){
        Graph G = new Graph(6);
        G.addEdge(0,1,3);
        G.addEdge(0,5,5);
        G.addEdge(0,4,6);
        G.addEdge(1,5,4);
        G.addEdge(4,5,2);
        G.addEdge(1,2,1);
        G.addEdge(5,2,4);
        G.addEdge(3,5,5);
        G.addEdge(3,4,8);
        G.addEdge(2,3,6);

        int[][] treeEdge = GetSpanningTree(G);
        for(int i=0;i<treeEdge.length;i++){
            for(int j=0;j<treeEdge[0].length;j++){
                System.out.print(treeEdge[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static int[][] GetSpanningTree(Graph G){
        //储存最小生成树的边
        int[][] treeEdge = new int[G.vertexNum][G.vertexNum];

        List<Integer> inList = new ArrayList<Integer>();
        List<Integer> outList = new ArrayList<Integer>();

        inList.add(0);
        for(int i=1;i<G.vertexNum;i++)
            outList.add(i);

        while(outList.size()>0){
            int[] newEdge = findMinEdge(G,inList,outList);
            //加入新的点
            inList.add(newEdge[1]);
            outList.remove(new Integer(newEdge[1]));
            treeEdge[newEdge[0]][newEdge[1]] = 1;
            treeEdge[newEdge[1]][newEdge[0]] = 1;
        }

        return treeEdge;
    }

    /**
     * 求连接两个点集合的最短边
     * @param G
     * @param inList
     * @param outList
     * @return 长度为2的数组，int[0]为已加入的点集的点，int[1]为未加入的点集的点
     */
    public static int[] findMinEdge(Graph G,List<Integer> inList,List<Integer> outList){
        int[] edge = new int[2];
        int a=0 ,b=0;
        int minLen = Integer.MAX_VALUE;
        for(int i=0;i<inList.size();i++){
            for(int j=0;j<outList.size();j++){
                int temp1 = inList.get(i);
                int temp2 = outList.get(j);
                if(G.Edge[temp1][temp2]!=0&&G.Edge[temp1][temp2]<minLen){
                    a = temp1;
                    b = temp2;
                    minLen = G.Edge[temp1][temp2];
                }
            }
        }
        edge[0] = a;
        edge[1] = b;
        return edge;
    }
}
