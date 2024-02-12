package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.junit.Test;
import static org.junit.Assert.*;
import java.security.InvalidParameterException;

public class DataUtilsTest {

    // Test createNumberArray method

    @Test
    public void testCreateNumberArray_ValidInput() {
        double[] data = {1.0, 2.0, 3.0};
        java.lang.Number[] expected = {1.0, 2.0, 3.0};
        assertArrayEquals(expected, DataUtilities.createNumberArray(data));
    }

    @Test
    public void testCreateNumberArray_EmptyInput() {
        double[] data = {};
        java.lang.Number[] expected = {};
        assertArrayEquals(expected, DataUtilities.createNumberArray(data));
    }

    @Test(expected = InvalidParameterException.class)
    public void testCreateNumberArray_NullInput() {
        double[] data = null;
        DataUtilities.createNumberArray(data);
    }

    @Test(expected = InvalidParameterException.class)
    public void testCreateNumberArray_InvalidInput() {
        double[] data = {Double.NaN, Double.POSITIVE_INFINITY};
        DataUtilities.createNumberArray(data);
    }

    @Test
    public void testCreateNumberArray_BoundaryValues() {
        double[] data = {Double.MIN_VALUE, Double.MAX_VALUE};
        java.lang.Number[] expected = {Double.MIN_VALUE, Double.MAX_VALUE};
        assertArrayEquals(expected, DataUtilities.createNumberArray(data));
    }

    // Test createNumberArray2D method

    @Test
    public void testCreateNumberArray2D_ValidInput() {
        double[][] data = {{1.0, 2.0}, {3.0, 4.0}};
        java.lang.Number[][] expected = {{1.0, 2.0}, {3.0, 4.0}};
        assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
    }

    @Test
    public void testCreateNumberArray2D_EmptyInput() {
        double[][] data = {};
        java.lang.Number[][] expected = {};
        assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
    }

    @Test(expected = InvalidParameterException.class)
    public void testCreateNumberArray2D_NullInput() {
        double[][] data = null;
        DataUtilities.createNumberArray2D(data);
    }

    @Test(expected = InvalidParameterException.class)
    public void testCreateNumberArray2D_InvalidInput() {
        double[][] data = {{Double.NaN, Double.POSITIVE_INFINITY}, {Double.NEGATIVE_INFINITY}};
        DataUtilities.createNumberArray2D(data);
    }

    @Test
    public void testCreateNumberArray2D_BoundaryValues() {
        double[][] data = {{Double.MIN_VALUE, Double.MAX_VALUE}, {Double.MAX_VALUE}};
        java.lang.Number[][] expected = {{Double.MIN_VALUE, Double.MAX_VALUE}, {Double.MAX_VALUE}};
        assertArrayEquals(expected, DataUtilities.createNumberArray2D(data));
    }
}
