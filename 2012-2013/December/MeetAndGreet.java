import java.util.*;
import java.io.*;

public class MeetAndGreet {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("greetings.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("greetings.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int bn = Integer.parseInt(st.nextToken());
    int en = Integer.parseInt(st.nextToken());
    Move[] b = new Move[bn];
    Move[] e = new Move[en];
    for (int i = 0; i < bn; i++) {
      b[i] = new Move(br.readLine().split(" "));
    }
    for (int i = 0; i < en; i++) {
      e[i] = new Move(br.readLine().split(" "));
    }
    //System.out.println(Arrays.toString(b));
    //System.out.println(Arrays.toString(e));
    int i = 0;
    int j = 0;
    int counter = 0;
    int x  = 0;
    int y  = 0;
    int px = 0;
    int py = 0;
    int t  = 0;
    while (i < bn || j < en) {
      t++;
      px = x;
      py = y;
      if (t==10) {
        t = 10;
      }
      if (i < bn) {
          if (b[i].d.equals("L")) {
            b[i].p--;
            x--;
          }
          if (b[i].d.equals("R")) {
            b[i].p--;
            x++;
          }
      }
      if (j < en) {
          if (e[j].d.equals("L")) {
            e[j].p--;
            y--;
          }
          if (e[j].d.equals("R")) {
            e[j].p--;
            y++;
          }
      }
      if ((x==y || (px+1==py && y+1==x) || (py+1==px && x+1==y)) && px!=py) {
        counter++;
        //System.out.println(t);
      }
      if (i < bn && b[i].p==0) {
        i++;
      }
      if (j < en && e[j].p==0) {
        j++;
      }
    }
    pw.println(counter);
    pw.close();

  }
  public static class Move {
    public int p;
    public String d;

    public Move (String[] arr) {
      p = Integer.parseInt(arr[0]);
      d = arr[1];
    }
    public String toString() {
      return "(" + p + ", " + d + ")";
    }
  }
}
