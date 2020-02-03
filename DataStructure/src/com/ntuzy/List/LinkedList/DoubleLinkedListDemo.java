package com.ntuzy.List.LinkedList;

/**
 * @Author IamZY
 * @create 2020/2/3 10:42
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        System.out.println("双向链表的测试");
        // 先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "1");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "2");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "3");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "4");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);

        doubleLinkedList.list();


        HeroNode2 heroNode2 = new HeroNode2(4,"xx","yyy");
        doubleLinkedList.update(heroNode2);

        System.out.println();
        doubleLinkedList.list();

        doubleLinkedList.delete(4);

        System.out.println();
        doubleLinkedList.list();

    }
}


class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    // 遍历双向链表
    public void list() {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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

    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head;

        while (true) {
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }

        // 找到链表最后
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空...");
            return;
        }

        HeroNode2 temp = head.next;
        boolean flag = false;

        while (true) {
            if (temp == null) {
                break;
            }

            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.pre.next = temp.next;
            // 如果节点是最后一个节点就不需要执行下面这句话
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.println("要删除的节点不存在");
        }


    }


    // 修改节点信息根据no修改
    public void update(HeroNode2 newHeroNode) {
        // 判断是否为空
        if (head.next == null) {
            System.out.println("链表为空...");
        }

        HeroNode2 temp = head.next;
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


}


class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;
    public HeroNode2 pre;


    public HeroNode2(int no, String name, String nickName) {
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
