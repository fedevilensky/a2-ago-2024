package adts.graph;

public interface Graph {
  void addEdge(int v, int u);

  void addWeightedEdge(int v, int u, int w);

  void removeEdge(int v, int u);

  int vertices();

  int edgesCount();

  Iterable<Edge> edges();

  Iterable<Edge> adjacents(int v);

  boolean isAdjecent(int v, int u);

  int getCost(int v, int u);
}
