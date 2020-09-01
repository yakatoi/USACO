import java.io.*;
import java.util.*;
public class Lifeguards {
	public static void main(String[] args) throws IOException {
		BufferedReader br    = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter pw       = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
		TreeSet<Integer> set = new TreeSet<Integer>();
		int n                = Integer.parseInt(br.readLine());
		Pair[] l             = new Pair[2*n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end   = Integer.parseInt(st.nextToken());
			l[2*i]    = new Pair(start, i);
			l[2*i+1]  = new Pair(end, i);
		}
		Arrays.sort(l);
		int actualCover = 0;
		int[] alone     = new int[n];
		int last        = 0;
		for(Pair out:l) {
			if(set.size()==1) {
				alone[set.first()]+=out.time-last;
			}
			if(!set.isEmpty()) {
				actualCover+=out.time-last;
			}
			if(set.contains(out.index)) {
				set.remove(out.index);
			}
			else {
				set.add(out.index);
			}
			last = out.time;
		}
		int ret = 0;
		for(int out: alone) {
			ret = Math.max(ret, actualCover - out);
		}
		pw.println(ret);
		pw.close();
	}

	static class Pair implements Comparable<Pair> {
		public int time, index;
		public Pair(int a, int b) {
			time  = a;
			index = b;
		}
		public int compareTo(Pair s) {
			return time - s.time;
		}
	}

}
