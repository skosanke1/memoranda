//**************************************************************************************************
// INTERFACE: BinaryTreeVisitor<E>
//
// DESCRIPTION
// This interface declares one abstract method visit() which is to be implemented in classes which
// implement the interface. Once this method is implemented, it may be called during a tree traversal
// to do something with the data stored at each node of the tree.
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
 * An object that implements this interface implements the visit() method which will be called by
 * the BinaryTree class traversal methods as each node of the BinaryTree is visited during the
 * traversal.
 */
public interface BinaryTreeVisitor<E> {
    void visit(E pData);
}
