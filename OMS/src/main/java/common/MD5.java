package common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 获取密码的md5加密
 * 无论多长的密码最终的长度都会变16字节
 * 32字符的字符串
 * 不可逆
 *
 *
 */
public class MD5 {


    private String pwd;

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public MD5() {
        this.pwd = pwd;
    }


    public String getMd5pwd( String pwd) {
            this.pwd=pwd;
        try {
            MessageDigest md5=MessageDigest.getInstance("MD5");
            md5.update(pwd.getBytes());//计算md5函数 getBytes返回字符的编码的byte数组

            /**
             * digest返回的是8位的hash值
             * MD的哈希值是16位
             * 使用BigInteger函数吧8位转化为16为
             *
             *
             */
            String md5pwd= new BigInteger(1,md5.digest()).toString();
          //  String md5pw = String.valueOf(new BigInteger(1,md5.digest()));
            return md5pwd;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }

        return  null;

    }

    public String getSha1Pwd( String pwd) {
        this.pwd=pwd;
        try {
            MessageDigest md5=MessageDigest.getInstance("SHA-1");
            md5.update(pwd.getBytes());//计算Sha-1函数 getBytes返回字符的编码的byte数组


            String Sha1pwd= new BigInteger(1,md5.digest()).toString();
            //  String md5pw = String.valueOf(new BigInteger(1,md5.digest()));
            return Sha1pwd;

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }

        return  null;

    }

    /**
     *
     * 多次的加密增加加密的难度
     *
     * @param times
     * @param password
     * @return
     */

    public String gettimesMD5( int times,String password){
        String MD5Timepwd="";
        for(int i=1;i<=times;i++){

             MD5Timepwd = this.getMd5pwd(password);


        }


        return MD5Timepwd;
    }





    public  String getKeys( String password  ){


        String pwdandRand="";

       String rand= String.valueOf(Math.random());//生成随机字符串
        pwdandRand=this.getMd5pwd(password+rand)+rand;
        //将字符串和随机数一起返回 存入数据库







        return pwdandRand;
    }






    public static  void main(String[] args){


        String password="666666";
       System.out.println( new MD5().getMd5pwd(password));
        System.out.println( new MD5().getSha1Pwd(password));
        System.out.println( new MD5().getMd5pwd(new MD5().getMd5pwd(password)));

    }




}
