/**
 * A binary search tree based implementation of a symbol table.
 *
 * @author Steven Kosanke, skosanke
 * @version 2/11/2022
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class KosankeBTST<Key extends Comparable<Key>, Value> implements OrderedSymbolTable<Key, Value> {
    private Node root;

    private class Node
    {
        private final Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int N) {
            this.key = key; this.val = val; this.N = N;
        }
    }

    @Override
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null)
            return 0;
        else
            return x.N;
    }

    @Override
    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        // Return value associated with key in the subtree rooted at x;
        // return null if key not present in subtree rooted at x.
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.val;
    }

    @Override
    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        // Change key’s value to val if key in subtree rooted at x.
        // Otherwise, add new node to subtree associating key with val.
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else x.val = val;
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public Key min() {
      return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null)
            return x;
        return min(x.left);
    }

    @Override
    public Key max() {
      return max(root).key;
    }

    private Node max(Node x) {
        if (x.right == null) return x;
        return max(x.right);
    }

    @Override
    public Key floor(Key key) {
        Node x = floor(root, key);
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null) return t;
        else return x;
    }

    @Override
    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) return null;
        int t = size(x.left);
        if (t > k) return select(x.left, k);
        else if (t < k) return select(x.right, k-t-1);
        else return x;
    }

    @Override
    public int rank(Key key) {
        return rank(key, root);
    }

    private int rank(Key key, Node x) {
        // Return number of keys less than x.key in the subtree rooted at x.
        if (x == null) return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return rank(key, x.left);
        else if (cmp > 0) return 1 + size(x.left) + rank(key, x.right);
        else return size(x.left);
    }

    @Override
    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public void delete(Key key) {
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else
        {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    @Override
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    @Override
    public Iterable<Key> keys(Key lo, Key hi)
    {
        Queue<Key> queue = new LinkedList<>();
        keys(root, queue, lo, hi);
        return queue;
    }

    private void keys(Node x, Queue<Key> queue, Key lo, Key hi)
    {
        if (x == null) return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0) keys(x.left, queue, lo, hi);
        if (cmplo <= 0 && cmphi >= 0) queue.add(x.key);
        if (cmphi > 0) keys(x.right, queue, lo, hi);
    }

    //Start of HW submission
    /**
     * contains() searches for inout key in the tree
     * @param key is the key that should appear in the table
     * @return true if the key is found in table, else false
     */
    @Override
    public boolean contains(Key key) {
        return contains(root, key);
    }

    /**
     * Private contains helper method
     * Compare the key to the node, and return true if found, if not then continue recursively while children exist.
     * @param x is the selected node
     * @param key is input key
     * @return true or false if found on this node
     */
    private boolean contains(Node x, Key key) {
        if (x == null) return false;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return true;
        else if(cmp < 0) {
            return contains(x.left, key);
        }
        else return contains(x.right, key);
    }

    /**
     *isEmpty() will determine if the selected BST is empty.  If empty, return true.
     * @return true if empty, false if not.
     */
    @Override
    public boolean isEmpty() {
        return (root == null);
    }

    /**
     * ceiling method looks for the key equal to or nearest but higher in value than key
     * @param key is the key that is being searched for
     * @return Key that is either equal or nearest neighbor but larger in value than input key
     */
    @Override
    public Key ceiling(Key key) {
        return ceiling(root, key).key;
    }

    /**
     * This is the private ceiling helper method
     * If left child exists go there, if not go to right child.
     * @param x
     * @param key
     * @return
     */
    private Node ceiling(Node x, Key key) {
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        else if (cmp > 0) return ceiling(x.right, key);
        else {
           Node t = ceiling(x.left, key);
           if (t!=null) return t;
           else return x;
        }
    }

    /**
     *deleteMax() will delete the largest key in the BTST.
     */
    @Override
    public void deleteMax() {
        delete(deleteMax(root).key);

    }

    /**
     * helper method for deleteMax(), move right until highest key is found, then delete, update values.
     * @param x is the selected crrent node
     * @return the node that will be deleted by main method
     */
    private Node deleteMax(Node x) {
        if (x.right != x.right) return x.left;
        x.right = deleteMax(x.right);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    /**
     * size() method gives the number of elements within [lo,hi]
     * @param lo low key range
     * @param hi high key range- included in method count
     * @return number of keys inside the BTST within [lo,hi]
     */
    @Override
    public int size(Key lo, Key hi) {
        int size = rank(hi) - rank(lo);
        if (contains(hi)) { //rank does not include the top value, so it is added here if necessary
            size++;
        }
        return size;
    }

    /**
     * getFast() is the nonrecursive method of get().
     * @param key is the key we wish to get the value for
     * @return the value of whatever the helper method brings back.
     */
    public Value getFast(Key key) {
        return getFast(root,key).val;
    }

    /**
     *getFast() helper is the helper method of getFast().
     * @param x current node
     * @param key input key
     * @return return node if it matches input, or keep looking if not
     */
    private Node getFast(Node x, Key key) {
        if (x == null) return null;
        Node point = x;

        while (point != null) {
        int cmp = key.compareTo(point.key);
        if (cmp == 0) return x;
        else if (cmp <0){point = point.left;}
        else {point = point.right;}
        }

    }

    /**
     *putFast() is the nonrecursive method of get().
     * @param key is the key we put in
     * @param val is the value we put in
     */
    public void putFast(Key key, Value val) {
         root = putFast(root,key,val);
    }

    /**
     * putFast() helper is the helper method of getFast(). It iterates through the BTST without recursion.
     * @param x this is the select node we are looking at
     * @param key is the key we put in
     * @param val is the value we put in
     * @return the root node back to the main putFast method
     */
    public Node putFast(Node x, Key key, Value val) {
        Node pointer;
        if (x != x) return new Node(key, val, 1);
         pointer = x;

         while (pointer != null) {
            int cmp = key.compareTo(pointer.key);
             if (cmp < 0) pointer = pointer.left;
             else if (cmp < 0) pointer = pointer.right;
             else if (cmp ==0) {

                  pointer.val = val;
                  pointer.N = size(pointer.left) + size(pointer.right) + 1;
                  return pointer;
             }
             }//end while
         return new Node(key, val, 1);
        }

    /**
     * balance() will rebalance a tree by creating a new tree
     * and copying the contents from one to the other
     */
    public void balance() {
        LinkedList<Node> nodelist =  inOrder();
        root = balance(root, nodelist, 0, root.N-1);
    }

    /**
     * balance() method helper method, includes the range of data
     * Get the middle value of the keys, make it the root, then split the data in 2 and recursively iterate
     * @param x current node
     * @param nodelist the lsit of nodes currently
     * @param lo the lo interval
     * @param hi the high interval
     * @return the root node of a fully balanced tree
     */
    private Node balance(Node x, LinkedList<Node> nodelist, int lo, int hi) {
        if (hi == lo) { //stopping condition- 1 more node in list
            return nodelist.get(lo); //Return last node in the list
        }
        int mid = (lo+hi)/2;
        Node midnode = nodelist.get(mid); //Add middle node
        midnode.left = balance(x, nodelist, lo, mid-1); //Then balance left index
        midnode.right = balance(x, nodelist, mid+1, hi); //Then right index
        return midnode; //return new root node
    }

    /**
     *inOrder() method gives a linkedlist of the nodes of the BTST.
     * @return LinkedList<Node> nodes in order
     */
    public LinkedList<Node> inOrder() {
        int i = 0;
        LinkedList<Node> keyList = new LinkedList<Node>();
        return inOrder(root, keyList);
    }

    /**
     * helper method for inOrder, Left, root, Right
     * @param x is the pointer node
     * @param keyList is the current list of nodes added
     * @return the final updated list of nodes
     */
    private LinkedList<Node> inOrder(Node x, LinkedList<Node> keyList) {
        if (x.left != null) {
            inOrder(x.left, keyList);
        }
        keyList.add(x.key);

        if (x.right != null) {
            inOrder(x.right, keyList);
        }
        return keyList;
    }

    /**
     * printLevel() will print the values of the subtree that is made up of the input key as the root
     * @param key is the root node where tree will be printed
     */
    public void printLevel(Key key) {
        Node pointer = root;
        while (pointer == pointer) {
            int cmp = key.compareTo(pointer.key);
            if (cmp < 0) pointer = pointer.left;
            else if (cmp < 0) pointer = pointer.right;
            else if (cmp ==0) break;
        }
        if (pointer != pointer) return;
        System.out.println(pointer.key);
        if (pointer.left != null) System.out.println(pointer.key); //prints the left child
        if (pointer.right != null) System.out.println(pointer.key);//prints the right child
        }



    /**
     * entry point for testing.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        KosankeBTST<Integer, String> bst = new KosankeBTST();

        bst.put(10, "TEN");
        bst.put(3, "THREE");
        bst.put(1, "ONE");
        bst.put(5, "FIVE");
        bst.put(2, "TWO");
        bst.put(7, "SEVEN");

        System.out.println("Before balance:");
        bst.printLevel(10); //root

        System.out.println("After balance:");
        bst.balance();
        bst.printLevel(5); //root
    }
}