import java.io.*;
import java.util.*;

public class BerryPicking {
  public static int n, k;
  public static int[] arr;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("input.txt"));
    PrintWriter pw = new PrintWriter(new FileWriter("berries.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)*-1).toArray();
    Arrays.sort(arr);
    for (int i = 0; i < n; i++) arr[i]*=-1;
    System.out.println(Arrays.toString(arr));
  }
  public static int check(int b) {
    int counter =0;
    int i = 0;
    TreeMap<Integer, Integer> map = new TreeMap<Integer>();
    while (i < n) {
      add(map, b, arr[i]/b);
      counter+=arr[i]/b;
      arr[i] = arr[i] % b;
      if (counter <)
    }

  }
  public static void add(HashMap<Integer> map, int i, int j) {
    if (map.keySet().contains(i)) map.put(i, map.get(i) + j);
    map.put(i, j);
  }
}
