package hospitalInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import org.json.JSONException;

public interface UserInterface extends Remote {

    public String login(String email, String password) throws RemoteException, SQLException, JSONException;

    public String MD5(String md5);
}
