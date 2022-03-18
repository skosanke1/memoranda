/**
 * QuadProbingHT is an extention of LinearProbingHT, using a exponential based hash function.
 * Methods contains(Key), isEmpty(), size(), keys(), imported from LinearProbingHT
 * Methods overriden are put(Key,Value), get(Key)
 *
 * @author Steven Kosanke, skosanke
 * @version 2/11/2022
 */
public class QuadProbingHT <Key, Value> extends LinearProbingHT <Key, Value>  {
    private int N; // number of key-value pairs
    private int M; // tables size
    private Key[] keys; // the keys
    private Value[] vals; // the values

    /**
     *
     */
    public QuadProbingHT () {
        this(997);
    }

    /**
     *
     * @param size
     */
    public QuadProbingHT (int size) {
        M = size;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    /**
     *
     * @param key
     * @return
     */
    private int hash(Key key) {
      return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     *
     * @param key
     * @param val
     */
    @Override
    public void put(Key key, Value val) {
        int currenthash = hash(key); int i;
        for (i = 0; keys[(currenthash + i^2) % M] != null; i++){
            if (keys[(currenthash + i^2) % M].equals(key)) {
                vals[(currenthash + i^2) % M] = val;
                return; }}
        keys[(currenthash + i^2) % M] = key;
        vals[(currenthash + i^2) % M] = val;
        N++;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public Value get(Key key) {
        int currenthash = hash(key); int i;
        for (i = 0; keys[(currenthash + i^2) % M] != null; i++){
            if (keys[(currenthash + i^2) % M].equals(key)) {
                return vals[(currenthash + i^2) % M]; }}
        return null;
    }

}
