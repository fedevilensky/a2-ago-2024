#include "adts/bst/bstImp.cpp"
#include <iostream>

int main(){
    int i;
    bst<int>* t = new bstImp<int>();

    do
    {
        std::cin >> i;
        t->insert(i);
    } while (i != 0);
    

    t->printInOrder();
    std::cout << "Quitar numero: ";
    std::cin >> i;
    t->remove(i);
    t->printInOrder();

    return 0;
}