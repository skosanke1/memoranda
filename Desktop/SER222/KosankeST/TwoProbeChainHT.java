/**
 * TwoProbeChainHT implements a two-probe separate chaining hashtable.
 * Implements SymbolTable given in homework
 *
 * @author Steven Kosanke, skosanke
 * @version 2/11/2022
 */
public class TwoProbeChainHT <Key, Value> implements SymbolTable<Key, Value>{
    private int N; // number of key-value pairs
    private int M; // table size
    private TwoProbeChainHT<Key, Value>[] ht;
    public TwoProbeChainHT() {
        this(997);
    }

    public TwoProbeChainHT(int M) {
        this.M = M;
        ht = (TwoProbeChainHT<Key, Value>[]) new TwoProbeChainHT[M];
        for (int i = 0; i < M; i++)
            ht[i] = new TwoProbeChainHT();
    }

    /**
     * hash1() is the first hash function given in homework
     * @param key is the key that must be hashed
     * @return the int value of the key hash code
     */
    private int hash1(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    /**
     *hash2() is the first hash function given in homework
     * @param key is the key that must be hashed
     * @return the int value of the key hash code
     */
    private int hash2(Key key) {
        return (((key.hashCode() & 0x7fffffff) % M) *31) %M;
    }

    /**
     * get(Key) will hearch the HT for the key to return the value.
     * @param key is the key that should be read
     * @return the value of the key if it exists in the HT
     */
    @Override
    public Value get(Key key) {
        int i=0;
        while (ht[hash1(key)].get(i) != null || ht[hash1(key)].get(i) != null) { //run through all spots
            if ((Key) ht[hash1(key)].get(i) == key) { //Check if the spot in the table contains correct key
                return (Value) ht[hash1(key)].get(i); //Return key value
            }
            if ((Key) ht[hash2(key)].get(i) == key) {
                return (Value) ht[hash2(key)].get(i);
            }
            i++; //end of search on both hashes at this index
        }
        return null; //did not find key at wither hash locations
    }


     /**
     *put(Key, Value) adds a key,value pair to the HT
     * @param key the key thats written
     * @param val the corresponding value of the key
     */
    @Override
    public void put(Key key, Value value) {
        if (ht[hash1(key)] == null) { //Need to initialize the spot
            ht[hash1(key)] = new TwoProbeChainHT(M); //Create new array at this location
            ht[hash1(key)].put(key,value); //Add value to this array
            return;
        }
        if (ht[hash2(key)] == null) {
            ht[hash2(key)] = new TwoProbeChainHT(M);
            ht[hash2(key)].put(key, value);
            return;
        }
        //Case : both first spots have been initializd
        int i=0; //Run through hash1 until emput spot is found,
        while (ht[hash1(key)].get(i) != null) {
        if (ht[hash2(key)] == null) { //if empty spot exist in hash2, add there instead
            ht[hash2(key)].put(key, value); //Add value to this array
            return;
        }
        i++;
        }
        ht[hash1(key)].put(key,value); //This spot should be empty now
    }



    /**
     * Main remove() function looks for the key and deletes it if it exists
     * @param key is the key to be deleted
     */
    @Override
    public void remove(Key key) {
        int i=0, hashfinal;
        while (ht[hash1(key)].get(i) != null || ht[hash1(key)].get(i) != null) { //run through all spots
            if ((Key) ht[hash1(key)].get(i) == key) { //Case where hash found in hash1 spot
                for (ht[hash1(key)].get(i+1) != null) { //Run through values and put the element next in the array in the current spot
                    ht[hash1(key)].put(ht[hash1(key)].get(i+1));
                    i++;
                }
                hashfinal=hash1(key); //used to at end to delete the duplicate node at the end from shifting the array
                break;
            }
            if ((Key) ht[hash2(key)].get(i) == key) { //Case where hash found in hash2 spot
                for (ht[hash2(key)].get(i+1) != null) {
                    ht[hash2(key)].put(ht[hash2(key)].get(i+1));
                    i++;
                }
                hashfinal=hash2(key);
                break;
            }
            ht[hashfinal].get(i) = null;
        } //End while, no more keys left in either list to search through
    }
    //I implemented this all a linked list, last minute changed to array structure with little time left
    //I hope I can still receive some credit for the logic behind the code here if it doesnt work. Cheers!
    }

}
