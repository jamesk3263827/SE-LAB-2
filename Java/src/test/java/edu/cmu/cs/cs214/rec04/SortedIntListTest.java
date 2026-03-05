package edu.cmu.cs.cs214.rec04;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for the SortedIntList class.
 * 
 * @author java-upgrade
 */
public class SortedIntListTest {

    private SortedIntList list;
    private SortedIntList emptyList;

    /**
     * Called before each test.
     */
    @Before
    public void setUp() {
        list = new SortedIntList();
        emptyList = new SortedIntList();
    }

    /**
     * Test the constructor creates an empty list.
     */
    @Test
    public void testConstructor() {
        assertEquals(0, emptyList.size());
    }

    /**
     * Test adding a single element to the list.
     */
    @Test
    public void testAddSingleElement() {
        assertTrue(list.add(5));
        assertEquals(1, list.size());
    }

    /**
     * Test adding multiple elements to the list.
     */
    @Test
    public void testAddMultipleElements() {
        assertTrue(list.add(1));
        assertTrue(list.add(3));
        assertTrue(list.add(2));
        assertTrue(list.add(4));
        assertEquals(4, list.size());
    }

    /**
     * Test adding duplicate elements to the list.
     */
    @Test
    public void testAddDuplicateElements() {
        assertTrue(list.add(5));
        assertTrue(list.add(5));
        assertTrue(list.add(5));
        assertEquals(3, list.size());
    }

    /**
     * Test adding negative numbers.
     */
    @Test
    public void testAddNegativeNumbers() {
        assertTrue(list.add(-10));
        assertTrue(list.add(-5));
        assertTrue(list.add(-1));
        assertEquals(3, list.size());
    }

    /**
     * Test adding zero.
     */
    @Test
    public void testAddZero() {
        assertTrue(list.add(0));
        assertEquals(1, list.size());
    }

    /**
     * Test adding Integer.MAX_VALUE.
     */
    @Test
    public void testAddMaxValue() {
        assertTrue(list.add(Integer.MAX_VALUE));
        assertEquals(1, list.size());
    }

    /**
     * Test adding Integer.MIN_VALUE.
     */
    @Test
    public void testAddMinValue() {
        assertTrue(list.add(Integer.MIN_VALUE));
        assertEquals(1, list.size());
    }

    /**
     * Test size of empty list.
     */
    @Test
    public void testSizeEmptyList() {
        assertEquals(0, emptyList.size());
    }

    /**
     * Test size after adding elements.
     */
    @Test
    public void testSizeAfterAdding() {
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
    }

    /**
     * Test size increases correctly with each add.
     */
    @Test
    public void testSizeIncrements() {
        assertEquals(0, list.size());
        list.add(10);
        assertEquals(1, list.size());
        list.add(20);
        assertEquals(2, list.size());
        list.add(30);
        assertEquals(3, list.size());
    }

    /**
     * Test the get method (currently returns 0 - stub implementation).
     */
    @Test
    public void testGet() {
        list.add(5);
        list.add(10);
        // Note: get() is a stub that returns 0
        assertEquals(0, list.get(0));
    }

    /**
     * Test the remove method (currently returns false - stub implementation).
     */
    @Test
    public void testRemove() {
        list.add(5);
        // Note: remove() is a stub that returns false
        assertFalse(list.remove(5));
        // Size should remain unchanged since remove is not implemented
        assertEquals(1, list.size());
    }

    /**
     * Test the removeAll method (currently returns false - stub implementation).
     */
    @Test
    public void testRemoveAll() {
        list.add(1);
        list.add(2);
        list.add(3);
        
        SortedIntList otherList = new SortedIntList();
        otherList.add(1);
        otherList.add(2);
        
        // Note: removeAll() is a stub that returns false
        assertFalse(list.removeAll(otherList));
        // Size should remain unchanged since removeAll is not implemented
        assertEquals(3, list.size());
    }

    /**
     * Test addAll method from AbstractIntList with empty list.
     */
    @Test
    public void testAddAllEmptyList() {
        list.add(1);
        list.add(2);
        
        assertFalse(list.addAll(emptyList));
        assertEquals(2, list.size());
    }

    /**
     * Test addAll method from AbstractIntList with non-empty list.
     */
    @Test
    public void testAddAllNonEmptyList() {
        list.add(1);
        list.add(2);
        
        SortedIntList otherList = new SortedIntList();
        otherList.add(3);
        otherList.add(4);
        otherList.add(5);
        
        assertTrue(list.addAll(otherList));
        assertEquals(5, list.size());
    }

    /**
     * Test addAll method from AbstractIntList to empty list.
     */
    @Test
    public void testAddAllToEmptyList() {
        SortedIntList otherList = new SortedIntList();
        otherList.add(10);
        otherList.add(20);
        
        assertTrue(emptyList.addAll(otherList));
        assertEquals(2, emptyList.size());
    }

    /**
     * Test addAll method with duplicate elements.
     */
    @Test
    public void testAddAllWithDuplicates() {
        list.add(1);
        list.add(2);
        
        SortedIntList otherList = new SortedIntList();
        otherList.add(2);
        otherList.add(3);
        
        assertTrue(list.addAll(otherList));
        assertEquals(4, list.size());
    }

    /**
     * Test addAll method with negative numbers.
     */
    @Test
    public void testAddAllWithNegativeNumbers() {
        SortedIntList otherList = new SortedIntList();
        otherList.add(-5);
        otherList.add(-10);
        otherList.add(-1);
        
        assertTrue(emptyList.addAll(otherList));
        assertEquals(3, emptyList.size());
    }

    /**
     * Test that multiple adds work correctly.
     */
    @Test
    public void testSequentialAdds() {
        for (int i = 0; i < 10; i++) {
            assertTrue(list.add(i));
        }
        assertEquals(10, list.size());
    }

    /**
     * Test large number of elements.
     */
    @Test
    public void testLargeNumberOfElements() {
        for (int i = 0; i < 1000; i++) {
            list.add(i);
        }
        assertEquals(1000, list.size());
    }
}
