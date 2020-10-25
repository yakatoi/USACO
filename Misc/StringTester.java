import java.util.*;
public class StringTester
{
  public static int countChars(String work, char letter) {   return Collections.frequency(Arrays.asList(work.toCharArray()), letter);}
    public static void main(String[] args) {
      int res = countChars("test", 't');
      System.out.println(res);
    }
}
