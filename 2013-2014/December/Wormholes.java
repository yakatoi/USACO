import java.util.*;
import java.io.*;

public class Wormholes {
  static int n;
  static int counter = 0;
  static ArrayList<ArrayList<Integer>> al = new ArrayList<ArrayList<Integer>>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("wormhole.out"));
    n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n/2; i++) al.add(new ArrayList<Integer>());
    al.get(0).add(0);
    al.get(1).add(1);
    recurse(2);
    al.clear();
    for (int i = 0; i < n/2; i++) al.add(new ArrayList<Integer>());
    al.get(0).add(0);
    al.get(1).add(1);
    recurse(2);
    System.out.println(counter);
  }
  static void recurse(int num) {
    if (num==n) {
      counter++;
      //System.out.println(al);
      return;
    }
    for (int i = 0; i < n/2; i++) {
      if (al.get(i).size() < 2) {
        al.get(i).add(num);
        recurse(num+1);
        al.get(i).remove((Integer) num);
      }
    }
  }
}
