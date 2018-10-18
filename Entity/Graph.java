package Entity;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Title: Graph</p>  
 * <p>Description: 无向图的邻接矩阵实现</p>  
 * @author zjp
 * 2018年10月18日 下午10:05:10
 */
public class Graph {
	
	public int vertexNum = 10; //默认
	
	public int[] Vex;
	public int[][] Edge;
	
	public Graph(int vertexNum) {
		super();
		this.vertexNum = vertexNum;
		Vex = new int[vertexNum];
		Edge = new int[vertexNum][vertexNum];
		
		for(int i=0;i<this.vertexNum;i++) {
			Edge[i][i] = 1;
		}
	}
	
	public void addEdge(int i,int j) {
		if(i>=0&&i<this.vertexNum && j>=0&&j<this.vertexNum) {
			Edge[i][j] = 1;
			Edge[j][i] = 1;
		}
	}
	/**
	 * 深度优先搜索遍历无向图算法
	 * @param G
	 * @param v
	 * @param visited
	 * @param OrderSeq DFS遍历顺序列表
	 */
	public static void DFS(Graph G,int v,int[] visited,List<Integer> OrderList) {
		visited[v] = 1;
		OrderList.add(v);
		for(int w = G.FirstNeighbor(G, v);w>=0;w=G.NextNeighbor(G, v, w)) {
			if(visited[w]==0)
				DFS(G, w, visited, OrderList);
		}
	}
	/**
	 * 求图中定点v的第一个邻接点
	 * @param G 无向图
	 * @param v 
	 * @return
	 */
	public static int FirstNeighbor(Graph G,int v) {
		if(v<0||v>=G.vertexNum)
			return -1;
		
		int i=0;
		while(i<G.vertexNum&&G.Edge[v][i]==0)
			i++;
		if(i!=G.vertexNum)
			return i;
		else
			return -1;
	}
	/**
	 * 求图中顶点v在顶点w之后的下一个邻接点
	 * @param G
	 * @param v
	 * @param w
	 * @return
	 */
	public static int NextNeighbor(Graph G,int v,int w) {
		if(v<0||v>=G.vertexNum || w<0||w>=G.vertexNum)
			return -1;
		
		int i=w+1;
		while(i<G.vertexNum&&G.Edge[v][i]==0)
			i++;
		if(i!=G.vertexNum)
			return i;
		else
			return -1;
	}
	
	public static void main(String[] args) {
		Graph G = new Graph(8);
		G.addEdge(0, 1);
		G.addEdge(0, 2);
		G.addEdge(1, 3);
		G.addEdge(1, 4);
		G.addEdge(1, 5);
		G.addEdge(5, 6);
		G.addEdge(5, 7);
		int[] visited = new int[8];
		List<Integer> list = new ArrayList<Integer>();
		G.DFS(G, 0, visited,list);
		for(int i:list)
			System.out.println(i);
	}
}
