package hospitalClient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

import org.json.JSONException;

import hospitalInterfaces.PatientInterface;

public class client {

	public static void main(String[] args) throws NotBoundException, SQLException, JSONException {
		try {
			Registry r = LocateRegistry.getRegistry("127.0.0.1", 1099);
			PatientInterface patient = (PatientInterface) r.lookup("PatientService");
			System.out.println(patient.getAllPatients());
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
