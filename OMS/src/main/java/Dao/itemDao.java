package Dao;

import bean.goods;
import bean.item;
import common.DbUtil2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class itemDao {
    private DbUtil2 db=new DbUtil2();
    private goods g =  new goods();

    public int addItem(String name, String itemDesc) {
        int rs=-1;
        String sql = "insert into item(name,itemdesc) values (?,?)";
        List p=new ArrayList();
        p.add(name);
        p.add(itemDesc);
        rs=db.genericDML(sql,p);

        return  rs;
    }


    /**
     * 通过类别名找类别id
     * @param name
     * @return
     */
    public List<item> SelectByName(String name) throws SQLException {
        String sql="select  * from item where name like '%"+name+"%' ";

        Connection conn = db.getConn();
        Statement statement = conn.createStatement();
        ResultSet rs =statement.executeQuery(sql);

        List<item> list = new ArrayList<item>();
        while (rs.next()) {

            item a=new item();
           a.setId(rs.getInt("id"));
           a.setName(rs.getString("name"));
           a.setItemdesc(rs.getString("itemdesc"));


           list.add(a);

        }
        return list;

    }


    /**
     * 通过id找类别
     * @param id
     * @return
     * @throws SQLException
     */
    public List<item> SelectById(int id)  {
        String sql="select  * from item where id=?";

    List p=new  ArrayList();
    p.add(id);
    List<item> list=db.genericQuery(sql,p, item.class);




        return list;

    }


    public int deleteItemById(int id) {
        int rs=-1;
        String sql = "delete from item where id=?;";
        List p=new ArrayList();
        p.add(id);

        rs=db.genericDML(sql,p);

        return  rs;
    }


    public int updateItemById(int id,String name,String itemdesc) {

        int rs=-1;
        String sql = "update item set name=?,itemdesc=? where id=?";
        List p=new ArrayList();

        p.add(name);
        p.add(itemdesc);
        p.add(id);

        rs=db.genericDML(sql,p);

        return  rs;
    }




































    public static void main(String[] args)  throws SQLException {
        itemDao dao= new itemDao();

       int rs=dao.updateItemById(9,"r8y","ry");

        System.out.println(rs);




    }









}
