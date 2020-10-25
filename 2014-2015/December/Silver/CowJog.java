import java.util.*;
import java.io.*;

public class CowJog {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("cowjog.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int t = Integer.parseInt(st.nextToken());
    int[] cows = new int[n];
    for (int  i= 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      int s = Integer.parseInt(st.nextToken());
      cows[i] = x + s * t;
    }
    System.out.println(Arrays.toString(cows));
    int counter = 1;
    int min = cows[n-1];
    for(int i=n-1; i>=0; i--) {
      if(cows[i] < min)  counter++;
      min = Math.min(min, cows[i]);
    }
    System.out.println(counter);
    pw.println(counter);
    pw.close();
  }
}
