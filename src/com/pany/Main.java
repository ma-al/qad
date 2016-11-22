package com.pany;


import java.util.Arrays;
import java.util.ArrayList;

/*
You are given an array of numbers:
[4,6,7,8,9,1,1,2,0,3,4,0,4,5,8,7,9]

Then you're given a smaller series of numbers
[8,9,7]

*/
public class Main {


    public static void showPerms(ArrayList<Integer> big, ArrayList<Integer> sub)
    {
        System.out.println("quack quack quack");
        for (Integer i: big) {
            System.out.print(i + ",");
        }

        System.out.println();
        for (Integer i: sub) {
            System.out.print(i + ",");
        }

        // create hashes of all permutations of sub
        // store in a hashtable?

        /*
        walk thru big looking for the hashes.
        example
        - get "4,6,7"
        - hash it
        - check hashtable for that hash
        - repeat (next one should be "6,7,8")
         */



    }


    public static void main(String[] args) {

        Integer[] arrBig = {4,6,7,8,9,1,1,2,0,3,4,0,4,5,8,7,9};
        ArrayList<Integer> big = new ArrayList<Integer>(Arrays.asList(arrBig));

        Integer[] arrSub = {8,9,7};
        ArrayList<Integer> sub = new ArrayList<Integer>(Arrays.asList(arrSub));

        showPerms(big, sub);

    }
}
