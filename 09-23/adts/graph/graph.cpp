#pragma once

#include "../iterator/iterable.cpp"

struct edge
{
  int from;
  int to;
  int weight;

  edge(int from, int to)
  {
    this->from = from;
    this->to = to;
  }

  edge(int from, int to, int weight)
  {
    this->from = from;
    this->to = to;
    this->weight = weight;
  }
};

class graph
{
public:
  virtual void addEdge(int v, int u) = 0;
  virtual void addWeightedEdge(int v, int u, int w) = 0;
  virtual void removeEdge(int v, int u) = 0;
  virtual int vertices() = 0;
  virtual int edgesCount() = 0;
  virtual iterable<edge> *edges() = 0;
  virtual iterable<edge> *adjacents(int v) = 0;
  virtual bool isAdjecent(int v, int u) = 0;
  virtual int getCost(int v, int u) = 0;
};
