package deque;

import java.util.Comparator;

class MyComparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        if (a.length() > b.length())
            return 1;
        else if (b.length() > a.length())
            return -1;
        else
            return 0;
    }
}
