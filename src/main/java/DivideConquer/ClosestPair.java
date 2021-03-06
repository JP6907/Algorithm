/*
 * 求平面上n个点的集合中最近点对
 */
package DivideConquer;

import java.util.ArrayList;
import java.util.List;

import Entity.Point;
import Entity.PointPair;

public class ClosestPair {
	
	public static void main(String[] args) {
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
		
		PointPair pair = BruteClosestPair(plist);
		System.out.println("蛮力法求最近点对：" + pair);
		
		pair = EfficientClosestPair(plist);
		System.out.println("分治法求最近点对：" + pair);
		
		for(int i=0;i<10;i++) {
			Point p = new Point((int)(Math.random()*50),(int)(Math.random()*50));
			plist.add(p);
		}
		
		pair = BruteClosestPair(plist);
		System.out.println("蛮力法求最近点对：" + pair);
		
		pair = EfficientClosestPair(plist);
		System.out.println("分治法求最近点对：" + pair);
		
	}
	/**
	 * 分治法求最近点对
	 * @return 最近点对
	 */
	static PointPair EfficientClosestPair(List<Point> list) {
		int n = list.size();
		if(n<=3) 
			return BruteClosestPair(list);
		else {
			//P 按X坐标升序排列
			List<Point> P = new ArrayList<Point>();
			MergeSort.PointMergeSort(list, 0, n-1, "X");
			P.addAll(list);
			
			int mid = (int)Math.ceil((double)n/2); //向上取整
			List<Point> listLeft = new ArrayList<Point>();
			List<Point> listRight = new ArrayList<Point>();
			//划分成左右两部分
			for(int i=0;i<mid;i++)
				listLeft.add(P.get(i));
			for(int i=mid;i<n;i++) 
				listRight.add(P.get(i));
			PointPair pp1 = EfficientClosestPair(listLeft);
			PointPair pp2 = EfficientClosestPair(listRight);
			PointPair minpair;
			//选择左右部分两个最小点距的最小者
			if(pp1.getDistance()<pp2.getDistance())
				minpair = pp1;
			else
				minpair = pp2;

			//Q 按Y坐标升序排列
			List<Point> Q = new ArrayList<Point>();
			MergeSort.PointMergeSort(list, 0, n-1, "Y");
			Q.addAll(list);

			//下面合并中间区域
			Point m = P.get(mid-1);
			//以m为中线选取Q中所有 |x-m|<d 的点
			double d = minpair.getDistance();
			List<Point> midPoints = new ArrayList<Point>();
			for(Point p : Q) {
				if(Math.abs(p.x - m.x)<d) {
					midPoints.add(p);
				}
			}
			for(int i=0;i<midPoints.size()-1;i++) {
				for(int j=i+1;j<midPoints.size();j++) {
					if(Math.abs(midPoints.get(i).y - midPoints.get(j).y) < d) {
						if(new PointPair(midPoints.get(i), midPoints.get(j)).getDistance()< d) {
							minpair = new PointPair(midPoints.get(i), midPoints.get(j));
							d = minpair.getDistance();	
						}
					}
				}
			}
			return minpair;
		}
	}
	
	/**
	 * 暴力破解求最近点对
	 * @param list 点的集合
	 * @return
	 */
	static PointPair BruteClosestPair(List<Point> list) {
		double minlength = Integer.MAX_VALUE;
		int a = 0;
		int b = 1;
		for(int i=0;i<list.size();i++) {
			for(int j=i+1;j<list.size();j++) {
				double len = Math.pow((list.get(i).x - list.get(j).x),2)+ Math.pow((list.get(i).y - list.get(j).y),2);
				if( len < minlength) {
					minlength = len;
					a = i;
					b = j;
				}
			}
		}
		PointPair pair = new PointPair(list.get(a),list.get(b));
		return pair;
	}
	
	
}
