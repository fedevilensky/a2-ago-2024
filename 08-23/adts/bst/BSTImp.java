package adts.bst;

public class BSTImp<T extends Comparable<T>> implements BST<T> {
    class Node<T extends Comparable<T>>{
        T data;
        Node<T> left;
        Node<T> right;

        Node(T data){
            this.data=data;
        }
    }

    private Node<T> root = null;
    private int elements = 0;

    private Node<T> insertAux(T data, Node<T> root){
        if(root == null){
            Node<T> newNode = new Node<T>(data);
            elements++;
            return newNode;
        }

        if(data.compareTo(root.data) < 0){
            root.left = insertAux(data, root.left);
        } else {
            root.right = insertAux(data, root.right);
        }

        return root;        
    }

    private boolean containsAux(T data, Node<T> node){
        if(node == null){
            return false;
        }
        if(data.equals(node.data)){
            return true;
        }
        if(data.compareTo(node.data)< 0){
            return containsAux(data, node.left);
        }
        //else
        return containsAux(data, node.right);
    }

    private T maxAux(Node<T> node){
        if(node.right != null){
            return maxAux(node.right);
        }

        return node.data;
    }

    private void printInOrderAux(Node<T> node){
        if(node == null){
            return;
        }

        printInOrderAux(node.left);
        System.out.println(node.data);
        printInOrderAux(node.right);
    }

    private Node<T> removeAux(T data, Node<T> node){
        if (node == null){
            return null;
        }

        if(data.equals(node.data)){
            if(node.left != null){
                node.data = maxAux(node.left);
                node.left = removeAux(node.data, node.left);
                return node;
            }
            elements --;
            return node.right;
        }
        if(data.compareTo(node.data) < 0){
            node.left = removeAux(data, node.left);
        } else {
            node.right = removeAux(data, node.right);
        }

        return node;
    }

    @Override
    public void insert(T data) {
        root = insertAux(data, root);
    }

    @Override
    public void remove(T data) {
        root = removeAux(data, root);
    }

    @Override
    public boolean contains(T data) {
        return containsAux(data, root);
    }

    @Override
    public T get(T data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public T max() {
        return maxAux(root);
    }

    @Override
    public T min() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'min'");
    }

    @Override
    public int count() {
        return elements;
    }

    @Override
    public void printInOrder() {
        printInOrderAux(root);
    }
    
}
