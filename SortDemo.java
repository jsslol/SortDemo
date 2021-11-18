/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortdemo;

import java.util.Random;

/**
 *
 * @author jared
 */
public class SortDemo {

    private static final int SIZE = 5000;
    
    public static void main(String[] args) {
        //creat a random list of size SIZE
        Random rand = new Random();
        Sorting sortTest = new Sorting();
        
        int[] number = new int[SIZE];
        for(int i=0;i<number.length;i++)
            number[i] = rand.nextInt(90)+10;
        print(number);
        
        // Call sort method
        long start = System.nanoTime();
        sortTest.selectionSort(number);
        long end = System.nanoTime();
        print(number);
        System.out.println("Elapsed time: " + (end - start)/Math.pow(10, 9)
                                                   + " seconds.");
        
    }
    
    public static void print(int[] val){
        for(int i=0; i<val.length; i++)
            System.out.print((val[i] + " "));
        System.out.println();
    }
    
}
