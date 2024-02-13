**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group: 16           |
| ------------------- |
| Luke Ens            |
| Chinonso Oragwam    |
| Marcos Perez Perera |
| Ibrahim Wani        |

# 1 Introduction

In this assignment, we created a JUnit test suite for two classes in JFree. Our creation process for the Range and DataUtilities class tests followed four phases:

1. Familiarization of class methods.
2. Generating unit test strategies. 
3. Generating and writing test cases.
4. Peer review and compilation of test suite. 

This lab report compiles our unit testing strategies and the test cases that followed, including their results. 


# 2 Detailed description of unit test strategy

## Range

Our unit test strategy for the Range class in JFreeChart focused on these 6 functionalities: checking for intersections (intersects method), expanding ranges (expand method), calculating the length of a range (getLength method), and calculating both the upper and lower bound of a range (getUpperBound and getLowerBound method). To ensure the completeness of our test we employed Equivalence Class Testing (ECT) and Boundary Value Testing (BVT) principles when designing our inputs. Below are the details regarding our input partitions and the rationale behind their selection.

### Range Intersect Test

**Equivalence Class Testing (ECT):**

- **Intersecting Ranges:** This input partition is where the test range clearly intersects with specified bounds. This test ensures the method correctly identifies overlapping ranges.

- **Non-Intersecting Ranges:** This input partition is where the range is completely outside the specified bounds. The test ensures the method correctly detects non-overlapping ranges from upper and lower bounds.

- **Edge-Case Intersections:** This input partition is the cases of ranges that touch the edges of the specified bounds without overlapping.

**Boundary Value Testing (BVT):**

- **Just Inside Bounds**: These test case scenarios cover when the range barely intersects with the bounds, testing if the method detects minimal overlaps.

- **Just Outside Bounds**: These test case scenarios cover when the range is barely outside the specified bounds. This tests the precision of the method in returning the correct value for non-intersecting ranges close to our tested range.

### Range Expand Test

**Equivalence Class Testing (ECT):**

- **Valid Positive Margins**: This input partition is for most cases, we tested with valid positive values for lower and upper margins to make sure general range expansion is worse.

- **Zero Margins**: Zero values for margins should result in no expansion and so this input partition acts like a control group.

- **Negative Margins**: This input partition is for invalid input. Negative margins should not be accepted, so our method should throw an exception.

**Boundary Value Testing (BVT):**

- **Minimal Positive Margins**: By testing very small positive margins, we look at the method's behaviour in expanding by a very small percentage.

- **Large Positive Margins**: This tests the method's capability to handle significant range expansions without errors.

- **Exact Boundaries**: We also test that the method expands the range to exact and expected values, ensuring bounds are correctly calculated and arbitrary lower or higher bounds are not assigned.

### Range GetLength Test

**Equivalence Class Testing (ECT):**

- **Positive Range:** This input partition is a range with a positive length representing the typical scenario.

- **Zero-length Range:** This input partition is for ranges where the lower and upper bounds are equal which ensures the method correctly handles ranges with no length

- **Range Spanning from Negative to Positive:**  This input partition looks at the method's ability to calculate lengths across negative and positive bounds accurately.

**Boundary Value Testing (BVT):**

- **Minimal Positive Range**: This input partition looks at the method's ability to calculate the length of very small positive ranges ensuring precision.

- **Large Range**: This input partition checks the method's ability to handle large values accurately.
  

### Range GetUpperBound Test

**Equivalence Class Testing (ECT):**

- **Positive Infinity:** This input partition verifies if the method returns positive infinity when the upper bound is set to Double.POSITIVE_INFINITY.

- **Non-Empty Range:** This input partition ensures that the method correctly returns the upper bound for a non-empty range.

- **Boundary Value Testing (BVT):**

- **Boundary Upper**: This input partition tests if the method returns the correct upper bound when it is exactly at the boundary value.
  
- **Boundary Just Above Upper**: This input partition tests if the method returns the correct upper bound when it is just above the boundary value.
  
- **Boundary Just Below Upper**: This input partition tests if the method returns the correct upper bound when it is just below the boundary value.


### Range GetLowerBound Test

**Equivalence Class Testing (ECT):**

- **Negative Infinity:** This input partition verifies if the method returns negative infinity when the lower bound is set to Double.NEGATIVE_INFINITY.

- **Non-Empty Range:** This input partition ensures that the method correctly returns the lower bound for a non-empty range.

**Boundary Value Testing (BVT):**

- **Boundary Lower**: This input partition tests if the method returns the correct lower bound when it is exactly at the boundary value.
  
- **Boundary Just Above Lower**: This input partition tests if the method returns the correct lower bound when it is just above the boundary value.
  
- **Boundary Just Below Lower**: This input partition tests if the method returns the correct lower bound when it is just below the boundary value.

## Data Utilities

While testing the functionality of the class methods, we again employed Equivalence Class Testing (ECT) and Boundary Value Testing (BVT) principles when designing our inputs. Below are the details regarding our input partitions and the rationale behind their selection.

### Data Utilities CalculateColumnTotal & CalculateRowTotal Test

Since both of these methods cover similar functionality, and our test strategies for them were the same, they are both described here.

**Equivalence Class Testing (ECT):**

- **Valid Input Data**: This input partition covers the instance where all data entries a valid Numbers.

- **Invalid Input Data**: This input partition covers where the data contains invalid entries.

**Boundary Value Testing (BVT):**

- **Just Inside Bounds**: These test case scenarios cover when the index is barely in bounds, testing the edges of the Values2D object.
- **Just Outside Bounds**: These test case scenarios cover when the index is barely outside the bounds, testing invalid indexes of the Values2D object.

### Data Utilities CreateNumberArray & CreateNumberArray2D Test

Since both of these methods cover similar functionality, and our test strategies for them were the same, they are both described here.

**Equivalence Class Testing (ECT):**

- **Valid Input Data**: This input partition covers the instance where all data entries a valid Numbers.

- **Empty Input Data**: This input partition covers when the array data contains null entries.

- **Invalid Input Data**: This input partition covers where the data contains invalid entries.

**Boundary Value Testing (BVT):**

- **Maximum and Minimum Values**: These test case scenarios cover when the data contains the maximum and minimum values for the data type.

### Data Utilities getCumulativePercentages Test

**Equivalence Class Testing (ECT):**

- **Valid Input Data**: This input partition covers the instance where all data entries a valid Numbers.

- **Semi-Valid Input Data**: This input partition covers when some of data values are null, but the remaining are valid Numbers.

- **Invalid Input Data**: This input partition covers where the data contains only invalid entries.

**Boundary Value Testing (BVT):**

- **Just Inside Bounds**: These test case scenarios cover when the index is barely in bounds, testing the edges of the Values2D object.
- **Just Outside Bounds**: These test case scenarios cover when the index is barely outside the bounds, testing invalid indexes of the Values2D object.

# 3 Test cases developed

// write down the name of the test methods and classes. Organize the based on
the source code method // they test. identify which tests cover which partitions
you have explained in the test strategy section //above

## Org.Jfree.data.Range

### Class: RangeGetLengthTest

**Test Method: testGetLengthWithVariousRanges**

For this test, we employed the use of parameterized classes to collectively address both ECT and BVT and reduce code bloating. Each test targets a unique input partition.

ALL TEST CASES PASSED

**Partitions Covered**:

**Positive Range (ECT)**: Tested by {1, 10, 9}.

**Zero-length Range(ECT)**: Tested by {5, 5, 0}.

**Range Spanning from Negative to Positive(ECT)**: Tested by {-1, 1, 2}.

**Minimal Positive Range (BVT)**: Tested by {5, 5.00001, 0.00001}.

**Large Range (BVT)**: Tested by {-1000000, 1000000, 2000000}.

### Class: RangeExpandTest

**setUp() Method:**

Initializes originalRange with a fixed range of 10 to 20 before each test.

**tearDown() Method:**

Sets originalRange to null after each test for cleanup.

**Unless Specified assume a test case passes** 

**Test Methods:**

**expand\_WithValidPositiveMargins\_ShouldExpandRangeProperly (FAILED)**

- Partition Covered (ECT): Valid positive margins.

**expand_WithZeroMargins_ShouldNotChangeRange**

- Partition Covered (ECT): Zero margins.

**expand_WithNegativeMargins_ShouldThrowError**

- Partition Covered (ECT): Invalid Argument

**expand\_MinimalPositiveMargins\_ShouldSlightlyExpandRange (FAILED)**

- Partition Covered (BVT): Minimal positive margins.

**expand_LargePositiveMargins_ShouldSignificantlyExpandRange**

- Partition Covered (BVT): Large positive margins

### Class: RangeIntersectsTest

**Unless Specified assume a test case passes** 

**setUp() Method**: Initializes testRange with a fixed range of 10 to 20 before each test.

**tearDown() Method**: Resets testRange to null after each test for cleanup

**Test Methods:**

**intersects_WithFullyInsideRange_ShouldReturnTrue**

- Partition Covered (ECT): Intersecting Ranges.

**intersects\_WithFullyOutsideRange\_LowerSide\_ShouldReturnFalse(FAILED)**

- Partition Covered (ECT): Non-Intersecting Ranges (Outside) on the lower side.

Ensures that ranges completely outside the lower bound of the test range are identified as not intersecting.

**intersects_WithFullyOutsideRange_UpperSide_ShouldReturnFalse**

- Partition Covered (ECT): Non-Intersecting Ranges (Outside) on the upper side.
- Verifies that ranges completely outside the upper bound of the test range are recognized as not intersecting.

**intersects_WithOverlappingRange_LowerBound_ShouldReturnTrue**

- Partition Covered (ECT/BVT): Edge-Case Intersections and Just Inside Bounds.
- Verifies that ranges overlapping the lower boundary of the test range are accurately detected as intersecting.

**intersects\_WithOverlappingRange\_UpperBound\_ShouldReturnTrue(FAILED)**

- Partition Covered (ECT/BVT): Edge-Case Intersections and Just Inside Bounds.
- Verifies that ranges overlapping the upper boundary of the test range are correctly identified as intersecting.

**intersects_WithExactMatchRange_ShouldReturnTrue**

- Partition Covered (ECT): Intersecting Ranges (Exact Match).
- Verifies that a range exactly matching the test range is identified as intersecting.

**intersects_JustInsideLowerBound_ShouldReturnTrue**

- Partition Covered (BVT): Just Inside Bounds.
- Verifies that a range barely inside the lower boundary is correctly flagged as intersecting.

**intersects\_JustInsideUpperBound\_ShouldReturnTrue(FAILED)**

- Partition Covered (BVT): Just Inside Bounds.
- Verifies that a range barely inside the upper boundary is accurately recognized as intersecting.

**intersects\_JustOutsideLowerBound\_ShouldReturnFalse(FAILED)**

- Partition Covered (BVT): Just Outside Bounds.
- Verifies that a range just outside the lower boundary is identified as not intersecting.

**intersects_JustOutsideUpperBound_ShouldReturnFalse**

- Partition Covered (BVT): Just Outside Bounds.
- Verifies that a range just outside the upper boundary is recognized as not intersecting.

### RangeGetLowerBoundTest

**Test Methods:**

**getLowerBound_WithValidRange_ReturnsCorrectValue (PASSED)**

*   Partition Covered (BVT): Lower bound of the range.
    
*   Ensures that the getLowerBound() method returns the correct lower bound for a valid range.

**getLowerBound_WithNegativeInfinity_ReturnsNegativeInfinity (PASSED)**

*   Partition Covered (ECT): Lower bound of the range.
    
*   Verifies that the getLowerBound() method returns negative infinity when the lower bound is set to Double.NEGATIVE_INFINITY.

**testGetLowerBoundNonEmptyRange_ReturnsCorrectValue (PASSED)**

*   Partition Covered (ECT): Non-empty range.
    
*   Ensures that the getLowerBound() method returns the correct lower bound for a non-empty range.

**testGetLowerBoundEmptyRange_ReturnsCorrectValue (PASSED)**

*   Partition Covered (ECT): Empty range.
    
*   Ensures that the getLowerBound() method returns the correct lower bound for an empty range.

**testGetLowerBoundBoundaryLower_ReturnsCorrectValue (PASSED)**

*   Partition Covered (BVT): Boundary lower.
    
*   Verifies that the getLowerBound() method returns the correct lower bound when it is exactly at the boundary value.

**testGetLowerBoundBoundaryJustAboveLower_ReturnsCorrectValue (PASSED)**

*   Partition Covered (BVT): Boundary just above lower.
    
*   Verifies that the getLowerBound() method returns the correct lower bound when it is just above the boundary value.

**testGetLowerBoundBoundaryJustBelowLower_ReturnsCorrectValue (PASSED)**

*   Partition Covered (BVT): Boundary just below lower.
    
*   Verifies that the getLowerBound() method returns the correct lower bound when it is just below the boundary value.


### RangeGetUpperBoundTest

**Test Methods:**

**getUpperBound_WithValidRange_ReturnsCorrectValue (FAILED)**

*   Partition Covered (BVT): Upper bound of the range.
    
*   Verifies that the getUpperBound() method returns the correct upper bound for a valid range.

**getUpperBound_WithPositiveInfinity_ReturnsPositiveInfinity (FAILED)**

*   Partition Covered (ECT): Upper bound of the range.
    
*   Verifies that the getUpperBound() method returns positive infinity when the upper bound is set to Double.POSITIVE_INFINITY.

**testGetUpperBoundNonEmptyRange_ReturnsCorrectValue (FAILED)**

*   Partition Covered (ECT): Non-empty range.
    
*   Ensures that the getUpperBound() method returns the correct upper bound for a non-empty range.

**testGetUpperBoundEmptyRange_ReturnsCorrectValue (PASSED)**

*   Partition Covered (ECT): Empty range.
    
*   Ensures that the getUpperBound() method returns the correct upper bound for an empty range.

**testGetUpperBoundBoundaryUpper_ReturnsCorrectValue (FAILED)**

*   Partition Covered (BVT): Boundary upper.
    
*   Verifies that the getUpperBound() method returns the correct upper bound when it is exactly at the boundary value.

**testGetUpperBoundBoundaryJustAboveUpper_ReturnsCorrectValue (FAILED)**

*   Partition Covered (BVT): Boundary just above upper.
    
*   Verifies that the getUpperBound() method returns the correct upper bound when it is just above the boundary value.

**testGetUpperBoundBoundaryJustBelowUpper_ReturnsCorrectValue (FAILED)**

*   Partition Covered (BVT): Boundary just below upper.
    
*   Verifies that the getUpperBound() method returns the correct upper bound when it is just below the boundary value.


## Org.Jfree.data.DataUtilities

### Class: DataUtilitiesCalculateColumnTotalTests

**Test Methods:**

**calculateColumnTotal_ForOnePositiveValues** (PASSED)

- Partition Covered (ECT/BVT): Valid Input Data, Just Inside Bounds.

- Verifies that a single row of data can be summed. 

**calculateColumnTotal_ForTwoPositiveValues** (PASSED)

- Partition Covered (ECT/BVT): Valid Input Data, Just Inside Bounds.

- Verifies that two rows of data can be summed. 

**calculateColumnTotal_ForThreeNegativeValues** (PASSED)

- Partition Covered (ECT): Valid Input Data.

- Verifies that negatives may be summed. 

**calculateColumnTotal_ForFourMixedValues** (PASSED)

- Partition Covered (ECT): Valid Input Data.

- Verifies that many mixed types of data are summed. 

**calculateColumnTotal_ForManyRows** (PASSED)

- Partition Covered (ECT/BVT): Valid Input Data, Just Inside Bounds.

- Verifies that a large number of rows may be summed. 

**calculateColumnTotal_WithNullValues** (FAILED)

- Partition Covered (ECT): Invalid Input Data.

- Verifies that the sum is aborted, outputting zero.  

**calculateColumnTotal_ForEmptyMatrix** (PASSED)

- Partition Covered (ECT/BVT): Valid Input Data, Just Inside Bounds. 

- Verifies that an empty Values2D sums to zero. 

**calculateColumnTotal_WithLargeIndex** (PASSED)

- Partition Covered (ECT/BVT): Valid Input Data, Just Inside Bounds. 

- Verifies that it sums correctly at large indexes.

**calculateColumnTotal_ForOutOfBoundsIndexBelow** (FAILED)

- Partition Covered (BVT): Just Outside Bounds. 

- Verifies that the sum is aborted, outputting zero.  

**calculateColumnTotal_ForOutOfBoundsIndexAbove** (FAILED)

- Partition Covered (BVT): Just Outside Bounds. 

- Verifies that the sum is aborted, outputting zero.  
### Class: DataUtilitiesCalculateRowTotalTests

**Test Methods:**

**CalculateRowTotal_ForOnePositiveValues** (FAILED)

- Partition Covered (ECT/BVT): Valid Input Data, Just Inside Bounds.

- Verifies that a single row of data can be summed. 

**CalculateRowTotal_ForTwoPositiveValues** (FAILED)

- Partition Covered (ECT/BVT): Valid Input Data, Just Inside Bounds.

- Verifies that two rows of data can be summed. 

**CalculateRowTotal_ForThreeNegativeValues** (FAILED)

- Partition Covered (ECT): Valid Input Data.

- Verifies that negatives may be summed. 

**CalculateRowTotal_ForFourMixedValues** (FAILED)

- Partition Covered (ECT): Valid Input Data.

- Verifies that many mixed types of data are summed. 

**CalculateRowTotal_ForManyRows** (FAILED)

- Partition Covered (ECT/BVT): Valid Input Data, Just Inside Bounds.

- Verifies that a large number of rows may be summed. 

**CalculateRowTotal_WithNullValues** (FAILED)

- Partition Covered (ECT): Invalid Input Data.

- Verifies that the sum is aborted, outputting zero.  

**CalculateRowTotal_ForEmptyMatrix** (PASSED)

- Partition Covered (ECT/BVT): Valid Input Data, Just Inside Bounds. 

- Verifies that an empty Values2D sums to zero. 

**CalculateRowTotal_WithLargeIndex** (FAILED)

- Partition Covered (ECT/BVT): Valid Input Data, Just Inside Bounds. 

- Verifies that it sums correctly at large indexes.

**CalculateRowTotal_ForOutOfBoundsIndexBelow** (PASSED)

- Partition Covered (BVT): Just Outside Bounds. 

- Verifies that the sum is aborted, outputting zero.  

**CalculateRowTotal_ForOutOfBoundsIndexAbove** (PASSED)

- Partition Covered (BVT): Just Outside Bounds. 

- Verifies that the sum is aborted, outputting zero.  

### Class: DataUtilitiesCreateNumberArray2DTest

**Test Methods:**

**testCreateNumberArray2D_OneByTwoPositive** (FAILED)

- Partition Covered (ECT): Valid Input Data

- This test method checks if the method can create a 2D array of numbers that is 1x2 from two positive values.

**testCreateNumberArray2D_ThreeByThreeMixed** (FAILED)

- Partition Covered (ECT): Valid Input Data

- This test method checks if the method can create a 2D array of numbers that is 3x3 from three mixed values.

**testCreateNumberArray2D_SixtyNineBySixtyNineValues** (FAILED)

- Partition Covered (ECT): Valid Input Data

- This test method checks if the method can create a 2D array of numbers that is 69x69 from sixty-nine numbers.

**testCreateNumberArray2D_EmptyInput**

- Partition Covered (ECT): Empty Input Data

- This test method check if an exception is thrown when the input data is empty.

**testCreateNumberArray2D_InvalidInput** (FAILED)

- Partition Covered (ECT): Invalid Input Data

- This test method checks if an exception is thrown when the input data is invalid.

**testCreateNumberArray2D_BoundaryValues** (FAILED)

- Partition Covered (BVT): Maximum and Minimum Values

- This test method checks if the method can create a 2D array of numbers from the maximum and minimum values.

### Class: DataUtilitiesCreateNumberArrayTest

**Test Methods:**

**testCreateNumberArray_ForOnePositiveValue** (FAILED)

- Partition Covered (ECT): Valid Input Data

- This test method checks if the method can create an array of numbers from a single positive value.

**testCreateNumberArray_ForTwoNegativeValue** (FAILED)

- Partition Covered (ECT): Valid Input Data

- This test method checks if the method can create an array of numbers from two negative values.

**testCreateNumberArray_ThreePositive** (FAILED)

- Partition Covered (ECT): Valid Input Data

- This test method checks if the method can create an array of numbers from three positive values.

**testCreateNumberArray_ForSixtyNineNumbers** (FAILED)

- Partition Covered (ECT): Valid Input Data

- This test method checks if the method can create an array of numbers from sixty-nine numbers.

**testCreateNumberArray_EmptyInput**

- Partition Covered (ECT): Empty Input Data

- This test method check if an exception is thrown when the input data is empty.

**testCreateNumberArray_InvalidInput** (FAILED)

- Partition Covered (ECT): Invalid Input Data

- This test method checks if an exception is thrown when the input data is invalid.

**testCreateNumberArray_BoundaryValues** (FAILED)

- Partition Covered (BVT): Maximum and Minimum Values 

- This test method checks if the method can create an array of numbers from the maximum and minimum values.

### Class: DataUtilitiesGetCumulativePercentagesTests

**Test Methods:**

**getCumulativePercentages_ForOneValue** (FAILED)

- Partition Covered (ECT/BVT): Valid Input Data, Just Inside Bounds.

- Verifies that a single value is properly calculated to percent. 

**getCumulativePercentages_ForTwoNegativeValues** (FAILED)

- Partition Covered (ECT/BVT): Valid Input Data, Just Inside Bounds.

- Verifies that two values are properly calculated to percent. 

**getCumulativePercentages_ForThreePositiveValues** (FAILED)

- Partition Covered (ECT): Valid Input Data.

- Verifies that three values are properly calculated to percent. 

**getCumulativePercentages_ForFourMixedValues** (FAILED)

- Partition Covered (ECT): Valid Input Data.

- Verifies that four mixed values are properly calculated to percent. 

**getCumulativePercentages_ForLargeData** (FAILED)

- Partition Covered (ECT/BVT): Valid Input Data, Just Inside Bounds.

- Verifies that a large number of values are properly calculated to percent. 

**getCumulativePercentages_WithEmptyData** (PASSED)

- Partition Covered (ECT/BVT): Valid Input Data, Just Inside Bounds.

- Verifies that an empty KeyedValues is properly calculated to being empty. 

**getCumulativePercentages_WithNullEntries** (FAILED)

- Partition Covered (ECT/BVT): Invalid Input Data, Just Outside Bounds.

- Verifies that the proper exception is thrown for invalid KeyedValues.

# 4 How the team work/effort was divided and managed

We liked the idea of pair testing from the last lab and decided to conduct our test in pairs for this lab as well. We split ourselves into groups of 2 and assigned one group to test the Range class and another group to test the DataUtilities Class. In these groups, each member evaluated three methods, guaranteeing that, upon completion of all tests, we achieved coverage for at least five methods per class.
We then evaluated our partner's test methods, ensuring that the tests adhered to our strategy and the javadoc requirements. Then one step further, we met back together as a group to look over each others tests with fresh eyes.

# 5 Difficulties encountered, challenges overcome, and lessons learned

A big challenge we were able to overcome was finding time to come together and discuss the tests each of us created, because communication is very important in the teamwork process this was a challenge we had to overcome. We also had initial difficulties understanding mocking but as we began to write our tests the reason for mocking became clearer and our understanding of the concept got better.

# 6 Comments/feedback on the lab itself

We found the lab document to be confusing for certain sections, particularly for the demo section and the requirements of the testing. For example, we found it unclear whether each student needed to demo a mocking test or if we needed to demo mocking tests in general. As well, we wished the lab had discussed a little more about mocking, as it was difficult to connect the concept of mocking from lectures to implementing it given only a single example which had no explanation. Other than that the lab did a good job in teaching the basics of writing ECT and BVT based tests. 
