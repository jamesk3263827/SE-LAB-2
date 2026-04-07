package edu.cmu.cs.cs214.rec04;

public class InheritanceSortedIntList extends SortedIntList {

    private int totalAdded;

    /**
     * Constructs an empty InheritanceSortedIntList with totalAdded initialized to 0.
     */
    public InheritanceSortedIntList() {
        super();
        totalAdded = 0;
    }

    /**
     * Adds the specified int to the list, maintaining sorted order, and
     * increments the totalAdded counter.
     *
     * @param num an integer to be added to the list
     * @return true if the list is changed as a result of the call
     */
    @Override
    public boolean add(int num) {
        totalAdded++;
        return super.add(num);
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
