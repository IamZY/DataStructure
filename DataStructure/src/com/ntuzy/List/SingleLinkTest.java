package com.ntuzy.List;

public class SingleLinkTest {
    public static void main(String[] args) {
        List1<String> str = new List1<>();
        str.add("a");
        str.add("b");
        str.add("c");
        str.add("d");
        str.add("e");
        str.add("f");

        str.remove(2);
        System.out.println(str.get(2));

    }
}

class List<T> {
    private int foot;    // 角标
    private int count;   // 链表的长度
    private Node root;   // 链表的第一个节点

    // 链节点的类
    private class Node {
        private T data;
        private Node next;

        //        private Node pre;
        public Node(T data) {
            this.data = data;
        }

        // 添加节点
        private void add(T data) {
            if (this.next == null) {
                this.next = new Node(data);
            } else {
                this.next.add(data);
            }
        }

        // 删除节点
        private void remove(Node pre, int index) {
            if (List.this.foot++ == index) {
                pre.next = this.next;  // this代表当前删除的节点  那么当前节点的上一个节点的next应该指向当前节点的next
                this.next = null;  // 当前要删除的节点从链表中删除 只需要移除next为空
                List.this.count--;
                return;
            } else {
                // 递归
                this.next.remove(this, index);
            }
        }

        // 删除节点2
        private void remove(Node pre, T data) {
            if (this.data.equals(data)) {
                // 直接进行删除操作
                pre.next = this.next;
                this.next = null;
                List.this.count--;
                return;
            } else {
                // 当前节点的下一个节点是否为空 不为空继续比对 为空返回
                if (this.next != null) {
                    this.next.remove(this, data);
                } else {
                    return;
                }
            }
        }

        // 修改数据
        private void replace(T oldData, T newData) {
            if (this.data.equals(oldData)) {
                this.data = newData;
            } else {
                this.next.replace(oldData, newData);
            }
        }

        // 索引修改数据
        private void replace(int index, T newData) {
            if (List.this.foot++ == index) {
                this.data = newData;
            } else {
                this.next.replace(index, newData);
            }
        }


        // 查询
        private T get(int index) {
            if (List.this.foot++ == index) {
                return this.data;
            } else {
                return this.next.get(index);
            }
        }


        // 是否包含
        private boolean contains(T data) {
            if (this.data.equals(data)) {  // 如果当前的data与需要查询的data匹配 但会true
                return true;
            } else {
                // 当前节点的next节点是否为空
                if (this.next != null) {
                    return this.next.contains(data);
                } else {
                    return false;
                }
            }
        }


    }


    public List() {

    }

    // 检查链表是否为空
    public boolean isEmpty() {
        if (this.count == 0 && this.root == null) {
            return true;
        }
        return false;
    }

    // 获取链表长度
    public int size() {
        return this.count;
    }

    // 添加
    public void add(T data) {
        // 判断当前链表是否为空
        if (this.isEmpty()) {
            this.root = new Node(data);
        } else {
            this.root.add(data);
        }
        this.count++;
    }

    // 删除
    public void remove(int index) {
        if (this.isEmpty()) {
            return;
        }

        if (index < 0 || this.count <= index) {
            return;
        }

        // 只是删除根节点
        if (index == 0) {
            Node temp = this.root;
            this.root = this.root.next;
            temp.next = null;  // 移除一个节点 只需要移除引用关系即可
            this.count--;
        } else {
            this.foot = 0;
            this.root.remove(this.root, index);
        }

    }

    //
    public void remove(T data) {
        if (this.isEmpty()) {
            return;
        }

        if (this.root.data.equals(data)) {
            Node temp = this.root;
            this.root = this.root.next;
            temp.next = null;  // 移除一个节点 只需要移除引用关系即可
            this.count--;
        } else {
            this.root.next.remove(this.root, data);
        }
    }


    // 修改
    public void replace(int index, T data) {
        if (this.isEmpty()) {
            return;
        }

        if (index < 0 || this.count <= index) {
            return;
        }

        this.foot = 0;
        this.root.replace(index, data);
    }

    // 修改
    public void replace(T oldData, T newData) {
        if (this.isEmpty()) {
            return;
        }
        this.root.replace(oldData, newData);
    }

    // 查询
    public T get(int index) {
        if (this.isEmpty()) {
            return null;
        }

        this.foot = 0;
        return this.root.get(index);
    }

    // 包含
    public boolean contains(T data) {
        if (this.isEmpty()) {
            return false;
        }
        return this.root.contains(data);
    }


    public Object[] toArray() {
        if (this.isEmpty()) {
            return null;
        }

        int count = this.count;
        Object[] retVal = new Object[count];
        for (int i = 0; i < count; i++) {
            retVal[i] = this.get(i);
        }

        return retVal;
    }

}



