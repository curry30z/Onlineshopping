package common;

/**
 * 数据库公共类
 *
 * @author curry
 * @date 2023-4-10
 */

import java.sql.*;

public class DBUtil1 {

    private Connection cn;//连接数据库
    private Statement st;//发送完整sql
    private PreparedStatement pst;//预编译发送sql命令的陈诉
    private ResultSet rs;//结果集

    public DBUtil1() {
        String className = "com.mysql.jdbc.Driver";
        try {
            Class.forName(className);
        } catch (ClassNotFoundException e) {
            e.getStackTrace();
        }

    }

    public Connection getCn() {
        String url = "jdbc:mysql://localhost:3306/shop?characterEncoding=utf8";
        String user = "root";
        String password = "303030";
        try {
            cn = DriverManager.getConnection(url, user, password);
            return cn;
        } catch (SQLException e) {
            e.getStackTrace();
        } catch (NullPointerException e) {
            System.out.println("dddddd");
        }


        return cn;
    }
    public Connection getCns(String databaseName ,String use,String password1) {
        String url = "jdbc:mysql://localhost:3306/"+databaseName+"?characterEncoding=utf8";
        String user=use;
        String password =password1;
        try {
            cn = DriverManager.getConnection(url, user, password);
            return cn;
        } catch (SQLException e) {
            e.getStackTrace();
        } catch (NullPointerException e) {
            System.out.println("dddddd");
        }


        return cn;
    }

    public Statement getSt() {
        try {
            if (cn == null) {
                cn = this.getCn();
            }
            st = cn.createStatement();
            return st;
        } catch (SQLException e) {
            e.getStackTrace();
        } catch (NullPointerException e) {
            System.out.println("ccccc");
        }


        return st;
    }

    public PreparedStatement getPST(String sql) {
        try {
            if (cn == null) cn = getCn();
            pst = cn.prepareStatement(sql);
        } catch (SQLException e) {
            e.getStackTrace();
        }


        return pst;
    }

    /**
     * 4-执行sql命令(insert/update/delete)
     * @param sql
     * @return 放回影响的甘薯
     */
    public int executeUpdate(String sql) {
        int row = -1;//结果集 所影响的行数
        try {
            if (st == null) st = this.getSt();
            row = st.executeUpdate(sql);
        } catch (SQLException e) {
            e.getStackTrace();
        }


        return row;
    }

    public int executeUpdate() {
        int row = -1;
        try {
            if (pst == null) pst = this.getPST(null);
            row = pst.executeUpdate();
        } catch (SQLException e) {
            e.getStackTrace();
        }

        return row;
    }

    /**
     * 4-2执行sql命令（select）
     * @param sql
     * @return 返回结果集
     */
    public ResultSet executeQuery(String sql) {
        try {
            if (st == null) {
                st = this.getSt();
            }
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            e.getStackTrace();
        } catch (NullPointerException e) {
            System.out.println("BBBB");
        }


        return rs;

    }

    /**
     * 5-关闭结果集 关闭预编译的sql 关闭连接
     * @param
     * @return 无
     */

    public void closeDB() {


        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }
        try {
            if (pst != null) {
                pst.close();
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }

        try {
            if (st != null) {
                st.close();
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }

        try {
            if (cn != null) {
                cn.close();
            }
        } catch (SQLException e) {
            e.getStackTrace();
        }


    }


}
