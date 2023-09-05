package com.datastructure;


public class LinkedList {
    class ListNode{ //创建节点类型
        public int val;//用于存储数据
        public ListNode next;//next存储的是下一个节点的地址，默认值为null
        public ListNode(int val){ //创建带参的构造方法来实例化对象，同时给val赋值
            this.val = val;
        }
    }
    public ListNode head;//头节点

    public void addFirst(int data){    //头插法
        ListNode node = new ListNode(data);
        node.next = this.head;
        head = node;
    }
    public  void addLast(int data){ //尾插法
        ListNode node = new ListNode(data);
        if(this.head == null){ //说明是第一次插入，直接让node变成head
            this.head = node;
        }else{
            ListNode cur = this.head;
            while(cur.next != null){  //利用cur遍历链表
                cur = cur.next;
            }
            // cur走完了所有节点 : cur.next = null，到达了尾部
            cur.next = node;
        }
    }
    public void display(){ //打印链表
        ListNode cur = this.head; //利用cur来代替头节点遍历链表
        while(cur != null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public boolean contains(int key){ //查找key是否在链表当中，在则返回true，不在返回false
        ListNode cur = this.head;
        while(cur != null){
            if(cur.val == key){   //利用cur遍历链表，当有val值等于key时，证明key存在
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    public int size(){   //得到链表的长度
        ListNode cur = this.head;
        int count = 0;   //用于记录链表长度
        while(cur != null){
            count++;
            cur = cur.next;
        }
        return count;  //返回链表的长度
    }
    public ListNode findIndex(int index){  //找到index-1的位置，并返回cur
        ListNode cur = this.head;
        while(index-1 != 0){
            cur = cur.next;
            index--;
        }
        return cur;
    }
    public void addIndex(int index,int data){  //在任意位置index插入数据data
        if(index<0 || index>size()){
            System.out.println("index位置不合法");
            return;
        }
        if(index == 0){    //头插法
            addFirst(data);
            return;
        }
        if (index == size()){   //尾插法
            addLast(data);
            return;
        }
        ListNode cur = findIndex(index); //取得index-1的位置
        ListNode node = new ListNode(data); //让输入的数据data成为新的节点
        node.next = cur.next;  //新节点node的后面接上index-1位置后的内容
        cur.next = node;  //index-1的后面接上存储了data的新节点
    }
    public ListNode searchPrev(int key){  //找到key的前驱节点，即节点值等于key的节点的前一个节点，并返回这个前驱节点cur
        ListNode cur = this.head;
        while(cur.next != null){
            if(cur.next.val == key){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    public void remove(int key){   //删除第一次出现关键词key的节点
        if(this.head == null){   //判断是否为空节点
            System.out.println("链表为空，不能删除");
            return;
        }
        if(this.head.val == key){   //判断要删除的是否就是头节点
            this.head = this.head.next;
            return;
        }
        ListNode cur = searchPrev(key);  //取得前驱节点
        if(cur == null){
            System.out.println("没有您要删除的节点");
            return;
        }
        ListNode de1 = cur.next;  //令要删除的节点为de1
        cur.next = de1.next;  //删除节点值key的节点
    }
    public ListNode removeAllKey(int key){ //删除所有值为key的节点
        if(this.head == null){  //判断是否空
            return null;
        }
        ListNode pre = this.head;
        ListNode cur = this.head.next;
        while(cur != null){
            if(cur.val == key){    //如果cur是要删除的节点，则将该节点删除再遍历
                pre.next = cur.next;
                cur = cur.next;
            }else {           //cur不是要删除的节点，继续遍历
                pre = cur;
                cur = cur.next;
            }
        }
        if(this.head.val == key){  //最后判断头节点是否是val为key的节点
            this.head = this.head.next;
        }
        return this.head;
    }

    //清空单链表，直接将头节点置空或将节点一个一个释放
    /*public void clear(){
        this.head = null;
    }*/
    public void clear(){
        while(this.head != null){
            ListNode cutNext = head.next;
            this.head.next = null;
            this.head = cutNext;
        }
    }
}

