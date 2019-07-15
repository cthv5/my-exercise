package org.cth.dataStructure.arr;

/**
 * 数据结构-数组练习
 */
public class Testarr {
    public static void main(String[] args) {
        int[] intArr = new int[100];
        intArr[0] = 12;
        System.out.println(intArr.length);
        int[] intArr1 = {1, 2, 3, 4, 5, 6};
        int start = 0;
        int end = 9;
        int cut = (start + end)/2;
        System.out.println(cut);
        int searchKey = 3;
        for (int item : intArr1) {
            if (item == searchKey) {
                System.out.println("找到了...");
                break;
            } else {
                System.out.println(item);
            }
        }
        HighArr highArr = new HighArr(6);
        highArr.insert(12);
        highArr.insert(13);
        highArr.insert(14);
        highArr.insert(15);
        highArr.insert(16);
        highArr.insert(17);
        highArr.display();
        if (highArr.find(13)) {
            System.out.println("找到了");
        } else {
            System.out.println("找不到");
        }
        if (highArr.delete(15)) {
            System.out.println("删除成功");
        }
        highArr.display();
    }
}
