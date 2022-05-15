import java.rmi.*;
import java.util.*;

public interface InterfaceRMI extends Remote {
    //metodi di modifica del db
    //restituiscono solamente true/false se operazione riuscita/fallita
    public boolean addCentroVaccinale(CentroVaccinale centro) throws RemoteException;//funzionante
    public boolean addCittadinoVaccinato(CittadinoVaccinato cittadino) throws RemoteException;//funzionante
    public boolean addCittadinoRegistrato(CittadinoRegistrato cittadinoR) throws RemoteException; //funzionante (ma migliorabile)
    public boolean addEventiAvversi(EventiAvversi eventi) throws RemoteException;

    //metodi lettura db
    //restiuiscono dei valori che cittadino deve leggere
    public String visualizzaInfoCentroVaccinale(CentroVaccinale centro) throws RemoteException; //non funziona
    public ArrayList<CentroVaccinale> cercaCentroVaccinale(String nomeCV) throws RemoteException; //non funziona
    public String cercaCentroVaccinale(String comune, String tipologia) throws RemoteException;
}