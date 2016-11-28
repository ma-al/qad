package com.pany.util;

import java.util.StringJoiner;

/**
 * Created by mardi on 23/11/16.
 */
public class Out
{
    public static void space()
    {
        System.out.println();
    }

    public static void section(String s)
    {
        space();
        log(String.format("---------------------------------- [%s]", s));
    }

    public static void section()
    {
        section("");
    }

    /**
     * Log Same Line (LSL)
     * @param s string to log
     */
    public static void lsl(String s)
    {
        System.out.print(s);
    }

    /**
     * Log same line
     * @param o what to log
     */
    public static void lsl(Object o)
    {
        lsl(String.valueOf(o));
    }
    public static void lsl(int i)
    {
        lsl(String.valueOf(i));
    }

    public static void log(String s)
    {
        System.out.println(s);
    }
    public static void log(int i)
    {
        log(String.valueOf(i));
    }


    public static void log(String s, Object o)
    {
        log(s + ":" + String.valueOf(o));
    }

    /**
     * Bulleted logging
     * @param s String to show as a bullet in a list
     */
    public static void bul(String s)
    {
        log(" - " + s);
    }

    /**
     * show the array
     * @param arr
     */
    public static void array(Object[] arr)
    {
        StringJoiner sj = new StringJoiner(",", "[", "]");

        for (Object o : arr)
        {
            sj.add(String.valueOf(o));
        }

        log(sj.toString());
    }

}
