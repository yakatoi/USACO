import java.util.*;
import java.io.*;

public class CowJog {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("cowjog.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("cowjog.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n =Integer.parseInt(st.nextToken());
    long t = Long.parseLong(st.nextToken());
    long[] cows = new long[n];
    for (int  i= 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      long x = Long.parseLong(st.nextToken());
      long s = Long.parseLong(st.nextToken());
      cows[i] = x + s * t;
    }
    Arrays.sort(cows);
    // /System.out.println(Arrays.toString(cows));
    long counter = 0;
    long min = cows[n-1];
    for(int i=n-1; i>=0; i--) {
      if(cows[i] < min)  counter++;
      min = min > cows[i] ? cows[i] : min;
    }
    //System.out.println(counter);
    pw.println(counter);
    pw.close();
  }
}
