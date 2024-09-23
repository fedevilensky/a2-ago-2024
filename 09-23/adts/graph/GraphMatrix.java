package adts.graph;

import adts.list.LinkedList;
import adts.list.List;

public class GraphMatrix implements Graph {
  int[][] matrix;
  int edgeCount;
  boolean isDirected;

  GraphMatrix(int vertexCount, boolean isDirected) {
    matrix = new int[vertexCount + 1][];
    for (int i = 1; i <= vertexCount; i++) {
      matrix[i] = new int[vertexCount + 1];
    }
    edgeCount = 0;
  }

  @Override
  public void addEdge(int v, int u) {
    addWeightedEdge(v, u, 1);
  }

  @Override
  public void addWeightedEdge(int v, int u, int w) {
    if (matrix[v][u] == 0) {
      edgeCount++;
    }
    matrix[v][u] = w;
    if (!isDirected) {
      matrix[u][v] = w;
    }
  }

  @Override
  public void removeEdge(int v, int u) {
    if (matrix[v][u] != 0) {
      edgeCount--;
    }
    matrix[v][u] = 0;
    if (!isDirected) {
      matrix[u][v] = 0;
    }
  }

  @Override
  public int vertices() {
    return matrix.length - 1;
  }

  @Override
  public int edgesCount() {
    return edgeCount;
  }

  @Override
  public Iterable<Edge> edges() {
    List<Edge> l = new LinkedList<Edge>();
    if (isDirected) {
      for (int i = 1; i < matrix.length; i++) {
        for (int j = 1; j < matrix.length; j++) {
          if (matrix[i][j] != 0) {
            l.add(new Edge(i, j, matrix[i][j]));
          }
        }
      }
    } else {
      for (int i = 1; i < matrix.length; i++) {
        for (int j = i; j < matrix.length; j++) {
          if (matrix[i][j] != 0) {
            l.add(new Edge(i, j, matrix[i][j]));
          }
        }
      }
    }

    return l;
  }

  @Override
  public Iterable<Edge> adjacents(int v) {
    List<Edge> l = new LinkedList<Edge>();
    for (int i = 1; i < matrix.length; i++) {
      if (matrix[v][i] != 0) {
        l.add(new Edge(v, i, matrix[v][i]));
      }
    }

    return l;
  }

  @Override
  public boolean isAdjecent(int v, int u) {
    return matrix[v][u] != 0;
  }

  @Override
  public int getCost(int v, int u) {
    return matrix[v][u];
  }
}
