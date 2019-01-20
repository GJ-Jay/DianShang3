package gj.com.buycar.bean;

import java.util.List;

import gj.com.buycar.R;

public class Shop {
    private List<Goods> list;//list类型
    private String sellerName;
    private String sellerid;
    int textColor = 0xffffffff;
    int background = R.color.grayblack;
    boolean check;

    public List<Goods> getList() {
        return list;
    }

    public void setList(List<Goods> list) {
        this.list = list;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public int getTextColor() {
        return textColor;
    }

    public void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public int getBackground() {
        return background;
    }

    public void setBackground(int background) {
        this.background = background;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
