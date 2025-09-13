public class DyanmicArray<T> implements IndexAccessADT<T> {

    T[] myArray;

    // KIARA
    // WORK ON MAIN CONSTRUCTOR 
    public Array(int length) {
       this.myArray = (T[] new Object [length]);
       this.size = length;
    }


    // GROUP TOGETHER
    /**
     * SPECIAL CONSTRUCTOR ABOUT DYNAMIC ARRAY
     * copy constructor that makes a deep copy
     * @param dynamicArray
     */
    public Array(T[] dynamicArray) {
       T[] newArray = 
    }

    
    // CHIASHI
    /**
     * 
     * @param index index of element the user is attempting to access
     * returns element at accessed index
     * will throw an exception if specified index is out of bounds
     * @return element which was accessed
     */
    public T getEle(int index) { 

    }

    
    // VICTORIA
    /**
     * 
     * @param index of element the user is attempting to modify
     * change/set the element at specified index
     * will throw an exception if the specified index is out of bounds
     * @return element which was modified
     */
    public T setEle(int index) {

    }


    // KIARA
    /**
     * 
     * @param arr array which user is passing in
     * @return length of the array
     */
    public T lenArray(T[] arr) {

    }


    // CHIASHI
    /**
     * @param index of placement where user wants to add an element
     * @param element that will be added to specified index 
     * Inserts element in specified index and shifts all other elements accordingly
     * @return updated dynamic array
     */
    public T addElement(int index, T element) {
        
    }



    // VICTORIA
    /**
     * 
     * @param index of element user wants to remove
     * @param element that will be removed at the specified index
     * Removes element at specified index and shifts all other elements left 
     * @return updated dynamic array
     */
        public T removeElement(int index, T element) {
        
    }


    // VICTORIA
    /**
     * @param dynamicArray that will be concatenated to the end of the array
     * Will add a the dynamic array to the end of the array
     * @return updated dynamic array
     */
    public T appendArray(T dynamicArray) {
        
    }



    // KIARA
    /**
     * 
     * @param index of the list
     * @param dynamicArray that will be removed from the dynamic array
     * Will remove a dynamic array from the specified indices
     * @return updated dynamic array
     */
    public T insertArray(T dynamicArray, int index) {
        
    }



    // CHIASHI
    /**
     * 
     * @param index
     * @return new dynamic array
     * returns elements from specified index and after as new dynamic array
     */
    public T splitSuffix(int index) {

    }



    // KIARA
    /**
     * 
     * @param index
     * @return new dynamic array
     * returns elements before specified index as new dynamic array
     */
    public T splitPrefix(int index) {

    }



    // CHIASHI
    /**
     * 
     * @param startIndex
     * @param endIndex
     * @return updated dynamic array
     */
    public T deleteList(int startIndex, int endIndex) {
        
    }


    // VICTORIA
    /**
     * 
     * @param fromIndex
     * @param toIndex
     * @return new dynamic array
     */
    public T extractArray(int fromIndex, int toIndex) {
        
    }

}
