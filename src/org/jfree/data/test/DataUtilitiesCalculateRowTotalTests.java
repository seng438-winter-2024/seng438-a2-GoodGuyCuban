package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesCalculateRowTotalTests extends DataUtilities {

	/**
     * calculateRowTotal Tests
     * - positive values
     * - negative values
     * - mixed values
     * - Large matrix
     * - null entry in matrix
     * - empty matrix
     * - Large index
     * - invalid index, too high
     * - invalid index, too low
     */
    
    @Test
	 public void calculateRowTotalForTwoPositiveValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(3.5));
	             one(values).getValue(0, 1);
	             will(returnValue(1.5));
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);

	     // verify
	     assertEquals("Sum was unexpected.", 5.0, result, .000000001d);
	 }
    
    @Test
	 public void calculateRowTotalForThreeNegativeValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getColumnCount();
	             will(returnValue(3));
	             one(values).getValue(0, 0);
	             will(returnValue(-5.3));
	             one(values).getValue(0, 1);
	             will(returnValue(-8.3));
	             one(values).getValue(0, 2);
	             will(returnValue(-0.3));
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);

	     // verify
	     assertEquals("Sum was unexpected.", -13.9, result, .000000001d);
	 }
    
    @Test
	 public void calculateRowTotalForFourMixedValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getColumnCount();
	             will(returnValue(4));
	             one(values).getValue(0, 0);
	             will(returnValue(0));
	             one(values).getValue(0, 1);
	             will(returnValue(5.5));
	             one(values).getValue(0, 2);
	             will(returnValue(-13));
	             one(values).getValue(0, 3);
	             will(returnValue(-12.5));
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);

	     // verify
	     assertEquals("Sum was unexpected.", -20, result, .000000001d);
	 }
    
    @Test
	 public void calculateRowTotalForManyColumns() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getColumnCount();
	             will(returnValue(60));
	             for (int i = 0; i < 60; i++) {
	            	 one(values).getValue(0, i);
	            	 will(returnValue(1));
	             }
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);

	     // verify
	     assertEquals("Sum was unexpected.", 60, result, .000000001d);
	 }
    
     @Test
	 public void calculateRowTotalWithNullValues() {
	     // From the javadoc:
	     // "With invalid input, a total of zero will be returned."
    	 
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(3.14));
	             one(values).getValue(0, 1);
	             will(returnValue(null));
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     
	     // verify
	     assertEquals("Sum was unexpected.", 0, result, .000000001d);
	 }
    
    @Test
    public void calculateRowTotalForEmptyMatrix() {
    	// setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getColumnCount();
	             will(returnValue(0));
	         }
	     });
    	double result = DataUtilities.calculateRowTotal(values, 0);
    	
    	// verify
    	assertEquals("Sum was unexpected.", 0, result, .000000001d);	
    }
    
    @Test
	 public void calculateRowTotalWithLargeIndex() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(60, 0);
	             will(returnValue(1));
	             one(values).getValue(60, 1);
	             will(returnValue(2));
	         }
	     });
	     double result = DataUtilities.calculateRowTotal(values, 60);

	     // verify
	     assertEquals("Sum was unexpected.", 3, result, .000000001d);
	 }
    
    @Test
    public void calculateRowTotalForOutOfBoundsIndexBelow() {
	     // From the javadoc:
	     // "With invalid input, a total of zero will be returned."
    	
    	// setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	 one(values).getColumnCount();
	    			will(returnValue(1));
	    			one(values).getValue(-1, 0);
	    			will(throwException(new IndexOutOfBoundsException()));
	         }
	     });
	     
	     // verify
	     try {
	    		double result = DataUtilities.calculateRowTotal(values, -1);
	    		assertEquals(0, result, .000000001d);
	    	} catch (IndexOutOfBoundsException e) {
	    		assertTrue("Fails to catch exception " + e +". Should return 0.", false);
	    	}
    }
    
    @Test
    public void calculateRowTotalForOutOfBoundsIndexAbove() {
	     // From the javadoc:
	     // "With invalid input, a total of zero will be returned."
    	
    	// setup
    	Mockery mockingContext = new Mockery();
    	final Values2D values = mockingContext.mock(Values2D.class);
    	mockingContext.checking(new Expectations() {
    		{
    			one(values).getColumnCount();
    			will(returnValue(1));
    			one(values).getValue(13, 0);
    			will(throwException(new IndexOutOfBoundsException()));
    		}
    	});
    	
    	// verify
    	try {
    		double result = DataUtilities.calculateRowTotal(values, 13);
    		assertEquals(0, result, .000000001d);
    	} catch (IndexOutOfBoundsException e) {
    		assertTrue("Fails to catch exception " + e +". Should return 0.", false);
    	}
    }
    
}
