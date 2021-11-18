/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortdemo;

/**
 *
 * @author jared
 */
public class Sorting {
    
    public void bubbleSort(int[] val) {
        boolean swapMade = true;
        int passNumber = 1,temp = 0;
        while(swapMade && passNumber <= val.length-1){
            swapMade = false;
            for(int i=0; i < val.length - passNumber; i++)
                if(val[i] > val[i+1]){
                    temp = val[i];
                    val[i] = val[i+1];
                    val[i+1] = temp;
                    swapMade = true;
                }
            passNumber++;
        }
        }
    public void selectionSort(int[] val){
        int temp = 0, minIndex = 0;
        for(int i = 0; i<val.length -1;i++){
            minIndex = i;
            for(int j = i+1; j < val.length;j++)
                if(val[j] < val[minIndex])
                    minIndex = j;
            if(i != minIndex){
                val[i] = val[minIndex];
                val[minIndex] = temp;
                //print(val) shows the individual steps
            }
        }
    }//end of selectionSort
    
    public void insertionSort(int[] val){
        int temp = 0, curIndex = 0;
        for(int i=1;i<val.length;i++){
            curIndex = i-1;
            temp = val[i];
            while(curIndex >= 0 &&  val[curIndex] > temp){
                val[curIndex+1] = val[curIndex];
                curIndex--;
            }
            
            val[curIndex + 1] = temp;
        }
    }
    
    public void quickSort(int[] val){
        quick(val,0,val.length-1);
        
    }
    
    public void quick(int[] val, int low, int high){
        int pivotIndex = partition(val,low,high);
        if(low < pivotIndex - 1)
            quick(val, low, pivotIndex - 1);
        if(pivotIndex + 1 < high)
            quick(val,pivotIndex+1,high);
        
    }
    
    private int partition(int [] val, int low, int high){
        int pivotValue = val[low];
        
        while(low < high){
            // Start at high side of the list
            while(val[high] >= pivotValue && low < high)
                high--;
            
            // Move the high element to the low side of the list
            if(low != high){
            val[low] = val[high];
            low++;
            }
            
            while(val[low] <= pivotValue && low < high)
                low++;
            
            // Move the low element to the high side of the list
            if(low != high){
                val[high] = val[low];
                high--;
            }
        }// end the while loop searching for pivotIndex
        
        // Place the pivot element and return the index
        val[low] = pivotValue;
        return low;
    }
    
    public void mergeSort(int[] val) {
        int[] valCopy = val.clone();
        split(valCopy, val, 0, val.length-1);
        
    }
    
    // Split helper method for merge sort
    public void split(int[] source, int[] dest, int low,int high){
        int middle = 0;
        if(low != high){
            middle = (low + high) / 2;
            split(dest, source, low, middle);
            split(dest, source, middle+1, high);
            merge(source, dest, low, middle, high);
        }
    }
    
    // Merging helper method for merge sort
    public void merge(int[] source, int[] dest, int low, int middle, int high){
        int p1 = 1, p2 = middle +1, destIndex = 1;
        do {
            if(source[p1] <= source[p2])
                dest[destIndex] = source[p1++];
            else
                dest[destIndex] = source[p2++];
            destIndex++;
            
        }while(p1 <= middle && p2 <= high);
        
        if(p1 > middle){
            do{
                dest[destIndex++] = source[p2++];
            }while(p2 <= high);
        }
        else{
            do{
                dest[destIndex++] = source[p1++];
            }while(p1 <= middle);
        }
    }
    
    
    
    public static void print(int[] val){
        for(int i=0; i<val.length; i++)
            System.out.print((val[i] + " "));
        System.out.println();
    }
    
    
}
