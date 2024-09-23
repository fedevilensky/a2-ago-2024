#pragma once

#include "./graph.cpp"
#include "../list/linked_list.cpp"

class adjacencyMatrixGraph : public graph
{
  int **matrix;
  int matrixSize;
  int edgeCount;
  bool isDirected;

public:
  adjacencyMatrixGraph(int vertexCount, bool isDirected)
  {
    matrixSize = vertexCount + 1;
    matrix = new int *[matrixSize];
    for (int i = 1; i < matrixSize; i++)
    {
      matrix[i] = new int[matrixSize]();
    }
    edgeCount = 0;
  }

  virtual void addEdge(int v, int u) override
  {
    addWeightedEdge(v, u, 1);
  }

  virtual void addWeightedEdge(int v, int u, int w) override
  {
    if (matrix[v][u] == 0)
    {
      edgeCount++;
    }
    matrix[v][u] = w;
    if (!isDirected)
    {
      matrix[u][v] = w;
    }
  }

  virtual void removeEdge(int v, int u) override
  {
    if (matrix[v][u] != 0)
    {
      edgeCount--;
    }
    matrix[v][u] = 0;
    if (!isDirected)
    {
      matrix[u][v] = 0;
    }
  }

  virtual int vertices() override
  {
    return matrixSize - 1;
  }

  virtual int edgesCount() override
  {
    return edgeCount;
  }

  virtual iterable<edge> *edges() override
  {
    List<edge> *l = new LinkedList<edge>();
    if (isDirected)
    {
      for (int i = 1; i < matrixSize; i++)
      {
        for (int j = 1; j < matrixSize; j++)
        {
          if (matrix[i][j] != 0)
          {
            l->add(edge(i, j, matrix[i][j]));
          }
        }
      }
    }
    else
    {
      for (int i = 1; i < matrixSize; i++)
      {
        for (int j = i; j < matrixSize; j++)
        {
          if (matrix[i][j] != 0)
          {
            l->add(edge(i, j, matrix[i][j]));
          }
        }
      }
    }

    return l;
  }

  virtual iterable<edge> *adjacents(int v) override
  {
    List<edge> *l = new LinkedList<edge>();
    for (int i = 1; i < matrixSize; i++)
    {
      if (matrix[v][i] != 0)
      {
        l->add(edge(v, i, matrix[v][i]));
      }
    }

    return l;
  }

  virtual bool isAdjecent(int v, int u) override
  {
    return matrix[v][u] != 0;
  }

  virtual int getCost(int v, int u) override
  {
    return matrix[v][u];
  }
};
