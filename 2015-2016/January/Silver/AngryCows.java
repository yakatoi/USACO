import java.util.*;
import java.io.*;

public class AngryCows {
  public static int numberofhaybales, maximumnumberofhaybales;
  public static long[] haybales;
  public static void main(String[] args) throws IOException {
    BufferedReader bufferedreader= new BufferedReader(new FileReader("input.txt"));
    PrintWriter printwriter = new PrintWriter(new FileWriter("angry.out"));
    StringTokenizer st = new StringTokenizer(bufferedreader.readLine());
    numberofhaybales = Integer.parseInt(st.nextToken());
    maximumnumberofhaybales = Integer.parseInt(st.nextToken());
    haybales = new long[numberofhaybales];
    for (int i = 0; i < numberofhaybales; i++) {
      haybales[i] = Integer.parseInt(bufferedreader.readLine());
    }
    Arrays.sort(haybales);
    long s = 1;
    long highestvalue = haybales[numberofhaybales-1] - haybales[0];
    while (lowestvalue!=highestvalue) {
      long themiddlevalue = (lowestvalue+highestvalue)/2;
      if (simulateThePowerOfASingleHaybale(themiddlevalue)) {
        highestvalue = themiddlevalue;
      }
      else {
        lowestvalue = themiddlevalue+1;
      }
    }
    System.out.println(lowestvalue);
    printwriter.println(lowestvalue);
    printwriter.close();
  }
  public static boolean simulateThePowerOfASingleHaybale(long x) {
    int acounterthatmeasureshowmanybirdsareneededtoexplodeallofthehaybales = 1;
    long endofthelengthofthehaybales = haybales[0] + 2*x;
    for (int i = 0; i < numberofhaybales; i++) {
      if (haybales[i] > endofthelengthofthehaybales) {
        acounterthatmeasureshowmanybirdsareneededtoexplodeallofthehaybales++;
        endofthelengthofthehaybales = haybales[i] + 2*x;
      }
      if (acounterthatmeasureshowmanybirdsareneededtoexplodeallofthehaybales > maximumnumberofhaybales) break;
    }
    return acounterthatmeasureshowmanybirdsareneededtoexplodeallofthehaybales <= maximumnumberofhaybales;
  }
}
