//**************************************************************************************************
// CLASS: Queue<E> (Queue.java)
//
// DESCRIPTION
// Implements a generic Queue data structure using a doubly linked list (of type DList<E>) to store
// the queue elements. Using a list to implement a queue is efficient because the stack enqueue
// operation simply appends the element to the list and the dequeue operation simply removes and
// returns the first element of the list. This means that enqueue and dequeue are O(1). The time
// complexity of an algorithm can never be better than O(1) so this queue implementation is time-wise
// very efficient (although it uses more memory than our queue would if we just used a 1D array to
// store the queue elements).
//
// AUTHOR
// Kevin R. Burger (burgerk@asu.edu)
// Computer Science & Engineering Program
// Fulton Schools of Engineering
// Arizona State University, Tempe, AZ 85287-8809
// http://www.devlang.com
//
// (c) Kevin R Burger
//**************************************************************************************************
package HW4;
/**
 * Implements a generic queue data structure using a DList to store the elements.
 */
public class Queue<E> {

    /*
     * The elements of the queue are stored in a doubly linked list.
     */
    private DList<E> mList;

    /**
     * Creates a new empty Queue by creating a new empty DList.
     */
    public Queue() {
        setList(new DList<>());
    }

    /**
     * Removes all of the elements from this Queue. After clear() returns this Queue is empty.
     */
    public void clear() {
        getList().clear();
    }

    /**
     * Removes and returns the element that is at the front of this Queue.
     */
    public E dequeue() {
        E front = getList().remove(0);
        return front;
    }

    /**
     * Adds pData to the rear of this Queue.
     */
    public void enqueue(E pData) {
        getList().append(pData);
    }

    /**
     * Accessor method for mList.
     */
    protected DList<E> getList() {
        return mList;
    }

    /**
     * Returns true if this Queue is empty.
     */
    public boolean isEmpty() {
        return getList().isEmpty();
    }

    /**
     * Returns the front element of this Queue without removing it.
     */
    public E peek() {
        return getList().get(0);
    }

    /**
     * Mutator method for mList.
     */
    protected void setList(DList<E> pList) {
        mList = pList;
    }

    /**
     * Overrides toString() inherited from Object. Returns a String representation of the elements
     * of this Queue by calling the DList.toString() method.
     */
    @Override
    public String toString() {
        return getList().toString();
    }
}
