package hospitalInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import org.json.JSONException;

public interface CheckupInterface extends Remote {
    public boolean createCheckup(Integer patientId, Integer doctorid, String reason, String date)
            throws RemoteException, SQLException;

    public String getCheckups(String status, int doctorid) throws RemoteException, SQLException, JSONException;
    
    public boolean updateCheckup(int checkupid, String diagnosis, String status) throws RemoteException, SQLException;
}
