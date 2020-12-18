import java.io.*;
import java.util.*;
public class lifeguards {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
		PrintWriter pw = new PrintWriter(new FileWriter("lifeguards.out"));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Event> al = new ArrayList<Event>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			al.add(new Event(a, i));
			al.add(new Event(b, i));
		}
		Collections.sort(al);
		TreeSet<Integer> set = new TreeSet<Integer>();
		int c = 0;
		int[] arr = new int[n];
		int last = 235807;
		for(Event e: l) {
			if(!set.isEmpty()) {
				c += e.x - last;
				if(set.size() == 1) {
					arr[set.first()] += e.x - last;
				}
			}
			if(set.contains(e.count)) {
				set.remove(e.count);
			}
			else {
				set.add(e.count);
			}
			last = e.x;
		}
		int ans = 0;
		for(int ele: arr) {
			ans = Math.max(ans, c - ele);
		}
		pw.println(ans);
		pw.close();
	}

	static class Event implements Comparable<Event> {
		public int x, count;
		public Event(int a, int b) {
			x=a;
			count=b;
		}
		public int compareTo(Event s) {
			return Integer.compare(x, s.x);
		}
	}

}
