import java.util.*;
import java.io.*;
public class Swea_1230_암호문3 {
    static class Node {
        int data;
        Node next;
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class MyLinkedList {
        private Node head;

        public void addLast(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            Node temp = head;
            while (temp.next != null) {
                //끝까지 탐색
                temp = temp.next;
            }
            temp.next = newNode;
        }

        public void insertAt(int index, int[] nums) {
            Node temp = head;
            if (index == 0) {  // 맨 앞에 삽입하는 경우 !!!!!!!!!!!!!
                Node newHead = new Node(nums[0]);
                Node last = newHead;
                for (int i = 1; i < nums.length; i++) {
                    last.next = new Node(nums[i]);
                    last = last.next;
                }
                last.next = head;
                head = newHead;
                return;
            }

            for (int i = 0; i < index - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp == null) return;
            //temp 뒤에 삽입
            Node nextNode = temp.next;
            Node newNode = new Node(nums[0]);
            Node last = newNode;
            for (int i = 1; i < nums.length; i++) {
                last.next = new Node(nums[i]);
                last = last.next;
            }
            last.next = nextNode;
            temp.next = newNode;
        }

        public void removeAt(int index, int y) {
            Node temp = head;
            if (index == 0) {
                for (int i = 0; i < y && head != null; i++) {
                    head = head.next;
                }
                return;
            }
            for (int i = 0; i < index - 1 && temp != null; i++) {
                temp = temp.next;
            }
            if (temp == null || temp.next == null) return;

            Node remove = temp; //remove부터 삭제
            for (int i = 0; i < y && remove.next != null; i++) {
                remove = remove.next;
            }
            temp.next = remove.next;
        }
        public void print() {
            Node temp = head;
            for (int i = 0; i < 10; i++) {
                System.out.printf("%d ", temp.data);
                temp = temp.next;
            }
        }
    }
    static MyLinkedList linkedList;
    static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int T = 10;
        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt(); //암호문 개수
            linkedList = new MyLinkedList();
            for (int i = 0; i < N; i++) {
                linkedList.addLast(sc.nextInt());
            }

            int command = sc.nextInt();  //명령어 개수
            for (int i = 0; i < command; i++) {
                char c = sc.next().charAt(0);
                switch (c) {
                    case 'I':
                        int x = sc.nextInt();
                        int y = sc.nextInt();
                        int[] nums = new int[y];
                        for (int j = 0; j < y; j++) {
                            nums[j] = sc.nextInt();
                        }
                        linkedList.insertAt(x,nums);
                        break;
                    case 'D':
                        x = sc.nextInt();
                        y = sc.nextInt();
                        linkedList.removeAt(x,y);
                        break;
                    case 'A':
                        y = sc.nextInt();
                        for (int j = 0; j < y; j++) {
                            linkedList.addLast(sc.nextInt());
                        }
                        break;
                }
            }
            System.out.printf("#%d ",t);
            linkedList.print();
            System.out.println();
        }
    }

    public static void add(int y, int[] s) {
        for (int i = 0; i < y; i++) {
            linkedList.addLast(s[i]);
        }
    }
}
