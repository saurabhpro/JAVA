package BlobClob.image;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;

/**
 * Created by Saurabh on 1/17/2016.
 */
public class ImageRetrieveBlob {
    static String path = "C:\\Users\\Saurabh\\Documents\\GitHub\\JAVA\\JavaCon\\JDBC\\src\\BlobClob\\image";

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");

        PreparedStatement pstmt = conn.prepareStatement("SELECT img FROM empimage WHERE name = ?");
        pstmt.setString(1, "babyRaj");

        ResultSet rs = pstmt.executeQuery();

        rs.next();

        InputStream inp = rs.getBinaryStream("img");
        FileOutputStream fos = new FileOutputStream(path + "\\newImage.png");

        int i = 0;
        while ((i = inp.read()) != -1)
            fos.write(i);
    }
}
