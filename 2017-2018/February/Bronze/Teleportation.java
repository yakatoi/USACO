import java.util.*;
import java.io.*;

public class Teleportation {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("teleport.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("teleport.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    int dist = Math.abs(a-b);
    dist = Math.min(dist, Math.abs(a-x)+Math.abs(y-b));
    dist = Math.min(dist, Math.abs(a-y)+Math.abs(x-b));
    pw.println(dist);
    pw.close();
  }
}
