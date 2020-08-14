import java.util.*;
import java.io.*;

public class Hoofball {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new FileReader("hoofball.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("hoofball.out")));
    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(arr);
    int[] dir = new int[n];
    dir[0] = 1;
    dir[n-1] = -1;
    for (int i = 1; i < n-1; i++) {
      if (arr[i+1]-arr[i]==arr[i]-arr[i-1]) {
        dir[i] = -1;
      }
      else {
        if (arr[i+1]-arr[i] > arr[i]-arr[i-1]) {
          dir[i] = -1;
        }
        else {
          dir[i] = 1;
        }
      }
    }
    int[] ballsto = new int[n];
    ballsto[0] = dir[1]==-1?1:0;
    ballsto[n-1] = dir[n-2]==1?1:0;
    for (int i = 1; i < n-1; i++) {
      if (dir[i-1]==1) {
        ballsto[i]++;
      }
      if (dir[i+1]==-1) {
        ballsto[i]++;
      }
    }
    int counter = 0;
    for (int i = 0; i < n-1; i++) {
      if (dir[i]==1 && dir[i+1]==-1 && ballsto[i]==1 && ballsto[i+1]==1) {
        counter++;
        ballsto[i] = -1;
        ballsto[i+1] = -1;
      }
    }
    for (int i = 0; i < n; i++) {
      if (ballsto[i]==0) {
        counter++;
      }
    }
    /*
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(dir));
    System.out.println(Arrays.toString(ballsto));
    */
    pw.println(counter);
    pw.close();
  }
}
