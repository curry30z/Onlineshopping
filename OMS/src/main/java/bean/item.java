package bean;

public class item {

    private  int id;//类别id


    private String name;//类别名称

    @Override
    public String toString() {
        return "item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", itemdesc='" + itemdesc + '\'' +
                '}';
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

    public String getItemdesc() {
        return itemdesc;
    }

    public void setItemdesc(String itemdesc) {
        this.itemdesc = itemdesc;
    }

    public item(){

    }
    public item(int id, String name, String itemdesc) {
        this.id = id;
        this.name = name;
        this.itemdesc = itemdesc;
    }

    private  String itemdesc;//类别描述






}
