package com.example.ckinnard.whiteboardapp;

import java.util.ArrayList;

/**
 * Created by ckinnard on 12/17/2015.
 */
public class LinearSearch {

    public static int search(ArrayList<Integer> list, int searchVal) {

        int index = 0;
        while(index < list.size() && list.get(index) < searchVal ) {
            index++;
        }
        if (index >= list.size() || searchVal != list.get(index)) {
            return -1;
        }
        return index;

    }
}
