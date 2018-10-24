package DivideConquer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Entity.Point;
import Tools.MyComparator;
/**
 * 分治法求凸包问题，即快包算法
 * QuickHull
 * @author zjp
 * 2018年10月18日 上午9:06:50
 */
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
		
		List<Point> hullList = FindQuickHull(plist);
		for(int i=0;i<hullList.size();i++) {
			System.out.print(hullList.get(i) + "  ");
		}
		System.out.println();
	}
	/**
	 * 求快包
	 * @param list
	 * @return
	 */
	public static List<Point> FindQuickHull(List<Point> list){
		List<Point> hullList = new ArrayList<Point>();
		if(list.size()<4) {
			hullList.addAll(list);
			return hullList;
		}else {
			Collections.sort(list, new MyComparator.XComparator());
			Point p1 = list.get(0);
			Point pn = list.get(list.size()-1);
			hullList.add(p1);
			hullList.add(pn);
			//分别求出上包的点和下包的点
			List<Point> upList = new ArrayList<Point>();
			List<Point> downList = new ArrayList<Point>();
			
			upList.add(p1);
			upList.add(pn);
			downList.add(p1);
			downList.add(pn);
			
			for(int i=1;i<list.size()-1;i++) {
				if(location(p1, pn, list.get(i)).equals("LEFT")) 
					upList.add(list.get(i));
				else if(location(p1, pn, list.get(i)).equals("RIGHT")) 
					downList.add(list.get(i));
			}
			
			//分治
			hullList.addAll(quickHull(upList,"UP"));
			hullList.addAll(quickHull(upList,"DOWN"));
			//hullList.addAll(DownQuickHull(downList));
			return hullList;
		}
	}
	/**
	 * 求上包/下包
	 * @param list
	 * @param flag UP  DOWN  表示求上包还是下包
	 * @return
	 * 上包递归求直线p1pmax和pmaxpn的上包
	 * 下包递归求直线p1pmax和pmaxpn的下包
	 */
	public static List<Point> quickHull(List<Point> list,String flag){
		List<Point> hullList = new ArrayList<Point>();
		if(list.size()<4) {
			hullList.addAll(list);
			return hullList;
		}else {
			Collections.sort(list, new MyComparator.XComparator());
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
			//分别求出位于直线p1pmax左边和直线pmaxpn左边的点集，递归求上包
			//分别求出位于直线p1pmax右边和直线pmaxpn右边的点集，递归求下包
			for(int i=1;i<list.size()-1;i++) {
				if((location(p1,pMax,list.get(i)).equals("LEFT")&&flag.equals("UP"))
					|| (location(p1,pMax,list.get(i)).equals("RIGHT")&&flag.equals("DOWN")))
					upList1.add(list.get(i));
				else if((location(pMax,pn,list.get(i)).equals("LEFT")&&flag.equals("UP"))
					|| (location(pMax,pn,list.get(i)).equals("RIGHT")&&flag.equals("DOWN")))
					upList2.add(list.get(i));
			}
			hullList.addAll(quickHull(upList1,flag));
			hullList.addAll(quickHull(upList2,flag));
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
}
