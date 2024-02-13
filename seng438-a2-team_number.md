**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group: 16           |
| ------------------- |
| Luke Ens            |
| Chinonso Oragwam    |
| Marcos Perez Perera |
| Ibrahim Wani        |


# 1 Introduction

Text…

# 2 Detailed description of unit test strategy

// including the input partitions you have designed

## Range

Our unit test strategy for the Range class in JFreeChart focused on these 6 functionalities: checking for intersections (intersects method), expanding ranges (expand method), and calculating the length of a range (getLength method) … **ADD ABES HERE.** To ensure the completeness of our test we employed Equivalence Class Testing (ECT) and Boundary Value Testing (BVT) principles when designing our inputs. Below are the details regarding our input partitions and the rationale behind their selection.

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

## NEED TO ADD ABES TESTS HERE

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

**Boundary Value Testing (BVT):**

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

*   Partition Covered (ECT): Valid positive margins.
    

**expand\_WithZeroMargins\_ShouldNotChangeRange**

*   Partition Covered (ECT): Zero margins.
    

**expand\_WithNegativeMargins\_ShouldThrowError**

*   Partition Covered (ECT): Invalid Argument
    

**expand\_MinimalPositiveMargins\_ShouldSlightlyExpandRange (FAILED)**

*   Partition Covered (BVT): Minimal positive margins.
    

**expand\_LargePositiveMargins\_ShouldSignificantlyExpandRange**

*   Partition Covered (BVT): Large positive margins
    

### Class: RangeIntersectsTest

**Unless Specified assume a test case passes** 

**setUp() Method**: Initializes testRange with a fixed range of 10 to 20 before each test.

**tearDown() Method**: Resets testRange to null after each test for cleanup

**Test Methods:**

**intersects\_WithFullyInsideRange\_ShouldReturnTrue**

*   Partition Covered (ECT): Intersecting Ranges.
    

**intersects\_WithFullyOutsideRange\_LowerSide\_ShouldReturnFalse(FAILED)**

*   Partition Covered (ECT): Non-Intersecting Ranges (Outside) on the lower side.
    

Ensures that ranges completely outside the lower bound of the test range are identified as not intersecting.

**intersects\_WithFullyOutsideRange\_UpperSide\_ShouldReturnFalse**

*   Partition Covered (ECT): Non-Intersecting Ranges (Outside) on the upper side.
    
*   Verifies that ranges completely outside the upper bound of the test range are recognized as not intersecting.
    

**intersects\_WithOverlappingRange\_LowerBound\_ShouldReturnTrue**

*   Partition Covered (ECT/BVT): Edge-Case Intersections and Just Inside Bounds.
    
*   Verifies that ranges overlapping the lower boundary of the test range are accurately detected as intersecting.
    

**intersects\_WithOverlappingRange\_UpperBound\_ShouldReturnTrue(FAILED)**

*   Partition Covered (ECT/BVT): Edge-Case Intersections and Just Inside Bounds.
    
*   Verifies that ranges overlapping the upper boundary of the test range are correctly identified as intersecting.
    

**intersects\_WithExactMatchRange\_ShouldReturnTrue**

*   Partition Covered (ECT): Intersecting Ranges (Exact Match).
    
*   Verifies that a range exactly matching the test range is identified as intersecting.
    

**intersects\_JustInsideLowerBound\_ShouldReturnTrue**

*   Partition Covered (BVT): Just Inside Bounds.
    
*   Verifies that a range barely inside the lower boundary is correctly flagged as intersecting.
    

**intersects\_JustInsideUpperBound\_ShouldReturnTrue(FAILED)**

*   Partition Covered (BVT): Just Inside Bounds.
    
*   Verifies that a range barely inside the upper boundary is accurately recognized as intersecting.
    

**intersects\_JustOutsideLowerBound\_ShouldReturnFalse(FAILED)**

*   Partition Covered (BVT): Just Outside Bounds.
    
*   Verifies that a range just outside the lower boundary is identified as not intersecting.
    

**intersects\_JustOutsideUpperBound\_ShouldReturnFalse**

*   Partition Covered (BVT): Just Outside Bounds.
    
*   Verifies that a range just outside the upper boundary is recognized as not intersecting.

## Org.Jfree.data.DataUtilities

### Class: DataUtilitiesCalculateColumnTotalTests

**Test Methods:**

**calculateColumnTotal_ForOnePositiveValues**

- Partition Covered (ECT): MAKE STUFF UP

**calculateColumnTotal_ForTwoPositiveValues**

- Partition Covered (ECT): MAKE STUFF UP

**calculateColumnTotal_ForThreeNegativeValues**

- Partition Covered (ECT): MAKE STUFF UP

**calculateColumnTotal_ForFourMixedValues**

- Partition Covered (ECT): MAKE STUFF UP

**calculateColumnTotal_ForManyRows**

- Partition Covered (ECT): MAKE STUFF UP

**calculateColumnTotal_WithNullValues**

- Partition Covered (ECT): MAKE STUFF UP

**calculateColumnTotal_ForEmptyMatrix**

- Partition Covered (ECT): MAKE STUFF UP

**calculateColumnTotal_WithLargeIndex**

- Partition Covered (ECT): MAKE STUFF UP

**calculateColumnTotal_ForOutOfBoundsIndexBelow**

- Partition Covered (ECT): MAKE STUFF UP

**calculateColumnTotal_ForOutOfBoundsIndexAbove**

- Partition Covered (ECT): MAKE STUFF UP

### Class: DataUtilitiesCreateNumberArray2DTest

**Test Methods:**

**calculateColumnTotal_ForOnePositiveValues**

- Partition Covered (ECT): MAKE STUFF UP

### Class: DataUtilitiesCreateNumberArrayTest

**Test Methods:**

**calculateColumnTotal_ForOnePositiveValues**

- Partition Covered (ECT): MAKE STUFF UP

### Class: DataUtilitiesGetCumulativePercentagesTests

**Test Methods:**

**calculateColumnTotal_ForOnePositiveValues**

- Partition Covered (ECT): MAKE STUFF UP

# 4 How the team work/effort was divided and managed

We liked the idea of pair testing from the last lab and decided to conduct our test in pairs for this lab as well. We split ourselves into groups of 2 and assigned one group to test the Range class and another group to test the DataUtilities Class. In these groups, each member evaluated three methods, guaranteeing that, upon completion of all tests, we achieved coverage for at least five methods per class.
We then evaluated our partner's test methods, ensuring that the tests adhered to our strategy and the javadoc requirements. Then one step further, we met back together as a group to look over each others tests with fresh eyes. 

# 5 Difficulties encountered, challenges overcome, and lessons learned

Text…
I wanna talk about the pain of Mocks in here. 

# 6 Comments/feedback on the lab itself

Text…
They shoulda told us more about how to use Mocks. 
