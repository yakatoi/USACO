import java.util.*;
import java.io.*;

public class WhyDidTheCowCrossTheRoadIII {
	static int n, k, r;
	static int counter;
	static int[] count;
	static int[][] arr;
	static boolean[][] visited;
	static HashSet<Integer> set = new HashSet<Integer>();
	static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("countcross.out"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		count = new int[k];
		visited = new boolean[n][n];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int d = Integer.parseInt(st.nextToken())-1;
			double x = (a+c)/2.0;
			double y = (b+d)/2.0;
			int x  = y
			set.add((int) (1000*x+y));
		}
		arr =new int[n][n];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map.put(1000*a+b, i);
			arr[a][b] = -1;
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j]==-1) {
					floodfill(i, j);
					counter++;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < k; i++) {
			for (int j = i+1; j < k; j++) {
				if (count[i]!=count[j]) ans++;
			}
		}
		System.out.println(ans);
		//pw.close();
	}
	public static void floodfill(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y]) return;
		visited[x][y] = true;
		if (arr[x][y]==-1) {
			int val = map.get(1000*x+y);
			count[val] = counter;
		}
		if (isInter(x, y, x+1, y)) {
			floodfill(x+1, y);
		}
		if (isInter(x, y, x-1, y)) {
			floodfill(x-1, y);
		}
		if (isInter(x, y, x, y-1)) {
			floodfill(x, y-1);
		}
		if (isInter(x, y, x, y+1)) {
			floodfill(x, y+1);
		}

	}
	public static boolean isInter(int x1, int x2, int y1, int y2) {
		if (x1 < 0 || x1 >= n || y1 < 0 || y1 >= n) return false;
		if (x2 < 0 || x2 >= n || y2 < 0 || y2 >= n) return false;
		double x = (x1+x2)/2.0;
		double y = (y1+y2)/2.0;
		int check = (int) (1000*x+y);
		return !set.contains(check);
	}
}
