package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesCalculateColumnTotalTests extends DataUtilities {

	/**
     * calculateColumnTotal Tests
     * - positive values
     * - negative values
     * - mixed values
     * - large matrix
     * - null entry in matrix
     * - empty matrix
     * - large index
     * - invalid index, too high
     * - invalid index, too low
     */
    
    @Test
	 public void calculateColumnTotalForTwoPositiveValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);

	     // verify
	     assertEquals("Sum was unexpected.", 10.0, result, .000000001d);
	 }
    
    @Test
	 public void calculateColumnTotalForThreeNegativeValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(3));
	             one(values).getValue(0, 0);
	             will(returnValue(-3.3));
	             one(values).getValue(1, 0);
	             will(returnValue(-10.3));
	             one(values).getValue(2, 0);
	             will(returnValue(-2.3));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);

	     // verify
	     assertEquals("Sum was unexpected.", -15.9, result, .000000001d);
	 }
    
    @Test
	 public void calculateColumnTotalForFourMixedValues() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(4));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(-13));
	             one(values).getValue(2, 0);
	             will(returnValue(0));
	             one(values).getValue(3, 0);
	             will(returnValue(2.5));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);

	     // verify
	     assertEquals("Sum was unexpected.", -3, result, .000000001d);
	 }
    
    @Test
	 public void calculateColumnTotalForManyRows() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(60));
	             for (int i = 0; i < 60; i++) {
	            	 one(values).getValue(i, 0);
	            	 will(returnValue(1));
	             }
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);

	     // verify
	     assertEquals("Sum was unexpected.", 60, result, .000000001d);
	 }
    
     @Test
	 public void calculateColumnTotalWithNullValues() {
	     // From the javadoc:
	     // "With invalid input, a total of zero will be returned."
    	 
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(null));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     
	     // verify
	     assertEquals("Sum was unexpected.", 0, result, .000000001d);
	 }
    
    @Test
    public void calculateColumnTotalForEmptyMatrix() {
    	// setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(0));
	         }
	     });
    	double result = DataUtilities.calculateColumnTotal(values, 0);
    	// verify
    	assertEquals("Sum was unexpected.", 0, result, .000000001d);	
    }
    
    @Test
	 public void calculateColumnTotalWithLargeIndex() {
	     // setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 60);
	             will(returnValue(1));
	             one(values).getValue(1, 60);
	             will(returnValue(2));
	         }
	     });
	     double result = DataUtilities.calculateColumnTotal(values, 60);
	     // verify
	     assertEquals("Sum was unexpected.", 3, result, .000000001d);
	 }
    
    @Test
    public void calculateColumnTotalForOutOfBoundsIndexBelow() {
	     // From the javadoc:
	     // "With invalid input, a total of zero will be returned."
    	
    	// setup
	     Mockery mockingContext = new Mockery();
	     final Values2D values = mockingContext.mock(Values2D.class);
	     mockingContext.checking(new Expectations() {
	         {
	        	 one(values).getRowCount();
	    			will(returnValue(1));
	    			one(values).getValue(0, -1);
	    			will(throwException(new IndexOutOfBoundsException()));
	         }
	     });
	     
	     // verify
	     try {
	    		double result = DataUtilities.calculateColumnTotal(values, -1);
	    		assertEquals(0, result, .000000001d);
	    	} catch (IndexOutOfBoundsException e) {
	    		assertTrue("Fails to catch exception " + e +". Should return 0.", false);
	    	}
    }
    
    @Test
    public void calculateColumnTotalForOutOfBoundsIndexAbove() {
	     // From the javadoc:
	     // "With invalid input, a total of zero will be returned."
    	
    	// setup
    	Mockery mockingContext = new Mockery();
    	final Values2D values = mockingContext.mock(Values2D.class);
    	mockingContext.checking(new Expectations() {
    		{
    			one(values).getRowCount();
    			will(returnValue(1));
    			one(values).getValue(0, 13);
    			will(throwException(new IndexOutOfBoundsException()));
    		}
    	});
    	
    	// verify
    	try {
    		double result = DataUtilities.calculateColumnTotal(values, 13);
    		assertEquals(0, result, .000000001d);
    	} catch (IndexOutOfBoundsException e) {
    		assertTrue("Fails to catch exception " + e +". Should return 0.", false);
    	}
    }

}
