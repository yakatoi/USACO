import java.util.*;
import java.io.*;

public class BreedProximity {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("proximity.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("proximity.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n =  Integer.parseInt(st.nextToken());
    int k =  Integer.parseInt(st.nextToken());
    SortedMap<Integer, TreeSet<Integer>> map = new TreeMap<Integer, TreeSet<Integer>>(Collections.reverseOrder());
    for (int i = 0; i < n; i++) {
      int in = Integer.parseInt(br.readLine());
      if (map.keySet().contains(in)) {
        map.get(in).add(i);
      }
      else {
        map.put(in, new TreeSet<Integer>());
        map.get(in).add(i);
      }
    }
    //System.out.println(map);
    TreeSet<Integer> set = new TreeSet<Integer>(map.keySet());
    ArrayList<Integer> al = new ArrayList<Integer>();
    for (int key : set) {
      al.add(key);
    }
    Collections.reverse(al);
    //System.out.println(al);
    int ans = -1;
    for (int key : al) {
      if (map.get(key).size() >= 2) {
        if (findDif(map.get(key), k)) {
          ans = key;
          break;
        }
      }
    }
    pw.println(ans);
    pw.close();
  }
  public static boolean findDif(TreeSet<Integer> set, int k) {
    ArrayList<Integer> al = new ArrayList<Integer>(set);
    for (int i = 1; i < al.size(); i++) {
      if (al.get(i) - al.get(i-1) <= k) {
        return true;
      }
    }
    return false;
  }
}
