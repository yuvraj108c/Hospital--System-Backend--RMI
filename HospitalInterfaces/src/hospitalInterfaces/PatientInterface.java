package hospitalInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import org.json.JSONException;

public interface PatientInterface extends Remote {
    public String getAllPatients() throws RemoteException, SQLException, JSONException;

    public boolean createPatient(String fname, String lname, String phone, String address, String dob, String gender)
            throws RemoteException, SQLException;
}
