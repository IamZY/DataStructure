package com.ntuzy.search;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.XMLFormatter;

/**
 * @Author IamZY
 * @create 2020/2/10 9:38
 */
public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int index = binarySearch(arr, 0, arr.length - 1, 11);
        ArrayList index = binarySearch2(arr, 0, arr.length - 1, 1);
        System.out.println(index);
    }


    //
    public static int binarySearch(int[] arr, int left, int right, int target) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (target > midVal) {
            return binarySearch(arr, mid + 1, right, target);
        } else if (target < midVal) {
            return binarySearch(arr, left, mid - 1, target);
        } else {
            return mid;
        }

    }

    /**
     * {1, 2, 3, 4, 5, 6, 7, 7, 7, 8, 9}; 返回所有相同的数字索引
     */
    public static ArrayList binarySearch2(int[] arr, int left, int right, int target) {

        if (left > right) {
            return new ArrayList();
        }

        int mid = (left + right) / 2;
        int midVal = arr[mid];

        if (target > midVal) {
            return binarySearch2(arr, mid + 1, right, target);
        } else if (target < midVal) {
            return binarySearch2(arr, left, mid - 1, target);
        } else {
            ArrayList resIndexList = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || arr[temp] != target) {
                    break;
                }
                if (arr[temp] == target) {
                    resIndexList.add(temp);
                }
                temp -= 1;
            }

            resIndexList.add(mid);

            temp = mid + 1;
            while (true) {
                if (temp > arr.length - 1 || arr[temp] != target) {
                    break;
                }

                if (arr[temp] == target) {
                    resIndexList.add(temp);
                }
                temp += 1;
            }

            return resIndexList;
        }

    }


}
