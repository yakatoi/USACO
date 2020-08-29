import java.util.*;
import java.io.*;

public class PairedUp {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("pairup.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pairup.out")));
    int n = Integer.parseInt(br.readLine());
    ArrayList<Integer> al = new ArrayList<Integer>();
    LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
    for (int c = 0; c < n; c++) {
      int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
      map.put(inp[1], inp[0]);
    }
    int maxSum = 0;
    while (map.size()!=0) {
      int smallkey = Collections.min(map.keySet());
      int bigkey = Collections.max(map.keySet());
      if (map.size()==1) {
        maxSum = Math.max(maxSum, map.get(smallkey) * 2);
        map.remove(smallkey);
        break;
      }
      if (map.get(smallkey) > map.get(bigkey)) {
        maxSum = Math.max(maxSum, bigkey + smallkey);
        map.replace(smallkey, map.get(smallkey) - map.get(bigkey));
        map.remove(bigkey);
      }
      else if (map.get(smallkey) == map.get(bigkey)) {
        maxSum = Math.max(maxSum, bigkey + smallkey);
        map.remove(bigkey);
        map.remove(smallkey);
      }
      else {
        maxSum = Math.max(maxSum, bigkey + smallkey);
        map.replace(bigkey, map.get(bigkey) - map.get(smallkey));
        map.remove(smallkey);
      }
    }
    pw.println(maxSum);
    pw.close();
  }
}
