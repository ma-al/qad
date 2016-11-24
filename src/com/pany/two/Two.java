package com.pany.two;

import com.pany.Runner;

import java.util.ArrayList;
import java.util.Arrays;

import static com.pany.util.Out.*;
import static com.pany.util.Out.bul;
import static com.pany.util.Out.section;

/**
 * Task TWO. 24/11/2016. See README for problem description.
 */
public class Two extends Runner
{
    ArrayList<String> result;
    ArrayList<Integer> original;

    /**
     * Initialize by creating the arrays
     */
    public Two()
    {
        this.result = new ArrayList<String>();

        Integer[] arrSub = {8,9,7};
        this.original = new ArrayList<Integer>(Arrays.asList(arrSub));
    }


    private void recurse(ArrayList<String> result,
                         ArrayList<Integer> left,
                         ArrayList<Integer> right)
    {
        section("" + right.toArray().length);
        log("Bef = " + left.toString() + " | " + right.toString());

        if(right.isEmpty())
        {
            log("RESULT += " + left.toString());
            result.add(left.toString());
            return;
        }

        for (int idx = 0; idx < right.toArray().length ; idx++)
        {
            left.add(right.remove(idx));
            lsl("Aft = ");
            lsl(left.toString());
            lsl(" | ");
            lsl(right.toString());
            lsl(", foridx=");
            lsl(idx);

            recurse(result,
                    new ArrayList<Integer>(left),
                    new ArrayList<Integer>(right));
        }
    }

    @Override
    public void run()
    {
        section("Start");
        log(this.original.toString());

        // have two arrays
        // - left
        // - right

        // take first char.
        // store as first char

        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>(this.original);

        recurse(this.result,
                new ArrayList<Integer>(left),
                new ArrayList<Integer>(right));

        section("Output");
        for (String s : this.result)
        {
            log(s);
        }

    }
}
