#include "./adts/list/linked_list.cpp"
#include <iostream>

int main()
{
  List<int> *l = new LinkedList<int>();

  l->add(0);
  l->add(1);
  l->add(2);
  l->add(3);

  for (int i = 0; i < 5; i++)
  {
    std::cout << l->contains(i) << std::endl;
  }

  return 0;
}
