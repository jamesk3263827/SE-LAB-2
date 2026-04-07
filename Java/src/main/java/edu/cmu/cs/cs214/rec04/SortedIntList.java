package edu.cmu.cs.cs214.rec04;

public class SortedIntList extends AbstractIntList {

    private int[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * Constructs an empty SortedIntList with default initial capacity.
     */
    public SortedIntList() {
        data = new int[DEFAULT_CAPACITY];
        size = 0;
    }

    /**
     * Adds the specified int to the list, maintaining ascending sorted order.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */
    @Override
    public boolean add(int num) {
        ensureCapacity();

        // Find the correct insertion index to maintain sorted order
        int insertIndex = size;
        for (int i = 0; i < size; i++) {
            if (num <= data[i]) {
                insertIndex = i;
                break;
            }
        }

        // Shift elements right to make room
        for (int i = size; i > insertIndex; i--) {
            data[i] = data[i - 1];
        }

        data[insertIndex] = num;
        size++;
        return true;
    }

    /**
     * Adds all elements of the given IntegerList to this list in ascending order.
     * Pre-sorts the incoming elements before inserting so that sorted order is
     * maintained efficiently regardless of the input order.
     *
     * @param list IntegerList containing elements to be added to the list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean addAll(IntegerList list) {
        int[] temp = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            temp[i] = list.get(i);
        }
        java.util.Arrays.sort(temp);

        boolean success = false;
        for (int num : temp) {
            success |= this.add(num);
        }
        return success;
    }

    /**
     * Returns the integer at the specified position in this list.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return data[index];
    }

    /**
     * Removes the first occurrence of the specified element from the list,
     * if it is present.
     *
     * @param num an integer to be removed from the list, if present
     * @return true if an element was removed as a result of this call
     */
    @Override
    public boolean remove(int num) {
        for (int i = 0; i < size; i++) {
            if (data[i] == num) {
                // Shift elements left to fill the gap
                for (int j = i; j < size - 1; j++) {
                    data[j] = data[j + 1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    /**
     * Removes from the list all elements that are contained in the
     * specified IntegerList.
     *
     * @param list IntegerList containing elements to be removed from the list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean removeAll(IntegerList list) {
        boolean changed = false;
        for (int i = 0; i < list.size(); i++) {
            changed |= this.remove(list.get(i));
        }
        return changed;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return number of elements in the list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Ensures the internal array has capacity for at least one more element,
     * doubling the array size if needed.
     */
    private void ensureCapacity() {
        if (size == data.length) {
            int[] newData = new int[data.length * 2];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    /**
     * Returns a string representation of the list.
     *
     * @return string representation
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}