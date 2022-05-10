import java.rmi.*;

public interface InterfaceRMI extends Remote {
    public boolean addCentroVaccinale(CentriVaccinali centro) throws RemoteException;
    public boolean addCittadinoVaccinato(CittadiniVaccinati cittadino) throws RemoteException;
    public boolean addCittadinoRegistrato(CittadiniRegistrati cittadinoR) throws RemoteException;
    public boolean addEventiAvversi(EventiAvversi eventi) throws RemoteException;
}
