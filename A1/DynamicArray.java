
public class DynamicArray<T> implements IndexAccessADT<T> {

    int size; 
    T[] myArray;

    /**
     * Private utility to do array allocation
     */

    @SuppressWarnings("unchecked")
    private T[] allocate(int len) {
        return (T[]) new Object[len];
    }


    /**
     * base array constructor
     * @param size of how large the size of the array should be
     */
    public DynamicArray(int size) {
        this.myArray= allocate(size);
        this.size = size;
    }


    /**
     * 
     * copy constructor that makes a deep copy and loops through base array to copy values
     * @param dynamicArray dynamic array being copied
     */
    public DynamicArray(T[] arr, int arraySize) {
        T[] myNewArray = allocate(arraySize);
        for (int i = 0; i < arraySize; i++) {
            myNewArray[i] = this.myArray[i];
        }

    }



     /**
     * 
     * returns element at specific index
     * will throw an exception if specified index is out of bounds
     * @param index of element user is trying to retrieve
     * @return element which was accessed
     */
    public T get(int index) {
        if (index >= 0) {
            if (index < size(myArray)) {
                return myArray[index];
            } else {
                throw new IndexOutOfBoundsException("Your index is greater than the array length. It is out of bounds.");
            }
        } else {
            throw new IndexOutOfBoundsException("Your index is less than 0. It is out of bounds."); 
        }
    }

    

    /**
     * 
     * @param index of element the user is attempting to modify
     * change/set the element at specified index
     * will throw an exception if the specified index is out of bounds
     * @return element which was modified
     */
    public T setEle(int index, T newEle) {
        //Throwing exception if the index's out of bounds
        if(index < 0 || index >= size(myArray)){
            throw new IndexOutOfBoundsException("Your index is out of bounds.");
        }

        
        //Saving the old element's index, replacing the old value with the new one, and returns old value's index
        //Cast and suppress warning
    
        T oldEle =  myArray[index];
        myArray[index] = newEle;
        return oldEle;

    }


   
    /**
     * 
     * finds length of array
     * @param arr array which user is passing in
     * @return length of the array
     */
    
    public int size(T[] arr) {
    
        int counter = 0;
        try  {
            while (true) {
                T temp = arr[counter];
                counter ++;
                //System.out.println(temp);
            } 
    

        } catch(ArrayIndexOutOfBoundsException e){
            System.out.println(("Error"));
        }
       // for (int i =0; i< size; i++){
            //counter ++;
        
        return counter;
            
        }


     /**
     * 
     * Inserts element in specified index and shifts subsequent elements to right
     * Throws exception if specified indicies are out of bounds
     * @param index for where element needs to be added
     * @param element specified element
     */
    public void addElement(int index, T element) {
        if (index >= 0) {
            if (index < size(myArray)) {
                DynamicArray<T> temp = new DynamicArray<T>(size(myArray) + 1);
                for (int i = 0; i < index; i++) {
                    // T myEle = getEle(i);
                    temp.setEle(i, get(i));
                }
                temp.setEle(index, element);
                for (int i = index; i < size(this.myArray); i++) {
                    temp.setEle(i+1, get(i));
                }
                // reassigns this.myArray (base array) to the same array of temp
                this.myArray = temp.myArray;
            } else {
                throw new IndexOutOfBoundsException("Your index is greater than the array length. It is out of bounds");
            }
        } else {
            throw new IndexOutOfBoundsException("Your index is less than 0. It is out of bounds.");
        }
    }



     /**
     * 
     * Overloaded addElement method that appends element to end of array
     * @param element specified element
     */
     public void addElement(T element) {
        DynamicArray<T> temp = new DynamicArray<T>(size(myArray) + 1);
        for (int i = 0; i < size(myArray); i++) {
            temp.setEle(i, get(i));
        }
        temp.setEle(size(myArray), element);
        // reassigns this.myArray (base array) to the same array of temp
        this.myArray = temp.myArray;
     }




    /**
     * 
     * @param index of element user wants to remove
     * @param element that will be removed at the specified index
     * Removes element at specified index and shifts all other elements left 
     * @return updated dynamic array
     */
        public T removeElement(int index, T element) {
            if(index < 0 || index >= size(myArray)){
                throw new IndexOutOfBoundsException("Your index is out of bounds.");
            }

            DynamicArray<T> newArray =  new DynamicArray<T>(size(myArray) - 1);

            T removed = get(index);

            for(int i = 0; i < size(myArray); i++ ){
                newArray.setEle(i, get(i)); //saving the stuff from old array into the same indeces for the new one
            }

            for (int i = index + 1; i < size(myArray); i++){
                newArray.setEle(i - 1, get(i));
            }

            this.myArray = newArray.myArray; // this new shelf is my shelf now; not sure if needed

            return removed;


        
    }



    /**
     * @param dynamicArray that will be concatenated to the end of the array
     * Will add a the dynamic array to the end of the array
     * @return updated dynamic array
     */
    public DynamicArray<T> appendArray(DynamicArray<T> appendedArray) {
        DynamicArray<T> newArray =  new DynamicArray<T>(size(myArray) + appendedArray.size(appendedArray.myArray));

        for(int i = 0; i < appendedArray.size(appendedArray.myArray); i++){ //copying array
            newArray.setEle(i, get(i));
        }
        for(int i = 0; i < appendedArray.size(myArray); i ++){
            T value = appendedArray.get(i); //getting a variable type T name value that gets the element at that index
            newArray.setEle(size(appendedArray.myArray) + i, value);
        }
         return newArray; 
        
    }




    /**
     * 
     * 
     * @param index of the list
     * @param dynamicArray that will be removed from the dynamic array
     * Will remove a dynamic array from the specified indices
     * @return updated dynamic array
     */
    public DynamicArray<T> insertArray(T[] myDynamicArray, int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Incorrect Index");
             }
        
        int newLength = size(myDynamicArray);
        int oldLength = size(myArray);
        int totalLength = newLength + oldLength;


        DynamicArray<T> result = new DynamicArray<>(myArray, totalLength);
        for (int i = 0; i < index; i++ ){
            result.addElement(this.myArray[i]);
        }
        for (int j = 0; j < newLength; j++ ){
            result.addElement(myDynamicArray[j]);

        }
       
        for (int i = index; i < oldLength;  i++ ){
            result.addElement(this.myArray[i]);

        }
       
         return result;
        }
        


    /**
     * 
     * returns elements from specified index and after as new dynamic array
     * throws exception if specified index is out of bounds
     * @param index of where array is going to be split including index
     * @return new dynamic array
     */
    public DynamicArray<T> splitSuffix(int index) {
        if (index >= 0) {
            if (index < size(myArray)) {
                DynamicArray<T> newArray = new DynamicArray<>(myArray, (size(myArray) - index));
                for (int i = index; i < size(myArray); i++) {
                    newArray.setEle(i-index, get(i));
                }
                return newArray;
            } else {
                throw new IndexOutOfBoundsException("Your index is greater than the array length. It is out of bounds.");
            }
        } else {
            throw new IndexOutOfBoundsException("Your index is less than 0. It is out of bounds.");
        }
    }


    /**
     * 
     * @param index of where array is going to be split
     * @return new dynamic array
     * returns elements before specified index as new dynamic array
     */
    public DynamicArray<T> splitPrefix(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException("Incorrect Index");
             }
        DynamicArray<T> result = new DynamicArray<>(myArray,index);
        for (int i = 0; i < index; i++ ){
            result.addElement(this.myArray[i]);
        }
       
         return result;
        }




    /**
     * 
     * removes elements from first index up to other index in current array
     * throws an exception if specified indicies are out of bounds
     * @param startIndex where deletion should start
     * @param endIndex where deletion should end
     * @return updated dynamic array
     */
    public DynamicArray<T> deleteList(int startIndex, int endIndex) {
        if ((startIndex >= 0) && (startIndex < endIndex)) {
            if (endIndex > startIndex && endIndex <= size(myArray)) {
                DynamicArray<T> updatedDArray = new DynamicArray<>(myArray, (size(myArray) - (endIndex - startIndex)));
                for (int i = 0; i < size(myArray); i++) {
                    // SQUISHY PART
                    if ((i < startIndex) || (i >= endIndex)) {
                        updatedDArray.setEle(i, get(i));
                    }
                }
                return updatedDArray;
            } else {
                throw new IndexOutOfBoundsException("Your end index is out of bounds.");
            }
        } else {
            throw new IndexOutOfBoundsException("Your start index is out of bounds.");
        } 
    }
 



    /**
     * 
     * grabs elements from one index up to just before another
     * @param fromIndex where extraction should start from
     * @param toIndex where extraction should end
     * @return new dynamic array
     */
    public DynamicArray<T> extractArray(int fromIndex, int toIndex) {
        //making the new array

        if (fromIndex < 0) {
            throw new ArrayIndexOutOfBoundsException("Start index is negative and is out of bounds");
        }

        if (fromIndex > size(myArray)){
            throw new ArrayIndexOutOfBoundsException("Start index (fromIndex) is too large");
        }

        if (toIndex < 0){
            throw new ArrayIndexOutOfBoundsException("End index (toIndex) is negative");

        }

        if (toIndex > size(myArray)){
            throw new ArrayIndexOutOfBoundsException("End index (toIndex) is out of bounds");
        }

        if (fromIndex > toIndex){
            throw new ArrayIndexOutOfBoundsException("Start index (fromIndex) is larger than end index(toIndex)");
        }

         if (size(myArray)==0){
            throw new ArrayIndexOutOfBoundsException("Array is empty");
        }

        DynamicArray<T> extractedArray =  new DynamicArray<T>(toIndex - fromIndex);

       
        //the value i is the value we are starting from, it should be less than the one we want to end at, and increment
        for(int i = fromIndex; i < toIndex; i ++){
            T value = get(i); //getting a variable type T name value that gets the element at that index
            extractedArray.setEle(i - fromIndex, value); //let the new array set that element into the array; from the index minus the starting value (this allows the value to be put in the right index position), and place that value there


        }

        return extractedArray; //returning array

    }

}
