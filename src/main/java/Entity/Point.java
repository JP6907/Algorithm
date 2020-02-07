package Entity;

/**
 * <p>Title: Point</p>  
 * <p>Description: 点实体类</p>  
 * @author zjp
 * 2018年10月18日 上午9:29:43
 */
public class Point{
	public int x;
	public int y;

	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}	
}