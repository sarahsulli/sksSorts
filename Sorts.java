import java.util.*;

public class Sorts{
    private long steps;

    /**
     *  Description of Constructor
     *
     * @param  list  Description of Parameter
     */
    public Sorts(){
        steps = 0;
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void bubbleSort(ArrayList <Integer> list){
        int j;
        boolean flag = true;
        int temp;

        while ( flag )
        {
            flag= false;
            for( j=0;  j < list.size() - 1;  j++ )
            {
                if ( list.get(j) > list.get(j+1) )
                {
                    temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j + 1, temp);
                    flag = true;
                }
            }
        }
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println();
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void selectionSort(ArrayList <Integer> list){
        /**int i = 0;
        int len = list.size();
        for (i = 0; i < len - 1; i++) 
        {
        int imin = i;
        for (int j = i + 1; j < len; j++) 
        {
        if (list.get(j) < list.get(imin)) 
        {
        imin = j;
        }
        }
        Collections.swap(list,i,imin);      
        }
        System.out.println(list);
        return list; 
         */
        // just return if the array list is null
        if (list == null)
        {
            return;
        }

        // just return if the array list is empty or only has a single element
        if (list.size() == 0 || list.size() == 1)
        {
            return;
        }
        // declare an int variable to hold value of index at which the element
        // has the smallest value
        int smallestIndex;

        // declare an int variable to hold the smallest value for each iteration
        // of the outer loop
        int smallest;

        // for each index in the array list
        for (int curIndex = 0; curIndex < list.size(); curIndex++)
        {
            /* find the index at which the element has smallest value */
            // initialize variables
            smallest = list.get(curIndex);
            smallestIndex = curIndex;
            for (int i = curIndex + 1; i < list.size(); i++) 
            {
                if (smallest > list.get(i)) 
                {
                    // update smallest
                    smallest = list.get(i);
                    smallestIndex = i;
                }
            }
            /* swap the value */
            // do nothing if the curIndex has the smallest value
            if (smallestIndex == curIndex)
            {
                ;
            }
            // swap values otherwise
            else 
            {
                int temp = list.get(curIndex);
                list.set(curIndex, list.get(smallestIndex));
                list.set(smallestIndex, temp);
            }
        }
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println();
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void insertionSort(ArrayList <Integer> list){
        for(int i=1;i<list.size();i++)
        {
            int key = list.get(i);
            for(int j= i-1;j>=0;j--)
            {
                if(key<list.get(j))
                {
                    // Shifting Each Element to its right as key is less than the existing element at current index
                    list.set(j+1,list.get(j));

                    // Special case scenario when all elements are less than key, so placing key value at 0th Position
                    if(j==0)
                    {
                        list.set(0, key);
                    }
                }
                else
                {
                    // Putting Key value after element at current index as Key value is no more less than the existing element at current index
                    list.set(j+1,key);
                    break; // You need to break the loop to save un necessary iteration
                }
            }
        }
    }

    /**
     *  Accessor method to return the current value of steps
     *
     */
    public long getStepCount()
    {
        return steps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(long stepCount)
    {
        steps = stepCount;
    }
}
