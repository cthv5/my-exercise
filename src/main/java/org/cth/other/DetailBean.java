package org.cth.other;

public class DetailBean {
    private Long dataGoodsflag;
    private Double sbillDetailOknum;
    private Double goodsNum;

    DetailBean(Long dataGoodsflag, Double sbillDetailOknum, Double goodsNum){
        this.dataGoodsflag = dataGoodsflag;
        this.sbillDetailOknum = sbillDetailOknum;
        this.goodsNum = goodsNum;
    }

    public Long getDataGoodsflag() {
        return dataGoodsflag;
    }

    public void setDataGoodsflag(Long dataGoodsflag) {
        this.dataGoodsflag = dataGoodsflag;
    }

    public Double getSbillDetailOknum() {
        return sbillDetailOknum;
    }

    public void setSbillDetailOknum(Double sbillDetailOknum) {
        this.sbillDetailOknum = sbillDetailOknum;
    }

    public Double getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Double goodsNum) {
        this.goodsNum = goodsNum;
    }
}
