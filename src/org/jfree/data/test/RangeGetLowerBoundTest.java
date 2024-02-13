package org.jfree.data.test;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RangeGetLowerBoundTest {
    private Range range;

    // Setup method to initialize the Range object before each test @Before
    @Before
    public void setUp() {
        range = new Range(10, 20);
    }

    // Cleanup code here. For this case, it might be unnecessary. range = null;
    @After
    public void tearDown() {
        range = null;
    }

    // Boundary Value Test: Lower bound of the range
    // This test ensures that the getLowerBound() method returns the correct lower bound for a valid range. 
    @Test
    public void getLowerBound_WithValidRange_ReturnsCorrectValue() {
        assertEquals("Lower bound is incorrect", 10, range.getLowerBound(), 0.00001); // ECT because testing valid input
    }

    // Equivalence Class Test: Lower bound of the range
    @Test
    public void getLowerBound_WithNegativeInfinity_ReturnsNegativeInfinity() {
        Range range = new Range(Double.NEGATIVE_INFINITY, 20);
        assertEquals("Lower bound is not negative infinity", Double.NEGATIVE_INFINITY, range.getLowerBound(), 0.00001);
    }

    // Test case for lower bound of a non-empty range
    @Test
    public void testGetLowerBoundNonEmptyRange_ReturnsCorrectValue() {
        Range range = new Range(2.0, 5.0);
        assertEquals("Lower bound is incorrect", 2.0, range.getLowerBound(), 0.0001); // ECT: Non-empty range
    }

    // Test case for lower bound of an empty range
    @Test
    public void testGetLowerBoundEmptyRange_ReturnsCorrectValue() {
        Range range = new Range(5.0, 5.0); // Empty range
        assertEquals("Lower bound is incorrect", 5.0, range.getLowerBound(), 0.0001); // ECT: Empty range
    }

    // Test case for lower bound boundary value (lower bound itself)
    @Test
    public void testGetLowerBoundBoundaryLower_ReturnsCorrectValue() {
        Range range = new Range(0.0, 5.0);
        assertEquals("Lower bound is incorrect", 0.0, range.getLowerBound(), 0.0001); // BVT: Boundary lower
    }

    // Test case for lower bound boundary value (just above lower bound)
    @Test
    public void testGetLowerBoundBoundaryJustAboveLower_ReturnsCorrectValue() {
        Range range = new Range(0.0001, 5.0);
        assertEquals("Lower bound is incorrect", 0.0001, range.getLowerBound(), 0.0001); // BVT: Boundary just above lower
    }

    // Test case for lower bound boundary value (just below lower bound)
    // In this test, we verify the behavior of the getLowerBound() method when the lower bound is just below zero.
    @Test
    public void testGetLowerBoundBoundaryJustBelowLower_ReturnsCorrectValue() {
        Range range = new Range(-0.0001, 5.0);
        assertEquals("Lower bound is incorrect", -0.0001, range.getLowerBound(), 0.0001); // BVT: Boundary just below lower
    }
}
