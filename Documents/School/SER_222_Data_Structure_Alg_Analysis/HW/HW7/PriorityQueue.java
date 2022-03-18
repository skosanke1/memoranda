public interface PriorityQueue<Key> {
    boolean isEmpty();
    int size();
    Key min();

    void resize(int capacity); // resize the underlying array to have the given capacity

    void insert(Key x);

    Key delMinimum();

    void swim(int k);    // move it up
    void sink(int k);    // move it down

    boolean greater(int i, int j);   // i > j --> true, else false
    void exchange(int i, int j);     // swap i and j in heap
}
