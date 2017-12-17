package com.westore.model;

public class Node{
    int value;
    Node nextNode;
    public Node(int value, Node nextNode) {
        super();
        this.value = value;
        this.nextNode = nextNode;
    }

    public static void main(String[] args) {
        Node head = init(10);
        out(head);
    }

    /**
     * 初始化单链表
     * @param num 数量
     * @return
     */
    public static Node init(int num) {
        Node node = new Node(0, null);
        Node cur = null;
        Node temp = null;
        for(int i = 1 ; i < num;i++){
            temp = new Node(i, null);
            if (i == 1) {
                node.nextNode = temp;
            }else{
                cur.nextNode = temp;
            }
            cur = temp;
        }
        return node;
    }

    /**
     * 打印节点值
     * @param head
     */
    private static void out(Node head) {
        Node tempNode = head;
        while(tempNode != null){
            System.err.println(tempNode.value);
            tempNode = tempNode.nextNode;
        }
    }

    /**
     * 反转单链表
     * @param head
     * @return
     */
    private static Node reverseHead(Node head) {
        if (head == null) {
            return head;
        }

        Node pre = head;
        Node cur = head.nextNode;
        Node next = null;
        while(cur != null){
            next = cur.nextNode;
            cur.nextNode = pre;

            pre = cur;
            cur = next;
        }
        head.nextNode = null;
        head = pre;
        return head;
    }
}