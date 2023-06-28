package Dao;

import bean.goods;
import common.DbUtil2;

import java.util.ArrayList;
import java.util.List;

public class goodsDao {
    private DbUtil2 db=new DbUtil2();
    private  goods g =  new goods();

    /**
     * 无分页查询
     * @param goodsName
     * @param item
     * @return
     */
    public List<goods> SelectGoodsByGoodsAndItemId(String goodsName,String item) {
        String sql = "select g.id,g.goodsno,g.gname,g.price,g.picturename,g.seller,g.itemid,g.adddate,g.amount,g.`describe`\n" +
                ",g.status,g.discount,i.name as name  from goods as g left  join item i on g.itemid = i.id";
        //sql处理
        List params = new ArrayList();
        if(goodsName.equals("")&&item.length()>0){
            sql=sql+" where i.name like ? ";
            params.add("%"+item+"%");

        } else   if(goodsName.length()>0&&item.equals("")){
            sql=sql+" where g.gname like ?";
            params.add("%"+goodsName+"%");

        }else if (goodsName.length()>0&&item.length()>0){

            sql=sql+" where i.name like ? and g.gname like ? ";
            params.add("%"+item+"%");
            params.add("%"+goodsName+"%");

        }





        List<goods> list= db.genericQuery(sql,params, goods.class);

        db.closeConnection(db.getConn());

       return list;
    }


    public List<goods> SelectGoodsByPage(String goodsName,String item ,int page) {
        String sql = "select g.id,g.goodsno,g.gname,g.price,g.picturename,g.seller,g.itemid,g.adddate,g.amount,g.`describe`\n" +
                ",g.status,g.discount,i.name as name  from goods as g left  join item i on g.itemid = i.id";
        //sql处理
        List params = new ArrayList();
        if(goodsName.equals("")&&item.length()>0){
            sql=sql+" where i.name like ? ";
            params.add("%"+item+"%");

        } else   if(goodsName.length()>0&&item.equals("")){
            sql=sql+" where g.gname like ?";
            params.add("%"+goodsName+"%");

        }else if (goodsName.length()>0&&item.length()>0){

            sql=sql+" where i.name like ? and g.gname like ? ";
            params.add("%"+item+"%");
            params.add("%"+goodsName+"%");

        }

        sql=sql+" limit ?,6";
        params.add(page);





        List<goods> list= db.genericQuery(sql,params, goods.class);

        db.closeConnection(db.getConn());

        return list;
    }

    /**
     * 添加
     * @param g
     * @return
     */

    public int insertByGoods(goods g){
        int rs=-1;
        String sql ="insert into goods(goodsno, gname, price, amount, picturename, seller, itemid, adddate, discount, `describe`)\n" +
                "values (?,?,?,?,?,?,?,?,?,?);  ";
        List p=new ArrayList();
        p.add(g.getGoodsno());
        p.add(g.getGname());
        p.add(g.getPrice());
        p.add(g.getAmount());
        p.add(g.getPicturename());
        p.add(g.getSeller());
        p.add(g.getItemid());

        p.add(g.getAdddate());
        p.add(g.getDiscount());
        p.add(g.getDescribe());
        rs =db.genericDML(sql,p);

        return rs;
    }

    /**
     * 传入对象和id修改
     * @param g
     * @param id
     * @return
     */
    public int updateByGoods(goods g){
        int rs=-1;
        String sql ="update  goods set goodsno=?, gname=?, price=?, amount=?, picturename=?, " +
                "seller=?, itemid=?, adddate=?, discount=?, `describe`=? where id=?";
        List p=new ArrayList();
        p.add(g.getGoodsno());
        p.add(g.getGname());
        p.add(g.getPrice());
        p.add(g.getAmount());
        p.add(g.getPicturename());
        p.add(g.getSeller());
        p.add(g.getItemid());
        p.add(g.getAdddate());
        p.add(g.getDiscount());
        p.add(g.getDescribe());
        p.add(g.getId());
        rs =db.genericDML(sql,p);

        return rs;
    }








    /**
     * 删除商品
     * @param id
     * @return
     */

    public int deleteByGoodSno(int id){
        int rs=-1;
        String sql = "delete from goods where id=?";
        List p=new ArrayList();
        p.add(id);
        rs =db.genericDML(sql,p);


        return rs;



    }

    /**
     * 通过id下架商品
     * @param id
     * @return
     */
    public int setByGoodSno(int id){
        int rs=-1;
        String sql = "update goods set status =0 where id=?;";
        List p=new ArrayList();
        p.add(id);
        rs =db.genericDML(sql,p);


        return rs;



    }


    public List<goods> SelectGoodsByGoodSno(String goodSno) {
        String sql = "select g.id,g.goodsno,g.gname,g.price,g.picturename,g.seller,g.itemid,g.adddate,g.amount,g.`describe`\n" +
                ",g.status,g.discount,i.name as name  from goods as g left  join item i on g.itemid = i.id";
        //sql处理
        List params = new ArrayList();

        sql=sql+" where goodsno=?";
        params.add(goodSno);

        List<goods> list= db.genericQuery(sql,params, goods.class);

        db.closeConnection(db.getConn());

        return list;
    }




    public List<goods> SelectGoodsById(int id) {
        String sql = "select g.id,g.goodsno,g.gname,g.price,g.picturename,g.seller,g.itemid,g.adddate,g.amount,g.`describe`\n" +
                ",g.status,g.discount,i.name as name  from goods as g left  join item i on g.itemid = i.id";
        //sql处理
        List params = new ArrayList();

        sql=sql+" where g.id=?";
        params.add(id);

        List<goods> list= db.genericQuery(sql,params, goods.class);

        db.closeConnection(db.getConn());

        return list;
    }




    public List<goods> SelectGoods() {
        String sql = "select g.id,g.goodsno,g.gname,g.price,g.picturename,g.seller,g.itemid,g.adddate,g.amount,g.`describe`\n" +
                ",g.status,g.discount,i.name as name  from goods as g left  join item i on g.itemid = i.id";
        //sql处理


        List<goods> list= db.genericQuery(sql,null, goods.class);



        db.closeConnection(db.getConn());

        return list;
    }





















    public static void main(String[] args) {
                List<goods> list= new goodsDao().SelectGoods();
        System.out.println(list);



            }









}
