package Entity;

import java.util.ArrayList;
import java.util.List;

/**  
 * @ClassName GraphD 有向图的邻接矩阵实现
 * @Description: TODO
 * @author ZJP
 * @date 18-10-22 下午3:56
 **/
public class GraphD {
	
	public int vertexNum = 10; //默认
	
	public char[] Vex;
	public int[][] Edge;
	
	public GraphD(int vertexNum) {
		super();
		if(vertexNum>0)
			this.vertexNum = vertexNum;
		Vex = new char[vertexNum];
		Edge = new int[vertexNum][vertexNum];
		
//		for(int i=0;i<this.vertexNum;i++) {
//			Edge[i][i] = 1;
//		}
	}
	
	public void addEdge(int i,int j,int weight) {
		if(i>=0&&i<this.vertexNum && j>=0&&j<this.vertexNum) {
			Edge[i][j] = weight;
		}
	}
	/**
	 * 深度优先搜索遍历无向图算法
	 * @param G
	 * @param v
	 * @param visited
	 * @param OrderList DFS遍历顺序列表
	 */
	public static void DFS(GraphD G, int v, int[] visited, List<Integer> OrderList) {
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
	public static int FirstNeighbor(GraphD G, int v) {
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
	public static int NextNeighbor(GraphD G, int v, int w) {
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
		GraphD G = new GraphD(6);
		G.addEdge(0, 1,2);
		G.addEdge(0, 3,3);
		G.addEdge(1, 4,3);
		G.addEdge(1, 2,5);
		G.addEdge(3, 2,1);
		G.addEdge(4, 5,4);
		G.addEdge(2, 5,2);

		int[] visited = new int[6];
		List<Integer> list = new ArrayList<Integer>();
		G.DFS(G, 0, visited,list);
		for(int i:list)
			System.out.println(i);
	}
}
