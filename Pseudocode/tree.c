//建树
//前序遍历
//中序遍历
//后序遍历
//层序遍历
//高度
//宽度

//先序建立
void createBiTree(BiTree &T){
    scanf(&ch);
    if(ch==' ')
        T=null;
    else{
        if(!T=(BiTree*)malloc(sizeof(BiTree)))
            exit(overflow);
        T-data=ch;
        CreateBiTree(T->lchild);
        CreateBiTree(T->rchild);
    }   
}
void createBiTree(BiTree T){
    scanf(&ch);
    if(ch==' ')
        T=null;
    else{
        if(T=(BiTree*)malloc(sizeof(BiTree)))
            exit;            
        T->data=ch;
        createBiTree(T->lchild);
        CreateBiTree(T->rchild);
    }
}
void createBiTree(BiTree &T){
    scanf(&ch);
    if(ch==' ')
        T=null;
    else{
        if(!T=(BiTree*)malloc(sizeof(BiTree)))
            return;
        else{
            T->data=ch;
            createBiTree(T->lchild);
            createBiTree(T->rchild);
        }
    }
}
//先序遍历
void PreOrder(BTree *BT){
    int top;
    p=BT;
    while(p!=null||top!=0){
        if(p!=null){
            top++;
            Stack[top]=p;
            printf(p->data);
            p=p->lchild;
        }
        if(top!=0){
            p=Stack[top];
            top--;
            p=p->rchild;
        }
    }
}
void PreOrder(BTree *BT){
    int top;
    p=BT;
    while(p!=null||top!=0){
        if(p!=null){
            top++;
            Stack[top]=p;
            printf(p->data);
            p=p->rchild;
        }
        if(top!=0){
            p=Stack[top];
            top--;
            p=p->rchild;
        }
    }
}
//后序遍历
void PostOrder(BTree *BT){
    int top=0;
    int mark;
    p=BT;
    while(p!=null||top!=0){
        if(p!=null){
            top++;
            Stack[top].link = p;
            Stack[top].mark = 1;
            p=p->lchild;
        }
        if(top!=0){
            p=Stack[top].link;
            mark=Stack[top].mark;
            top--;
            if(mark==1){
                top++;
                Stack[top].link=p;
                Stack[top].mark=2;
                p=p->rchild;
            }else{
                printf(p->data);
                p=null;
            }
        }
    }
}
void PostOrder(BTree *BT){
    int top=0;
    int mark;
    p=BT;
    while(p!=null||top!=0){
        while(p!=null){
            top++;
            Stack[top].link=p;
            Stack[top].mark=1;
            p=p->lchild;
        }
        if(top!=0){
            p=Stack[top].link;
            mark=Stack[top].mark;
            top--;
            if(mark==1){
                top++;
                Stack[top].link=p;
                Stack[top].mark=2;
                p=p->rchild;
            }else{
                printf(p->data);
                p=null;
            }
        }
    }
}
//层次遍历
void levelOrder(BTree *BT){
    int front=0,rear=1;
    if(BT==null)
        return;
    Queue[rear]=BT;
    while(front!=rear){
        front++;
        p=Queue[front];
        printf(p->data);
        if(p->lchild){
            rear++;
            Queue[rear]=p->lchild;
        }
        if(p->rchild){
            rear++;
            Queue[rear]=p->lchild;
        }
    }
}
void levelOrder(BTree *BT){
    int front=0,rear=1;
    if(BT==null)
        return;
    Queue[rear]=BT;
    while(front!=rear){
        p=Queue[++front];
        printf(p->data);
        if(p->lchild)
            Queue[++rear]=p->lchild;
        if(p->rchild)
            Queue[++rear]=p->rchild;
    }
}
//高度
int BtDepth(BiTree T){
    if(!T)
        return 0;
    int front=-1,rear=-1;
    int last=0,level=;
    BiTree Q[MaxSize];
    Q[++rear]=T;
    while(front<rear){
        p=Q[++front];
        if(p->lchild)
            Q[++rear]=p->lchild;
        if(p->rchild)
            Q[++rear]=p->rchild;
        if(front==last){
            last=rear;
            level++;
        }
    }
    return level;
}
int BtDepth(BiTree *T){
    if(!T)
            return 0;
    int front=-1,rear=-1;
    int last=0,level=0;
    BiTree Q[MaxSize];
    Q[++rear]=T;
    while(front<rear){
        p=Q[++front];
        if(p->lchild)
            Q[++rear]=p->lchild;
        if(p->rchild)
            Q[++rear]=p->rchild;
        if(front==last){
            last=rear;
            level++;
        }
    }
    return level;
}
int BtDept(BiTree *T){
    if(!T)
        return 0;
    lDept = BtDept(T->lchild);
    rDept = BtDept(T->rchild);
    if(lDept>rDept)
        return lDept+1;
    else
        return rDept+1;
}
//宽度    
int BtWidth(BiTree *T){
    int front=-1,rear=-1;
    int last=0,level=0;
    int width=0;
    BiTree Q[MaxSize];
    int L[MaxSize];
    Q[++rear]=T;
    L[++rear]=1;
    while(front<rear){
        p=Q[++front];
        if(p->lchild){
            Q[++rear]=p->lchild;
            L[rear]=L[front]+1;
        }
        if(p->rchild){
            Q[++rear]=p->rchild;
            L[rear]=L[front]+1;
        }
        if(front==last){
            if(rear-front>width)
                width=rear-front;
            last=rear;
            level++;
        }
    }
}
k=1;
while(i<=rear){
    n=0;
    while(i<=reat&&Q[i]==k){
        i++;
        n++;
    }
    k=Q[i];
    if(n>max)
        max=n;
}
return max;