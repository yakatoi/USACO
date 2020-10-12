import java.util.*;
import java.io.*;

public class CrazyFences {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("crazy.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    Fence[] fences = new Fence[n];
    for (int i = 0; i < n; i++) {
      fences[i] = new Fence(br.readLine().split(" "));
    }
    Cow[] cows = new Cow[c];
    for (int i = 0; i < c; i++) {
        cows[i] = new Cow(br.readLine().split(" "));
    }
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < c; i++) {
      String str = "";
      for (int j = 0; j < n; j++) {
        str += fences[j].isIn(cows[i]);
      }
      if (map.keySet().contains(str)) {
        map.put(str, map.get(str) + 1);
      }
      else {
        map.put(str, 1);
      }
    }
    System.out.println(map);

  }
  public static class Cow {
    public int x;
    public int y;

    public Cow(String[] inp) {
      x = Integer.parseInt(inp[0]);
      y = Integer.parseInt(inp[1]);
    }
  }

  public static class Fence {
    public int x1;
    public int y1;
    public int x2;
    public int y2;
    public boolean isVert;

    public Fence(String[] inp) {
      x1 = Integer.parseInt(inp[0]);
      y1 = Integer.parseInt(inp[1]);
      x2 = Integer.parseInt(inp[2]);
      y2 = Integer.parseInt(inp[3]);
      if (y1==y2) {
        isVert = false;
      }
      else {
        isVert = true;
      }
    }
    public String isIn(Cow cow) {
      if (isVert) {
        if (cow.y > y2 || cow.y < y1) {
          //return "2";
        }
        return cow.x > x1 ? "1" : "0";
      }
      if (cow.x > x2 || cow.x < x1) {
        //return "2";
      }
      return cow.y > y1 ? "1" : "0";
    }

  }

}
