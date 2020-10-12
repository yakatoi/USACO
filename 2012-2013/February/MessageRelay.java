import java.util.*;
import java.io.*;

public class MessageRelay {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("relay.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("relay.out"));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    for (int i =0; i < n; i++) {
      arr[i] = Integer.parseInt(br.readLine()) - 1;
    }
    int counter = 0;
    HashSet<Integer> cycles = new HashSet<Integer>();
    for (int i = 0; i < n; i++) {
      if (!cycles.contains(i)) {
        HashSet<Integer> set = new HashSet<Integer>();
        int index = i;
        while (arr[index]!=-1 && !set.contains(index)) {
          set.add(index);
          index = arr[index];
          if (cycles.contains(index)) {
            break;
          }
        }
        if (arr[index]==-1) {
          counter++;
        }
        else {
          for (int s : set) {
            cycles.add(s);
          }
        }
      }
    }
    pw.println(counter);
    pw.close();
  }
}
