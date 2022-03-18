/**
 * Key class that is used in Programming HW PriorityQueueImplemented
 *
 *
 * Completion time: 1 hour
 *
 * @author Steven Kosanke, skosanke
 * @version 2/01/2022
 */
public class Key implements Comparable<Key> {

    private int number;

    public Key(int number) {
        this.number = number;
    }

    public int getKey() {
        return this.number;
    }

    @Override
    public int compareTo(Key compared) {
        if (this.getKey() > compared.getKey()) {
            return 1;
        }
        if (this.getKey() < compared.getKey()) {
            return -1;
        }
        return 0;
    }

}
