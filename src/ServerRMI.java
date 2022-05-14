import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.sql.*;

public class ServerRMI extends UnicastRemoteObject implements InterfaceRMI {
    private static final long serialVersionUID = 1L;
    //creo riferimenti al Database
    Database db;
    {
        try {
            db = Database.getInstance();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    DataTables dt = new DataTables();

    protected ServerRMI() throws RemoteException {
        super();
    }

    @Override
    public boolean addCentroVaccinale(CentriVaccinali cv){
        try{
        String query = "INSERT INTO centrivaccinali VALUES ('" + cv.getNome() + "','" + cv.getIndirizzo() + "','"
                + cv.getComune() + "','" + cv.getProvincia() + "','" + cv.getTipologia() + "','" + cv.getCap() + "')";
        db.submitQuery(query);


        query = "CREATE TABLE Vaccinati_"+cv.getNome()+" ("
                +"idcittadino NUMERIC(8) PRIMARY KEY,"
                +"nome VARCHAR(50) NOT NULL,"
                +"cognome VARCHAR(50) NOT NULL,"
                +"cf VARCHAR(16) NOT NULL,"
                +"dataVaccinazione DATE NOT NULL,"
                +"nomeVaccino VARCHAR(50) NOT NULL )";
        db.submitQuery(query);
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addCittadinoVaccinato(CittadiniVaccinati cittV) {
        String query = "INSERT INTO vaccinati_"+cittV.getNomeCV()+" VALUES ('" + cittV.getIdUnivoco() + "','" + cittV.getNome() + "','"
                + cittV.getCognome() + "','" + cittV.getCf() + "','" + cittV.getDataVaccinazione() + "','" + cittV.getNomeVaccino() + "')";
        try {
            db.submitQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean addCittadinoRegistrato(CittadiniRegistrati cittR) {
        String query = "INSERT INTO cittadini_registrati VALUES ('" + cittR.getIdUnivoco() + "','" + cittR.getNome() + "','"
                + cittR.getCognome() + "','" + cittR.getCf() + "','" + cittR.getEmail() + "','" + cittR.getUsername() + "',"+cittR.getPassword()+")";
        try {
            db.submitQuery(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean addEventiAvversi(EventiAvversi eventi) {
        CittadiniRegistrati cittadino = eventi.getCittadino();
        String query = "INSERT INTO eventiavversi VALUES ('" +cittadino.getIdUnivoco() + "','"
                + cittadino.getNomeCV() + "','" + eventi.getValoreFebbre() + "','" + eventi.getNotaFebbre() + "','" + eventi.getValoreMalDiTesta() + "',"+eventi.getNotaMdT()
                + eventi.getValoreDolori() + "','" + eventi.getNotaDolori() + "','" + eventi.getValoreLinfoadenopatia() + "','" + eventi.getNotaLinfoadenopatia() + "',"+eventi.getValoreTachicardia()
                + eventi.getNotaTachicardia() + "','" + eventi.getValoreCrisiI() + "','" + eventi.getNotaCrisiI() +")";
        try {
            db.submitQuery(query);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public String getInfoCentro(CentriVaccinali centro){
        String query = "SELECT febbre, avg(febbre) AS media FROM eventiavversi"+
                "WHERE nomeCV = "+centro.getNome()+
                "GROUP BY febbre";

        String informazione = null;
        try {
           ResultSet rs = db.submitQuery(query);
            DataTables dt = new DataTables();
            String media = dt.handleEventiAvversiSet(rs);
            informazione = centro.toString()+media;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return informazione;
    }

    public static void main(String[] args) {
        try {
            ServerRMI obj = new ServerRMI();
            Registry registro = LocateRegistry.createRegistry(1099);
            registro.rebind("CentriVaccinali",obj);
            System.out.println("Server ready");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
