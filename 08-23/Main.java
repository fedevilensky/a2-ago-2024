import adts.bst.BST;
import adts.bst.BSTImp;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BSTImp<Integer>();

        int lastInsert = 0;
        for(int i = 0; i < 5; i++){
            lastInsert = (int)(Math.random()*100);
            bst.insert(lastInsert);
        }

        bst.printInOrder();

        System.out.println("Remove " + lastInsert);
        bst.remove(lastInsert);
        bst.printInOrder();
    }
}
