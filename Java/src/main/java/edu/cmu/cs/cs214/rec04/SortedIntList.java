package edu.cmu.cs.cs214.rec04;

import  java.util.ArrayList;

public class SortedIntList extends AbstractIntList {
	
	protected ArrayList<Integer> arr;
	protected int count;

	public SortedIntList () {
		count = 0;
		arr = new ArrayList<>();				
	}

	@Override
	public boolean add(int num) {
        arr.add(num);
		count++;
		
		return true;

	}

	@Override
	public int get(int index) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean remove(int num) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(IntegerList list) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int size() {
		return arr.size();
	}
	
}