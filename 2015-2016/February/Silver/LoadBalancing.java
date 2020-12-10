import java.util.*;
import java.io.*;

public class LoadBalancing {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("balancing.out"));
		int n = Integer.parseInt(br.readLine());
		HashSet<Integer> one = new HashSet<Integer>();
		HashSet<Integer> two = new HashSet<Integer>();
		Point[] arr = new Point[n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[i] = new Point(a, b);
		}
		Arrays.sort(arr, (a, b) -> (Integer.compare(a.x, b.x)));
		if (n%2==0) {
			if (arr[n/2-1].x==arr[n/2].x) {
				one.add(arr[n/2-1].x+1);
				one.add(arr[n/2-1].x-1);
			}
			else {
				one.add(arr[n/2-1].x+1);
			}
		}
		else {
			one.add(arr[n/2].x+1);
			one.add(arr[n/2].x-1);
		}
		Arrays.sort(arr, (a, b) -> (Integer.compare(a.y, b.y)));
		if (n%2==0) {
			if (arr[n/2-1].y==arr[n/2].y) {
				two.add(arr[n/2-1].y+1);
				two.add(arr[n/2-1].y-1);
			}
			else {
				two.add(arr[n/2-1].y+1);
			}
		}
		else {
			two.add(arr[n/2].y+1);
			two.add(arr[n/2].y-1);
		}
		//System.out.println(one);
		//System.out.println(two);
		int minM = Integer.MAX_VALUE;
		
		for (int x : one) {
			for (int y : two) {
				int q1 = 0;int q2 = 0;int q3 = 0;int q4 = 0;
				for (Point p : arr) {
					if (p.x > x && p.y > y) q1++;
					else if (p.x < x && p.y > y) q2++;
					else if (p.x < x && p.y < y) q3++;
					else q4++;
				}
				int max = Math.max(Math.max(q1, q2), Math.max(q3, q4));
				minM = Math.min(minM, max);
			}
		}
		System.out.println(minM);
		pw.close();
	}
	public static class Point {
		int x, y;
		public Point(int a, int b) {
			x=a;
			y=b;
		}
		public String toString() {
			return x + " " + y;
		}
	}
}
