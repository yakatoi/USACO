import java.util.*;
public class StringTester
{
  public static void main(String[] args) {
    int a = 5;
    int b = 7;
    System.out.println(a + " " + b);
    // b^=a^=b;
    b^=a^=b^=a^=b;
    System.out.println(a + " " + b);

  }
}
