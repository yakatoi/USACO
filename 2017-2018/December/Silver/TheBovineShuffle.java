import java.util.*;
import java.io.*;

public class TheBovineShuffle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("shuffle.in"));
		PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("shuffle.out")));
		int n = Integer.parseInt(br.readLine());
		int[] inp = new int[n];
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[inp[i] = Integer.parseInt(st.nextToken()) -1]++;
		}
		int sum = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < n; i++) {
			if(arr[i] == 0) {
				q.add(i);
				sum++;
			}
		}
		while(!q.isEmpty()) {
			int key = q.remove();
			if(--arr[inp[key]] == 0) {
				q.add(inp[key]);
				sum++;
			}
		}
		pw.println(n-sum);
		pw.close();
	}
}
