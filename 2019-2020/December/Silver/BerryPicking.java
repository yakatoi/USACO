import java.io.*;
import java.util.*;

public class BerryPicking {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("berries.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());
    int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)*-1).toArray();
    Arrays.sort(arr);
    for (int i = 0; i < n; i++) arr[i]*=-1;
    System.out.println(Arrays.toString(arr));
  }
}
