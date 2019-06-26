package org.cth.dataStructure.arr;

public class LowArr {
    private long[] a;
    public LowArr(int size){
        a = new long[size];
    }
    public void setElem(int index, long value){
        a[index] = value;
    }
    public long getElem(int index){
        return a[index];
    }
}
