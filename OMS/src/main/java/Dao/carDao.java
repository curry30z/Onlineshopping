package Dao;

import bean.car;
import bean.goods;
import bean.item;
import bean.user;
import common.DbUtil2;

import java.util.ArrayList;
import java.util.List;

public class carDao {
    private DbUtil2 db=new DbUtil2();
    private goods g =  new goods();

    /**
     * 添加购物车
     * @param userid
     * @param goodsid
     * @param amount
     * @return
     */
    public int addCar(int userid, int goodsid,int amount) {
        int rs=-1;
        String sql = "insert into car(userid, goodsid, amount) values (?,?,?)";
        List p=new ArrayList();
        p.add(userid);
        p.add(goodsid);
        p.add(amount);
        rs=db.genericDML(sql,p);

        return  rs;
    }

    /**
     * 查找已经添加的商品
     * @param userid
     * @param goodsid
     * @return
     */
    public  List<car> SelectByUseridAndGoodsId(int userid,int goodsid){

        String sql="select  * from car where userid=? and goodsid=?";

        List p=new  ArrayList();
        p.add(userid);
        p.add(goodsid);
        List<car> list=db.genericQuery(sql,p, car.class);

        return list;

    }


    /**
     * 购物车更新
     * @param userid
     * @param goodsid
     * @param amount
     * @return
     */
    public int updateCarById(int userid,int goodsid,int amount) {

        int rs=-1;
        String sql = "update car set amount=amount+? where userid=? and goodsid=?";
        List p=new ArrayList();
        p.add(amount);
        p.add(userid);
        p.add(goodsid);



        rs=db.genericDML(sql,p);

        return  rs;
    }

    /**
     * 删除购物车
     * @param userid
     * @param goodsid
     * @param amount
     * @return
     */
    public int deleteCarByUserid(int userid,int goodsid,int amount) {

        int rs=-1;
        String sql = "delete from car  where userid=? and goodsid=?";
        List p=new ArrayList();
        p.add(amount);
        p.add(userid);
        p.add(goodsid);

        rs=db.genericDML(sql,p);

        return  rs;
    }

    /**
     * 通过id删购物车
     * @param id
     * @return
     */
    public int deleteCarById(int id) {

        int rs=-1;
        String sql = "delete from car  where id=?";
        List p=new ArrayList();
        p.add(id);
        rs=db.genericDML(sql,p);
        return  rs;

    }
















    /**
     * 通过用户检索购物车
     * @param id
     * @return
     */

    public List<car> SelectById(int id)  {
        String sql="select c.id,c.userid,c.goodsid,c.amount,g.gname,g.price,g.picturename,g.discount from car as c inner join goods g on c.goodsid = g.id inner join user u on c.userid = u.id where u.id=?";

        List p=new  ArrayList();
        p.add(id);
        List<car> list=db.genericQuery(sql,p, car.class);




        return list;

    }

















  public static void main(String[] args){

        carDao dao=new carDao();
       List<car> rs=dao.SelectById(14);
        System.out.println(rs);



  }

























}
