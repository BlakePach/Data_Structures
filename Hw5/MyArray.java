package HW5;

public class MyArray<E> {
    int numElements;
    E[] elements;
    public MyArray(){ // O(1)
        numElements = 0;
        elements = (E[]) new Object[5];
    }
    public void printArray(){ // O(numElements)
        System.out.printf("printArray(%d, %d): ", numElements, elements.length);
        for(int i=0; i<numElements; i++)
            System.out.print(elements[i] + " ");
        System.out.println();
    }
    private void enlarge(){ // O(elements.length)
        // double up the size of the array              // cost                 // times
        E[] newArray = (E[]) new Object[elements.length * 2];  // 2*elements.length    // 1
        for(int i=0; i < numElements; i++)
            newArray[i] = elements[i];
        elements = newArray;
    }
    public void add(E val){ // Best-case: O(1), Worst-case: O(elements.length)
        // adding the new element at the end
        if( isFull() )      // O(1)
            enlarge();      // O(elements.length)
        elements[numElements++] = val;
//        numElements++;
    }
    void addOrder(int idx, E val){ // Best-case: O(1), Worst-case: O(elements.length)
        // adding 'val' at 'idx' while shifting right all elements from there to right.
        // add(2, 99) will change {10, 20, 5, 6, 30} into {10, 20, 99, 5, 6, 30}
        // add(1, 99) will change {10, 20, 5, 6, 30} into {10, 99, 20, 5, 6, 30}
        if( isFull() )
            enlarge();
        // shift to the right. start from the right-most position
        for(int i=numElements-1;i>=idx; i--)
            elements[i+1] = elements[i];
        elements[idx] = val;
        numElements++;
    }
    int search(E val){
        return linearSearch(val);
//        return binarySearch(val);
    }
    int linearSearch(E val){  // Best-case: O(1), Worst-case: O(numElements)
        // return the index of an element equal to 'val'.
        // if 'val' is not found, return -1
        for(int i=0; i<numElements;i++)
            if(val.equals(elements[i]))
                return i;
        return -1;
    }
    // remove(val)
    void remove(E val){ // Best-case: O(1), Worst-case: O(numElements)
        // search for 'val' in elements
        int idx = linearSearch(val);
        if(idx < 0)
            return;
        // copy the last element to the location of 'val'
        // cut off the last element. numElements--
        elements[idx] = elements[--numElements]; // same as // elements[numElements-- -1];
//        numElements--;
    }
    // max()
    E max(){ // O(numElements)
//        E maxV = Integer.MIN_VALUE;
//        for(int i=0; i < numElements; i++)
//            if(elements[i] > maxV)
//                maxV = elements[i];
//        if(numElements==0)
//            return Integer.MIN_VALUE;
        E maxV = elements[0];
        for(int i=1; i < numElements; i++)
            if( ((Comparable)elements[i]).compareTo(maxV) > 0)//if(elements[i] > maxV)
                maxV = elements[i];
        return maxV;
    }
    void sort(){ // O(numElements ^ 2)
        // selection sort
        for(int i=0; i<numElements; i++){
            int minIdx = i;
            for(int j=i+1; j<numElements; j++)
                if(((Comparable)elements[j]).compareTo(elements[minIdx]) < 0)//if(elements[j] < elements[minIdx])
                    minIdx = j;
            // swap elements[i] and elements[minIdx]
            E temp = elements[i];
            elements[i] = elements[minIdx];
            elements[minIdx] = temp;
        }

    }
    //    E[] getPositiveElements(){
//        int cnt=0;
//        for(int i=0; i<numElements;i++)
//            if(elements[i].compareTo("0") )//if(elements[i] > 0)
//                cnt++;
//        E[] newArray = new E[cnt];
//        for(int i=0, j=0; i<numElements;i++)
//            if(elements[i] > 0)
//                newArray[j++] = elements[i];
//        return newArray;
//    }
    boolean isFull() { return numElements == elements.length;} // O(1)
    public boolean isEmpty() { return numElements == 0;} // O(1)
}
