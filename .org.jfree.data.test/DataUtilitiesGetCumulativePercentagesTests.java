package org.jfree.data.test;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

public class DataUtilitiesGetCumulativePercentagesTests extends DataUtilities {

	/**
     * getCumulativePercentages Tests
     * - one value
     * - positive values
     * - negative values
     * - mixed values
     * - large quantity of values
     * - no values
     * - keyedvalues with nulls
     */
    
    @Test
    public void getCumulativePercentagesForOneValue() {
    	// setup
    	Mockery mockingContext = new Mockery();
        final KeyedValues values = mockingContext.mock(KeyedValues.class);

        mockingContext.checking(new Expectations() {{
        	exactly(3).of(values).getItemCount();
        	will(returnValue(1));
        	
        	exactly(2).of(values).getValue(0);
            will(returnValue(10));
            
            one(values).getKey(0);
            will(returnValue('a'));
        }});
        
        HashMap<Object, Number> expected = new HashMap<>();
        expected.put('a', 1.0);
        
        HashMap<Object, Number> result = new HashMap<>();
        
        
        // verify
        KeyedValues resultKeyedValues= DataUtilities.getCumulativePercentages(values);
        
        // Convert KeyedValues to HashMap
        for (int i = 0; i < resultKeyedValues.getItemCount(); i++) {
        	Object key = resultKeyedValues.getKey(i);
        	Number value = resultKeyedValues.getValue(i);
        	result.put(key, value);
        }
        
        assertEquals("Unexpected Percentages.", expected, result);
    }
    
    @Test
    public void getCumulativePercentagesForThreePositiveValues() {
    	// setup
    	Mockery mockingContext = new Mockery();
        final KeyedValues values = mockingContext.mock(KeyedValues.class);

        mockingContext.checking(new Expectations() {{
        	exactly(7).of(values).getItemCount();
        	will(returnValue(3));
        	
        	exactly(2).of(values).getValue(0);
            will(returnValue(1));
            exactly(2).of(values).getValue(1);
            will(returnValue(3));
            exactly(2).of(values).getValue(2);
            will(returnValue(4));
            
            one(values).getKey(0);
            will(returnValue('a'));
            one(values).getKey(1);
            will(returnValue('b'));
            one(values).getKey(2);
            will(returnValue('c'));
        }});
        
        HashMap<Object, Number> expected = new HashMap<>();
        expected.put('a', 0.125);
        expected.put('b', 0.5);
        expected.put('c', 1.0);
        
        HashMap<Object, Number> result = new HashMap<>();
        
        
        // verify
        KeyedValues resultKeyedValues= DataUtilities.getCumulativePercentages(values);
        
        // Convert KeyedValues to HashMap
        for (int i = 0; i < resultKeyedValues.getItemCount(); i++) {
        	Object key = resultKeyedValues.getKey(i);
        	Number value = resultKeyedValues.getValue(i);
        	result.put(key, value);
        }
        
        assertEquals("Unexpected Percentages.", expected, result);
    }
    
    @Test
    public void getCumulativePercentagesForTwoNegativeValues() {
    	// setup
    	Mockery mockingContext = new Mockery();
        final KeyedValues values = mockingContext.mock(KeyedValues.class);

        mockingContext.checking(new Expectations() {{
        	exactly(5).of(values).getItemCount();
        	will(returnValue(2));
        	
        	exactly(2).of(values).getValue(0);
            will(returnValue(-3));
            exactly(2).of(values).getValue(1);
            will(returnValue(-7));
            
            one(values).getKey(0);
            will(returnValue('a'));
            one(values).getKey(1);
            will(returnValue('b'));
        }});
        
        HashMap<Object, Number> expected = new HashMap<>();
        expected.put('a', 0.3);
        expected.put('b', 1.0);
        
        HashMap<Object, Number> result = new HashMap<>();
        
        
        // verify
        KeyedValues resultKeyedValues= DataUtilities.getCumulativePercentages(values);
        
        // Convert KeyedValues to HashMap
        for (int i = 0; i < resultKeyedValues.getItemCount(); i++) {
        	Object key = resultKeyedValues.getKey(i);
        	Number value = resultKeyedValues.getValue(i);
        	result.put(key, value);
        }
        
        assertEquals("Unexpected Percentages.", expected, result);
    }
    
    @Test
    public void getCumulativePercentagesForFourMixedValues() {
    	// setup
    	Mockery mockingContext = new Mockery();
        final KeyedValues values = mockingContext.mock(KeyedValues.class);

        mockingContext.checking(new Expectations() {{
        	exactly(9).of(values).getItemCount();
        	will(returnValue(4));
        	
        	exactly(2).of(values).getValue(0);
            will(returnValue(-2));
            exactly(2).of(values).getValue(1);
            will(returnValue(4));
            exactly(2).of(values).getValue(2);
            will(returnValue(0));
            exactly(2).of(values).getValue(3);
            will(returnValue(6));
            
            one(values).getKey(0);
            will(returnValue('a'));
            one(values).getKey(1);
            will(returnValue('b'));
            one(values).getKey(2);
            will(returnValue('c'));
            one(values).getKey(3);
            will(returnValue('d'));
        }});
        
        HashMap<Object, Number> expected = new HashMap<>();
        expected.put('a', -0.25);
        expected.put('b', 0.25);
        expected.put('c', 0.25);
        expected.put('d', 1.0);
        
        HashMap<Object, Number> result = new HashMap<>();
        
        
        // verify
        KeyedValues resultKeyedValues= DataUtilities.getCumulativePercentages(values);
        
        // Convert KeyedValues to HashMap
        for (int i = 0; i < resultKeyedValues.getItemCount(); i++) {
        	Object key = resultKeyedValues.getKey(i);
        	Number value = resultKeyedValues.getValue(i);
        	result.put(key, value);
        }
        
        assertEquals("Unexpected Percentages.", expected, result);
    }

    @Test
    public void getCumulativePercentagesForLargeData() {
    	// setup
    	Mockery mockingContext = new Mockery();
        final KeyedValues values = mockingContext.mock(KeyedValues.class);

        int numOfRows = 50;
        mockingContext.checking(new Expectations() {{
        	exactly(2*numOfRows+1).of(values).getItemCount();
        	will(returnValue(numOfRows));
        	
        	for (int i = 0; i < numOfRows; i++) {
	        	exactly(2).of(values).getValue(i);
	            will(returnValue(1));
	            
	            one(values).getKey(i);
	            will(returnValue(i));
        	}
        }});
        
        HashMap<Object, Number> expected = new HashMap<>();
        for (int i = 0; i < numOfRows; i++) {
        	expected.put(i, ((double) i+1) / numOfRows);
    	}
        
        HashMap<Object, Number> result = new HashMap<>();
        
        
        // verify
        KeyedValues resultKeyedValues= DataUtilities.getCumulativePercentages(values);
        
        // Convert KeyedValues to HashMap
        for (int i = 0; i < resultKeyedValues.getItemCount(); i++) {
        	Object key = resultKeyedValues.getKey(i);
        	Number value = resultKeyedValues.getValue(i);
        	result.put(key, value);
        }
        
        assertEquals("Unexpected Percentages.", expected, result);
    }
    
    @Test
    public void getCumulativePercentagesWithEmptyData() {
    	// setup
    	Mockery mockingContext = new Mockery();
        final KeyedValues values = mockingContext.mock(KeyedValues.class);

        mockingContext.checking(new Expectations() {{
        	exactly(2).of(values).getItemCount();
        	will(returnValue(0));
        	
        }});
        
        HashMap<Object, Number> expected = new HashMap<>();
        
        HashMap<Object, Number> result = new HashMap<>();
        
        
        // verify
        KeyedValues resultKeyedValues= DataUtilities.getCumulativePercentages(values);
        
        // Convert KeyedValues to HashMap
        for (int i = 0; i < resultKeyedValues.getItemCount(); i++) {
        	Object key = resultKeyedValues.getKey(i);
        	Number value = resultKeyedValues.getValue(i);
        	result.put(key, value);
        }
        
        assertEquals("Unexpected Percentages.", expected, result);
    }
    
    @Test
    public void getCumulativePercentagesWithNullEntries() {
    	// setup
    	Mockery mockingContext = new Mockery();
        final KeyedValues values = mockingContext.mock(KeyedValues.class);

        mockingContext.checking(new Expectations() {{
        	exactly(9).of(values).getItemCount();
        	will(returnValue(4));
        	
        	exactly(2).of(values).getValue(0);
            will(returnValue(1));
            exactly(2).of(values).getValue(1);
            will(returnValue(3));
            exactly(2).of(values).getValue(2);
            will(returnValue(null));
            exactly(2).of(values).getValue(3);
            will(returnValue(4));
            
            one(values).getKey(0);
            will(returnValue('a'));
            one(values).getKey(1);
            will(returnValue('b'));
            one(values).getKey(2);
            will(returnValue('c'));
            one(values).getKey(3);
            will(returnValue('d'));
        }});
        
        HashMap<Object, Number> expected = new HashMap<>();
        expected.put('a', 0.125);
        expected.put('b', 0.5);
        expected.put('c', 0.5);
        expected.put('d', 1.0);
        
        HashMap<Object, Number> result = new HashMap<>();
        
        
        // verify
        KeyedValues resultKeyedValues= DataUtilities.getCumulativePercentages(values);
        
        // Convert KeyedValues to HashMap
        for (int i = 0; i < resultKeyedValues.getItemCount(); i++) {
        	Object key = resultKeyedValues.getKey(i);
        	Number value = resultKeyedValues.getValue(i);
        	result.put(key, value);
        }
        
        assertEquals("Unexpected Percentages.", expected, result);
    }

}
