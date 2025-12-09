/**  
 * Interface to describe operations supported by built-in array
 * A hypothetical IndexAccess object would be created in a constructor. The constructor is not featured in the interface. 
 * The object would be declared by defining the type the array will hold followed by its name. Then, it would be initialized by defining the size.
*/
interface IndexAccessADT <T> {
    
    

    /**
     * 
     * @param index index of element the user is attempting to access
     * returns element at accessed index
     * will throw an exception if specified index is out of bounds
     * @return element which was accessed
     */
    public T get(int index);

    /**
     * 
     * @param index of element the user is attempting to modify
     * change/set the element at specified index
     * will throw an exception if the specified index is out of bounds
     * @return element which was modified
     */
    public T setEle(int index, T element); 

    /**
     * 
     * @param arr array which user is passing in
     * @return length of the array
     */
    public int size();

    /**
     * Inserts element in specified index and shifts subsequent elements to right
     * Throws exception if specified indicies are out of bounds
     * @param index 
     * @param element 
     */
    public void addElement(int index, T element);


    /**
     * 
     * @param element
     * Overloaded addElement method that appends element to end of array
     */
    public void addElement(T element);


    /**
     * 
     * @param index of element user wants to remove
     * @param element that will be removed at the specified index
     * Removes element at specified index and shifts all other elements left 
     * @return updated dynamic array
     */
        public T removeElement(int index, T element);

    /**
     * @param dynamicArray that will be concatenated to the end of the array
     * Will add a the dynamic array to the end of the array
     * @return updated dynamic array
     */
    public DynamicArray<T> appendArray(DynamicArray<T> appendedArray);

    /**
     * 
     * @param index of the list
     * @param dynamicArray that will be removed from the dynamic array
     * Will remove a dynamic array from the specified indices
     * @return updated dynamic array
     */
    public IndexAccessADT<T> insertArray(T[] dynamicArray, int index);

    /**
     * 
     * @param startIndex
     * @param endIndex
     * @return updated dynamic array
     */
    public IndexAccessADT<T> deleteList(int startIndex, int endIndex);

    /**
     * 
     * @param fromIndex
     * @param toIndex
     * @return new dynamic array
     */
    public DynamicArray<T> extractArray(int fromIndex, int toIndex);


    /**
     * 
     * @param index
     * @return new dynamic array
     * returns elements from specified index and after as new dynamic array
     */
    public IndexAccessADT<T> splitSuffix(int index);


    /**
     * 
     * @param index
     * @return new dynamic array
     * returns elements before specified index as new dynamic array
     */
    public IndexAccessADT<T> splitPrefix(int index);


    









    /**
     * 
     */




}

// JUNIT TESTS

// public T getEle(int index) - method call w/expected return value
// The length of this array is 5. Each index holds an element (char). For instance, the array is B L U E S. 
// The method should return the element at the specific index. In this case, if the user wants to access the element at index 2, the method should return 'U'.
// We will use AssertEqual to check if the expected value aligns with the returned value. The expected value of 'U' and return value of 'U' match, so the test case passes. 

// public T getEle(int index) - method call w/expected exception
// The length of this array is 5. Each index holds an element (char). For instance, the array is B L U E S. 
// The method should return the element at the specific index. In this case, the user wants to access the element at index 5.
// In this case, we will use AssertTrue to test if the requested index is less than the length of the array. However, because the 5th index is out of bounds (exception), the test will fail.

// public T getEle(int index) - method call w/fail test
// The length of this array is 5. Each index holds an element (char). For instance, the array is B L U E S. 
// The method should return the element at the specific index. In this case, if the user wants to access the element at index 2, the method should return 'U'.
// We will again use AssertEqual to check if the expected element aligns with the returned element. However, the elements do not match (expected is 'U' and returned is 'B'), the test will fail.

// public T setEle(int index) - method call w/expected return value
// The length of this array is 5. Each index holds an element (char). For instance, the array is B L U E S. 
// We want to change the element at the 3rd index to an 'I'. The method should return the changed array as B L U I S. 
// We will again use AssertEqual to check if the expected array aligns with the returned array. The expected array of B L U I S and returned array matches, so the test case passes. 

// public T setEle(int index) - method call w/expected exception
// The length of this array is 5. Each index holds an element (char). For instance, the array is B L U E S. 
// We want to store an element at the 5th index. 
// In this case, we will use AssertTrue to test if the index requested is less than the length of the array. However, the 5th index is out of bounds, so the test fails. 

// public T setEle(int index) - method call w/fail test
// The length of this array is 5. Each index holds an element (char). For instance, the array is B L U E S. 
// We want to change the element at the 3rd index to an 'I'. The method should return the changed array as B L U I S. 
// We will use AssertEqual to check if the expected array aligns with the returned array. The expected array (B L U I S) and returned array (B L I E S) do not match, as you made a typo. The test fails.

// public T lenArray(T[] arr) - method call w/expected return value
// The length of this array is 4. Each index holds an element (int). The array contains the ints 1 2 3 4. 
// We want to return the length of the array, which is 4. 
// We will use AssertEqual to check if the expected length matches the returned length. The expected length is 4, and the returned length is 4, so the test passes.
