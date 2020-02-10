package com.ntuzy.search;

import java.util.Arrays;

/**
 * @Author IamZY
 * @create 2020/2/10 10:36
 */
public class FibonacciSearch {

    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 10, 89, 1000, 1234};
        int index = fibSearch(arr, 10);
        System.out.println(index);
    }


    // 非递归
    public static int[] fibonacci() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f;
    }

    //
    public static int fibSearch(int[] a, int key) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;

        int mid = 0;
        int f[] = fibonacci();
        // 获取到斐波那契分割数值小标
        while (high > f[k] - 1) {
            k++;
        }

        // 因为f[k] 可能大于a的长度 因此我们需要使用Arrays类构造一个新的数组
        // 不足的部分将会使用0填充
        int[] temp = Arrays.copyOf(a, f[k]);

        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = a[high];
        }


        while (low <= high) {
            mid = low + f[k - 1] - 1;
            if (key < temp[mid]) {
                high = mid - 1;
                //
                // 因为前面又f[k-1]个元素 所以可以继续拆分f[k-1] = f[k - 2] + f[k - 3]
                k--;
            } else if (key > temp[mid]) {
                low = mid + 1;
                // f[k] = f[k-1] + f[k-2]
                // 即 f[k-2]的前面查找 k-=2
                k -= 2;
            } else {
                // find it
                if (mid < high) {
                    return mid;
                }
                if (mid > high) {
                    return high;
                }
            }
        }

        return -1;
    }


}
