package appPack;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String url = "jdbc:mysql://localhost/javaspring";
    private final String userName = "root";
    private final String userPass = "";

    public Connection conn = null;

    public DB() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userName, userPass);
            if ( !conn.isClosed() ) {
                System.out.println("Connection Success");
            }
        }catch (Exception ex) {
            System.err.println("Connection Error : " + ex );
        }
    }


    // close connection
    public void close() {
        try {
            if ( conn != null && !conn.isClosed() ) {
                conn.close();
                conn = null;
                System.out.println("Connetion Closed");
            }
        }catch (Exception ex) {
            System.err.println("Close Error : " + ex);
        }
    }


}
