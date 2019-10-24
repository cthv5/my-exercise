package org.cth.other.enumtest;

public class MainTest {
    public static void main(String[] args) {
        for (TestEnum en : TestEnum.values()){
            System.out.println(en.getIndex()+":"+en.getName());
        }
        String flag = null;
        String tableName = "cth";
        String item = "out".equals(flag) ? "wod_erp_flag" : "wrd_erp_flag";
        String sql = "update "+tableName+" set "+item+" = 'Y' where id = ?";
        System.out.println(sql);
    }
}
