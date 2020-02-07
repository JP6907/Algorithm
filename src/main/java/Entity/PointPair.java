package Entity;
/**
 * <p>Title: PointPair</p>  
 * <p>Description: 点对实体类</p>  
 * @author zjp
 * 2018年10月18日 上午9:30:11
 */
public class PointPair{
	public Point p1;
	public Point p2;
	
	public PointPair(Point p1, Point p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}
	public double getDistance() {
		return Math.sqrt( Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2) );
	}
	@Override
	public String toString() {
		return "PointPair:" + p1 + "," + p2 + " Distance:" + this.getDistance();
	}		
}