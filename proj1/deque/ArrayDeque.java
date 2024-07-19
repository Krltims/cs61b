package deque;

    public class ArrayDeque <T> implements Deque<T>{
        public T[] items;
        public int head;
        public int tail;
        public int size;
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
        int pointer_head=head;
        int i=0;
        while(i<size){
            newItems[i]=items[pointer_head];
            i+=1;
            pointer_head=plus_one(pointer_head);
        }
        items=newItems;
        head=0;
        tail=size-1;
    }
    public int minus_one(int num){
        if (num==0){
            return items.length-1;
        }
        return num-1;
        }
    public int plus_one(int num){
        if (num==items.length-1){
            return 0;
        }
        return num+1;
    }

    @Override
    //  Adds an item of type T to the front of the deque. You can assume that item is never null.
    public void addFirst(T item){
        resize();
        if(items[head]!=null){
            head=minus_one(head);
        }
        items[head]=item;
        size+=1;
    }

    @Override
    //  Adds an item of type T to the back of the deque. You can assume that item is never null.
    public void addLast(T item){
        resize();
        if(items[tail]!=null){
            tail=plus_one(tail);
        }
        items[tail]=item;
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
        int temp=head;
        head=plus_one(head);
        size-=1;
        return items[temp];
    }

    @Override
    //  Removes and returns the item at the back of the deque. If no such item exists, returns null.
    public T removeLast(){
        if (isEmpty()){
            return null;
        }
        int temp=tail;
        tail=minus_one(tail);
        size-=1;
        return items[temp];
    }

    @Override
    //   Gets the item at the given index, where 0 is the front, 1 is the next item, and so forth. If no such item exists, returns null. Must not alter the deque!
    public T get(int index){
    if(index<0 || index>=size){
        return null;
    }
    int pos=(head+index)%size;
    return items[pos];
    }

    public T getfirst(){
        return items[head];
    }
}
