package Tools;

public class Tools {
	
	public static void printMartix(int[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				System.out.print(m[i][j] + "  ");
			}
			System.out.println();
		}
	}
	public static void printMartix(float[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				System.out.print(m[i][j] + "  ");
			}
			System.out.println();
		}
	}
	public static void printMartix(String[][] m) {
		for(int i=0;i<m.length;i++) {
			for(int j=0;j<m[0].length;j++) {
				System.out.print(m[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
