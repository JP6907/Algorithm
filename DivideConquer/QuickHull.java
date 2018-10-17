/**
 * 快包问题
 */
package DivideConquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Tools.Point;

public class QuickHull {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point p1 = new Point(1,0);
		Point p2 = new Point(3,7);
		Point p3 = new Point(10,0);
		Point p4 = new Point(5,8);
		Point p5 = new Point(20,8);
		Point p6 = new Point(3,18);
		Point p7 = new Point(100,8);
		Point p8 = new Point(-1,4);
		Point p9 = new Point(5,25);
		Point p10 = new Point(0,9);
		Point p11 = new Point(-5,13);
		
		List<Point> plist = new ArrayList<Point>();
		plist.add(p1);
		plist.add(p2);
		plist.add(p3);
		plist.add(p4);
		plist.add(p5);
		plist.add(p6);
		plist.add(p7);
		plist.add(p8);
		plist.add(p9);
		plist.add(p10);
		plist.add(p11);
	
		Collections.sort(plist, new XComparator());
		
		List<Point> hullList = UpQuickHull(plist);
		for(int i=0;i<hullList.size();i++) {
			System.out.print(hullList.get(i) + "  ");
		}
		System.out.println();
	}
	
	public static List<Point> UpQuickHull(List<Point> list){
		List<Point> hullList = new ArrayList<Point>();
		if(list.size()<4) {
			hullList.addAll(list);
			return hullList;
		}else {
			Collections.sort(list, new XComparator());
			//MergeSort.PointMergeSort(list, 0, hullList.size()-1, "X");
			//最左边和最右边的点必定是快包顶点
			Point p1 = list.get(0);
			Point pn = list.get(list.size()-1);
			hullList.add(p1);
			hullList.add(pn);
			
			Point pMax = p1;  //上包顶点
			//寻找上包中离直线p1pn最远的点
			double maxArea = 0;
			for(int i=1;i<list.size()-1;i++) {
				double area = area(p1,pn,list.get(i));
				if(area > maxArea) {
					maxArea = area;
					pMax = list.get(i);
				}else if(area == maxArea) {//有多个相同距离顶点，选择角PmaxP1Pn最大的点，即横坐标最小的点
					if(list.get(i).x<pMax.x) {
						pMax = list.get(i);
					}
				}
			}
			List<Point> upList1 = new ArrayList<Point>();
			List<Point> upList2 = new ArrayList<Point>();
			upList1.add(p1);
			upList1.add(pMax);
			upList2.add(pn);
			upList2.add(pMax);
			for(int i=1;i<list.size()-1;i++) {
				if(location(p1,pMax,list.get(i)).equals("LEFT"))
					upList1.add(list.get(i));
				else if(location(pMax,pn,list.get(i)).equals("LEFT"))
					upList2.add(list.get(i));
			}
//			hullList.addAll(UpQuickHull(upList1));
//			hullList.addAll(UpQuickHull(upList2));
			List<Point> hull1 = UpQuickHull(upList1);
			List<Point> hull2 = UpQuickHull(upList2);
			for(Point p: hull1)
				hullList.add(p);
			for(Point p: hull2)
				hullList.add(p);
			return hullList;
		}
	}
	
	/**
	 * 求点p3在直线p1p2的相对位置
	 * @param p1
	 * @param p2
	 * @param p3
	 * @return "LEFT" "RIGHT"  "IN"
	 */
	public static String location(Point p1,Point p2,Point p3) {
		int d = p1.x*p2.y + p3.x*p1.y + p2.x*p3.y - p3.x*p2.y - p2.x*p1.y - p1.x*p3.y;
		if(d > 0)
			return "LEFT";
		else if(d < 0)
			return "RIGHT";
		else
			return "IN";
	}
	/**
	 * 求三角形面积
	 * @param p1
	 * @param p2
	 * @param p3
	 * @return
	 */
	public static double area(Point p1,Point p2,Point p3) {
		int d = p1.x*p2.y + p3.x*p1.y + p2.x*p3.y - p3.x*p2.y - p2.x*p1.y - p1.x*p3.y;
		return ((double)Math.abs(d))/2;
	}
	
	//优先按X坐标升序排列的比较器
	static class XComparator implements Comparator<Point>{
		@Override
		public int compare(Point o1, Point o2) {
			if(o1.x == o2.x)
				return o1.y - o2.y;
			else
				return o1.x - o2.x;
		}
	}
}
