package com.ntuzy.List.LinkedList;

/**
 * @Author IamZY
 * @create 2020/2/3 11:20
 */
public class Joseph {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();


        circleSingleLinkedList.countBoy(1, 2, 5); // 2->4->1->5->3

    }
}


// 创建环形单项列表
class CircleSingleLinkedList {
    // 创建一个first节点
    private Boy first = new Boy(-1);

    // 添加小孩节点 构建环形链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums的值不正确");
            return;
        }

        Boy curBoy = null;

        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                first = boy;
                first.setNext(first);
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }


    // 遍历当前环形链表
    public void showBoy() {
        // 判断链表是否为空
        if (first == null) {
            System.out.println("没有任何小孩");
            return;
        }
        // 因为first不能动 因此我们仍然使用一个辅助指针完成遍历
        Boy curBoy = first;
        while (true) {
            System.out.printf("小孩的编号是 %d \n", curBoy.getNo());
            if (curBoy.getNext() == first) {
                break;
            }

            curBoy = curBoy.getNext();
        }
    }


    /**
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示梳几下
     * @param nums     表示最初由多少个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误 重新输入");
            return;
        }

        // 先创建辅助指针
        Boy helper = first;
        while (true) {
            if (helper.getNext() == first) {
                // 说明helper指向最后
                break;
            }
            helper = helper.getNext();
        }


        for (int i = 0; i < startNo - 1; i++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        while (true) {
            if (helper == first) {
                break; // 圈中只有一个个人
            }
            for (int i = 0; i < countNum - 1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            // first 指向的节点就是除权小孩的节点
            System.out.printf("小孩%d出圈\n", first.getNo());
            first = first.getNext();
            helper.setNext(first);
        }

        System.out.printf("最后留在圈中小孩的编号%d", first.getNo());


    }


}

// 创建一个boy类
class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
