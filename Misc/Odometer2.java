import java.util.*;
import java.io.*;

public class Odometer2 {
  static HashSet<Long> set = new HashSet<Long>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("odometer.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("odometer.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long x = Long.parseLong(st.nextToken());
    long y = Long.parseLong(st.nextToken());
    for (int s = 3; s <= 16; s++) {
      for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
          generateAllLengthN(s, i, j);
        }
      }
    }
    set.add(10L*10*10*10*10*10*10*10*10*10*10*10*10*10*10*10L);
    int counter = 0;
    for (long ele : set) {
      if (ele >= x && ele <= y) {
        counter++;
      }
    }
    pw.println(counter);
    pw.close();
  }
  static boolean isInteresting(long k) {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    for (int ele : Arrays.stream((k+"").split("")).mapToInt(x -> Integer.parseInt(x)).toArray()) {
      if (!map.keySet().contains(ele)) map.put(ele, 0);
      map.put(ele, map.get(ele) + 1);
    }
    if (map.keySet().size() == 2) {
      for (int ele : map.keySet()) {
        if (map.get(ele) == 1) return true;
      }
    }
    return false;
  }
  static void generateAllLengthN(int n, int mark, int marktwo) {
    int[][][] arr= new int[10][n][n];
    for (int x = 0; x < 10; x++) {
      for (int y = 0; y < n; y++) {
        for (int z = 0; z < n; z++) {
          if (y+z==n-1) {
            arr[x][y][z] = mark;
          }
          else {
            arr[x][y][z] = marktwo;
          }
        }
      }
    }
    for (int x = 0; x < 10; x++) {
      for (int y = 0; y < n; y++) {
        long number = 0;
        for (int z = 0; z < n; z++) {
          number = number * 10 + arr[x][y][z];
        }
        if (number >= 100 && isMadeUpOutOfOneDigit(number)) {
          set.add(number);
        }
      }
    }
  }
  static boolean isMadeUpOutOfOneDigit(long x) {
    String str =x +"";
    HashSet<String> check = new HashSet<String>();
    for (int i = 0; i < str.length(); i++) {
      check.add(str.substring(i, i+1));
    }
    return check.size()==2;
  }
}
