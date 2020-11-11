package hospitalInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PatientInterface extends Remote {
    public String getAllPatients() throws RemoteException;

    public boolean createPatient(String fname, String lname, String phone, String address, String dob, String gender)
            throws RemoteException;
}
