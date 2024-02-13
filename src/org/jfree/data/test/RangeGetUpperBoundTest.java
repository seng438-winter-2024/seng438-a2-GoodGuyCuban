package org.jfree.data.test;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RangeGetUpperBoundTest {
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

    // Boundary Value Test: Upper bound of the range
    @Test
    public void getUpperBound_WithValidRange_ReturnsCorrectValue() {
        assertEquals("Upper bound is incorrect", 20, range.getUpperBound(), 0.00001);
    }

    // Equivalence Class Test: Upper bound of the range
    @Test
    public void getUpperBound_WithPositiveInfinity_ReturnsPositiveInfinity() {
        Range range = new Range(10, Double.POSITIVE_INFINITY);
        assertEquals("Upper bound is not positive infinity", Double.POSITIVE_INFINITY, range.getUpperBound(), 0.00001);
    }

    // Test case for upper bound of a non-empty range
    @Test
    public void testGetUpperBoundNonEmptyRange_ReturnsCorrectValue() {
        Range range = new Range(2.0, 5.0);
        assertEquals("Upper bound is incorrect", 5.0, range.getUpperBound(), 0.0001); // ECT: Non-empty range
    }

    // Test case for upper bound of an empty range
    @Test
    public void testGetUpperBoundEmptyRange_ReturnsCorrectValue() {
        Range range = new Range(5.0, 5.0); // Empty range
        assertEquals("Upper bound is incorrect", 5.0, range.getUpperBound(), 0.0001); // ECT: Empty range
    }

    // Test case for upper bound boundary value (upper bound itself)
    @Test
    public void testGetUpperBoundBoundaryUpper_ReturnsCorrectValue() {
        Range range = new Range(0.0, 5.0);
        assertEquals("Upper bound is incorrect", 5.0, range.getUpperBound(), 0.0001); // BVT: Boundary upper
    }

    // Test case for upper bound boundary value (just above upper bound)
    @Test
    public void testGetUpperBoundBoundaryJustAboveUpper_ReturnsCorrectValue() {
        Range range = new Range(0.0, 5.0001);
        assertEquals("Upper bound is incorrect", 5.0001, range.getUpperBound(), 0.0001); // BVT: Boundary just above upper
    }

    // Test case for upper bound boundary value (just below upper bound)
    @Test
    public void testGetUpperBoundBoundaryJustBelowUpper_ReturnsCorrectValue() {
        Range range = new Range(0.0, 4.9999);
        assertEquals("Upper bound is incorrect", 4.9999, range.getUpperBound(), 0.0001); // BVT: Boundary just below upper
    }
}
