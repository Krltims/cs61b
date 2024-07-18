package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {
    private Comparator<T> c;

    //creates a MaxArrayDeque with the given Comparator.
    public MaxArrayDeque(Comparator<T> c){
        super();
        this.c=c;
    }

    //returns the maximum element in the deque as governed by the previously given Comparator.
    //If the MaxArrayDeque is empty, simply return null.
    public T max(){
        return max(c);
    }

    //returns the maximum element in the deque as governed by the parameter Comparator c.
    //If the MaxArrayDeque is empty, simply return null.
    public T max(Comparator<T> c){
        if(size()==0){
            return null;
        }
        int count=1;
        T ans=get(head);
        for(int i=head;count<=size();i=plus_one(i)){
            if(c.compare(ans,get(i))<0){
                ans=get(i);
            }
            count++;
        }
        return ans;
    }

}
