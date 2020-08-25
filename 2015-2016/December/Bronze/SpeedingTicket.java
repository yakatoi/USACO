import java.util.*;
import java.io.*;

public class SpeedingTicket {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
    PrintWriter pw  = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
    String[] inp1 = br.readLine().split(" ");
    int n = Integer.parseInt(inp1[0]);
    int m = Integer.parseInt(inp1[1]);
    //int[] arr = new int[100];
    ArrayList<Integer> al = new ArrayList<Integer>();
    int index = 0;
    for (int c = 0; c < n; c++) {
      String[] inp = br.readLine().split(" ");
      int a = Integer.parseInt(inp[0]);
      int b = Integer.parseInt(inp[1]);
      for (int i = 0; i < a; i++) {
        al.add(b);
      }
    }
    Object[] oarr = al.toArray();
    int[] arr = new int[100];
    for (int i = 0; i < 100; i++) {
      arr[i] = (int) oarr[i];
    }
    ArrayList<Integer> ala = new ArrayList<Integer>();
    for (int c = 0; c < m; c++) {
      String[] inp = br.readLine().split(" ");
      int a = Integer.parseInt(inp[0]);
      int b = Integer.parseInt(inp[1]);
      for (int i = 0; i < a; i++) {
        ala.add(b);
      }
    }
    Object[] oarrr = ala.toArray();
    int[] arrr = new int[100];
    for (int i = 0; i < 100; i++) {
      arrr[i] = (int) oarrr[i];
    }
    int maxDif = 0;
    for (int i = 0; i < 100; i++) {
      maxDif = Math.max(arrr[i] - arr[i], maxDif);
    }
    pw.println(maxDif);
    pw.close();
  }

}
