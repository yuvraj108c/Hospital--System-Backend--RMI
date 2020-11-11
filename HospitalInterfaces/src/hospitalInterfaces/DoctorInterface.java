package hospitalInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import org.json.JSONException;

public interface DoctorInterface extends Remote {

    public String getAllDoctors(int dept_id) throws RemoteException, SQLException, JSONException;

}
