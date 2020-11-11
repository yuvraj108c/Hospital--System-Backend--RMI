package hospitalImplementations;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class server {
    public static void main(String[] args) {
        try {
            Registry r = LocateRegistry.createRegistry(1099);
            PatientImplementation patient = new PatientImplementation();
            Naming.rebind("PatientService", patient);
            System.out.println("Server is ready.");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}