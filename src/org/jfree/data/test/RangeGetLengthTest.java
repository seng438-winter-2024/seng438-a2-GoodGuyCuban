package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class RangeGetLengthTest {
	 	private double lowerBound;
	    private double upperBound;
	    private double expectedLength;

	    public RangeGetLengthTest(double lowerBound, double upperBound, double expectedLength) {
	        this.lowerBound = lowerBound;
	        this.upperBound = upperBound;
	        this.expectedLength = expectedLength;
	    }

	    @Parameterized.Parameters
	    public static Collection<Object[]> data() {
	        return Arrays.asList(new Object[][] {
	        	//Formatted as lowerBound, upperBound, ExpectedLength
	            {1, 10, 9}, // Positive range ECT
	            {5, 5, 0}, // Zero-length range ECT
	            {-1, 1, 2}, // Range spanning from negative to positive ECT
	            {5, 5.00001, 0.00001}, // Minimal positive range BVT
	            {-1000000, 1000000, 2000000} // Large  BVT
	        });
	    }

	    @Test
	    public void testGetLengthWithVariousRanges() {
	        Range range = new Range(lowerBound, upperBound);
	        assertEquals("The length of the range should match the expected value", expectedLength, range.getLength(), 0.00001);
	    }
	    
}

