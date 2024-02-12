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

    @Test
    public void intersects_WithFullyInsideRange_ShouldReturnTrue() {
        assertTrue("Should return true for a range that is fully inside", testRange.intersects(12, 18));
    }

    @Test
    public void intersects_WithFullyOutsideRange_LowerSide_ShouldReturnFalse() {
        assertFalse("Should return false for a range fully outside on the lower side", testRange.intersects(5, 9));
    }

    @Test
    public void intersects_WithFullyOutsideRange_UpperSide_ShouldReturnFalse() {
        assertFalse("Should return false for a range fully outside on the upper side", testRange.intersects(21, 25));
    }

    @Test
    public void intersects_WithOverlappingRange_LowerBound_ShouldReturnTrue() {
        assertTrue("Should return true for a range overlapping on the lower bound", testRange.intersects(5, 15));
    }

    @Test
    public void intersects_WithOverlappingRange_UpperBound_ShouldReturnTrue() {
        assertTrue("Should return true for a range overlapping on the upper bound", testRange.intersects(15, 25));
    }

    @Test
    public void intersects_WithExactMatchRange_ShouldReturnTrue() {
        assertTrue("Should return true for a range that exactly matches", testRange.intersects(10, 20));
    }

    @Test
    public void intersects_JustInsideLowerBound_ShouldReturnTrue() {
        assertTrue("Should return true for a range just inside the lower bound", testRange.intersects(10, 11));
    }

    @Test
    public void intersects_JustInsideUpperBound_ShouldReturnTrue() {
        assertTrue("Should return true for a range just inside the upper bound", testRange.intersects(19, 20));
    }

    @Test
    public void intersects_JustOutsideLowerBound_ShouldReturnFalse() {
        assertFalse("Should return false for a range just outside the lower bound", testRange.intersects(9, 10));
    }

    @Test
    public void intersects_JustOutsideUpperBound_ShouldReturnFalse() {
        assertFalse("Should return false for a range just outside the upper bound", testRange.intersects(20, 21));
    }
    

}