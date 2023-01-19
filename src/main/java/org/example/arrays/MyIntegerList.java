package org.example.arrays;
import java.util.ArrayList;
import java.util.Arrays;

public class MyIntegerList {
    private final ArrayList<Integer> list;

    public MyIntegerList(Integer[] array) {
        this.list = new ArrayList<>(Arrays.asList(array));
    }

    public Integer[] getListAsAnArray() {
        return this.list.toArray(new Integer[0]);
    }

    public void add(int n) {
        this.list.add(n);
    }

    public void remove() {
        if(!this.list.isEmpty())
            this.list.remove(this.list.size()-1);
    }

    public int get(int index) {
        if(this.list.size() - 1 >= index)
            return this.list.get(index);
        else
            throw new IllegalStateException("Illegal index");
    }

    public int size() {
        return this.list.size();
    }

    public void clear() {
        this.list.clear();
    }
}
