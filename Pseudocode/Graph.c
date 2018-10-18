//建图
//邻接矩阵
//构造无向网
void createNet(Graph &G){
    scanf(&G.vexnum,&G.arcnum,&IncInfo)//IncInfo为0为各弧不包含其他信息
    for(i=0;i<G.vexnum;i++)
        scanf(&G.vexs[i]);
    for(i=0;i<G.vexnum;i++)
        for(j=0;j<G.vexnum;j++)
            G.arcs[i][j] = -1;
    for(k=0;k<G.arcnum;k++){
        scanf(&v1,&v2,&w);
        i=LocateVex(G,v1);
        j=LocateVex(G,v2);
        G.arcs[i][j].adj=w;
        G.arcs[j][i]=G.arcs[i][j];
    }
}
void createNet(Graph &G){
    scanf(&G.vexnum,&G.arcnum);
    for(i=0;i<G.vexnum;i++)
        scanf(&G.vexs[i]);
    for(i=0;i<G.vexnum;i++)
        for(j=0;j<G.vexnum;j++)
            G.arcs[i][j]=-1;
    for(k=0;k<G.arcnum;k++){
        scanf(&v1,&v2,&w);
        i=LocateVex(G,v1);
        j=LocateVex(G,v2);
        G.arcs[i][j].adj=w;
        G.arcs[j][i]=G.arcs[i][j];
    }
}
//邻接表
//构造有向网
void createDG(Graph &G){
    scanf(&G.vexnum,&G.arcnum);
    for(i=0;i<G.vexnum;i++){
        scanf(&G.vexs[i].data);
        G.vexs[i].firstarc=null;
    }
    for(k=0;<G.arcnum;k++){
        scanf(&v1,&v2,&w);
        i=LocateVex(G,v1);
        j=LocateVex(G,v2);
        if(G.vexs[i].firstarc==null){
            p=(ArcNode*)malloc(sizeof(ArcNode));
            p.adj=w;
            p.nextarc=null;
            G.vexs[i].firstarc=p;
        }else{
            p=G.vexs[i].firstarc;
            while(p.nextarc!=null)
                p=p.nextarc;
            q=(ArcNode*)malloc(sizeof(ArcNode));
            q.adj=w;
            q.nextarc=null;
            p.nextarc=q;
        }
    }
        
}

//邻接矩阵
typedef struct{
    VertexType Vex[MaxVertexNum];
    EdgeType Edge[MaxVertexNum][MaxVertexNum]; 
    int vexnum,arcnum;
}MGraph;
//邻接表
typedef struct ArcNode{
    int adjvex;
    struct ArcNode *next;
}
typedef struct VNode{
    VertexType data;
    ArcNode *first;
}VNode,AdjList[MaxVertexNum];
typedef struct Graph{
    AdjList vertices;
    int vexnum,arcnum;
}
//邻接表转化成邻接矩阵
void convert(ALGraph &G,int arcs[M][N]){
    for(int i=0;i<n;i++){
        p=(G->v[i]).firstarc;
        while(p!=null){
            arcs[i][p->data]=1;
            p=p->nextarc;
        }
    }
}
void convert(ALGraph &G,int arcs[M][N]){
    for(int i=0;i<n;i++){
        p=(G->v[i]).firstarc;
        while(p!=null){
            arcs[i][p->data]=1;
            p=p->nextarc;
        }
    }
}
//BFS
void BFSTraverse(Graph G){
    for(i=0;i<G.vexnum;i++){
        visited[i] = false;
    }
    InitQueue(Q);
    for(i；i<G.vexnum;i++){
        if(!visited[i])
            BFS(G,i);
    }
}
void BFS(Graph G,int v){
    visit(v);
    visited[v]=true;
    EnQueue(Q,v);
    while(!IsEmpty(Q)){
        DeQueue(Q,v);
        for(w=FirstNeighbor(Q,v);w>=0;w=NextNeighbor(G,v,w)){
            if(!visited[w]){
                visit(v);
                visited[v]=true;
                EnQueue(Q,w);
            }
        }
    }
}
void BFS(Graph G,int v){
    visit(v);
    visited[v]=true;
    InitQueue(Q);
    EnQueue(Q,v);
    while(!IsEmpty(Q)){
        DeQueue(Q,v);
        for(w=FirstNeighbor(Q,v);w>=0;w=NextNeighbor(Q,v,w)){
            if(!visited[w]){
                visit(w);
                visited[W]=true;
                EnQueue(Q,w);
            }
        }
    }
}
void BFSTraverse(Graph G){
    for(int i=0;i<G.vexnum;i++){
        visited[i]=false;
    }
    InitQueue(Q);
    for(i=0;i<G.vexnum;i++){
        if(!visited[i]){
            BFS(G,i);
        }
    }
}
//DFS
void DFSTraverse(Graph G){
    for(i=0;i<G.vexnum;i++){
        visited[i]=false;
    }
    for(i=0;i<G.vexnum;i++){
        if(!visited[i])
            DFS(G,i);
    }
}
void DFS(Graph G,int v){
    visit(v);
    visited[v]=true;
    for(w=FirstNeighbor(G,v);w>=0;w=NextNeighbor(G,v,w)){
        if(!visited[w])
            DFS(G,w);
    }
}
void DFS(Graph G,int v){
    visit(v);
    visited[v]=true;
    for(w=FirstNeighbor(G,v);w>=0;w=NextNeighbor(G,v,w)){
        if(!visited[w])
            DFS(G,w);
    }
}
//isTree
bool isTree(Graph &G){
    for(i=0;i<G.vexnum;i++)
        visited[i]=false;
    int VNum=0,ENum=0;
    DFS(G,0);
    if(VNum==G.vexnum&&ENum==2*(G.vexnum-1))
        return true;
    else
        return false;
}
void DFS(Graph G,int v){
    visit(v);
    visited[v]=true;
    VNum++;
    for(w=FirstNeighbor(G,v);w>=0;w=NextNeighbor(G,v,w)){
        ENum++;
        if(!visited[w])
            DFS(G,w);
    }
}
bool isTree(Graph G){
    for(i=0;i<G.vexnum;i++)
        visited[i]=false;
    int VNum=0,ENum=0;
    DFS(G,0);
    if(VNum==G.vexnum&&ENum==2*(G.vexnum-1))
        return true;
    else    
        return false;
}
void DFS(Graph G,int v){
    visit(v);
    visited[v]=true;
    VNum++;
    for(w=FirstNeighbor(G,v);w>=0;w=NextNeighbor(G,v,w)){
        ENum++;
        if(!visited[w])
            DFS(G,w);
    }
}