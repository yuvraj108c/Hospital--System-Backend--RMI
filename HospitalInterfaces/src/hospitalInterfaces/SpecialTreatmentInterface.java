package hospitalInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import org.json.JSONException;

public interface SpecialTreatmentInterface extends Remote {

    public String getPatientsForSpecialTreatment(int dept_id, String status)
            throws RemoteException, SQLException, JSONException;

    public String getCheckupForSpecialTreatment(int specialtreatment_id)
            throws RemoteException, SQLException, JSONException;

    public boolean createSpecialTreatment(int checkupid, String date, int departmentid)
            throws RemoteException, SQLException;

    public boolean updateSpecialTreatment(int specialtreatment_id, String givenTreatment, int specialist_id,
            String status) throws RemoteException, SQLException;

}
