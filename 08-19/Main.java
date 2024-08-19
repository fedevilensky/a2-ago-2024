import adts.list.*;

public class Main {
  public static void main(String[] args) {
    List<Integer> l = new LinkedList<Integer>();

    l.add(0);
    l.add(1);
    l.add(2);
    l.add(3);

    for (int i = 0; i < 5; i++) {
      System.out.println(l.contains(i));
    }
  }

}
