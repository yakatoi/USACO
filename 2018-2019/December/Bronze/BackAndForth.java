import java.util.*;
import java.io.*;

public class BackAndForth {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("backforth.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("backforth.out")));
    ArrayList<String> input1 = new ArrayList<String>(Arrays.asList(br.readLine().split(" ")));
    ArrayList<String> input2 = new ArrayList<String>(Arrays.asList(br.readLine().split(" ")));
    int barn1 = 1000;
    int barn2 = 1000;
    Set<Integer> possible = new HashSet<Integer>();
    for (int a = 0; a < 10; a++) {
      ArrayList<String> fir = (ArrayList<String>) input1.clone();
      ArrayList<String> sec = (ArrayList<String>) input2.clone();
      barn1 = 1000;
      barn2 = 1000;
      String fbuck = fir.get(a);
      sec.add(fbuck);
      fir.remove(a);
      barn1-=Integer.parseInt(fbuck);
      barn2+=Integer.parseInt(fbuck);
      for (int b = 0; b < 11; b++) {
        ArrayList<String> fir2 = (ArrayList<String>) fir.clone();
        ArrayList<String> sec2 = (ArrayList<String>) sec.clone();
        int barn01 = barn1;
        int barn02 = barn2;
        String sbuck = sec2.get(b);
        sec2.remove(sbuck);
        fir2.add(sbuck);
        barn01+=Integer.parseInt(sbuck);
        barn02-=Integer.parseInt(sbuck);
        for (int c = 0; c < 10; c++) {
          ArrayList<String> fir3 = (ArrayList<String>) fir2.clone();
          ArrayList<String> sec3 = (ArrayList<String>) sec2.clone();
          int barn11 = barn01;
          int barn12 = barn02;
          String tbuck = fir3.get(c);
          sec3.add(tbuck);
          fir3.remove(tbuck);
          barn11-=Integer.parseInt(tbuck);
          barn12+=Integer.parseInt(tbuck);
          for (int d = 0; d < 11; d++) {
            ArrayList<String> fir4 = (ArrayList<String>) fir3.clone();
            ArrayList<String> sec4 = (ArrayList<String>) sec3.clone();
            int barn21 = barn11;
            int barn22 = barn12;
            String fobuck = sec4.get(d);
            sec4.remove(fobuck);
            fir4.add(fobuck);
            barn21+=Integer.parseInt(fobuck);
            barn22-=Integer.parseInt(fobuck);
            possible.add(barn21);
          }
        }
      }
    }
    pw.println(possible.size());
    pw.close();
  }
}
