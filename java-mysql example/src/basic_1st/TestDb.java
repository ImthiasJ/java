package basic_1st;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.jdbc.PreparedStatement;

//import com.sun.corba.se.impl.util.Version;

public class TestDb {

public static void main(String[] args) {
    Connection con = null;
    java.sql.PreparedStatement st = null;
    ResultSet rs = null;
    String url = "jdbc:mysql://localhost:3306/sample";
    String user = "root";
    String password = "";
    try {
        con = DriverManager.getConnection(url, user, password);
        //st = con.createStatement();
        String[] ar= {"sample1","sample2","sample3","sample4"};
        String[] myout=new String[ar.length];
        String sampleQuery="select * from sample where upper(name) = ?";
        st=con.prepareStatement(sampleQuery);
        //st.setInt(1, 100);
        for(int i=0;i<ar.length;i++)
        {
        	st.setString(1, ar[i].toUpperCase());
        
        System.out.println(st.toString());
        rs=st.executeQuery();
        while(rs.next())
        {
        	myout[i]=String.valueOf(rs.getInt(1));
        	//System.out.println(rs.getInt(1)+"   "+rs.getString(2));
        }
        }
        for(int j=0;j<ar.length;j++)
        	System.out.println(myout[j]);
        
            } catch (SQLException ex) {
       //Logger lgr = Logger.getLogger(Version.class.getName());
      //  lgr.log(Level.SEVERE, ex.getMessage(), ex);

    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }

        } catch (SQLException ex) {
				/*
				 * Logger lgr = Logger.getLogger(Version.class.getName());
				 * lgr.log(Level.WARNING, ex.getMessage(), ex);
				 */
        }
    }
 }
}