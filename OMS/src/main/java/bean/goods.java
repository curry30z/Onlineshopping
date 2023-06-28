package bean;

public class goods {

    private int id ;//
    private  String goodsno;//商品编号
    private  String gname;//商品名
    private  double price;//单间
    private int  amount;//数量

    public String getGoodsno() {
        return goodsno;
    }

    public void setGoodsno(String goodsno) {
        this.goodsno = goodsno;
    }

    public goods(String goodsno, String gname, double price, int amount, String picturename, String seller, int itemid, String adddate, double discount, String describe) {
        this.goodsno = goodsno;
        this.gname = gname;
        this.price = price;
        this.amount = amount;
        this.picturename = picturename;
        this.seller = seller;
        this.itemid = itemid;
        this.adddate = adddate;
        this.discount = discount;
        this.describe = describe;
    }

    public goods(String goodsno, String gname, double price, int amount, String picturename, String seller, int itemid, String adddate, double discount, String describe, String name) {
        this.goodsno = goodsno;
        this.gname = gname;
        this.price = price;
        this.amount = amount;
        this.picturename = picturename;
        this.seller = seller;
        this.itemid = itemid;
        this.adddate = adddate;
        this.discount = discount;
        this.describe = describe;
        this.name = name;
    }

    private  String picturename;//图片名
    private String seller;//卖家
    private  int itemid;//类别Id
    private  String adddate;//上架时间
    private double discount;//折扣
    private String describe;//描述

    @Override
    public String toString() {
        return "goods{" +
                "id=" + id +
                ", goodsno='" + goodsno + '\'' +
                ", gname='" + gname + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", picturename='" + picturename + '\'' +
                ", seller='" + seller + '\'' +
                ", itemid=" + itemid +
                ", adddate='" + adddate + '\'' +
                ", discount=" + discount +
                ", describe='" + describe + '\'' +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public goods(int id, String goodsno, String gname, double price, int amount, String picturename, String seller, int itemid, String adddate, double discount, String describe, String status, String name) {
        this.id = id;
        this.goodsno = goodsno;
        this.gname = gname;
        this.price = price;
        this.amount = amount;
        this.picturename = picturename;
        this.seller = seller;
        this.itemid = itemid;
        this.adddate = adddate;
        this.discount = discount;
        this.describe = describe;
        this.status = status;
        this.name = name;
    }

    public goods() {

    }


    private  String status;//状态
    private String name;//类别名

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    public String getPicturename() {
        return picturename;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getAdddate() {
        return adddate;
    }

    public void setAdddate(String adddate) {
        this.adddate = adddate;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
