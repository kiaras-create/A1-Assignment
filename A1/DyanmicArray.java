public class DyanmicArray<T> implements IndexAccessADT<T> {
    
        /**
     * 
     * @param index index of element the user is attempting to access
     * returns element at accessed index
     * will throw an exception if specified index is out of bounds
     * @return element which was accessed
     */
    public T getEle(int index) { 

    }

    /**
     * 
     * @param index of element the user is attempting to modify
     * change/set the element at specified index
     * will throw an exception if the specified index is out of bounds
     * @return element which was modified
     */
    public T setEle(int index) {

    }

    /**
     * 
     * @param arr array which user is passing in
     * @return length of the array
     */
    public T lenArray(T[] arr) {

    }

    /**
     * @param index of placement where user wants to add an element
     * @param element that will be added to specified index 
     * Inserts element in specified index and shifts all other elements accordingly
     * @return updated dynamic array
     */
    public T addElement(int index, T element) {
        
    }


    /**
     * 
     * @param index of element user wants to remove
     * @param element that will be removed at the specified index
     * Removes element at specified index and shifts all other elements left 
     * @return updated dynamic array
     */
        public T removeElement(int index, T element) {
        
    }

    /**
     * @param dynamicArray that will be concatenated to the end of the array
     * Will add a the dynamic array to the end of the array
     * @return updated dynamic array
     */
    public T appendArray(T dynamicArray) {
        
    }


    /**
     * 
     * @param index of the list
     * @param dynamicArray that will be removed from the dynamic array
     * Will remove a dynamic array from the specified indices
     * @return updated dynamic array
     */
    public T insertArray(T dynamicArray, int index) {
        
    }

    /**
     * 
     * @param startIndex index of the starting point
     * @param endIndex index of the end
     * @return copy of the list from starting point to ending point
     */
    public T subList(int startIndex, int endIndex) {
        
    }

    /**
     * 
     * @param startIndex
     * @param endIndex
     * @return updated dynamic array
     */
    public T deleteList(int startIndex, int endIndex) {
        
    }

    /**
     * 
     * @param fromIndex
     * @param toIndex
     * @return new dynamic array
     */
    public T extractArray(int fromIndex, int toIndex) {
        
    }

}
