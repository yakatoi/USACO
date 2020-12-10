import java.util.*;
import java.io.*;

public class SwitchingOnTheLights {
	static int n, m, lights;
	static boolean[][] lighted;
	static boolean[][] visited;
	static HashMap<Point, HashSet<Point>> map = new HashMap<Point, HashSet<Point>>();
	public static void main(String[] args) throws IOException {
		BufferedReader br=  new BufferedReader(new FileReader("lightson.in"));
		PrintWriter	 pw = new PrintWriter(new FileWriter("lightson.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		lighted = new boolean[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			Point one = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
			Point two = new Point(Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1);
			if (!map.keySet().contains(one)) map.put(one, new HashSet<Point>());
      map.get(one).add(two);
		}
		lighted[0][0] = true;
		int curLights = lights;
		do {
			curLights = lights;
			for (int i = 0; i < n; i++) {
				for (int j = 0 ; j < n; j++) {
					if (lighted[i][j] && !visited[i][j] && isNextToAVistedRoom(i, j)) {
						floodfill(i, j);
					}
				}
			}
		}
		while (curLights != lights);
		pw.println(lights+1);
		pw.close();
	}
	public static boolean isNextToAVistedRoom(int x, int y) {
        if (x==0 && y==0) return true;
		if (!outOfBounds(x+1, y) && visited[x+1][y]) return true;
		if (!outOfBounds(x-1, y) && visited[x-1][y]) return true;
		if (!outOfBounds(x, y+1) && visited[x][y+1]) return true;
		if (!outOfBounds(x, y-1) && visited[x][y-1]) return true;
		return false;
	}
	public static boolean outOfBounds(int x, int y) {
		return (x < 0 || y < 0 || x >= n || y >= n);
	}
	public static void floodfill(int x, int y) {
		if (outOfBounds(x, y) || visited[x][y] || !lighted[x][y]) return;
		visited[x][y] = true;
		if (map.keySet().contains(new Point(x, y))) {
			for (Point p : map.get(new Point(x, y))) {
  			if (!lighted[p.x][p.y]) {
          lighted[p.x][p.y] = true;
  			  lights++;
        }
			}
      map.remove(new Point(x, y));
		}
		floodfill(x+1, y);
    floodfill(x, y+1);
    floodfill(x-1, y);
    floodfill(x, y-1);
	}
	static class Point {
		int x, y;
		public Point(int a, int b) {
			x=a;
			y=b;
		}
		public String toString() {
			return x + " " + y;
		}
		public boolean equals(Object obj) {
			return this.hashCode()==obj.hashCode();
		}
		public int hashCode() {
			return n*x+y;
		}
	}
}
