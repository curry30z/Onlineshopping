package bean;

public class orders {

    private int id;//订单号
    private  String orderno;//订单编号
    private  int userid; //用户id
    private  String orderdate;//订单日期
    private String deliverydate;//发货日期
    private  String contactname;//收货人
    private  String address;//收货人地址
    private  double orderSum;//订单总额度
    private  String status;//订单状态
    private  String note;//备注
    private  String phone;//收货电话
    private  String receiverdate;//收货日期

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
    }

    public String getContactname() {
        return contactname;
    }

    public void setContactname(String contactname) {
        this.contactname = contactname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getOrderSum() {
        return orderSum;
    }

    public void setOrderSum(double orderSum) {
        this.orderSum = orderSum;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getReceiverdate() {
        return receiverdate;
    }

    public void setReceiverdate(String receiverdate) {
        this.receiverdate = receiverdate;
    }

    @Override
    public String toString() {
        return "orders{" +
                "id=" + id +
                ", orderno='" + orderno + '\'' +
                ", userid=" + userid +
                ", orderdate='" + orderdate + '\'' +
                ", deliverydate='" + deliverydate + '\'' +
                ", contactname='" + contactname + '\'' +
                ", address='" + address + '\'' +
                ", orderSum=" + orderSum +
                ", status='" + status + '\'' +
                ", note='" + note + '\'' +
                ", phone='" + phone + '\'' +
                ", receiverdate='" + receiverdate + '\'' +
                '}';
    }

    public orders(int id, String orderno, int userid, String orderdate, String deliverydate, String contactname, String address, double orderSum, String status, String note, String phone, String receiverdate) {
        this.id = id;
        this.orderno = orderno;
        this.userid = userid;
        this.orderdate = orderdate;
        this.deliverydate = deliverydate;
        this.contactname = contactname;
        this.address = address;
        this.orderSum = orderSum;
        this.status = status;
        this.note = note;
        this.phone = phone;
        this.receiverdate = receiverdate;
    }
}
