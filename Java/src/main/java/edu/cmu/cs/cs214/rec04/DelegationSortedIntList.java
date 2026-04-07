package edu.cmu.cs.cs214.rec04;

/**
 * DelegationSortedIntList -- a variant of a SortedIntList that keeps
 * count of the number of attempted element insertions (not to be confused
 * with the current size, which goes down when an element is removed)
 * and exports an accessor (totalAdded) for this count.
 *
 * @author Nora Shoemaker
 *
 */

public class DelegationSortedIntList implements IntegerList {

    /** The private delegate that handles all list storage and sorting. */
    private final SortedIntList delegate;

    /** Running count of all add() calls made since this list was created. */
    private int totalAdded;

    /**
     * Constructs an empty DelegationSortedIntList with totalAdded initialized to 0.
     */
    public DelegationSortedIntList() {
        delegate = new SortedIntList();
        totalAdded = 0;
    }

    /**
     * Adds the specified int to the list by delegating to the internal
     * SortedIntList, and increments the totalAdded counter.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */
    @Override
    public boolean add(int num) {
        totalAdded++;
        return delegate.add(num);
    }

    /**
     * Adds all elements of the given IntegerList to this list. Delegates the
     * pre-sorting of input to SortedIntList, but routes each individual add
     * through this.add() so that totalAdded is incremented for every element.
     *
     * @param list IntegerList containing elements to be added to the list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean addAll(IntegerList list) {
        boolean success = false;
        for (int i = 0; i < list.size(); i++) {
            success |= this.add(list.get(i));  // routes through this.add(), incrementing totalAdded
        }
        return success;
    }

    /**
     * Returns the integer at the specified position in this list,
     * delegating to the internal SortedIntList.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    @Override
    public int get(int index) {
        return delegate.get(index);
    }

    /**
     * Removes the first occurrence of the specified element from the list,
     * delegating to the internal SortedIntList.
     *
     * @param num an integer to be removed from the list, if present
     * @return true if an element was removed as a result of this call
     */
    @Override
    public boolean remove(int num) {
        return delegate.remove(num);
    }

    /**
     * Removes all elements contained in the given IntegerList from this list,
     * delegating to the internal SortedIntList.
     *
     * @param list IntegerList containing elements to be removed from the list
     * @return true if the list changed as a result of the call
     */
    @Override
    public boolean removeAll(IntegerList list) {
        return delegate.removeAll(list);
    }

    /**
     * Returns the number of elements currently in this list,
     * delegating to the internal SortedIntList.
     *
     * @return number of elements in the list
     */
    @Override
    public int size() {
        return delegate.size();
    }

    /**
     * Returns the total number of integers that have been added to this list
     * since it was created (i.e., total attempted insertions, not current size).
     *
     * @return the total number of add attempts made on this list
     */
    public int getTotalAdded() {
        return totalAdded;
    }
}