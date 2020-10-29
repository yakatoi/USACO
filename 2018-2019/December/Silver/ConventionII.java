import java.util.*;
import java.io.*;

public class ConventionII {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("convention2.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("convention2.out"));
    int n = Integer.parseInt(br.readLine());
    int[][] arr = new int[n][3];
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      arr[i][0] = i+1;
      arr[i][1] = Integer.parseInt(st.nextToken());
      arr[i][2] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr, (a, b) -> (Integer.compare(a[1], b[1])));
    //System.out.println(Arrays.deepToString(arr));
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < arr.length; i++) {
      map.put(arr[i][0], i);
    }
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    int i = 0;
    int maxWait = 0;
    int endTime = 0;
    while (i < n) {
      while (!pq.isEmpty()) {
        int index = map.get(pq.poll());
        maxWait = Math.max(maxWait, endTime - arr[index][1]);
        endTime += arr[index][2];
      }
      if (endTime <= arr[i][1]) {
        endTime = arr[i][1] + arr[i][2];
      }
      else {
        while (i < n && endTime > arr[i][1]) {

          pq.add(arr[i][0]);
          i++;
        }
        i--;
      }
      i++;
    }
    while (!pq.isEmpty()) {
        int index = map.get(pq.poll());
        maxWait = Math.max(maxWait, endTime - arr[index][1]);
        endTime = arr[index][1] + arr[index][2];
      }
    pw.println(maxWait);
    pw.close();
  }
}
