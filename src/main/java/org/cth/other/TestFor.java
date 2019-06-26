package org.cth.other;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class TestFor {
    public static void main(String[] args) {
        List<DetailBean> detailList = new ArrayList<>();
        DetailBean bean1 = new DetailBean(1L, 4.00000000, 5D);
        detailList.add(bean1);
        DetailBean bean2 = new DetailBean(0L, 5.00000000, 5D);
        detailList.add(bean2);
        DetailBean bean3 = new DetailBean(0L, 4.00000000, 5D);
        detailList.add(bean3);

        int detailNum = 0;
        boolean detailFlag = false;
        for (DetailBean detail : detailList) {
            // 货齐
            if (Long.valueOf("1").equals(detail.getDataGoodsflag())) {
                detailNum++;
                // 自动货齐
                if ((detail.getGoodsNum() - detail.getSbillDetailOknum()) > 0.0) {
                    detailFlag = true;
                }
            }
        }
        Hashtable<String, String> a= new Hashtable<>();
        System.out.println(">>>" + detailNum);
        if (detailNum == detailList.size()) {
            throw new RuntimeException("已全部出库");
        }
        if (detailNum < detailList.size() && detailFlag) {
            throw new RuntimeException("存在明细已自动货齐");
        }
        System.out.println("可以延时");
    }
}
