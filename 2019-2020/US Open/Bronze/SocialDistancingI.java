import java.util.*;
import java.io.*;

public class SocialDistancingI {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("socdist1.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("socdist1.out"));
    int n = Integer.parseInt(br.readLine());
    int[] arr = Arrays.stream(br.readLine().split("")).mapToInt(x -> Integer.parseInt(x)).toArray();
    //System.out.println(Arrays.toString(arr));
    int d = 0;
    int counter = 0;
    TreeSet<Integer> choices = new TreeSet<Integer>();
    for (int ele : arr) {
      if (ele==0) counter++;
      else counter = 0;
      d = Math.max(d, counter);
      choices.add(d);
    }
    choices.remove(0);
    int max = choices.last();
    choices.remove(max);
    int smax = choices.last();
    choices.remove(smax);
    //System.out.println(d);
    //System.out.println(choices);
    int ans = min(operation(max), operation(smax), choices.first());
    pw.println(ans+1);
    pw.close();
  }
  public static int operation(int a) {
    return a%2==0 ? a/2-1 : a/2;
  }
  public static int min(int a, int b, int c) {
    return Math.min(c, Math.min(a, b));
  }
}
