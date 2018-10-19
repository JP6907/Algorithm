package Entity;

public class BSTree {
	
	public BSTree lchild;
	public BSTree rchild;
	
	public int data;
	
	public static void CreateBST(BSTree T,int[] data) {
		T = null;
		for(int i=0;i<data.length;i++) {
			InsertBST(T,data[i]);
		}
	}
	
	public static boolean InsertBST(BSTree T,int data) {
		if(T == null) {
			T = new BSTree();	
			T.lchild = null;
			T.rchild = null;
			T.data = data;
			return true;
		}else if(data == T.data)
			return false;
		else if(data>T.data)
			return InsertBST(T.rchild,data);
		else
			return InsertBST(T.lchild,data);
		
	}
	
	public static BSTree SearchBST(BSTree T,int data) {
		if(T == null || data == T.data)
			return T;
		else if(data>T.data)
			return SearchBST(T.lchild,data);
		else
			return SearchBST(T.rchild,data);
	}
	/**
	 * 二叉查找树删除
	 * 如果没有子树，直接删除
	 * 如果只有一个子树，直接删除，用子树代替	
	 * 如果有两个子树，直接删除，，用直接前驱代替，即用左子树的最大值代替
	 * @param T
	 * @param data
	 */
	public static void DeleteBST(BSTree T,int data) {
		if(T != null) {
			if(data == T.data)
				Delete(T);
			else if(data>T.data)
				DeleteBST(T.rchild,data);
			else
				DeleteBST(T.lchild,data);
		}
	}
	/**
	 * 删除指定节点
	 * @param T
	 */
	private static void Delete(BSTree T) {
		if(T!=null) {
			if(T.lchild==null&&T.rchild==null) { //无子树
				T = null;
			}else if(T.lchild!=null) {
				T = T.lchild;
			}else if(T.rchild!=null) {
				T = T.rchild;
			}else { //左右子树都不为空
				BSTree leftMax = FindMax(T.lchild);  
				T.data = leftMax.data; //用左子树的最大点代替,必定无右子树
				//替换之后删除左子树最大点
				if(leftMax.lchild!=null)
					leftMax = leftMax.lchild;
				else
					leftMax = null;
			}
		}
	}
	/**
	 * 寻找二叉树中的最大值
	 * @param T
	 * @return
	 */
	public static BSTree FindMax(BSTree T) {
		if(T == null)
			return null;
		BSTree p = T;
		while(p.rchild!=null)
			p = p.rchild;
		return p;
	}
}
