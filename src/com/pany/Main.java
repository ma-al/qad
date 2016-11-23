package com.pany;



import java.util.Arrays;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Random;
import java.lang.*;

import static com.pany.util.Out.*;

/*
You are given an array of numbers:
[4,6,7,8,9,1,1,2,0,3,4,0,4,5,8,7,9]

Then you're given a smaller series of numbers
[8,9,7]

*/
public class Main {

    public static void showPermutations(ArrayList<Integer> big, ArrayList<Integer> sub)
    {
        // Print out arrays for visual check
        log(big.toString());
        log(sub.toString());

        /*
        Basic idea below is to:
        - create hashes of all the permutations of the sub-array
        - store in a hash-table as sorf of a quick lookup-table
        */

        Random r = new Random();
        space();

        // The lookup table we will populate
        Hashtable<String, ArrayList<Integer>> ht = new Hashtable<>();

        /*
        Quick and dirty. Just brute force to get all permutations.
        100 times for a 3 element array should be enough
        */

        // TODO: make this more efficient
        for (int i = 0; i < 100; i++)
        {
            String s = "";
            ArrayList<Integer> tmp = new ArrayList<Integer>(sub);
            ArrayList<Integer> arr = new ArrayList<Integer>();

            /*
            1. randomly choose an element in the array
            2. removing it from array
            3. append it to the temp array

            Once nothing left in the array, there's your randomly re-ordered
            copy of the array
            */
            while(!tmp.isEmpty())
            {
                space();

                int tmpSize = tmp.toArray().length;
                lsl("Size=" + tmpSize + ",");

                int idx = Math.abs(r.nextInt(tmpSize));
                lsl("idx=" + idx + ",");

                int val = tmp.remove(idx);
                lsl(val);

                arr.add(val);
                s += String.valueOf(val);
            }

            space();
            log(s);

            ht.put(s, arr);
        }

        // Print out lookup table to check
        section();
        for (ArrayList<Integer> ali :ht.values()) {
            for (Integer i : ali) {
                lsl(i);
            }
            space();
        }


        /*
        walk thru the big array, extract sub-array and compare with
        the lookup table from above.

        Example, from the input big array:
         - get "4,6,7"
         - hash it
         - check lookup table for that hash
         - repeat (next One should be "6,7,8")
         */

        section();
        int maxBig = big.toArray().length;
        int maxSub = sub.toArray().length;

        log("maxBig", maxBig);
        log("maxSub", maxSub);

        ArrayList<Integer> tmp = new ArrayList<Integer>(big);
        ArrayList<String> result = new ArrayList<>();

        while(!tmp.isEmpty())
        {
            // exit when we're nearing the end
            if(tmp.toArray().length < maxSub)
            {
                break;
            }

            ArrayList<Integer> ali = new ArrayList<>(tmp.subList(0, maxSub));

            space();

            // This is clumsy. We're iterating thru and copying out to the string.
            String s = "";
            for (Integer i: ali)
            {
                s += String.valueOf(i);
            }
            lsl(s);

            // if there is a hit on the lookup, add to results
            if(ht.containsKey(s))
            {
                result.add(s);
            }
            tmp.remove(0);
        }

        section("Found");
        for (String s : result)
        {
            bul(s);
        }

    }


    public static void main(String[] args)
    {

        Integer[] arrBig = {4,6,7,8,9,1,1,2,0,3,4,0,4,5,8,7,9};
        ArrayList<Integer> big = new ArrayList<Integer>(Arrays.asList(arrBig));

        Integer[] arrSub = {8,9,7};
        ArrayList<Integer> sub = new ArrayList<Integer>(Arrays.asList(arrSub));

        showPermutations(big, sub);
    }
}
