package BlobClob.xml;

import java.io.*;
import java.sql.*;

/**
 * Created by Saurabh on 1/17/2016.
 */
public class JdbcXml {
    static String path = "C:\\Users\\Saurabh\\Documents\\GitHub\\JAVA\\JavaCon\\JDBC\\src\\BlobClob\\xml";

    public static void main(String[] args) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("connecting to the database...");

            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "system", "98989");
            Statement st = conn.createStatement();

            createXmlTable(st);

            //open a FileInputStream
            File f = new File(path + "\\simple.xml");
            long fileLength = f.length();
            FileInputStream fis = new FileInputStream(f);

            String SQL = "INSERT INTO XML_Data VALUES(?,?)";

            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, 200);
            pstmt.setAsciiStream(2, fis, fileLength);
            pstmt.execute();

            fis.close();

            SQL = "SELECT data FROM XML_Data WHERE id = 200";

            ResultSet rs = st.executeQuery(SQL);

            if (rs.next()) {
                InputStream xmlInputStream = rs.getAsciiStream(1);
                int c;

                ByteArrayOutputStream bos = new ByteArrayOutputStream();

                while ((c = xmlInputStream.read()) != -1)
                    bos.write(c);

                System.out.println(bos.toString());
            }

            rs.close();
            pstmt.close();
            st.close();
            conn.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createXmlTable(Statement st) throws SQLException {
        System.out.println("Creating XML_Data Table...");
        String streamingDataSQL = "CREATE TABLE XML_Data (id NUMBER, Data LONG)";

        try {
            st.executeUpdate("DROP TABLE XML_Data");
        } catch (SQLException ignored) {
        }

        st.executeUpdate(streamingDataSQL);
    }
}
