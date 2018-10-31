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

    public AVLNode<T> getRoot(){
        return root;
    }

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

    private AVLNode<T> maxNode(AVLNode<T> tree){
//        if(tree!=null){
//                AVLNode<T> lmaxNode = maxNode(tree.lchild);
//                AVLNode<T> rmaxNode = maxNode(tree.rchild);
//                if(lmaxNode!=null&&rmaxNode!=null){
//                    AVLNode<T> maxchild = (lmaxNode.key.compareTo(rmaxNode.key)>0)?lmaxNode:rmaxNode;
//                    return (tree.key.compareTo(maxchild.key)>0)?tree:maxchild;
//                }else if(lmaxNode!=null){
//                    return (tree.key.compareTo(lmaxNode.key)>0?tree:lmaxNode);
//                }else if(rmaxNode!=null){
//                    return (tree.key.compareTo(rmaxNode.key)>0?tree:rmaxNode);
//                }else{
//                    return tree;
//                }
//        }else{
//            return null;
//        }
        if(tree!=null){
            if(tree.rchild!=null)
                return maxNode(tree.rchild);
            else
                return tree;
        }else
            return null;
    }

    public T Maximum(){
        AVLNode<T> maxNode = maxNode(this.root);
        if(maxNode!=null)
            return maxNode.key;
        else
            return null;
    }

    private AVLNode<T> minNode(AVLNode<T> tree){
//        if(tree!=null){
//            AVLNode<T> lminNode = minNode(tree.lchild);
//            AVLNode<T> rminNode = minNode(tree.rchild);
//            if(lminNode!=null&&rminNode!=null){
//                AVLNode<T> minchild = (lminNode.key.compareTo(rminNode.key)<0)?lminNode:rminNode;
//                return (tree.key.compareTo(minchild.key)<0)?tree:minchild;
//            }else if(lminNode!=null){
//                return (tree.key.compareTo(lminNode.key)<0?tree:lminNode);
//            }else if(rminNode!=null){
//                return (tree.key.compareTo(rminNode.key)<0?tree:rminNode);
//            }else{
//                return tree;
//            }
//        }else{
//            return null;
//        }
        if(tree!=null){
            if(tree.lchild!=null)
                return minNode(tree.lchild);
            else
                return tree;
        }else
            return null;
    }

    public T Minmum(){
        AVLNode<T> minNode = minNode(this.root);
        if(minNode!=null)
            return minNode.key;
        else
            return null;
    }

    private AVLNode<T> remove(AVLNode<T> node,AVLNode<T> deleteNode){
        if(node==null|| deleteNode==null)
            return null;
        else{
            int cmp = deleteNode.key.compareTo(node.key);
            if(cmp<0){  //待删除的点在左子树中
                node.lchild = remove(node.lchild,deleteNode);
                if(height(node.rchild) - height(node.lchild) == 2){ //删除后引起不平衡
                    if(height(node.rchild.rchild) > height(node.rchild.lchild)){
                        node = RightRightRotation(node);
                    }else
                        node = RightLeftRotation(node);
                }
            }else if(cmp>0){  //待删除的点在右子树中
                node.rchild = remove(node.rchild,deleteNode);
                if(height(node.lchild) - height(node.rchild) == 2){
                    if(height(node.lchild.lchild) > height(node.lchild.rchild)){
                        node = LeftLeftRotation(node);
                    }else{
                        node = LeftRightRotation(node);
                    }
                }
            }else{ //根节点为要删除的节点
                if(node.lchild!=null&&node.rchild!=null){
                    if(height(node.lchild)>height(node.rchild)){//左子树比较高，用左子树的最大值代替删除节点
                        AVLNode<T> lmaxnode = maxNode(node.lchild);
                        node.key = lmaxnode.key;
                        node.lchild = remove(node.lchild,lmaxnode);
                    }else{ //用右子树的最小值代替删除节点
                        AVLNode<T> rminnode = minNode(node.rchild);
                        node.key = rminnode.key;
                        node.rchild = remove(node.rchild,rminnode);
                    }
                }else {
                    node = node.lchild!=null?node.lchild:node.rchild;
                }
            }
        }
        return node;
    }

    public void remove(T key){
        AVLNode<T> node = search(this.root,key);
        if(node!=null)
            remove(this.root,node);
    }

    private AVLNode<T> search(AVLNode<T> node,T key){
        if(node!=null){
            if(node.key.compareTo(key)==0)
                return node;
            else if(node.key.compareTo(key)>0)
                return search(node.lchild,key);
            else
                return search(node.rchild,key);
        }else
            return null;
    }

    public static void main(String[] args){
        int[] data = {5,6,8,3,2,4,7};
        AVLTree<Integer> tree = new AVLTree<Integer>();
        for(int i=0;i<data.length;i++){
            tree.Insert(data[i]);
        }
        tree.InOrderTraversal();
        System.out.println("max:" + tree.Maximum());
        System.out.println("min:" + tree.Minmum());

        tree.remove(5);
        tree.InOrderTraversal();
        System.out.println(tree.getRoot().key);
    }

}
