import java.util.*;
import java.io.*;

public class AIME {
  public static void main(String[] args) {
    ArrayList<Card> al = new ArrayList<Card>();
    for (int a = 0; a <= 2; a++){
      for (int b = 0; b <= 2; b++){
        for (int c = 0; c <= 2; c++){
          al.add(new Card(a, b, c));
        }
      }
    }
    System.out.println(al.size());
    int counter = 0;
    for (int a = 0; a < 27; a++) {
      for (int b = a+1; b < 27; b++) {
        for (int c = b+1; c < 27; c++) {
          boolean ab = (al.get(a).shape!= al.get(b).shape &&al.get(c).shape!= al.get(b).shape &&al.get(a).shape!= al.get(c).shape) || (al.get(a).shape==al.get(b).shape && al.get(b).shape==al.get(c).shape);
          boolean bb = (al.get(a).color!= al.get(b).color &&al.get(c).color!= al.get(b).color &&al.get(a).color!= al.get(c).color) || (al.get(a).color==al.get(b).color && al.get(b).color==al.get(c).color);
          boolean cb = (al.get(a).shade!= al.get(b).shade &&al.get(c).shade!= al.get(b).shade &&al.get(a).shade!= al.get(c).shade) || (al.get(a).shade==al.get(b).shade && al.get(b).shade==al.get(c).shade);
          if (ab && bb && cb) {
            counter++;
          }
        }
      }
    }
    System.out.println(counter);
  }
  public static class Card {
    public int shape;
    public int color;
    public int shade;

    public Card(int shape, int color, int shade) {
      this.shape = shape;
      this.color = color;
      this.shade = shade;
    }
  }
}
