package Tools;

import java.util.Comparator;

import Entity.Point;

/**
 * 自定义比较器
 * @author zjp
 * 2018年10月18日 上午9:07:13
 */
public class MyComparator {
	/**
	 * 优先按点的X坐标排序的比较器
	 * @author zjp
	 * 2018年10月18日 上午9:07:41
	 */
	public static class XComparator implements Comparator<Point>{
		@Override
		public int compare(Point o1, Point o2) {
			if(o1.x == o2.x)
				return o1.y - o2.y;
			else
				return o1.x - o2.x;
		}
	}
}
