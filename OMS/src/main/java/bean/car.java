package bean;

public class car {
    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }



    public car() {

    }

    private int id;//购物车编号
    private int userid;//用户id

    private  String gname;
    private  double price;


    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "car{" +
                "id=" + id +
                ", userid=" + userid +
                ", gname='" + gname + '\'' +
                ", price=" + price +
                ", picturename='" + picturename + '\'' +
                ", discount=" + discount +
                ", goodsid=" + goodsid +
                ", amount=" + amount +
                '}';
    }

    public car(int id, int userid, String gname, double price, String picturename, double discount, int goodsid, int amount) {
        this.id = id;
        this.userid = userid;
        this.gname = gname;
        this.price = price;
        this.picturename = picturename;
        this.discount = discount;
        this.goodsid = goodsid;
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPicturename() {
        return picturename;
    }

    public void setPicturename(String picturename) {
        this.picturename = picturename;
    }


    private  String picturename;
    private  double  discount;


    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(int goodsid) {
        this.goodsid = goodsid;
    }

    private int goodsid;//商品id

    public car(int id, int userid, int goodsid, int amount) {
        this.id = id;
        this.userid = userid;
        this.goodsid = goodsid;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    private int amount;//数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}



