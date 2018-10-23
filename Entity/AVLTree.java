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

    private AVLNode<T> leftLeftRotation(AVLNode<T> node){
        AVLNode<T> lnode = node.lchild;
        node.lchild = lnode.rchild;
        lnode.rchild = node;

        node.height = max(node.lchild.height,node.rchild.height) + 1;
        lnode.height = max(lnode.lchild.height,node.height) + 1;

        return lnode;
    }

    private AVLNode<T> RightRightRotation(AVLNode<T> node){
        AVLNode<T> rnode = node.rchild;
        node.rchild = rnode.lchild;
        rnode.lchild = node;

        node.height = max(node.lchild.height,node.rchild.height) + 1;
        rnode.height = max(rnode.rchild.height,node.height) + 1;

        return rnode;
    }

}
