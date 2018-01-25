
import java.util.*;

public class Sorts{
    private int steps;

    /**
     *  Description of Constructor
     *
     * @param  list  Description of Parameter
     */
    public Sorts(){
        steps = 1;
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void bubbleSort(ArrayList <Integer> list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Bubble Sort");
        System.out.println();
        
        for (int outer = 0; outer < list.size() - 1; outer++){
            for (int inner = 0; inner < list.size()-outer-1; inner++){
                steps += 3;
                if (list.get(inner) > list.get(inner + 1)){
                    //swap list[inner] & list[inner+1]
                    int temp = list.get(inner);
                    list.set(inner, list.get(inner + 1));
                    list.set(inner + 1, temp);
                    steps += 4;
                }
            }
        }
        
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void selectionSort(ArrayList <Integer> list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Selection Sort");
        System.out.println();

        int min, temp;

        for (int outer = 0; outer < list.size() - 1; outer++){
            min = outer;
            for (int inner = outer + 1; inner < list.size(); inner++){
                steps += 3;                
                if (list.get(inner) < list.get(min)) {
                    min = inner; // a new smallest item is found
                }
            }
            //swap list[outer] & list[min]
            temp = list.get(outer);
            list.set(outer, list.get(min));
            list.set(min, temp);
            steps += 4;
        }
    }

    /**
     *  Description of the Method
     *
     * @param  list  reference to an array of integers to be sorted
     */
    public void insertionSort(ArrayList <Integer> list){
        //replace these lines with your code
        System.out.println();
        System.out.println("Insertion Sort");
        System.out.println();

        for (int outer = 1; outer < list.size(); outer++){
            int position = outer;
            int key = list.get(position);

            // Shift larger values to the right
            while (position > 0 && list.get(position - 1) > key){
                list.set(position, list.get(position - 1));
                position--;
                steps += 4;
            }
            list.set(position, key);
            steps +=2;
        }
    }

    public void mergeSort(ArrayList <Integer> list, int low, int high) {
        // check if low is smaller than high, if not then the array is sorted
        if( low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            //System.out.print ("low " + low + "middle " + middle + " high " + high);
            // Sort the left side of the array
            mergeSort(list, low, middle);
            // Sort the right side of the array
            mergeSort(list, middle + 1, high);
            // Combine them both
            merge(list, low, middle, high);
        }
    }

    private void merge(ArrayList <Integer> list, int low, int middle, int high) {
        ArrayList <Integer> helper = new ArrayList <Integer> ();

        int i = low;
        int j = middle + 1;
        // Copy the smallest values from either the left or the right side
        // to the helper
        while (i <= middle || j <= high) {
            if (i > middle) {
                helper.add(list.get(j));
                j++;
                steps++;
            }
            else if (j > high){
                helper.add(list.get(i));
                i++;
                steps++;
            }
            else if (list.get(i) <= list.get(j)) {
                helper.add(list.get(i));
                i++;
                steps++;
            } else {
                helper.add(list.get(j));
                j++;
                steps++;
            }
        }
        int m = low;
        // Copy the merged part back into the original list from low to high index
        for(int l = 0; l < helper.size(); l++) {
            list.set(m, helper.get(l));
            m++;
            steps++;
        }
    }

    /**
     *  Accessor method to return the current value of steps
     *
     */
    public int getStepCount(){
        return steps;
    }

    /**
     *  Modifier method to set or reset the step count. Usually called
     *  prior to invocation of a sort method.
     *
     * @param  stepCount   value assigned to steps
     */
    public void setStepCount(int stepCount){
        steps = stepCount;
    }
}