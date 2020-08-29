import java.util.*;
import java.io.*;

public class GrassPlanting {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("planting.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
    int n = Integer.parseInt(br.readLine());
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int i = 0; i < n; i++) {
      int[] inp = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
      addToHashMap(map, inp[0]);
      addToHashMap(map, inp[1]);
    }
    int max = Collections.max(map.values());
    pw.println(max+1);
    pw.close();
  }
  public static void addToHashMap(HashMap<Integer, Integer> map, int a) {
    if (map.keySet().contains(a)) {
      map.replace(a, map.get(a)+1);
    }
    else {
      map.put(a, 1);
    }
  }
}
