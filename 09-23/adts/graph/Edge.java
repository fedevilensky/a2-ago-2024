package adts.graph;

public class Edge {
  int from;
  int to;
  int weight;

  public Edge(int from, int to) {
    this.from = from;
    this.to = to;
  }

  public Edge(int from, int to, int weight) {
    this.from = from;
    this.to = to;
    this.weight = weight;
  }
}
