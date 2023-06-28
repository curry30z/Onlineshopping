package bean;

public class detail {

    private  int id;//订单号
    private  int  order_id;//订单id
    private  int  goods_id;//商品id
    private double goods_price;//商品价格
    private  String amount;//商品数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrder_id() {
        return order_id;
    }

    public void setOrder_id(int order_id) {
        this.order_id = order_id;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
        this.goods_price = goods_price;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public detail(int id, int order_id, int goods_id, double goods_price, String amount) {
        this.id = id;
        this.order_id = order_id;
        this.goods_id = goods_id;
        this.goods_price = goods_price;
        this.amount = amount;
    }
}
