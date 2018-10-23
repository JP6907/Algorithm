package Entity;

/**  
 * @ClassName AVLTree
 * https://www.cnblogs.com/skywang12345/p/3577479.html
 * @Description: TODO
 * @author ZJP
 * @date 18-10-23 下午3:06
 **/
public class AVLTree<T extends Comparable<T>> {

    private AVLNode<T> root;

    public class AVLNode<T extends Comparable<T>>{

        T key;
        int height;
        AVLNode<T> lchild;
        AVLNode<T> rchild;

        public AVLNode(T key,AVLNode<T> lchild,AVLNode<T>rchild){
            this.key = key;
            this.lchild = lchild;
            this.rchild = rchild;
        }
    }

    private int height(AVLNode<T> tree){
        if(tree!=null)
            return tree.height;
        else
            return 0;
    }

    public int height(){
        return height(root);
    }

    private int max(int a,int b){
        return (a>b)?a:b;
    }

    private AVLNode<T> LeftLeftRotation(AVLNode<T> node){
        AVLNode<T> lnode = node.lchild;
        node.lchild = lnode.rchild;
        lnode.rchild = node;

        node.height = max(height(node.lchild),height(node.rchild)) + 1;
        lnode.height = max(height(lnode.lchild),node.height) + 1;

        return lnode;
    }

    private AVLNode<T> RightRightRotation(AVLNode<T> node){
        AVLNode<T> rnode = node.rchild;
        node.rchild = rnode.lchild;
        rnode.lchild = node;

        node.height = max(height(node.lchild),height(node.rchild)) + 1;
        rnode.height = max(height(rnode.rchild),node.height) + 1;

        return rnode;
    }

    private AVLNode<T> LeftRightRotation(AVLNode<T> node){
        node.lchild = RightRightRotation(node.lchild);
        return LeftLeftRotation(node);
    }

    private AVLNode<T> RightLeftRotation(AVLNode<T> node){
        node.rchild = LeftLeftRotation(node.rchild);
        return RightRightRotation(node);
    }

    private AVLNode<T> insert(AVLNode<T> tree,T key){
        if(tree==null){
            tree = new AVLNode<T>(key,null,null);
        }else{
            int cmp = key.compareTo(tree.key);
            if(cmp<0){//插入左子树
                tree.lchild = insert(tree.lchild,key);
                if(height(tree.lchild) - height(tree.rchild) == 2){
                    if(key.compareTo(tree.lchild.key)<0){ //LL
                        tree = LeftLeftRotation(tree);
                    }else { //LR
                        tree = LeftRightRotation(tree);
                    }
                }
            }else if(cmp>0){//插入右子树
                tree.rchild = insert(tree.rchild,key);
                if(height(tree.rchild) - height(tree.lchild) == 2){
                    if(key.compareTo(tree.rchild.key)<0){ //RL
                        tree = RightLeftRotation(tree);
                    }else{ //RR
                        tree = RightRightRotation(tree);
                    }
                }
            }
        }

        tree.height = max(height(tree.lchild),height(tree.rchild)) + 1;

        return tree;
    }

    public void Insert(T key){
        this.root = insert(this.root,key);
    }

    private void InOrderTraversal(AVLNode<T> tree){
        if(tree!=null){
            InOrderTraversal(tree.lchild);
            System.out.println(tree.key);
            InOrderTraversal(tree.rchild);
        }
    }

    public void InOrderTraversal(){
        InOrderTraversal(this.root);
    }


    public static void main(String[] args){
        int[] data = {5,6,8,3,2,4,7};
        AVLTree<Integer> tree = new AVLTree<Integer>();
        for(int i=0;i<data.length;i++){
            tree.Insert(data[i]);
        }
        tree.InOrderTraversal();
    }

}
