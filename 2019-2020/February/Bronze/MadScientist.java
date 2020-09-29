import java.util.*;
import java.io.*;

public class MadScientist {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("breedflip.in"));
    PrintWriter pw = new PrintWriter(new FileWriter("breedflip.out"));
    int n = Integer.parseInt(br.readLine());
    int[] correct = Arrays.stream(br.readLine().replaceAll("G", "0").replaceAll("H", "1").split("")).mapToInt(x -> Integer.parseInt(x)).toArray();
    int[] arr = Arrays.stream(br.readLine().replaceAll("G", "0").replaceAll("H", "1").split("")).mapToInt(x -> Integer.parseInt(x)).toArray();
    //System.out.println(Arrays.toString(correct));
    //System.out.println(Arrays.toString(arr));
    int index = 0;
    int a;
    int b;
    int counter = 0;
    while (!Arrays.equals(correct, arr)) {
      while (arr[index]==correct[index]) {
        index++;
      }
      a = index;
      b = index;
      while (arr[b+1]!=correct[b+1]) {
        b++;
      }
      counter++;
      flip(arr, a, Math.min(b, n-1));
    }
    //System.out.println(Arrays.toString(correct));
    //System.out.println(Arrays.toString(arr));
    pw.println(counter);
    pw.close();
  }

  public static void flip(int[] arr, int a, int b) {
    for (int i = a; i <= b; i++) {
      arr[i] = arr[i]==1 ? 0 : 1;
    }
  }
}
