/**
 * LinearProbingHT is a simple hash table which implements linear probing for duplicate entties.
 * Implements SymbolTable given in homework
 *
 * @author Steven Kosanke, skosanke
 * @version 2/11/2022
 */
import java.util.ArrayList;
public class LinearProbingHT <Key, Value> implements SymbolTable<Key, Value>{
    private int N; // number of key-value pairs
    private int M; // table size
    private Key[] keys; // the keys
    private Value[] vals; // the values

    /**
     * Default constructor, size 997 LinearProbe Hash Table
     * Use 2 arrays- one will store Key objects, while the other will store Value objects
     */
    public LinearProbingHT () {
        this(997);
    }

    /**
     * Helper for default constructor, input the actual desired size
     * @param size is the size of the Linear has table
     */
    public LinearProbingHT (int size) {
        M = size;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    /**
     * hash() uses the hash function given in homework problem
     * @param key is the key that needs to be hashed
     * @return the index that this key wil be inserted in the hash table
     */
    private int hash(Key key) {
      return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     * put(Key, Value) will concurrently store the key, value pair in the appropiate hash index
     * If the desired spot is not available, linear probe will add 1 to the hash value and try again until there is an open space
     * @param key is the desired key to save
     * @param val is the corresponding input value associated with key
     */
    @Override
    public void put(Key key, Value val) {
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % M){
            if (keys[i].equals(key)) {
                vals[i] = val;
                return; }}
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    /**
     * get(Key) will search the aray for the specific key and return if found
     * @param key is the key value that should be returned
     * @return the value of the key from the hash table
     */
    @Override
    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % M){
          if (keys[i].equals(key)) return vals[i];}
        return null;
    }

    /**
     * contains(Key) searches the HT for a key, and returns true if it is present
     * @param key the key that is searched for
     * @return true if the key was found in the table, fasle if not found
     */
    @Override
    public boolean contains(Key key) {
       for (int i = hash(key); keys[i] != null; i = (i + 1) % M){
           if (keys[i].equals(key)) return true;}
        return false;
    }

    /**
     * isEmpty() will look through the hash table to see if a key has been stored yet
     * @return true if there are no keys are found in the HT
     */
    @Override
    public boolean isEmpty() {
       if (keys != keys) return true;
        for (int i = 0; i < M; i++){
           if (keys[i]==keys[i]) return false;
       }
        return true;
    }

    /**
     * size() returns the number of keys stored in the HT as an int
     * @return the number of unique keys stored
     */
    @Override
    public int size() {
       int count=0;
       if (keys != keys) return 0;
        for (int i = 0; i < M; i++){
           if (keys[i]==keys[i]) count++;
        }
        return count;
    }

    /**
     * keys() makes a list of all of the keys in the HT
     * @return a list of all of the keys in the HT
     */
    @Override
    public Iterable<Key> keys() {
       if (keys != keys) return null;
       ArrayList<Key> queue = new ArrayList<Key>();
       for (int i = 0; i < M; i++){
           if (keys[i]==keys[i]) queue.add(keys[i]);
       }
       return queue;
    }

    /**
     * delete(Key) is the method that removes a key from the HT
     * Extra credit on Homework
     * @param key is the desired key to be deleted
     */
    @Override
    public void delete(Key key) { //EXTRA CREDIT COMPLETED
        int i = hash(key);
        if (keys[hash(key)].equals(key)) {
            while (keys[i+1] != null) {
                    keys[i] = keys[i+1];
                    vals[i] = vals[i+1];
                    i++;
                }
            keys[i]=null; vals[i]=null;
            return;
        }
        for (i = hash(key); keys[i] != null; i = (i + 1) % M) {
            if (keys[i].equals(key)) {
                while (keys[i+1] != null) {
                    keys[i] = keys[i+1];
                    vals[i] = vals[i+1];
                    i++;
                }
                keys[i]=null; vals[i]=null;
                return;
            }
        }
    }


}
