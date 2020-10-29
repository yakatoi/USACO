import java.util.*;
import java.io.*;

public class MooBuzz {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("moobuzz.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("moobuzz.out"));
    int[] arr = {1, 2, 4, 7, 8, 11, 13, 14};
    int n = Integer.parseInt(br.readLine()) - 1;
    pw.println(arr[n%8] + n/8 * 15);
    pw.close();
  }
}
