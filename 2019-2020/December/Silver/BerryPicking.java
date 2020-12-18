import java.io.*;
import java.util.*;

public class BerryPicking {
  public static int n, k;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("berries.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("berries.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    ArrayList<Integer> al = new ArrayList<Integer>();
    for (String ele : br.readLine().split(" ")) {
      al.add(Integer.parseInt(ele));
    }
    Collections.sort(al, Collections.reverseOrder());
    while (al.size() < k) {
      int x = al.get(0);
      al.remove(Integer.valueOf(x));
      al.add(x/2);
      al.add((x+1)/2);
      Collections.sort(al, Collections.reverseOrder());
    }
    System.out.println(al);
    int bef = 0; int newBef = 0;
    for (int i = k/2; i < k; i++) newBef+=al.get(i);
    do {
      bef = newBef;
      int x = al.get(0);
      al.remove(Integer.valueOf(x));
      al.add(x/2);
      al.add((x+1)/2);
      Collections.sort(al, Collections.reverseOrder());
      newBef = 0;
      for (int i = k/2; i < k; i++) newBef+=al.get(i);
    }
    while (newBef > bef);
    newBef  = Math.max(bef, newBef);
    System.out.println(newBef);
    pw.println(newBef);
    pw.close();
  }
}
