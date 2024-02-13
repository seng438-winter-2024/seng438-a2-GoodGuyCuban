package org.jfree.data.test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.jfree.data.test.DataUtilitiesCalculateColumnTotalTests;
import org.jfree.data.test.DataUtilitiesCalculateRowTotalTests;
import org.jfree.data.test.DataUtilitiesCreateNumberArray2DTest;
import org.jfree.data.test.DataUtilitiesCreateNumberArrayTest;
import org.jfree.data.test.DataUtilitiesGetCumulativePercentagesTests;

import org.jfree.data.test.RangeExpandTest;
import org.jfree.data.test.RangeGetLengthTest;
import org.jfree.data.test.RangeGetLowerBoundTest;
import org.jfree.data.test.RangeGetUpperBoundTest;
import org.jfree.data.test.RangeIntersectsTest;


import org.junit.Test;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	   	DataUtilitiesCalculateColumnTotalTests.class,
	    DataUtilitiesCalculateRowTotalTests.class,
	    DataUtilitiesCreateNumberArray2DTest.class,
	    DataUtilitiesCreateNumberArrayTest.class,
	    DataUtilitiesGetCumulativePercentagesTests.class,
	    RangeExpandTest.class,
	    RangeGetLengthTest.class,
	    RangeGetLowerBoundTest.class,
	    RangeGetUpperBoundTest.class,
	    RangeIntersectsTest.class
})
public class AllTestsSuite {
    // Placeholder
}