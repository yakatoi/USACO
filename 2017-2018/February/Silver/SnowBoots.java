  import java.util.*;
  import java.io.*;

  public class SnowBoots {
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new FileReader("input.txt"));
      PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("snowboots.out")));
      String[] inp1 = br.readLine().split(" ");
      int n = Integer.parseInt(inp1[0]);
      int b = Integer.parseInt(inp1[1]);
      int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(x -> Integer.parseInt(x)).toArray();
      Stack<Pair> stack = new Stack<Pair>();
      for (int i = 0; i < b; i++) {
        String[] inp2 = br.readLine().split(" ");
        int ai = Integer.parseInt(inp2[0]);
        int bi = Integer.parseInt(inp2[1]);
        stack.push(new Pair(ai, bi));
      }
      System.out.println(stack);
      Collections.reverse(stack);
      //System.out.println(stack.peek());
      int counter = 1;
      int index = 0;
      int prev = 0;
      Pair current = new Pair(stack.pop());
      while (index < n) {
        if (current.a < arr[index+1]) {
          current = new Pair(stack.pop());
          counter++;
          prev = index;
          while (index - prev < current.b && current.a > arr[index]) {
            index++;
          }
        }
        else {
          prev = index;
          while(index - prev < current.b &&current.a > arr[index]) {
            index++;
          }
        }
      }
      System.out.println(counter);

    }

    public static class Pair {
      public int a = 0;
      public int b = 0;

      public Pair(int a, int b) {
        this.a = a;
        this.b = b;
      }
      public Pair(Pair p) {
        a = p.a;
        b = p.b;
      }
      public String toString() {
        return "(" + a + ", " + b + ")";
      }
    }
  }
