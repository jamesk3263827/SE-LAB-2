package edu.cmu.cs.cs214.rec04;

public class InheritanceSortedIntList  extends SortedIntList {

	private int totalAdded;
	
	public InheritanceSortedIntList () {
		super();
		totalAdded = 0;
	}

	@Override
	public boolean add(int num) {
        arr.add(num);
		count++;
		totalAdded++;
		
		return true;

	}

	@Override
	public boolean addAll(IntegerList list) {

        boolean success = false;

        for (int i = 0; i < list.size(); i++)
        {
            success |= arr.add(list.get(i));
        }
        
        totalAdded += list.size();
        return success;
    }
	
	public int getTotalAdded () {
		return totalAdded;
	}

}
