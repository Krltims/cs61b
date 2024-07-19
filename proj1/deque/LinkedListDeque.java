package deque;

import java.security.PublicKey;
import java.util.Iterator;
import java.util.NoSuchElementException;

/** Performs some basic linked list tests. */
public class LinkedListDeque<T> implements Deque<T> , Iterable<T> {
    public int size;
    public Node sent;

    public class Node{
        public T value;
        public Node head;
        public Node next;

        public Node (T v, Node f,Node a){
            value = v;
            head=f;
            next=a;
        }
    }

    public LinkedListDeque(){
        //item=(typo[]) new Object[100];
        size=0;
        sent=new Node(null,null,null);
        sent.next=sent;
        sent.head=sent;
    }

    @Override
//  Adds an item of type T to the front of the deque. You can assume that item is never null.
    public void addFirst(T item){
        Node firstnode=new Node(item,sent,sent.next);
        sent.next.head=firstnode;
        sent.next=firstnode;
        size+=1;
    }

    @Override
//  Adds an item of type T to the back of the deque. You can assume that item is never null.
    public void addLast(T item){
        Node lastnode=new Node(item,sent.head,sent);
        sent.head.next=lastnode;
        sent.head=lastnode;
        size+=1;
    }

    @Override
//  Returns the number of items in the deque.
    public int size(){
        return size;
    }

    @Override
//  Prints the items in the deque from first to last, separated by a space. Once all the items have been printed, print out a new line.
    public void printDeque(){
        Node temp=sent.next;
        while(temp!=sent){
            if(temp.next==sent){
                System.out.println(temp.value);
                return;
            }
            System.out.print(temp.value+" ");
            temp=temp.next;
        }
    }
    @Override
//  Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        T val=sent.next.value;
        sent.next.next.head=sent;
        sent.next=sent.next.next;
        size-=1;
        return val;
    }

    @Override
//  Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        T val=sent.head.value;
        sent.head.head.next=sent;
        sent.head=sent.head.head;
        size-=1;
        return val;
    }

    @Override
//   Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index){
        if(index<0 || index>size){
            return null;
        }
        Node temp=sent.next;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp.value;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDequeIterator<>();
    }

    public class LinkedListDequeIterator<T> implements Iterator<T>{
        private int current;
        public LinkedListDequeIterator(){
            current=0;
        }
        @Override
        public boolean hasNext() {
            return current<size();
        }
        @Override
        public T next() {
            T tmp=(T) get(current);
            current+=1;
            return tmp;
        }
    }
    @Override
    public boolean equals(Object o){
        if(o instanceof LinkedListDeque otherarraydeque){
            if(otherarraydeque.size()!=this.size()){
                return false;
            }
            int ans=0;
            while(ans<otherarraydeque.size()){
                if(!(otherarraydeque.get(ans).equals(this.get(ans)))){
                    return false;
                };
                ans+=1;
            }
        }
        else{
            return false;
        }
        return true;
    }

    //  Same as get, but uses recursion.
    public T getRecursive(int index){
        if(index<0 || index>size){
            return null;
        }
        Node temp=sent.next;
        return method1(index,temp);
    }
    public T method1(int num,Node temp){
        if (num==0){
            return temp.value;
        }
        return method1(num-1,temp.next);
    }

}
