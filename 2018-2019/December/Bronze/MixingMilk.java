import java.util.*;
import java.io.*;

public class MixingMilk {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("mixmilk.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("mixmilk.out")));
    // I/O setup
    StringTokenizer st = new StringTokenizer(br.readLine());
    int c1 = Integer.parseInt(st.nextToken());
    int b1 = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int c2 = Integer.parseInt(st.nextToken());
    int b2 = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int c3 = Integer.parseInt(st.nextToken());
    int b3 = Integer.parseInt(st.nextToken());

    for (int i = 0; i < 33; i++) {
      if (b1+b2<=c2) {
        b2+=b1;
        b1=0;
      }
      else {
        b1 = (b1+b2)-c2;
        b2 = c2;
      }
      if (b2+b3<=c3) {
        b3+=b2;
        b2=0;
      }
      else {
        b2 = (b2+b3)-c3;
        b3 = c3;
      }
      if (b3+b1<=c1) {
        b1+=b3;
        b3=0;
      }
      else {
        b3 = (b3+b1)-c1;
        b1 = c1;
      }
    }
    if (b1+b2<=c2) {
      b2+=b1;
      b1=0;
    }
    else {
      b1 = (b1+b2)-c2;
      b2 = c2;
    }
    pw.println(b1);
    pw.println(b2);
    pw.println(b3);
    pw.close();
    br.close();

  }
}
