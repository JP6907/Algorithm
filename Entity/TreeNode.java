package Entity;
/**
 * <p>Title: TreeNode</p>  
 * <p>Description: 二叉树节点</p>  
 * @author zjp
 * 2018年10月19日 下午2:59:01
 */
public class TreeNode {
	
	public int value;
	public TreeNode lchild;
	public TreeNode rchild;
	
	public TreeNode(int value) {
		super();
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(this.value);
	}
	
}
