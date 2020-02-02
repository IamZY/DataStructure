package com.ntuzy.List.LinkedList;

import java.text.BreakIterator;
import java.util.Stack;

/**
 * @Author IamZY
 * @create 2020/2/2 14:37
 */
public class SingleLinkedListDemo {

    public static void main(String[] args) {
        // 先创建节点
        HeroNode hero1 = new HeroNode(1, "宋江", "1");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "2");
        HeroNode hero3 = new HeroNode(3, "吴用", "3");
        HeroNode hero4 = new HeroNode(4, "林冲", "4");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);

        singleLinkedList.list();

//        reverseList(singleLinkedList.getHead());
//        System.out.println();
//        singleLinkedList.list();

        System.out.println();
        reversePrint(singleLinkedList.getHead());

//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero3);
//
//        singleLinkedList.update(new HeroNode(1, "tom", ""));
//
//
////        singleLinkedList.delete(4);
//
//        singleLinkedList.list();
//
//        System.out.println(getLength(singleLinkedList.getHead()));
//
//        System.out.println(findLastIndexNode(singleLinkedList.getHead(), 3));

    }

    // 获取单链表的节点的个数
    public static int getLength(HeroNode head) {
        if (head.next == null) {
            return 0;
        }

        int length = 0;

        HeroNode cur = head.next;

        while (cur != null) {
            length++;
            cur = cur.next;
        }

        return length;
    }

    // 查找单链表倒数第k个节点
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }

        int size = getLength(head);

        if (index <= 0 || index > size) {
            return null;
        }

        HeroNode cur = head.next;

        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }

        return cur;
    }


    // 链表反转
    public static void reverseList(HeroNode head) {
        // 如果为空或者只有一个节点 直接返回
        if (head.next == null || head.next.next == null) {
            return;
        }

        // 定义一个辅助指针
        HeroNode cur = head.next;
        HeroNode next = null;

        HeroNode reverseHead = new HeroNode(0,"","");


        while (cur != null) {
            next = cur.next;
            cur.next = reverseHead.next;
            reverseHead.next = cur;
            cur = next;
        }

        // 将head.next 指向reverseHead.next
        head.next = reverseHead.next;
    }

    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        Stack<HeroNode> stack = new Stack<>();

        HeroNode cur = head.next;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }

}

// 定义SingleLinkedList管理我们就得英雄
class SingleLinkedList {
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    // 添加节点到单向链表
    public void add(HeroNode heroNode) {
        // 当不考虑编号数据时候
        HeroNode temp = head;
        // 遍历链表 找到最后
        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        // 因为头节点不能动 仍然通过辅助指针来帮助找到添加的位置
        // 是位于添加位置的前一个节点
        HeroNode temp = head;
        boolean flag = false;   // 添加的标号是否存在


        while (true) {
            if (temp.next == null) {
                // 说明temp在链表的最后
                break;
            }

            if (temp.next.no > heroNode.no) {
                // 位置找到 就在temp后面
                break;
            } else if (temp.next.no == heroNode.no) {
                // 希望添加的heroNode的标号已经存在
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag == true) {
            System.out.println("准备插入英雄标号已经存在...");
        } else {
            // 插入到链表中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空...");
        }

        HeroNode temp = head;
        boolean flag = false;

        while (true) {
            if (temp.next == null) {
                break;
            }

            if (temp.next.no == no) {
                // 找到待删除节点的前一个节点
                flag = true;
                break;
            }

            temp = temp.next;

        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的节点不存在");
        }


    }


    // 修改节点信息根据no修改
    public void update(HeroNode newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空...");
        }

        HeroNode temp = head.next;
        boolean flag = false;


        while (true) {
            if (temp == null) {
                break; // 链表最后
            }

            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.println("没有找到编号的节点");
        }


    }


    // 显示链表
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            // 输出节点的信息
            System.out.println(temp);
            // 将next后移
            temp = temp.next;
        }
    }


}


class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;


    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}