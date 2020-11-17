import java.util.*;
import java.io.*;

public class BessieSlowsDown {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("slowdown.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("slowdown.out"));
    int n = Integer.parseInt(br.readLine());
    ArrayList<Integer> t = new ArrayList<Integer>();
    ArrayList<Integer> d = new ArrayList<Integer>();
    StringTokenizer st;
    for (int i = 0; i < n; i++) {
      st = new StringTokenizer(br.readLine());
      String type = st.nextToken();
      int inp = Integer.parseInt(st.nextToken());
      if (type.equals("T")) {
        t.add(inp);
      }
      else {
        d.add(inp);
      }
    }
    Collections.sort(t);
    Collections.sort(d);
    int i, j;
    double denom, speed, currentTime, currentDist;
    currentTime = currentDist = 0;
    i = j = 0;
    denom = speed = 1;
    while (i < t.size() || j < d.size()) {
      if (currentDist >= 1000) break;
      if (i==t.size()) {
        double dist = d.get(j);
        currentTime+=(dist - currentDist) / speed;
        currentDist = dist;
        j++;
      }
      else if (j==d.size()) {
        double time = (t.get(i));
        currentDist+= (time-currentTime) * speed;
        currentTime=time;
        i++;
      }
      else {
        double tdist = (t.get(i) - currentTime) * speed;
        double ddist = d.get(j) - currentDist;
        if (tdist<ddist) i++;
        else j++;
        double realdist = tdist < ddist ? tdist : ddist;
        currentTime+=(realdist) / speed;
        currentDist+= realdist;
      }
      denom++;
      speed = 1/denom;
    }
    if (currentDist > 1000) {
      currentTime-=(currentDist - 1000)/speed;
    }
    if (currentDist < 1000) {
      currentTime+=(1000-currentDist)/speed;
    }
    pw.println((int) (currentTime+0.5));
    pw.close();
  }
}
