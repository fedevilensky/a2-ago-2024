#pragma once

#include "bst.cpp"
#include "../list/linked_list.cpp"

#include <iostream>

template <class T>
struct BSTNode
{
    T data;
    BSTNode<T> *left;
    BSTNode<T> *right;

    BSTNode(T data)
    {
        this->data = data;
    }
};

template <class T>
class bstImp : public bst<T>
{
private:
    BSTNode<T> *root = nullptr;
    int elements = 0;

    BSTNode<T> *insertAux(T data, BSTNode<T> *root)
    {
        if (root == nullptr)
        {
            BSTNode<T> *newBSTNode = new BSTNode<T>(data);
            elements++;
            return newBSTNode;
        }

        if (data < root->data)
        {
            root->left = insertAux(data, root->left);
        }
        else
        {
            root->right = insertAux(data, root->right);
        }

        return root;
    }

    bool containsAux(T data, BSTNode<T> *node)
    {
        if (node == nullptr)
        {
            return false;
        }
        if (data == node->data)
        {
            return true;
        }
        if (data < node->data)
        {
            return containsAux(data, node->left);
        }
        // else
        return containsAux(data, node->right);
    }

    T maxAux(BSTNode<T> *node)
    {
        if (node->right != nullptr)
        {
            return maxAux(node->right);
        }

        return node->data;
    }

    void printInOrderAux(BSTNode<T> *node)
    {
        if (node == nullptr)
        {
            return;
        }

        printInOrderAux(node->left);
        std::cout << node->data << std::endl;
        printInOrderAux(node->right);
    }

    BSTNode<T> *removeAux(T data, BSTNode<T> *node)
    {
        if (node == nullptr)
        {
            return nullptr;
        }

        if (data == node->data)
        {
            if (node->left != nullptr)
            {
                node->data = maxAux(node->left);
                node->left = removeAux(node->data, node->left);
                return node;
            }
            elements--;
            return node->right;
        }
        if (data < node->data)
        {
            node->left = removeAux(data, node->left);
        }
        else
        {
            node->right = removeAux(data, node->right);
        }

        return node;
    }

    void inOrderLoad(List<T> *l, BSTNode<T> node)
    {
        if (node == nullptr)
        {
            return;
        }
        inOrderLoad(l, node->left);
        l->add(node->data);
        inOrderLoad(l, node->right);
    }

public:
    iterator<T> iterable() override
    {
        List<T> *l = new LinkedList<T>();

        inOrderLoad(l, root);

        return l->iterator();
    }

    void insert(T data) override
    {
        root = insertAux(data, root);
    }

    void remove(T data) override
    {
        root = removeAux(data, root);
    }

    bool contains(T data) override
    {
        return containsAux(data, root);
    }

    T get(T data) override
    {
        // TODO Auto-generated method stub
    }

    T max() override
    {
        return maxAux(root);
    }

    T min() override
    {
        // TODO Auto-generated method stub
    }

    int count() override
    {
        return elements;
    }

    void printInOrder() override
    {
        printInOrderAux(root);
    }
};
