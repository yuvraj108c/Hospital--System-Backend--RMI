package hospitalClient;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.SQLException;

import org.json.JSONException;

import hospitalInterfaces.UserInterface;
import hospitalInterfaces.PatientInterface;
import hospitalInterfaces.SpecialTreatmentInterface;
import hospitalInterfaces.CheckupInterface;

public class client {

	public static void main(String[] args) throws NotBoundException, SQLException, JSONException {
		try {
			Registry r = LocateRegistry.getRegistry("127.0.0.1", 1099);
			String result = "";
			Boolean result2 = false;

			PatientInterface patient = (PatientInterface) r.lookup("PatientService");
			result = patient.getAllPatients();
			// result2 = patient.createPatient("Sara", "Croft", "123123", "curepiep",
			// "2020-12-24", "male");

			UserInterface user = (UserInterface) r.lookup("UserService");
			// result = user.getAllDoctors(1);
			// result = user.login("ent@gmail.com", "12345");

			CheckupInterface checkup = (CheckupInterface) r.lookup("CheckupService");
			// result = checkup.getCheckups("complete",2);
			// result2 = checkup.createCheckup(1, 2, "Bad vente", "2020-12-24");
			// result2 = checkup.updateCheckup(27, "new diagnosis", "incomplete");

			SpecialTreatmentInterface specialTreatment = (SpecialTreatmentInterface) r
					.lookup("SpecialTreatmentService");
			// result = specialTreatment.getPatientsForSpecialTreatment(1,"incomplete");
			// result = specialTreatment.getCheckupForSpecialTreatment(36);
			// result2 = specialTreatment.createSpecialTreatment(26, "2021-12-24", 1);
			// result2 = specialTreatment.updateSpecialTreatment(37, "new treatment", 2, "complete");

			System.out.println(result);
			System.out.println(result2);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
