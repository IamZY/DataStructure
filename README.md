# 数据结构
## 简单的排序算法



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



#### 优先级队列

带排序的队列，与阻塞非阻塞队列没有关系

## 链表

链表的机制灵活，用途广泛，它适用于许多通用的数据库。它可以取代数组，并且可以作为其他数据结构的基础，如栈和队列。链表虽然不能解决数据存储中的所有问题，但他的应用范围很广。

### 单链表

单链表是一种链式存取的数据结构，用一组地址任意的存储单元存放线性表中的数据元素。链表中的数据是以结点来表示的，每个结点的构成：元素(数据元素的映象)

指针(指示后继元素存储位置)，元素就是存储数据的存储单元，指针就是连接每个结点的地址数据。

### 双端链表

双端链表与传统链表非常相似，但是双端链表有一个新的特性：对最后一个链结点的引用。就像对第一个链结点的引用一样。

对最后一个链结点的引用允许像在表头一样，在表尾直接插入一个链结点。当然，仍然可以在普通的单链表的表尾插入一个链结点，方法是遍历整个链表到达表尾，但是这种方法效率很低。

### 双向链表

### 有序链表

### 迭代器链表

### LinkedList和ArrayList的区别

ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构 （LinkedList是双向链表，有next也有previous）

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

和选择排序一样，归并排序的性能不受输入数据的影响，但表现比选择排序好的多，因为始终都是O(n log n）的时间复杂度。代价是需要额外的内存空间。

归并排序是建立在归并操作上的一种有效的排序算法。该算法是采用分治法（Divide and Conquer）的一个非常典型的应用。归并排序是一种稳定的排序方法。将已有序的子序列合并，得到完全有序的序列；即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为2-路归并

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

快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，则可分别对这两部分记录继续进行排序，以达到整个序列有序。

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

### 堆排序

堆排序（Heapsort）是指利用堆这种数据结构所设计的一种排序算法。堆积是一个近似完全二叉树的结构，并同时满足堆积的性质：即子结点的键值或索引总是小于（或者大于）它的父节点。

```java
package com.ntuzy.sort;


public class HeapSort {
    private static int len;

    public static void main(String[] args) {

    }

    //
    public static int[] heapSort(int[] arr) {
        len = arr.length;
        // 1 构建大顶堆  构建大顶堆中调整的递归方法
        buildMaxHeap(arr);
        // 2 将顶部的元素 与无序区的最后一个元素交换位置
        while (len > 0) {
            Utils.swap(arr, 0, len - 1);   // 0表示大顶元素 len-1表示最后一个元素
            len--; // 无序区的长度减少一位
            changeHeap(arr, 0);
        }
        return arr;
    }

    // 构建大顶堆
    public static void buildMaxHeap(int[] arr) {
        for (int i = len / 2; i < arr.length; i--) {
            // 调整大顶堆
            changeHeap(arr, i);
        }
    }

    /**
     * 调整大顶堆
     *
     * @param arr
     * @param i
     */
    private static void changeHeap(int[] arr, int i) {

        int maxIndex = i;
        // 如果有左子树且左子树大于父节点  那么将最大指针指向左子树
        if (i * 2 < len && arr[i] * 2 > arr[maxIndex]) {
            maxIndex = i * 2;
        }

        // 如果有右子树且右子树大于父节点  那么将最大指针指向右子树
        if (i * 2 + 1 < len && arr[i * 2 + 1] > arr[maxIndex]) {
            maxIndex = i * 2 + 1;
        }

        // 如果父节点不是最大值 则将父节点与最大值进行交换 这样才能保证我们的父节点是最大的 构建成一个大顶堆
        if (maxIndex != i) {
            Utils.swap(arr, maxIndex, i);
            changeHeap(arr, maxIndex);
        }


    }

}
```

### 计数排序

计数排序的核心在于将输入的数据值转化为键存储在额外开辟的数组空间中。 作为一种线性时间复杂度的排序，计数排序要求输入的数据必须是有确定范围的整数（局限性）。

计数排序(Counting sort)是一种稳定的排序算法。计数排序使用一个额外的数组C，其中第i个元素是待排序数组A中值等于i的元素的个数。然后根据数组C来将A中的元素排到正确的位置。它只能对整数进行排序。

```java
package com.ntuzy.sort;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {

    }

    public static int[] sort(int[] arr) {
        int min = arr[0], max = arr[0];
        for (int i = 0; i < arr.length; i++) {  // 找到最大最小的值
            if (arr[i] > max) {
                max = arr[i];
            }

            if (arr[i] < min) {
                min = arr[i];
            }
        }

        // 定义一个额外的数组
        int[] bucket = new int[max - min + 1];

        Arrays.fill(bucket, 0);
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i] - min]++;
        }
        //
        int index = 0, i = 0;
        while (index < arr.length) {
            if (bucket[i] != 0) {
                arr[index] = i + min;
                bucket[i]--;
                index++;
            } else {
                i++;
            }
        }

        return arr;
    }
}
```

### 桶排序

桶排序是计数排序的升级版。它利用了函数的映射关系，高效与否的关键就在于这个映射函数的确定。

桶排序 (Bucket sort)的工作的原理：假设输入数据服从均匀分布，将数据分到有限数量的桶里，每个桶再分别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排



```java
package com.ntuzy.sort;

import java.util.ArrayList;

public class BucketSort {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(5);
        arr.add(77);
        arr.add(11);
        arr.add(3);
        arr.add(76);
        arr.add(76);
        System.out.println(sort(arr, 3));
    }

    public static ArrayList<Integer> sort(ArrayList<Integer> arr, int bucketSize) {

        if (arr == null || arr.size() < 2) {
            return arr;
        }

        int min = arr.get(0), max = arr.get(0);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) > max) {
                max = arr.get(i);
            }

            if (arr.get(i) < min) {
                min = arr.get(i);
            }
        }

        int bucketCount = (max - min) / bucketSize + 1; // 避免bucketCaunt为 0
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);

        ArrayList<Integer> resultArr = new ArrayList<>();   // 内层存放值的list
        // 初始化桶
        for (int i = 0; i < bucketCount; i++) {
            // 计数排序里面是数字的类型 桶排序里面是list
            bucketArr.add(new ArrayList<Integer>());
        }

        // 循环原始的数据 将原始数据填充到应该填充的位置
        for (int i = 0; i < arr.size(); i++) {
            bucketArr.get((arr.get(i) - min) / bucketSize).add(arr.get(i));
        }

        // 递归的将桶里的数据进行i排序并且回填我们的原数组中
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) { // 有重复数据出现的时候的进行判断
                for (int j = 0; j < bucketArr.get(i).size(); j++) {
                    resultArr.add(bucketArr.get(i).get(j));
                }
            } else {
                if (bucketCount == 1) {
                    bucketSize--;  // 也是为了避免递归操作中数据少 size大 导致桶的数量为1 这样就不能再继续排序了 bucketCount
                }
                // 递归式的进桶排序
                ArrayList<Integer> temp = sort(bucketArr.get(i), bucketSize);  // 递归操作 bucketSize不能为0 因为0不能做被除数
                // 将排序好的序列回填到 我们的结果list里面
                for (int j = 0; j < temp.size(); j++) {
                    resultArr.add(temp.get(j));
                }
            }
        }

        return resultArr;
    }

}
```

### 基数排序

基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。有时候有些属性是有优先级顺序的，先按低优先级排序，再按高优先级排序。最后的次序就是高优先级高的在前，高优先级相同的低优先级高的在前。基数排序基于分别排序，分别收集，所以是稳定的。

```java
package com.ntuzy.sort;

import java.util.ArrayList;
import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {44, 22, 11, 35, 6, 734, 224, 1980, 1};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }

        int max = arr[0];

        for (int i = 0; i < arr.length; i++) {
            max = Math.max(arr[i], max);
        }

        int maxDigit = 0; // 确定最大的数字一共有几位

        while (max != 0) {
            max /= 10;
            maxDigit++;
        }

        int mod = 10; // 每一位的倍数差距
        int div = 1;  // 除法一个除法的基准值

        //
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();  // 定义一个桶
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int num = (arr[j] % mod) / div;  // 第一次循环取出个位数字进行填充
                bucketList.get(num).add(arr[j]);
            }
            int index = 0;
            // 一个回填的操作
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    arr[index++] = bucketList.get(j).get(k);
                }
                bucketList.get(j).clear();
            }
        }

        return arr;
    }

}
```

## 二叉树

二叉树是一种简单的树结构，每一个父节点下最多只能有两个子节点。

二叉树是一种常用的数据结构，是JAVA语言中非常重要的数据结构，他比数组和链表更加的快速实用，也是很多高级结构的顶层结构，如：堆内存结构。

 ```java
package com.ntuzy.tree;

import javax.print.attribute.standard.NumberOfInterveningJobs;
import java.util.Calendar;
import java.util.Stack;

/**
 * 二叉树
 */
public class Tree {

    private Node root;

    public Tree() {
        root = null;  // 创建一个空树
    }

    // 查询
    public Node find(int key) {
        Node current = root; // 我们的查询是需要从root节点开始查询的

        while (key != current.iData) {

            if (key < current.iData) { // 如果小于当前的key 向左子树进行一个查找
                current = current.leftChild;
            } else {
                current = current.rightChild;  // 如果大于当前的key 则向右子树进行查找
            }

            if (current == null) {
                return null;   // 说明当前二叉树没有存储此值
            }

        }

        return current;
    }

    // 插入

    /**
     * @param id 代表索引
     * @param dd 代表值
     */
    public void insert(int id, double dd) {
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;

        if (root == null) { // 如果为空树 直接将新的节点赋予root节点
            root = newNode;
        } else {

            // 如果不为空
            Node current = root;  // 从root节点开始查找  满足左小右大
            Node parent; // 定义一个父节点 该父节点与current相关

            while (true) {

                parent = current;  // 初始化赋值
                if (id < current.iData) {
                    current = current.leftChild;
                    if (current == null) {  // 当前节点为空 则代表有位置插入节点
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }

            }


        }


    }


    // 删除
    public boolean delete(int key) {

        Node current = root;
        Node parent = root;
        boolean isLeftChild = false;

        // 查找到想要删除的节点
        while (current.iData != key) {
            parent = current;

            if (key < current.iData) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }

            // 叶子节点 没有节点
            if (current == null) {
                return false;
            }

        }

        // 查找到想要删除的节点结束

        // 删除操作
        // 1. 没有左右子树
        if (current.leftChild == null && current.rightChild == null) {
            if (current == root) {
                root = null;
            } else if (isLeftChild) {  // 如果删除的左子节点 那么父节点的左子节点不为空
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        }
        // 2. 只有左子树 没有右节点
        else if (current.rightChild == null && current.leftChild != null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;  // 如果删除当前节点 需要将当前节点的父节点的指向进行一个修改
            } else {
                parent.rightChild = current.leftChild;  //
            }
        }
        // 3. 只有右节点 没有左节点
        else if (current.rightChild != null && current.leftChild == null) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = current.rightChild;  //
            } else {
                parent.rightChild = current.rightChild;  //
            }
        }
        // 既有左节点也有右节点
        /**
         * 节点的继承者 肯定在右子树。（因为要保证，继承者的值要大于左节点
         * 继承者肯定是右子树中最小的节点。（因为要保证，继承者的值小于右子树
         * 总结：找到被删除节点的右节点后，一路向左寻找子节点，直到最后一个叶子节点，即为继承者
         */
        else {
            Node successor = getSuccessor(current);  // 寻找继承者
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;  // 当前被删除节点的父类的一个赋值操作
            } else {
                parent.rightChild = successor; //
            }

            successor.leftChild = current.leftChild;  // 给successor继承者的左节点进行了一个赋值  右节点赋值 ??

        }


        return true;
    }

    // 寻找继承者
    private Node getSuccessor(Node delNode) {

        Node successorParent = delNode;
        Node successor = delNode; // 初始化

        Node current = delNode.rightChild;  // 先向右节点寻找一次
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;   // 一路向左进行查找
        }

        if (successor != delNode.rightChild) {  // 如果继承者不是当前被删除节点的右子节点 说明右节点不是只有一层 -> 右子树
            successorParent.leftChild = successor.rightChild; // 继承者的右子树成为了父类的左子树
            successor.rightChild = delNode.rightChild;  // 右节点赋值
        }

        return successor;
    }


    // 遍历
    // 前序
    private void preOrder(Node localNode) {
        if (localNode != null) {
            System.out.println(localNode.iData + "     ");
            preOrder(localNode.leftChild);
            preOrder(localNode.rightChild);
        }
    }

    // 中序遍历
    private void inOrder(Node localNode) {
        if (localNode != null) {
            inOrder(localNode.leftChild);
            System.out.println(localNode.iData + "     ");
            inOrder(localNode.rightChild);
        }
    }

    // 后序遍历
    private void postOrder(Node localNode) {
        if (localNode != null) {
            postOrder(localNode.leftChild);
            postOrder(localNode.rightChild);
            System.out.println(localNode.iData + "     ");
        }
    }

    public void tranverse(int type) {
        switch (type) {
            case 1:
                System.out.println("pre:");
                preOrder(root);
                break;
            case 2:
                System.out.println("in:");
                inOrder(root);
                break;
            case 3:
                System.out.println("post:");
                postOrder(root);
                break;
        }
    }


    // 打印树
    public void displayTree() {
        Stack globalStack = new Stack();
        globalStack.push(root);
        int nBlanks = 32;
        getClass();
        boolean isRowEmpty = false;
        System.out.println("=========================================================================");
        while (isRowEmpty == false) {
            Stack localStack = new Stack();
            isRowEmpty = true;
            for (int j = 0; j < nBlanks; j++) {
                System.out.print(" ");
            }

            while (globalStack.isEmpty() == false) {
                Node temp = (Node) globalStack.pop();
                if (temp != null) {
                    System.out.print(temp.iData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);
                    if (temp.leftChild != null || temp.rightChild != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
            nBlanks /= 2;
            while (localStack.isEmpty() == false) {
                globalStack.push(localStack.pop());
            }
        }
        System.out.println("=========================================================================");
    }


}


class Node {
    public Node leftChild;
    public Node rightChild;  // 需要关联的时候进行一个数据指定 并且此属性代表二叉树利用了链表的结构
    public int iData;  // 定义一个索引  一个二叉树的节点 利用数组的索引结构 有利于快读的查询
    public double dData;


    public void displayNode() {
        System.out.println("{");
        System.out.println(iData);
        System.out.println(", ");
        System.out.println(dData);
        System.out.println("}");
    }
}

 ```

## 红黑树

二叉树搜索有一个很麻烦的问题：

如果树中插入的是随机数据，那么二叉树的执行效果会非常好。但是，如果插入的是有序数据，如1,2,3,4…那么二叉树的执行速度就会非常的慢。因为当插入的数据是有序的话，二叉树就是非平衡的了（只有左子树或者只有右子树）。而对于非平衡树，他的快速查找指定数据项的能力就丧失了。

红黑树，一种增加了某种特点的二叉搜索树。它能够保证树是平衡的。 

### 规则

每一个节点都是有颜色的，非黑即红

根总是黑色的

如果节点是红色的，则它的子节点必须是黑色的（反之，不一定）

从根到叶节点或空子节点的每条路径，必须包含相同数目的黑色节点。

## 2-3-4树

在二叉树中，每个节点有一个数据项，最多有两个子节点。如果允许每个节点可以有更多的数据项和更多的子节点，就是多叉树。

本章的2-3-4树就是一种多叉树，他的每个节点最多有四个子节点，每个子节点最多有三个数据项。

2-3-4树非常有趣，他像红黑树一样是平衡树，他的效率比红黑树稍差，但变成容易。最重要的是，通过学习2-3-4树可以更加容易理解B-树。

B-树是另外一种多叉树，专门用于外部存储中来组织数据（磁盘驱动器）。B-树中可以有上百个子节点。

   2-3-4树是平衡树多叉树,每个节点最多有4个子节点和3个数据项,2,3,4的含义是指一个节点可能含有的子节点的个数,效率比红黑树稍差.一般不允许出现重复关键字值

2-3-4树有以下特征:   

1、有一个数据项的节点总是有2个子节点(称为2-节点)   

2、有两个数据项的节点总是有3个子节点(称为3-节点)    

3、有三个数据项的节点总是有4个子节点(称为4-节点) 

4、 2-3-4树中所有的叶子节点总是在同一层     

简单的说,非叶节点的子节点树总是比它含有的数据项多1,叶节点可能含有一个,两个或三个数据项.空叶节点不存在.2-3-4树的规则如下:      1、第一个子节点的关键字值小于父节点第一个数据项      2、第二个子节点的关键字值小于父节点第二个数据项并大于第一个数据项      3、第三个子节点的关键字值小于父节点第三个数据项并大于第二个数据项      4、最后一个节点的关键字值大于父节点第三个数据项 

### 插入

（**1）如果2-3-4树中已存在当前插入的key，则插入失败，否则最终一定是在叶子节点中进行插入操作**

（**2）如果待插入的节点不是4节点，那么直接在该节点插入**

（**3）如果待插入的节点是个4节点，那么应该先分裂该节点然后再插入。一个4节点可以分裂成一个根节点和两个子节点（这三个节点各含一个key）然后在子节点中插入，我们把分裂形成的根节点中的key看成向上层插入的key，然后重复第2步和第3步。**

   如果是在**4节点中进行插入，每次插入会多出一个分支，如果插入操作导致根节点分裂，则2-3-4树会生长一层。**

### 删除

（**1）如果2-3-4树中不存在当前需要删除的key，则删除失败。**

（**2）如果当前需要删除的key不位于叶子节点上，则用后继key覆盖，然后在它后继**

key**所在的子支中删除该后继key。**

（3）如果当前需要删除的key位于叶子节点上:**

​       （**3.1）该节点不是2节点，删除key，结束**

​       （**3.2）该节点是2节点，删除该节点：**

​              （**3.2.1）如果兄弟节点不是2节点，则父节点中的key下移到该节点，兄弟节点中的一个key上移**

​             （**3.2.2）如果兄弟节点是2节点，父节点是个3节点或4节点，父节点中的key与兄弟节点合并**

​             （**3.2.3）如果兄弟节点是2节点，父节点是个2节点，父节点中的key与兄弟节点中的key合并，形成一个3节点，把此节点看成当前节点（此节点实际上是下一层的节点），重复步骤3.2.1到3.2.3**

如果是在**2节点（叶子节点）中进行删除，每次删除会减少一个分支，如果删除操作导致根节点参与合并，则2-3-4树会降低一层。**

```java
package cap3.test;

public class Tree234 {
	private Node root = new Node(); // 首先创建一个根

	// 查找数据项
	public int find(long key) {
		Node curNode = root; // 当前访问的节点
		int childNumber;
		while (true) {
			if ((childNumber = curNode.findItem(key)) != -1) // 如果在当前节点中查找对应的数据项返回不为-1，说明找到了对应的数据项
				return childNumber; // 直接返回查找数据项对应的索引值
			else if (curNode.isLeaf()) // 如果当前节点为叶子节点 则返回-1 说明树中没有改数据项
				return -1;
			else // 默认情况下 获取下一个节点
				curNode = getNextChild(curNode, key);
		}
	}

	// 插入一个数据项
	public void insert(long dvalue) {
		Node curNode = root; // 找插入位置的时候表示当前的节点的局部变量
		DataItem tempItem = new DataItem(dvalue); // 创建一个新的数据项对象
		while (true) {
			if (curNode.isFull()) { // 如果当前的节点满了的话
				split(curNode); // 拆分节点
				curNode = curNode.getParent(); // 差分结束之后 之前的节点变为了子节点 所以先获取其父节点
												// 然后重新开始查询
				curNode = getNextChild(curNode, dvalue); // 直接查找下一个节点
			} else if (curNode.isLeaf()) // 如果当前节点是一个叶子节点，而且未满
				break; // 找到了要插入数据的节点 跳出循环 直接进行插入操作
			else
				curNode = getNextChild(curNode, dvalue); // 没有找到的话 获取下一个子节点节点
		}
		curNode.insertItem(tempItem); // 让当前的节点插入新的数据
	}

	// 拆分一个节点 传入一个需要拆分的节点
	public void split(Node thisNode) {
		DataItem itemB, itemC;
		Node parent, child2, child3;
		int itemIndex;

		itemC = thisNode.removeItem(); // 当前节点中最大的数据项（removeItem方法
										// 默认是删除节点中最大的数据项） 并且已经清空了当前节点的该数据项
		itemB = thisNode.removeItem(); // 当前节点中中间的数据项 并且已经清空了当前节点的该数据项
		child2 = thisNode.disconnectChild(2); // 当前节点的2号子节点 已经断开了当前节点与2号子节点的连接
		child3 = thisNode.disconnectChild(3); // 当前节点的3号子节点 已经断开了当前节点与3号子节点的连接
		Node newRight = new Node(); // 新建一个右边的子节点

		if (thisNode == root) { // 如果要拆分的节点为根的话
			root = new Node(); // 创建一个新的根
			parent = root; // 父节点等于新的根
			root.connectChild(0, thisNode); // 然后让新的根节点与之前的节点相连 连在最左边的位置上
		} else // 不是根的话
			parent = thisNode.getParent(); // 先获取要拆分节点的父节点

		itemIndex = parent.insertItem(itemB); // 将要拆分节点的中间的数据插入到父节点中 并且获取到插入的索引
		int n = parent.getNumItems(); // 获取父节点中数据项的个数

		for (int j = n - 1; j > itemIndex; j--) { //
			Node temp = parent.disconnectChild(j); // 父节点和要拆分的接待你断开连接
			parent.connectChild(j + 1, temp); // 父节点和要拆分的原节点重新连接
												// 位置为原要拆分节点的中间的数据项在父节点中位置的左边
		}

		parent.connectChild(itemIndex + 1, newRight); // 然后在原要拆分节点新的位置的右边插入新的右边节点

		newRight.insertItem(itemC); // 原节点中最大的数据项 插入新的右节点中
		newRight.connectChild(0, child2); // 新的右节点和原要拆分节点的右边的两个子节点相连 分别放在新节点的 0
											// 1 位置上
		newRight.connectChild(1, child3);
	}

	// 获取下一个子节点 传入一个当前的节点还有一个要查找的数据项的值
	public Node getNextChild(Node theNode, long theValue) {
		int j;
		int numItems = theNode.getNumItems(); // 获取当前节点的数据项的个数
		for (j = 0; j < numItems; j++) { // 遍历
			if (theValue < theNode.getItem(j).dData) // 如果要查找的值小于当前数据项的值
				return theNode.getChild(j); // 返回当前数据项左边的子节点
		}
		// 如果找不到 则返回最后一个子节点
		return theNode.getChild(j);
	}

	// 打印一整棵树
	public void displayTree() {
		recDisplayTree(root, 0, 0);
	}

	// 打印树 传入要从那个节开始打 从那层开始的 哪个节点开始的 前序遍历
	private void recDisplayTree(Node thisNode, int level, int childNumber) {
		System.out.print("level=" + level + " child=" + childNumber + " "); // 先打印当前节点的状况
		thisNode.displayNode();

		int numItems = thisNode.getNumItems();
		for (int j = 0; j < numItems + 1; j++) { // 遍历每一个子节点并打印 递归
			Node nextNode = thisNode.getChild(j);
			if (nextNode != null) // 如果
				recDisplayTree(nextNode, level + 1, j); // 向下层递归
			else
				return; // 递归结束
		}
	}
}
```

## 2-3树

2-3**树和2-3-4树类似。**

2-3**树的节点比2-3-4树少存一个数据项和少一个子节点，2-3树也是一种多叉树。**

2-3**树的操作在很多方面都和2-3-4树类似，节点可以保存1个或2个数据项，可以有0个，1个，2个，3个子节点。其他的方面，父节点和子节点的关键字值的排列顺序和2-3-4树一样的。向节点插入数据项简单一些，因为需要比较和移动的次数少了。**

和**2-3-4树一样，所有新数据项都插入到叶节点中去，而且所有的叶节点都在树的最底层。**

2-3**树的节点分裂过程与2-3-4树大有不同，这里不再做过多介绍，有兴趣的同学可以作为拓展知识从网上进行搜索学习。**

## B-树

### 插入

其实**B-树的插入是很简单的，它主要是分为如下的两个步骤：**

  1. 使用之前介绍的查找算法查找出关键字的插入位置，如果我们在**B-树中查找到了关键字，则直接返回。**

  2**.然后，我就需要判断那个终端结点上的关键字数量是否满足：n<=m-1,如果满足的话，就直接在该终端结点上添加一个关键字，否则我们就需要产生结点的“分裂”。 分裂的方法是：生成一新结点。把原结点上的关键字和k（需要插入的值）按升序排序后，从中间位置把关键字（不包括中间位置的关键字）分成两部分。左部分所含关键字放在旧结点中，右部分所含关键字放在新结点中，中间位置的关键字连同新结点的存储位置插入到父结点中。如果父结点的关键字个数也超过（m-1），则要再分裂，再往上插。直至这个过程传到根结点为止。**

## 哈希表

**哈希表是一种数据结构，他可以提供快速的插入和查找工作。哈希表运算的非常快，而且编程实现也比较容易。**

**哈希表也有一些缺点：他是基于数组实现的，数组创建后难于扩展，某些哈希表被基本填满是，性能下降很快，所以使用之前需要明确数据量。**

### 哈希冲突解决策略

#### 开放寻址法

开放寻址法的最简单的一种实现就是线性探查（**Linear Probing），步骤如下：**

  1 当**插入新的元素时，使用哈希函数在哈希表中定位元素位置；**

  2 检查**哈希表中该位置是否已经存在元素。如果该位置内容为空，则插入并返回，否则转向步骤** 3

  3 如果**该位置为** i**，则检查** i+1 是否为空，如果已被占用，则检查 i+2**，依此类推，直到找到一个内容为空的位置。**

#### 二次探查

#### 二度哈希

有一个包含一组哈希函数 H1...**Hn** 的集合。当需要从哈希表中添加或获取元素时，首先使用哈希函数 H1**。如果导致冲突，则尝试使用** H2**，以此类推，直到** Hn**。所有的哈希函数都与** H1 十分相似，不同的是它们选用的乘法因子（**multiplicative factor）。**

[**GetHash(key) + k * (1 + (((GetHash(key) >> 5) + 1) % (hashsize** – 1)))] % hashsize

当使用二度哈希时，重要的是在执行了 hashsize 次探查后，哈希表中的每一个位置都有且只有一次被访问到。也就是说，对于给定的 key**，对哈希表中的同一位置不会同时使用** Hi 和 Hj**。在** Hashtable 类中使用二度哈希公式，其始终保持 (1 + (((**GetHash(key) >> 5) + 1) % (hashsize** – 1)) 与 hashsize 互为素数（两数互为素数表示两者没有共同的质因子）。

二度哈希使用了 Θ(**m2)** 种探查序列，而线性探查（**Linear Probing）和二次探查（Quadratic Probing）使用了Θ(m)** 种探查序列，故二度哈希提供了更好的避免冲突的策略。

两个自然数中只有公约数**1的,这两个数称为互质数。例如：3和4，** 4**和9** 都互为质数。 而**：4和6就不是互为质数，以为它们都可以整除1和2**

#### 链地址法











