import java.util.*;
import java.io.*;

public class MilkMeasurement {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("measurement.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int n = Integer.parseInt(st.nextToken());
    int g = Integer.parseInt(st.nextToken());
    int[][] arr = new int[n][3];
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      int c = Integer.parseInt(st.nextToken());
      arr[i][0] = a;
      arr[i][1] = b;
      arr[i][2] = c;
    }
    Arrays.sort(arr, (a, b) -> a[0] - b[0]);
    //System.out.println(Arrays.deepToString(arr));
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    HashSet<Integer> winners = new HashSet<Integer>();
    int highGal = g;
    int secHigh = g;
    int counter = 0;
    for (int i = 0; i < n; i++) {
      if (map.keySet().contains(arr[i][1])) {
        map.put(arr[i][1], map.get(arr[i][1]) + arr[i][2]);
        if (winners.contains(arr[i][1])) {
          if (winners.size() == 1) {
            if (map.get(arr[i][1]) <= secHigh) {
              winners.clear();
              counter++;
              highGal = secHigh;
            }
            else {
              highGal = map.get(arr[i][1]);
              highG
            }
          }
          else if (map.get(arr[i][1]) < highGal) {
            counter++;
            winners.remove(arr[i][1]);
            if (winners.size()==1) {
              secHigh = g;
            }
          }
        }
        else {
          if (map.get(arr[i][1])  >= highGal) {
            counter++;
            winners.clear();
            winners.add(arr[i][1]);
            secHigh = highGal;
            highGal = map.get(arr[i][1]);
          }
        }
      }
      else {
        map.put(arr[i][1], arr[i][2] + g);
        if (map.get(arr[i][1]) >= highGal) {
          if (map.get(arr[i][1]) != highGal) {
            winners.clear();
          }
          counter++;
          secHigh = highGal;
          highGal = map.get(arr[i][1]);

          winners.add(arr[i][1]);
        }
      }
    }
    pw.println(counter);
    pw.close();

  }
}
