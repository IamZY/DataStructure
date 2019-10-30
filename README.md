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

```java
package com.ntuzy.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {11, 48, 15, 7};
        sort(arr);
    }

    public static void sort(int[] arr) {
        int len = arr.length;
        int temp;
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                int preIndex = i - gap; // 此时为0

                temp = arr[i];
                while (preIndex >= 0 && arr[preIndex] > temp) {
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }

                arr[preIndex + gap] = temp;
            }
            gap /= 2;
        }
        
        System.out.println(Arrays.toString(arr));
        
    }

}

```

## 栈和队列

### 栈

### 队列

队列可分为两种，一种是阻塞队列，一种是非阻塞队列。

阻塞队列和非阻塞队列的区别：阻塞队列可以阻塞，非阻塞队列不能阻塞，只能使用队列wait(),notify()进行队列消息传送。而阻塞队列当队列里面没有值时，会阻塞直到有值输入。输入也一样，当队列满的时候，会阻塞，直到队列不为空。

![1572266032548](https://github.com/IamZY/DataStructure/blob/master/images/1572266032548.png)

#### 优先级队列

带排序的队列，与阻塞非阻塞队列没有关系

## 链表

链表的机制灵活，用途广泛，它适用于许多通用的数据库。它可以取代数组，并且可以作为其他数据结构的基础，如栈和队列。链表虽然不能解决数据存储中的所有问题，但他的应用范围很广。

### 单链表

单链表是一种链式存取的数据结构，用一组**地址任意**的存储单元存放线性表中的数据元素。链表中的数据是以结点来表示的，每个结点的构成：**元素**(数据元素的映象)

**指针**(指示后继元素存储位置)，元素就是存储数据的存储单元，指针就是连接每个结点的地址数据。

### 双端链表

双端链表与传统链表非常相似，但是双端链表有一个新的特性：对最后一个链结点的引用。就像对第一个链结点的引用一样。

对最后一个链结点的引用允许像在表头一样，在表尾直接插入一个链结点。当然，仍然可以在普通的单链表的表尾插入一个链结点，方法是遍历整个链表到达表尾，但是这种方法效率很低。

### 双向链表

### 有序链表

### 迭代器链表

### `LinkedList`和`ArrayList`的区别

`ArrayList`是实现了基于动态数组的数据结构，`LinkedList`基于链表的数据结构 （`LinkedList`是双向链表，有next也有previous）

+ 对于随机访问get和set，`ArrayList`觉得优于`LinkedList`，因为`LinkedList`要移动指针。 
+ 对于新增和删除操作add和remove，`LinedList`比较占优势，因为`ArrayList`要移动数据。 
+ 当操作是在一列数据的后面添加数据而不是在前面或中间,并且需要随机地访问其中的元素时,使用`ArrayList`会提供比较好的性能；当你的操作是在一列数据的前面或中间添加或删除数据,并且按照顺序访问其中的元素时,就应该使用`LinkedList`了。

ArrayList和LinkedList在性能上各有优缺点，都有各自所适用的地方，总的说来可以描述如下：

+ 对ArrayList和LinkedList而言，在列表末尾增加一个元素所花的开销都是固定的。对ArrayList而言，主要是在内部数组中增加一项，指向所添加的元素，偶尔可能会导致对数组重新进行分配；而对LinkedList而言，这个开销是统一的，分配一个内部Entry对象。
+ 在ArrayList的中间插入或删除一个元素意味着这个列表中剩余的元素都会被移动；而在LinkedList的中间插入或删除一个元素的开销是固定的。
+ LinkedList不支持高效的随机元素访问。
+ ArrayList的空间浪费主要体现在在list列表的结尾预留一定的容量空间，而LinkedList的空间花费则体现在它的每一个元素都需要消耗相当的空间

## 递归

+ 尾递归

  ```java
  package com.ntuzy;
  
  /**
   * 伪递归
   */
  public class NumberTest {
      public static void main(String[] args) {
          System.out.println(getSum(5));
          System.out.println(getX(5));
          System.out.println(getX(5, 1));
      }
  
      // 三角数字
      public static int getSum(int n) {
          int total = 0;
          if (n == 1) {
              return 1;
          } else {
              total = n + getSum(n - 1);
              return total;
          }
      }
  
      // 阶乘
      public static int getX(int n) {
          if (n == 1) {
              return 1;
          } else {
              int totle = n * getX(n - 1);
              return totle;
          }
      }
  
      // 尾递归
      public static int getX(int n, int a) {
          if (n == 1) {
              return a;
          } else {
              int total = getX(n - 1, n * a);
              return total;
          }
      }
  
  }
  ```

### 二分查找

![1572417492012](https://github.com/IamZY/DataStructure/blob/master/images/1572417492012.png)

```java
package com.ntuzy;

/**
 * 二分查找
 */
public class BinSearchTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Integer index = binSearch(arr, 0, arr.length - 1, 2);
        System.out.println(index);
    }


    public static Integer binSearch(int[] arr, int low, int high, int keyValue) {

        if (low <= high) {
            int mid = (low + high) / 2;
            if (keyValue == arr[mid]) {
                return mid;
            } else if (keyValue < arr[mid]) {
                return binSearch(arr, low, mid - 1, keyValue);
            } else {
                return binSearch(arr, mid + 1, high, keyValue);
            }
        } else {
            return -1;
        }

    }

}
```

### 归并排序

**和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。**

**归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（**Divide and Conquer）的一个非常典型的应用。归并排序是一种稳定的排序方法。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并

```java
package com.ntuzy;

import java.util.Arrays;

public class MergeSorted {
    public static void main(String[] args) {
        int[] arr = {3, 8, 1, 0, 2, 33};
        System.out.println(Arrays.toString(megerSort(arr)));
    }

    // 将整个数组进行一个递归式的分割治理
    public static int[] megerSort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int mid = arr.length / 2;
        // 包含头不包含尾
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        return merge(megerSort(left), megerSort(right));
    }


    // 将两个排序好的数组合并为一个数组
    public static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length) {
                result[index] = right[j++];
            } else if (j >= right.length) {
                result[index] = left[i++];
            } else if (left[i] > right[j]) {
                result[index] = right[j++];
            } else {
                result[index] = left[i++];
            }
        }

        return result;
    }


}
```

## 高级的排序算法

### 快速排序

**快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。**

快速排序使用分治法来把一个串（list）分为两个子串（sub-lists）

```java
package com.ntuzy.sort;

import java.util.Arrays;
import java.util.Map;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {11, 48, 15, 7};
        int[] ints = quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    // 快排
    public static int[] quickSort(int[] arr, int start, int end) {
        //
        int smallIndex = partition(arr, start, end);  // 最终这个位置是smallIndex的值
        if (smallIndex > start) {
            quickSort(arr, start, smallIndex - 1);
        }

        if (smallIndex < end) {
            quickSort(arr, smallIndex + 1, end);
        }
        return arr;
    }

    // 分区操作
    public static int partition(int[] arr, int start, int end) {
        // 设定基准值
        int pivot = (int) (start + Math.random() * (end - start + 1));
        // 将基准移动到数组后面
        Utils.swap(arr, pivot, end);
        int smallIndex = start - 1;   // 比基准数大的索引角标 用于交换位置

        for (int i = start; i <= end; i++) {
            if (arr[i] <= arr[end]) {  // 将第i个元素与基准值进行对比
                smallIndex++;
                if (i > smallIndex) {
                    Utils.swap(arr, i, smallIndex);
                }
            }
        }

        return smallIndex;
    }

}
```































