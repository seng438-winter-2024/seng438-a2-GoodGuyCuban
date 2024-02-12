package org.jfree.data.test;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.junit.Test;

public class DataUtilitiesCreateNumberArray2DTest {

    // Test createNumberArray method
    // testing for one by two positive value array
    @Test
    public void testCreateNumberArray2D_OneByTwoPositive() {
        double[][] data = {{1.0, 2.0}, {2.0, 1.0}};
        java.lang.Number[][] expected = {{1.0, 2.0}, {2.0, 1.0}};
        assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
    }
    
    // testing for three by three mixed value array
    @Test
    public void testCreateNumberArray2D_ThreeByThreeMixed() {
    	double[][] data = {{1.0, 2.0, -33.5}, {3.0, -6.7, 4.0}, {-987.43, 0.7, 4.53}};
    	java.lang.Number[][] expected = {{1.0, 2.0, -33.5}, {3.0, -6.7, 4.0}, {-987.43, 0.7, 4.53}};
    	assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
    }
    
    // testing a large array of values
    @Test
    public void testCreateNumberArray2D_SixtyNineBySixtyNineValues() {
    	double[][] data = new double[69][69];
    	java.lang.Number[][] expected = new java.lang.Number[69][69];
    	for (int i = 0; i < 69; i++) {
    		for (int j = 0; j < 69; j++) {
    			data[i][j] = (double) 420*i + 35*j;
    			expected[i][j] = (double) 420*i + 35*j;
    		}
    	}
    	assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
    }

    // testing for empty input array
    @Test
    public void testCreateNumberArray2D_EmptyInput() {
        double[][] data = {};
        java.lang.Number[][] expected = {};
        assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
    }

    // testing for invalid input
    @Test(expected = InvalidParameterException.class)
    public void testCreateNumberArray2D_InvalidInput() {
        double[][] data = {{Double.NaN, Double.POSITIVE_INFINITY}, {Double.NEGATIVE_INFINITY}};
        DataUtilities.createNumberArray2D(data);
    }

    // testing for boundary values minimum and maximum
    @Test
    public void testCreateNumberArray2D_BoundaryValues() {
        double[][] data = {{Double.MIN_VALUE, Double.MAX_VALUE}, {Double.MAX_VALUE}};
        java.lang.Number[][] expected = {{Double.MIN_VALUE, Double.MAX_VALUE}, {Double.MAX_VALUE}};
        assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
    }

}