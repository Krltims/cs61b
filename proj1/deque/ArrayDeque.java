package deque;

import java.util.Iterator;
import java.util.LinkedList;

public class ArrayDeque <T> implements Deque<T>, Iterable<T> {
    private T[] items;
    private int head;
    private int tail;
    private int size;
    public ArrayDeque(){
        items= (T[]) new Object[8];
        head=0;
        tail=0;
        size=0;
    }
    private void resize(){
        T[] newItems;
        if(size==items.length){
            newItems=(T[]) new Object[items.length*2];
        }
        else if(size<items.length/4 && items.length>=16){
            newItems=(T[]) new Object[items.length/2];
        }
        else{
            return;
        }
        for(int i=0;i<size();i++){
            newItems[i]=get(i);
        }
        items=newItems;
        head=minus_one(0);
        tail=size;
    }
    private int minus_one(int num){
        if (num==0){
            return items.length-1;
        }
        return num-1;
        }
    private int plus_one(int num){
        if (num==items.length-1){
            return 0;
        }
        return num+1;
    }

    @Override
    //  Adds an item of type T to the front of the deque. You can assume that item is never null.
    public void addFirst(T item){
        resize();
        if(isEmpty()){
            tail=plus_one(tail);
        }
        items[head] = item;
        head=minus_one(head);
        size+=1;
    }

    @Override
    //  Adds an item of type T to the back of the deque. You can assume that item is never null.
    public void addLast(T item){
        resize();
        if(isEmpty()){
            head=minus_one(head);
        }
        items[tail] = item;
        tail=plus_one(tail);
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
        int i=0;
        int start=head;
        while(i<size){
            System.out.print(items[start]+" ");
            start=plus_one(start);
            i+=1;
        }
        System.out.println();
    }

    @Override
    //  Removes and returns the item at the front of the deque. If no such item exists, returns null.
    public T removeFirst(){
        if (isEmpty()){
            return null;
        }
        resize();
        if(size==1){
            tail=minus_one(tail);
        }
        head=plus_one(head);
        size-=1;
        return items[head];
    }

    @Override
    //  Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        resize();
        if(size==1){
            head=plus_one(head);
        }
        tail=minus_one(tail);
        size-=1;
        return items[tail];
    }

    @Override
    //   Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index){
        if (index < 0 || index >= size || isEmpty()) {
            return null;
        }
        index = Math.floorMod(plus_one(head) + index, items.length);
        return items[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDequeIterator<T>();
    }

    private class ArrayDequeIterator<T> implements Iterator<T>{

        private int current;
        public ArrayDequeIterator(){
            current=0;
        }
        @Override
        public boolean hasNext() {
            return current<size;
        }

        @Override
        public T next() {
            T tmp=(T) get(current);
            current+=1;
            return tmp;
        }
    }
    public T getRecursive(int index){
        return helper(head,index);
    }
    private T helper(int head,int index){
        if(index==-1){
            return items[head];
        }
        return helper(plus_one(head),index-1);
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof ArrayDeque){
            ArrayDeque otherarraydeque=(ArrayDeque) o;
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
        else if (o instanceof LinkedListDeque){
            LinkedListDeque otherarraydeque=(LinkedListDeque) o;
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
}
