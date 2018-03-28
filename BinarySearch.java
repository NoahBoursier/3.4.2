package com.example.ckinnard.whiteboardapp;

import java.util.ArrayList;

/**
 * Created by ckinnard on 12/17/2015.
 */
public class BinarySearch {

    public static int search(ArrayList<Integer> list, int searchNum) {

        int low = 0;
        int mid;
        int high = list.size() - 1;

        while (low <= high) {
            mid = (low + high) / 2;
            if (searchNum == list.get(mid)) {
                return mid;
            }
            else if (searchNum < list.get(mid)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
