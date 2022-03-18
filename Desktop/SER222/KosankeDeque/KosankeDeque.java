/**
 * This program provides an implementation of the Deque interface
 * and demonstrates it.
 *
 * @author Steven Kosanke
 * @version 1/20/2022
 */
import java.util.NoSuchElementException;

public class BaseDeque<Item> implements Deque<Item> {
    private Node head = new Node<Item> ();
    private Node tail = new Node<Item> ();
    private int size;

    private class Node<Item> {
        public Node<Item> nextNode;
        public Node<Item> prevNode;
        public Item dataNode;
    }

    public BaseDeque() {
        this.head.prevNode = tail;
        this.head.dataNode = null;
        this.tail.nextNode = head;
        this.tail.dataNode = null;
        this.size = 0;
    }

    @Override
    public void enqueueFront(Item element) {
        Node newNode = new Node<Item> ();

        this.head.dataNode = element;
        this.head.nextNode = newNode;

        newNode.prevNode = this.head;

        this.head = newNode;
        this.size = this.size + 1;
    }

    @Override
    public void enqueueBack(Item element) {
        Node newNode = new Node<Item> ();

        this.tail.dataNode = element;
        this.tail.prevNode = newNode;

        newNode.nextNode = this.tail;

        this.tail = newNode;
        this.size = this.size + 1;
    }

    @Override
    public Item dequeueFront() throws NoSuchElementException {
        if ( this.size() == 0 ) {
            throw new NoSuchElementException();
        }
        Item returnNode = (Item) this.head.prevNode.dataNode;
        this.head = this.head.prevNode;
        this.size = this.size - 1;
        return returnNode;
    }

    @Override
    public Item dequeueBack() throws NoSuchElementException {
        if ( this.size() == 0 ) {
            throw new NoSuchElementException();
        }
        Item returnNode = (Item) this.tail.nextNode.dataNode;
        this.tail = this.tail.nextNode;
        this.size = this.size - 1;
        return returnNode;
    }

    @Override
    public Item first() throws NoSuchElementException {
        if ( this.size() == 0 ) {
            throw new NoSuchElementException();
        }
        return (Item) this.head.prevNode.dataNode;
    }

    @Override
    public Item last() throws NoSuchElementException {
        if ( this.size() == 0 ) {
            throw new NoSuchElementException();
        }
        return (Item) this.tail.nextNode.dataNode;
    }

    @Override
    public boolean isEmpty() {
        if ( this.size() == 0 ) {
            return true;
        }
        else
            return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (this.size == 0)
            return "empty";
        Node pointer = this.tail;
        String returnString = "";
        while (this.head.prevNode != pointer) {
            pointer = pointer.nextNode;
            returnString = returnString + pointer.dataNode + " ";
        }
        return returnString;
    }


    /**
     * Program entry point for deque.
     * @param args command line arguments
     */
    public static void main(String[] args) {
        BaseDeque<Integer> deque = new BaseDeque<>();

        //standard queue behavior
        //standard queue behavior
        deque.enqueueBack(3);
        deque.enqueueBack(7);
        deque.enqueueBack(4);
        deque.dequeueFront();
        deque.enqueueBack(9);
        deque.enqueueBack(8);
        deque.dequeueFront();
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());
        //deque features
        System.out.println(deque.dequeueFront());
        deque.enqueueFront(1);
        deque.enqueueFront(11);
        deque.enqueueFront(3);
        deque.enqueueFront(5);
        System.out.println(deque.dequeueBack());
        System.out.println(deque.dequeueBack());
        System.out.println(deque.last());
        deque.dequeueFront();
        deque.dequeueFront();
        System.out.println(deque.first());
        System.out.println("size: " + deque.size());
        System.out.println("contents:\n" + deque.toString());
    }
}