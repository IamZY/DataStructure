# 数据结构
## 简单的排序算法

![1572228782619](https://github.com/IamZY/DataStructure/blob/master/images/1572228782619.png)

### 冒泡算法

冒泡排序是一种简单的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果它们的顺序错误就把它们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢“浮”到数列的顶端。

```java
package com.ntuzy.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {11, 48, 15, 7};
        sort(arr);
    }

    public static void sort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }

        // 外层的for循环指的是进行冒泡操作的轮数  数组的长度-1
        // 最后一个元素是不需要操作的
        for (int i = 0; i < arr.length - 1; i++) {
            // 内层的for循环是每一轮冒泡操作中两两数据比较与数据交换
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
```

### 选择排序

表现最稳定的排序算法之一，因为无论什么数据进去都是O(n2)的时间复杂度，所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间。

选择排序是一种简单直观的排序算法。它的工作原理：首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置，然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。

```java
package com.ntuzy.sort;

import javax.rmi.CORBA.Util;
import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {11, 48, 15, 7};
        sort(arr);
    }
    public static void sort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        // 定义选择排序需要的轮数 数组的长度
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            // 每一轮选择数据排序进行数据比较
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
                Utils.swap(arr, i, j);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
```

### 插入排序

插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，通常采用in-place排序（即只需用到O(1)的额外空间的排序），因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间。

```java
package com.ntuzy.sort;

import java.util.Arrays;

public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {11, 48, 15, 7};
        sort(arr);
    }


    public static void sort(int[] arr) {

        if (arr.length == 0) {
            return;
        }

        // 设置当前的元素
        int current;
        for (int i = 0; i < arr.length - 1; i++) {
            current = arr[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < arr[preIndex]) {
                // 需要将上一元素进行下移操作
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = current;
        }

        System.out.println(Arrays.toString(arr));

    }

}
```

###   希尔排序

希尔排序是希尔（Donald Shell）于1959年提出的一种排序算法。希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序，同时该算法是冲破O(n2）的第一批算法之一。它与插入排序的不同之处在于，它会优先比较距离较远的元素。希尔排序又叫缩小增量排序

![1572248223813](https://github.com/IamZY/DataStructure/blob/master/images/1572248223813.png)

## 栈和队列

### 栈

### 队列

队列可分为两种，一种是阻塞队列，一种是非阻塞队列。

阻塞队列和非阻塞队列的区别：阻塞队列可以阻塞，非阻塞队列不能阻塞，只能使用队列wait(),notify()进行队列消息传送。而阻塞队列当队列里面没有值时，会阻塞直到有值输入。输入也一样，当队列满的时候，会阻塞，直到队列不为空。

![1572266032548](https://github.com/IamZY/DataStructure/blob/master/images/1572266032548.png)

















