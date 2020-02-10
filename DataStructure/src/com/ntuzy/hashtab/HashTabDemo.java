package com.ntuzy.hashtab;

/**
 * @Author IamZY
 * @create 2020/2/10 11:37
 */
public class HashTabDemo {

    public static void main(String[] args) {

        HashTab hashTab = new HashTab(7);

        Emp emp1 = new Emp(1, "1");
        Emp emp2 = new Emp(8, "8");
        Emp emp3 = new Emp(3, "3");
        Emp emp4 = new Emp(4, "4");
        Emp emp5 = new Emp(5, "5");
        Emp emp6 = new Emp(6, "6");
        Emp emp7 = new Emp(7, "7");

        hashTab.add(emp1);
        hashTab.add(emp2);
        hashTab.add(emp3);
        hashTab.add(emp4);
        hashTab.add(emp5);
        hashTab.add(emp6);
        hashTab.add(emp7);

        hashTab.list();

        hashTab.findEmpById(10);


    }


}


// 创建hash表
class HashTab {
    EmpLinkedList[] empLinkedLists;
    int size;

    public HashTab(int size) {
        this.size = size;
        this.empLinkedLists = new EmpLinkedList[size];
        // 分别初始化每一个链表
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }


    public void add(Emp emp) {
        // 根据员工id 得到该员工应该添加到哪条列表
        int number = hashFun(emp.id);
        // 将emp添加到对应
        empLinkedLists[number].add(emp);
    }

    // 遍历所有链表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list();
        }
    }


    // 编写一个散列函数 使用简单的取模法
    public int hashFun(int id) {
        return id % size;
    }

    // 根据输入id 查找雇员
    public void findEmpById(int id) {

        int index = hashFun(id);

        Emp emp = empLinkedLists[index].findById(id);

        if (emp == null) {
            System.out.println("没有找到雇员");
        } else {
            System.out.printf("找到雇员 信息=>%d,%s", emp.id, emp.name);
        }

    }


}


class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

}

// 创建EmpLinkedList
class EmpLinkedList {
    // 头指针 执行第一个Emp 因此我们这个链表的head是指向第一个Emp
    private Emp head;

    // 当添加雇员是id是自增的
    // 因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp emp) {
        // 如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        // 如果不是添加第一个雇员
        Emp curEmp = head;
        while (true) {
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        // 直接将emp加入链表
        curEmp.next = emp;
    }

    // 遍历链表的雇员信息
    public void list() {
        if (head == null) {
            return;
        }

        Emp curEmp = head;

        while (curEmp != null) {
            System.out.printf("=> id=%d name=%s\t", curEmp.id, curEmp.name);
            curEmp = curEmp.next;
        }
        System.out.println();

    }

    public Emp findById(int id) {
        if (head == null) {
            return null;
        }

        Emp curEmp = head;

        while (curEmp != null) {
            if (curEmp.id == id) {
                return curEmp;
            }

            curEmp = curEmp.next;
        }

        return null;
    }


}
