import java.sql.*;
import java.io.*;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws SQLException {
        //insert("IBM", "IBM");
        File file = new File("C:\\Users\\223053315\\Desktop\\img3.jpg");
        insertImage(file);

    }

    private static void insert(String username, String password) throws SQLException {
        Connection con = sqlConnection.connection();
        PreparedStatement ps = null;

        try {
            String sql = "INSERT INTO login(username, password) VALUES(?,?) ";
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.execute();
            System.out.println("Your data has been inserted!");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                //assert ps != null;
                ps.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }

    }
    private static void insertImage(String path) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection con = sqlConnection.connection();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO pictures(pic) VALUES(?) ";
            String sql2 = "SELECT id FROM pictures ORDER BY id DESC LIMIT 1";
            ps = con.prepareStatement(sql);
            FileInputStream fis = new FileInputStream(path);
            ps.setBinaryStream(1, fis, fis.available());
            ps.execute();
            System.out.println("Your data has been inserted!");

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql2);
            int id = -1;
            while (resultSet.next()) {
               id = Integer.parseInt(resultSet.getString("id"));
            }
            String response = sc.next();
            if(response.equals("yes") || response.equals("YES") || response.equals("Yes")){
                deleteImage(id);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert ps != null;
                ps.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }

    }
    private static void deleteImage(int id) throws SQLException {
        Connection con = sqlConnection.connection();
        PreparedStatement ps = null;

        try {
            String sql = "delete from pictures where id = ? ";
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
            System.out.println("Your data has been deleted!");
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                assert ps != null;
                ps.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }

    // overload
    private static void insertImage(File file) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection con = sqlConnection.connection();
        PreparedStatement ps = null;
        try {
            String sql = "INSERT INTO pictures(pic) VALUES(?) ";
            String sql2 = "SELECT id FROM pictures ORDER BY id DESC LIMIT 1";
            ps = con.prepareStatement(sql);
            FileInputStream fis = new FileInputStream(file);
            ps.setBinaryStream(1, fis, fis.available());
            ps.execute();
            System.out.println("Your data has been inserted!");

            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery(sql2);
            int id = -1;
            while (resultSet.next()) {
                id = Integer.parseInt(resultSet.getString("id"));
            }
            String response = sc.next();
            if(response.equals("yes") || response.equals("YES") || response.equals("Yes")){
                deleteImage(id);
            }

        } catch (SQLException e) {
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                assert ps != null;
                ps.close();
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }

    }


}