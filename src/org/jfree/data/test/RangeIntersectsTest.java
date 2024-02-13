package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


public class RangeIntersectsTest {

    private Range testRange;

    @Before
    public void setUp() {
        // Initialize a common Range object for the test methods
        // Choosing a mid-range example for broad applicability
        testRange = new Range(10, 20);
    }
    
    @After
    public void tearDown() {
    	testRange = null;
    }
    
    // ECT: Test with a range fully inside the test range

    @Test
    public void intersects_WithFullyInsideRange_ShouldReturnTrue() {
        assertTrue("Should return true for a range that is fully inside", testRange.intersects(12, 18));
    }
    
    // ECT: Test with a range fully outside the test range on the lower side


    @Test
    public void intersects_WithFullyOutsideRange_LowerSide_ShouldReturnFalse() {
        assertFalse("Should return false for a range fully outside on the lower side", testRange.intersects(5, 9));
    }

    
    // ECT: Test with a range fully outside the test range on the upper side

    @Test
    public void intersects_WithFullyOutsideRange_UpperSide_ShouldReturnFalse() {
        assertFalse("Should return false for a range fully outside on the upper side", testRange.intersects(21, 25));
    }
    
    // ECT: Test with a range overlapping the lower bound of the test range


    @Test
    public void intersects_WithOverlappingRange_LowerBound_ShouldReturnTrue() {
        assertTrue("Should return true for a range overlapping on the lower bound", testRange.intersects(5, 15));
    }
    // ECT: Test with a range overlapping the upper bound of the test range

    @Test
    public void intersects_WithOverlappingRange_UpperBound_ShouldReturnTrue() {
        assertTrue("Should return true for a range overlapping on the upper bound", testRange.intersects(15, 25));
    }
    // ECT: Test with a range that exactly matches the test range

    @Test
    public void intersects_WithExactMatchRange_ShouldReturnTrue() {
        assertTrue("Should return true for a range that exactly matches", testRange.intersects(10, 20));
    }
    // BVT: Test with a range just inside the lower bound of the test range

    @Test
    public void intersects_JustInsideLowerBound_ShouldReturnTrue() {
        assertTrue("Should return true for a range just inside the lower bound", testRange.intersects(10, 11));
    }
    // BVT: Test with a range just inside the upper bound of the test range


    @Test
    public void intersects_JustInsideUpperBound_ShouldReturnTrue() {
        assertTrue("Should return true for a range just inside the upper bound", testRange.intersects(19, 20));
    }
    // BVT: Test with a range just outside the lower bound of the test range


    @Test
    public void intersects_JustOutsideLowerBound_ShouldReturnFalse() {
        assertFalse("Should return false for a range just outside the lower bound", testRange.intersects(9, 10));
    }
    // BVT: Test with a range just outside the upper bound of the test range


    @Test
    public void intersects_JustOutsideUpperBound_ShouldReturnFalse() {
        assertFalse("Should return false for a range just outside the upper bound", testRange.intersects(20, 21));
    }
    

}