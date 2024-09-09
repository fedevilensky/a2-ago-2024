package adts;

public class Pair<T1, T2> {
  public T1 fst;
  public T2 snd;

  public Pair() {
  }

  public Pair(T1 t1, T2 t2) {
    fst = t1;
    snd = t2;
  }
}
