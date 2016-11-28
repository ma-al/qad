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

    public void checker(ArrayList<Character> ac)
    {
        lsl(ac.toString());

        if(ac.toString().compareTo("[o, o, o, o]") == 0 ||
           ac.toString().compareTo("[x, x, x, x]") == 0 )
        {
            lsl("(!)");
        }
        else
        {
            lsl("( )");
        }

        lsl(" | ");
    }

    @Override
    public void run()
    {
//        section("Dimensions");
//        log(board.length);
//        for (char[] arr : board)
//        {
//            section("" + board[0].length);
//            for (char c: arr)
//            {
//                log(String.valueOf(c));
//            }
//        }

        /*
        Smart aleck answer = use machine vision to segregate the blobs and
        measure their lengths :D
         */


        for(int x = 0; x < board.length; x++)
        {
            section("" + x);

            for(int y = 0; y < board[x].length; y++)
            {
                char val = board[x][y];
//                log(x + "," + y + " is " + val);

                if(val == 'e')
                {
                    log(x + "," + y + " is " + "empty");
                    continue;
                }

                if(val == 'x' || val == 'o')
                {
                    lsl(x + "," + y + " is " + val);
                }

                lsl(" ---> ");

                int maxX = x + 3;
                int maxY = y + 3;
                int minX = x - 3;
                int minY = y - 3;

                boolean east = false, north = false, south = false, west = false;

                if(maxX <= 6) east = true;
                if(maxY <= 5) north = true;
                if(minX >= 0) west = true;
                if(minY >= 0) south = true;

                if(north)
                {
                    lsl("nort");
                    ArrayList<Character> ac = new ArrayList<>();
                    for(int ny = y; ny <= maxY; ny ++)
                    {
                        lsl(String.format("(%d,%d)", x, ny));
                        ac.add(board[x][ny]);
                    }
                    checker(ac);
                }

                if(east)
                {
                    lsl("east");
                    ArrayList<Character> ac = new ArrayList<>();
                    for(int nx = x; nx <= maxX; nx ++)
                    {
                        lsl(String.format("(%d,%d)", nx, y));
                        ac.add(board[nx][y]);
                    }
                    checker(ac);
                }

                if(south)
                {
                    lsl("sout");
                    ArrayList<Character> ac = new ArrayList<>();
                    for(int ny = y; ny >= minY; ny --)
                    {
                        lsl(String.format("(%d,%d)", x, ny));
                        ac.add(board[x][ny]);
                    }
                    checker(ac);
                }

                if(west)
                {
                    lsl("west");
                    ArrayList<Character> ac = new ArrayList<>();
                    for(int nx = x; nx >= minX; nx --)
                    {
                        lsl(String.format("(%d,%d)", nx, y));
                        ac.add(board[nx][y]);
                    }
                    checker(ac);
                }

                if(north && west)
                {
                    lsl("NoWe");
                    ArrayList<Character> ac = new ArrayList<>();

                    int nx = x;
                    int ny = y;

                    while(nx >= minX && ny <= maxY)
                    {
                        lsl(String.format("(%d,%d)", nx, ny));
                        ac.add(board[nx][ny]);

                        nx--;
                        ny++;
                    }
                    checker(ac);
                }

                if(north && east)
                {
                    lsl("NoEa");
                    ArrayList<Character> ac = new ArrayList<>();

                    int nx = x;
                    int ny = y;

                    while(nx <= maxX && ny <= maxY)
                    {
                        lsl(String.format("(%d,%d)", nx, ny));
                        ac.add(board[nx][ny]);

                        nx++;
                        ny++;
                    }
                    checker(ac);
                }

                if(south && west)
                {
                    lsl("SoWe");
                    ArrayList<Character> ac = new ArrayList<>();

                    int nx = x;
                    int ny = y;

                    while(nx >= minX && ny >= minY)
                    {
                        lsl(String.format("(%d,%d)", nx, ny));
                        ac.add(board[nx][ny]);

                        nx--;
                        ny--;
                    }
                    checker(ac);
                }

                if(south && east)
                {
                    lsl("SoEa");
                    ArrayList<Character> ac = new ArrayList<>();

                    int nx = x;
                    int ny = y;

                    while(nx <= maxX && ny >= minY)
                    {
                        lsl(String.format("(%d,%d)", nx, ny));
                        ac.add(board[nx][ny]);

                        nx++;
                        ny--;
                    }
                    checker(ac);
                }

                space();

            }
        }


    }
}
