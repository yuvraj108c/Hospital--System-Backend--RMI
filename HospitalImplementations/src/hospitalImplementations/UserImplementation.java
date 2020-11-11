package hospitalImplementations;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import hospitalInterfaces.UserInterface;

public class UserImplementation extends UnicastRemoteObject implements UserInterface {
    protected Connection conn;

    protected UserImplementation() throws RemoteException {
        super();
        conn = Database.getConnection();
    }

    public String MD5(String md5) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(md5.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
        } catch (java.security.NoSuchAlgorithmException e) {
        }
        return null;
    }

    public String login(String email, String password) throws SQLException, JSONException {

        String query = "select users.*,department.name as dname from users,department where email = ? and password = ? and department.id = users.departmentid";

        PreparedStatement preparedStmt = this.conn.prepareStatement(query);
        preparedStmt.setString(1, email);
        preparedStmt.setString(2, MD5(password));

        ResultSet rs = preparedStmt.executeQuery();

        if (rs.next()) {
            return rs.getString("dname");
        }

        return "";
    }

}
