package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class DataUtilitiesCreateNumberArrayTest {

    // Test createNumberArray method
    // testing for one positive value
    @Test
    public void testCreateNumberArray_ForOnePositiveValue() {
        double[] data = {1.7};
        java.lang.Number[] expected = {1.7};
        assertArrayEquals(expected, DataUtilities.createNumberArray(data));
    }
    
    // testing for two negative value
    @Test
    public void testCreateNumberArray_ForTwoNegativeValue() {
    	double[] data = {-6.23, -543.76};
    	java.lang.Number[] expected = {-6.23, -543.76};
    	assertArrayEquals(expected, DataUtilities.createNumberArray(data));
    }
    
    // testing for three positive value
    @Test
    public void testCreateNumberArray_ThreePositive() {
    	double[] data = {1.0, 2.0, 3.0};
    	java.lang.Number[] expected = {1.0, 2.0, 3.0};
    	assertArrayEquals(expected, DataUtilities.createNumberArray(data));
    }
    
    // testing for large number of values
    @Test
    public void testCreateNumberArray_ForSixtyNineNumbers() {
    	double[] data = new double[69];
    	java.lang.Number[] expected = new java.lang.Number[69];
    	for (double i = 0; i < 69; i++) {
    		data[(int) i] = i;
    		expected[(int) i] = i;
    	}
    	assertArrayEquals(expected, DataUtilities.createNumberArray(data));
    }

    // testing for empty input array
    @Test
    public void testCreateNumberArray_EmptyInput() {
        double[] data = {};
        java.lang.Number[] expected = {};
        assertArrayEquals(expected, DataUtilities.createNumberArray(data));
    }

    // testing for invalid input
    @Test(expected = InvalidParameterException.class)
    public void testCreateNumberArray_InvalidInput() {
        double[] data = {Double.NaN, Double.POSITIVE_INFINITY};
        DataUtilities.createNumberArray(data);
    }

    // testing for boundary values (min and max values of double type)
    @Test
    public void testCreateNumberArray_BoundaryValues() {
        double[] data = {Double.MIN_VALUE, Double.MAX_VALUE};
        java.lang.Number[] expected = {Double.MIN_VALUE, Double.MAX_VALUE};
        assertArrayEquals(expected, DataUtilities.createNumberArray(data));
    }

}