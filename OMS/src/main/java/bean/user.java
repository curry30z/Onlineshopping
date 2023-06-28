package bean;

public class user {
    private int id;
    private String name;
    private String pass;
    private  String  sex;
    private  String realname;//真实姓名
    private  String phone;
    private  String email;
    private  String address;
    private  String statu;//状态

    public user(String name, String pass, String sex, String realname, String phone, String email, String address, String img) {
        this.name = name;
        this.pass = pass;
        this.sex = sex;
        this.realname = realname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.img = img;
    }

    @Override
    public String toString() {
        return "user{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                ", sex='" + sex + '\'' +
                ", realname='" + realname + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", statu='" + statu + '\'' +
                ", types='" + types + '\'' +
                ", img='" + img + '\'' +
                '}';
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    private  String types;//是否管理员
    private  String img;//图片地址

    public user(int id, String name, String pass, String sex, String realname, String phone, String email, String address, String statu, String types, String img) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.sex = sex;
        this.realname = realname;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.statu = statu;
        this.types = types;
        this.img = img;
    }

    public user() {

    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public user(String name, String pass, String sex, String realname, String phone, String email, String address) {
        this.name = name;
        this.pass = pass;
        this.sex = sex;
        this.realname = realname;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public user(String name, String pass) {
        this.name = name;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatu() {
        return statu;
    }

    public void setStatu(String statu) {
        this.statu = statu;
    }





}
