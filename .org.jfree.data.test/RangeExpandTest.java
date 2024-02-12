package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;



public class RangeExpandTest {
	
	private Range originalRange;

    // Setup method to initialize the Range object before each test
    @Before
    public void setUp() {
        // Initialize a common Range object for test methods
        originalRange = new Range(10, 20);
    }

    @After
    public void tearDown() {
        // Cleanup code here. For this case, it might be unnecessary.
    	originalRange = null;
    }

    @Test
    public void expand_WithValidPositiveMargins_ShouldExpandRangeProperly() {
        double lowerMargin = 0.1; // 10%
        double upperMargin = 0.2; // 20%
        Range expandedRange = Range.expand(originalRange, lowerMargin, upperMargin);
        // Expected: Lower bound decreases by 1, upper bound increases by 2
        assertEquals("Expanded range lower bound is incorrect", 9, expandedRange.getLowerBound(), 0.00001);
        assertEquals("Expanded range upper bound is incorrect", 22, expandedRange.getUpperBound(), 0.00001);
    }

    @Test
    public void expand_WithZeroMargins_ShouldNotChangeRange() {
        Range expandedRange = Range.expand(originalRange, 0, 0);
        assertEquals("Range should not change with zero margins", originalRange, expandedRange);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void expand_WithNegativeMargins_ShouldThrowError() {
        double lowerMargin = -0.1; // -10%
        double upperMargin = -0.2; // -20%
        Range originalRange = new Range(1, 10); // Example range, adjust as necessary
        
        Range.expand(originalRange, lowerMargin, upperMargin);
    }

    @Test
    public void expand_MinimalPositiveMargins_ShouldSlightlyExpandRange() {
        double lowerMargin = 0.001; // 0.1%
        double upperMargin = 0.001; // 0.1%
        Range expandedRange = Range.expand(originalRange, lowerMargin, upperMargin);
        // Verify minimal expansion
        assertTrue("Expanded range should be slightly larger", expandedRange.getLength() > originalRange.getLength());
    }

    @Test
    public void expand_LargePositiveMargins_ShouldSignificantlyExpandRange() {
        double lowerMargin = 1; // 100%
        double upperMargin = 1; // 100%
        Range expandedRange = Range.expand(originalRange, lowerMargin, upperMargin);
        // Verify significant expansion
        assertTrue("Expanded range should be significantly larger", expandedRange.getLength() > originalRange.getLength());
    }

}
