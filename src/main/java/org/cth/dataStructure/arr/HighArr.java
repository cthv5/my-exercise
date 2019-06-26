package org.cth.dataStructure.arr;

class HighArr {
    private long[] a;
    private int nElem;
    HighArr(int size){
        a = new long[size];
        nElem = 0;
    }
    boolean find(long searchKey){
        int j;
        for (j = 0; j < nElem; j++){
            if (a[j] == searchKey) return true;
        }
        return j == nElem;
    }
    void insert(long value){
        a[nElem] = value;
        nElem++;
    }
    boolean delete(long value){
        int i;
        for (i = 0; i < nElem; i++){
            if (a[i] == value) break;
        }
        if (i == nElem) return false;
        else {
            for (int j = i; j < nElem - 1; j++){
                a[j] = a[j+1];
            }
            nElem--;
            return true;
        }
    }
    void display(){
        for (int i = 0; i < nElem; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println(" ");
    }
}
