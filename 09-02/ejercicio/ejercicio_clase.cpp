#include <iostream>

int main()
{

  int N;
  std::cin >> N;
  int idPlato, costo;
  for (int i = 0; i < N; i++)
  {
    std::cin >> idPlato >> costo;

    std::cout << "ID del plato es " << idPlato << " con un costo de " << costo << std::endl;
  }

  return 0;
}
