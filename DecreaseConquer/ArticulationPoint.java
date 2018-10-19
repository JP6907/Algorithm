package DecreaseConquer;

import Entity.Graph;
/**
 * <p>Title: ArticulationPoint</p>  
 * <p>Description: 求图中关节点算法</p>  
 * @author zjp
 * 2018年10月19日 上午9:36:06
 */
public class ArticulationPoint {
	
	public static int ArcNum = 10;
	
	public static int[] visited = new int[ArcNum]; //访问数组
	public static int[] dfn = new int[ArcNum]; //访问时间数组
	public static int[] low = new int[ArcNum];
	public static int[] pred = new int[ArcNum]; //dsf搜索前向节点数组
	public static int time = 0;
	
	public static void main(String[] args) {
		for(int i=0;i<ArcNum;i++)
			pred[i] = -1;
		
		Graph G = new Graph(10);
		G.addEdge(0, 1);
		G.addEdge(1, 2);
		G.addEdge(2, 3);
		G.addEdge(0, 4);
		G.addEdge(0, 5);
		G.addEdge(1, 5);
		G.addEdge(2, 5);
		G.addEdge(2, 6);
		G.addEdge(3, 7);
		G.addEdge(4, 8);
		G.addEdge(4, 9);
		G.addEdge(8, 9);
		G.addEdge(6, 7);

		ArtPointDFS(G,0);
	}
	/**
	 * 深度优先搜索求关节点
	 * @param u
	 */
	public static void ArtPointDFS(Graph G,int u) {
		time++;
		low[u] = time;
		dfn[u] = time;
		visited[u] = 1;
		int children = 0;//记录u子树数
		
		for(int w=Graph.FirstNeighbor(G, u);w>=0;w=Graph.NextNeighbor(G, u, w)) {
			if(visited[w]==0) { //未被访问
				children++;
				pred[w] = u;
				ArtPointDFS(G,w);
				low[u] = min(low[u],low[w]); //此时（u，w）为树边
				if(pred[u]==-1&&children>1) { //关节点第一种情况：如果为根节点，而且子树数>1,则为关节点
					System.out.println("ArtPoint:" + u);
				}
				if(pred[u]!=-1&&low[w]>=dfn[u]) { //关节点第二种情况，非根节点（u，w）没有回边使w能够到达u的祖先
					System.out.println("ArtPoint:" + u);
				}
			}else if(w!=pred[u]) { //节点w已经访问，则（u，v）为回边
				low[u] = min(low[u],dfn[w]);
			}
		}
	}

	public static int min(int i,int j) {
		return (i>j)?j:i;
	}
}
