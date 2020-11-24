import java.util.*;
import java.io.*;

public class AutoComplete {
  public static int w, n;
  public static String[] words;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("auto.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("auto.out"));
    StringTokenizer st = new StringTokenizer(br.readLine());
    w = Integer.parseInt(st.nextToken());
    n = Integer.parseInt(st.nextToken());
    words = new String[w];
    HashMap<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i< w; i++) {
      words[i] = br.readLine();
      map.put(words[i], i+1);
    }
    map.put("!", -1);115438
    Arrays.sort(words);
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      int x = Integer.parseInt(st.nextToken());
      String wor = st.nextToken();
      String res = queryCalc(x, wor);
      pw.println(map.get(res));
    }
    pw.close();
  }
  public static String queryCalc(int nth, String str) {
    int counter = 0;
    for (String ele : words) {
      if (ele.startsWith(str)) {
        counter++;
        if (counter >= nth) {
          return ele;
        }
      }
    }
    return "!";

  }
}
