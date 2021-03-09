import java.util.*;
import java.io.*;
24399
public class HoofPaperScissors {
  public static void main(String[] args) throws IOException {
    BufferedReader br  = new BufferedReader(new FileReader("hps.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hps.out")));
    int n = Integer.parseInt(br.readLine());
    String[] inp = new String[n];
    for (int i = 0; i < n; i++) {
      inp[i] = br.readLine();
    }
    int[] rock = new int[n];
    int[] pape = new int[n];
    int[] scis= new int[n];
    if (inp[0].equals("P"))
      scis[0] = 1;
    else if (inp[0].equals("H"))
      pape[0] = 1;
    else
      rock[0] = 1;
    for (int i = 1; i < n; i++) {
      rock[i] = rock[i-1];
      pape[i] = pape[i-1];
      scis[i] = scis[i-1];
      if (inp[i].equals("P"))
        scis[i]++;
      else if (inp[i].equals("H"))
        pape[i]++;
      else
        rock[i]++;
    }
    int[] rockb = new int[n];
    int[] papeb = new int[n];
    int[] scisb= new int[n];
    if (inp[n-1].equals("P"))
      scisb[n-1] = 1;
    else if (inp[n-1].equals("H"))
      papeb[n-1] = 1;
    else
      rockb[n-1] = 1;
    for (int i = n-2; i >= 0; i--) {
      rockb[i] = rockb[i+1];
      papeb[i] = papeb[i+1];
      scisb[i] = scisb[i+1];
      if (inp[i].equals("P"))
        scisb[i]++;
      else if (inp[i].equals("H"))
        papeb[i]++;
      else
        rockb[i]++;
    }
    int ans = max(max(rock[n-1], pape[n-1], scis[n-1]), max(rockb[0], papeb[0], scisb[0]));

    for (int i = 0; i < n-1; i++) {
      int fir = max(rock[i], pape[i], scis[i]);
      int sec = max(rockb[i+1], papeb[i+1], scisb[i+1]);
      ans = max(ans, fir+sec);
    }
    pw.println(ans);
    pw.close();
    /*
    System.out.println("---------------");
    System.out.println(Arrays.toString(rock));
    System.out.println(Arrays.toString(pape));
    System.out.println(Arrays.toString(scis));
    System.out.println("---------------");
    System.out.println(Arrays.toString(rockb));
    System.out.println(Arrays.toString(papeb));
    System.out.println(Arrays.toString(scisb));
    System.out.println("---------------");
    */
  }

  public static int max(int... x) {
    int curr = x[0];
    for (int n:x) {
      curr = Math.max(curr, n);
    }
    return curr;
  }
}
