package hospitalImplementations;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;

import realtimespecialtreatmentinterface.RealTimeSpecailTreatmentInterface;

public class server {
    public static void main(String[] args) throws NotBoundException {
        try {
            int PORT = 1099;
            System.setProperty("java.rmi.server.hostname", "192.168.43.216");
            Registry r = LocateRegistry.createRegistry(PORT);
            Connection conn = Database.getConnection();

            PatientImplementation patient = new PatientImplementation(conn);
            CheckupImplementation checkup = new CheckupImplementation(conn);
            UserImplementation user = new UserImplementation(conn);
            SpecialTreatmentImplementation specialTreatment = new SpecialTreatmentImplementation(conn);

            Naming.rebind("PatientService", patient);
            Naming.rebind("CheckupService", checkup);
            Naming.rebind("UserService", user);
            Naming.rebind("SpecialTreatmentService", specialTreatment);

            System.out.println("Server is ready on port: " + PORT);

        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}