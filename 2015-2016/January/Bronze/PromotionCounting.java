import java.util.*;
import java.io.*;

public class PromotionCounting {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("promote.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("promote.out")));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int b1 = Integer.parseInt(st.nextToken());
    int b2 = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int s1 = Integer.parseInt(st.nextToken());
    int s2 = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int g1 = Integer.parseInt(st.nextToken());
    int g2 = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int p1 = Integer.parseInt(st.nextToken());
    int p2 = Integer.parseInt(st.nextToken());
    int c = p2-p1;
    int b = g2+c-g1;
    int a = b+s2-s1;
    pw.println(a);
    pw.println(b);
    pw.println(c);
    pw.close();

  }
}
