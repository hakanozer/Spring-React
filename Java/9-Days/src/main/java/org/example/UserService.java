package org.example;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    // user Login
    /*
    public boolean userLogin( String email, String  password ){
        boolean status = false;
        DB db = new DB();
        try {
            String sql = "SELECT * FROM users WHERE email = '"+email+"' and password = '"+password+"'";
            System.out.println( sql );
            Statement st = db.conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            status = rs.next();
        }catch (Exception ex) {
            System.err.println("userLogin Error : " + ex);
        }finally {
            db.close();
        }
        return status;
    }
     */

    public boolean userLogin( String email, String  password ){
        boolean status = false;
        DB db = new DB();
        try {
            String sql = "SELECT * FROM users WHERE email = ? and password = ?";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setString(1, email);
            pre.setString(2, password);
            ResultSet rs = pre.executeQuery();
            status = rs.next();
        }catch (Exception ex) {
            System.err.println("userLogin Error : " + ex);
        }finally {
            db.close();
        }
        return status;
    }

    // all users
    public List<User> allUser() {
        List<User> ls = new ArrayList();
        DB db = new DB();
        try {
            String sql = "select * from users";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while( rs.next() ) {
                int uid = rs.getInt("uid");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String date = rs.getString("date");
                User user = new User(uid, name, surname, email, password, date);
                ls.add(user);
            }
        }catch (Exception ex) {
            System.err.println( "allUser Error : " + ex );
        }finally {
            db.close();
        }
        return ls;
    }

    // user
    // insert
    // delete
    // update

    // sample insert
    // note
    // title, detail
    public int save( String title, String detail ) {
        int status = 0;
        DB db = new DB();
        try {
            String sql = "insert into note( null, ?, ? )";
            PreparedStatement pre = db.conn.prepareStatement(sql);
            pre.setString(1, title);
            pre.setString(2, detail);
            status = pre.executeUpdate(); // etkilenen satır sayısı
        }catch (Exception ex) {
            System.err.println("Save Error : " + ex);
        }finally {
            db.close();
        }
        return status;
    }

}
