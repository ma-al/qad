package com.pany.three;

import com.pany.Runner;

import java.util.*;

import static com.pany.util.Out.*;
import static java.util.Arrays.*;

/**
 * Created by mardi on 25/11/16.
 */
public class Three extends Runner
{
    // just to kick things off
    char[][] board = {
            {'x','o','x','x','e','e'},
            {'x','o','x','e','e','e'},
            {'o','x','x','o','e','e'},
            {'x','o','o','e','e','e'},
            {'o','o','x','x','o','e'},
            {'o','o','x','o','x','e'},
            {'x','x','e','e','e','e'}};

    @Override
    public void run()
    {
        section("Dimensions");
        log(board.length);
        for (char[] arr : board)
        {
            section("" + board[0].length);
            for (char c: arr)
            {
                log(String.valueOf(c));
            }
        }
    }
}
