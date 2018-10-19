package Entity;

public class BSTree {
	
	public TreeNode root;
	
	public BSTree(int value) {
		root = new TreeNode(value);
		root.lchild = null;
		root.rchild = null;
	}
	
	
	public void insert(int value) {
		TreeNode node = new TreeNode(value);
		if(root==null) {
			root = node;
			root.lchild = null;
			root.rchild = null;
		}else {
			TreeNode current = root;
			TreeNode parent = null;
			while(true) {
				if(value>current.value) {
					parent = current;
					current = current.rchild;
					if(current==null) {
						parent.rchild = node;
						break;
					}
				}else if(value<current.value) {
					parent = current;
					current = current.lchild;
					if(current==null) {
						parent.lchild = node;
						break;
					}
				}else
					break;
			}
		}
	}
	
	public TreeNode SearchBST(TreeNode node,int value) {
		if(node!=null) {
			System.out.println("search:"+node.value);
			if(value == node.value)
				return node;
			else if(value>node.value)
				return SearchBST(node.rchild,value);
			else
				return SearchBST(node.lchild,value);
		}else
			return null;
	}
	/**
	 * 二叉查找树删除
	 * 如果没有子树，直接删除
	 * 如果只有一个子树，直接删除，用子树代替	
	 * 如果有两个子树，直接删除，，用直接前驱代替，即用左子树的最大值代替
	 * @param T
	 * @param data
	 */
//	public static void DeleteBST(BSTree T,int data) {
//		if(T != null) {
//			if(data == T.data)
//				Delete(T);
//			else if(data>T.data)
//				DeleteBST(T.rchild,data);
//			else
//				DeleteBST(T.lchild,data);
//		}
//	}
//	/**
//	 * 删除指定节点
//	 * @param T
//	 */
	private static void DeleteNode(TreeNode node) {
		if(node!=null) {
			if(node.lchild==null&&node.rchild==null) { //无子树
				node = null;
			}else if(node.lchild!=null) {
				node = node.lchild;
			}else if(node.rchild!=null) {
				node = node.rchild;
			}else { //左右子树都不为空
				TreeNode leftMax = FindMax(node.lchild);  
				node.value = leftMax.value; //用左子树的最大点代替,必定无右子树
				//替换之后删除左子树最大点
				DeleteNode(leftMax);
			}
		}
	}
//	/**
//	 * 寻找二叉树中的最大值
//	 * @param T
//	 * @return
//	 */
	public static TreeNode FindMax(TreeNode node) {
		if(node == null)
			return null;
		TreeNode n = node;
		while(n.rchild!=null)
			n = n.rchild;
		return n;
	}
//	/**
//	 * 中序遍历二叉树
//	 * @param T
//	 */
	public static void InOrderTraversal(TreeNode node) {
		if(node!=null) {
			InOrderTraversal(node.lchild);
			System.out.println("InOrder:" + node.value);
			InOrderTraversal(node.rchild);
		}
	}
	
	public static void main(String[] args) {
		int[] data = {3,1,8,2,6,7,5};
		BSTree T = new BSTree(3);
		//测试insert
		for(int i=0;i<data.length;i++) {
			T.insert(data[i]);
		}
		System.out.println(T.root.lchild.rchild==null);
		System.out.println(T.root.rchild.value);
		//测试search
		TreeNode node = T.SearchBST(T.root, 6);
		System.out.println(node==null?"null":node.value);
		//测试Inorder
		InOrderTraversal(T.root);
		//测试寻找最大顶点
		TreeNode maxNode = FindMax(T.root);
		System.out.println("Max:" + maxNode.value);
		//测试DeleteNode
		node = new TreeNode(8);
		T.DeleteNode(node);
		InOrderTraversal(T.root);
		
	}
	
}
