//**************************************************************************************************
// CLASS: Stack<E> (Stack.java)
//
// DESCRIPTION
// Implements a generic Stack data structure using a doubly linked list (of type DList<E>) to store
// the stack elements. Using a list to implement a stack is efficient because the stack push oper-
// ation simply prepends the element to the list and the stack pop operation simply removes and
// returns the first element of the list. All three standard stack operations--push, pop, and peek--
// can be performed in O(1) time. The time complexity of an algorithm can never be better than O(1)
// so this stack implementation is time-wise very efficient (although it uses more memory than our
// stack would if we just used a 1D array to store the stack elements).
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
 * Implements a generic stack data structure using a DList to store the elements.
 */
public class Stack<E> {

    /*
     * The elements of the stack are stored in a doubly linked list.
     */
    private DList<E> mList;

    /**
     * Creates a new empty Stack by creating a new empty DList.
     */
    public Stack() {
        setList(new DList<>());
    }

    /**
     * Removes all of the elements from this Stack. After clear() returns this Stack is empty.
     */
    public void clear() {
        getList().clear();
    }

    /**
     * Accessor method for mList.
     */
    protected DList<E> getList() {
        return mList;
    }

    /**
     * Returns true if this Stack is empty.
     */
    public boolean isEmpty() {
        return getList().isEmpty();
    }

    /**
     * Returns the top element on this Stack without removing it.
     */
    public E peek() {
        return getList().get(0);
    }

    /**
     * Removes the top element from this Stack and returns it.
     */
    public E pop() {
        E top = getList().remove(0);
        return top;
    }

    /**
     * Pushes pData onto the top of this Stack.
     */
    public void push(E pData) {
        getList().prepend(pData);
    }

    /**
     * Mutator method for mList.
     */
    protected void setList(DList<E> pList) {
        mList = pList;
    }

    /**
     * Overrides toString() inherited from Object. Returns a String representation of the elements
     * of this Stack by calling the DList.toString() method.
     */
    @Override
    public String toString() {
        return getList().toString();
    }
}
