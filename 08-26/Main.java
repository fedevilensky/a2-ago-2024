import java.util.Iterator;

import adts.bst.BST;
import adts.bst.BSTImp;
import adts.list.*;

public class Main {
    public static void main(String[] args) {
        // BST<Integer> bst = new BSTImp<Integer>();

        // int lastInsert = 0;
        // for(int i = 0; i < 5; i++){
        // lastInsert = (int)(Math.random()*100);
        // bst.insert(lastInsert);
        // }

        // bst.printInOrder();

        // System.out.println("Remove " + lastInsert);
        // bst.remove(lastInsert);
        // bst.printInOrder();

        List<Integer> l = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            l.add(i);
        }

        Iterator<Integer> it = l.iterator();
        while (it.hasNext()) {
            int i = it.next();
            System.out.println(i);
        }

        System.out.println("Con Foreach");

        for (int i : l) {
            System.out.println(i);
        }
    }
}
