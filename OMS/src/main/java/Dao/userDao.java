package Dao;

import bean.user;
import common.DbUtil2;
import common.MD5;

import java.util.ArrayList;
import java.util.List;

public class userDao {
   private DbUtil2 db=new DbUtil2();
   private user u=new user();




public int isLogin(String username ,String password) {
    int result = -1;
    String sql = "select * from  user where name=? and pass=?";
    List list = new ArrayList();
    List p =new ArrayList();

    p.add(username);
    p.add(password);
    list=db.genericQuery(sql,p);
    if(list!=null){
        return list.size()-1;
    }








    return result;
}


public List<user> login(String name, String password){
    String sql = "select * from  user where name=? and pass=?";
    List params = new ArrayList();
    params.add(name);
    params.add(password);
  List<user> list= db.genericQuery(sql,params, user.class);

    db.closeConnection(db.getConn());

    return list;
}


    public List<user> SelectById(int id){
        String sql = "select * from  user where id=?";
        List params = new ArrayList();

        params.add(id);
        List<user> list= db.genericQuery(sql,params, user.class);



        return list;
    }














public  int add(user u){
    int rs=-1;
    List p=new ArrayList();
    String sql="insert into user(name,pass,sex,realname,phone,email,address,img)\n" +
            "values(?,?,?,?,?,?,?,?)";

    p.add(u.getName());
    p.add(u.getPass());
    p.add(u.getSex());
    p.add(u.getRealname());
    p.add(u.getPhone());
    p.add(u.getEmail());
    p.add(u.getAddress());
    p.add(u.getImg());
    rs=db.genericDML(sql,p);


return rs;
}

    /**
     * 通过关键字查询用户
     * @param key
     * @return
     */
 public List<user> SelectByKey( String key){

     String sql ;
     if(key==null&&key.equals("")){
         sql="select * from  user";
     }else {
         sql="select * from  user where name like ?";
     }


        key="%"+key+"%";

     List params = new ArrayList();
     params.add(key);
     List<user> list= db.genericQuery(sql,params, user.class);

     db.closeConnection(db.getConn());


    return list;
 }

    /**
     * 重置密码000000
     * @param id
     * @return
     */
 public int ResetToPassword(int  id ){
     int rs=-1;
     List p=new ArrayList();
     String sql = "update user set pass=? where id=?; ";
        p.add(new MD5().getMd5pwd("000000"));
        p.add(id);
     rs=db.genericDML(sql,p);



     return rs;

 }

 public  int DeleteToUser(int  id){
     int rs=-1;
     List p=new ArrayList();
     String sql = "delete from user where id=? ";

     p.add(id);
     rs=db.genericDML(sql,p);



     return rs;



 }














    /**
     * 修改密码
     * @param name
     * @param pass
     * @return
     */
 public  int ChangeToPassword( String name ,String pass){
     int rs=-1;
     List p = new ArrayList();
     String sql = "update user set pass=? where name=?";
     p.add(new MD5().getMd5pwd(pass));
     p.add(name);
     rs=db.genericDML(sql,p);



     return rs;
 }


    /**
     * 注销用户
     * @param name
     * @return
     */
    public  int AccountCancellation( String name){


    int rs=-1;
    List p=new ArrayList();
    String sql = "update user set statu='2' where name=?; ";

    p.add(name);
    rs=db.genericDML(sql,p);



    return rs;


}
    /**
     * 用户不可用
     * @param id
     * @return
     */
    public  int NOCancellation( int id){


        int rs=-1;
        List p=new ArrayList();
        String sql = "update user set statu='0' where id=?; ";

        p.add(id);
        rs=db.genericDML(sql,p);



        return rs;


    }







}
