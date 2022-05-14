import java.sql.*;
import java.util.*;

public class DataTables {
    //permette di accedere al meccanismo dei cursori
    //permette di navigare tra le tuple come se fosse un DBMS
    private ArrayList<CentriVaccinali> centriVaccinaliTable;
    private ArrayList<CittadiniRegistrati> cittadiniRegistratiTable;
    private ArrayList<CittadiniVaccinati> cittadiniVaccinatiTable; //da implementare
    private ArrayList<EventiAvversi> eventiAvversiTable; //da implementare

    public DataTables() {
        this.centriVaccinaliTable = new ArrayList<CentriVaccinali>();
        this.cittadiniRegistratiTable = new ArrayList<CittadiniRegistrati>();
        this.cittadiniVaccinatiTable = new ArrayList<CittadiniVaccinati>();
        this.eventiAvversiTable = new ArrayList<EventiAvversi>();
    }

    public void handleCentriVaccinaliSet(ResultSet rs) throws SQLException {
        //rs.first(); //così handle iniziano da prima riga
        while(rs.next()) {
            CentriVaccinali cv = new CentriVaccinali(rs.getString("nome"),
                    rs.getString("indirizzo"),
                    rs.getString("comune"),
                    rs.getString("provincia"),
                    rs.getInt("cap"),
                    rs.getString("tipologia")
            );
            centriVaccinaliTable.add(cv);
        }
    }

    public ArrayList<CentriVaccinali> getCentriVaccinaliTable(){
        return this.centriVaccinaliTable;
    }

    public void handleCittadiniRegistratiSet(ResultSet rs) throws SQLException {
        //rs.first(); //così handle iniziano da prima riga
        while(rs.next()) {
            CittadiniRegistrati cittr = new CittadiniRegistrati(rs.getString("nome"),
                    rs.getString("cognome"),
                    rs.getString("nomeCV"),
                    rs.getString("cf"),
                    rs.getDate("data"),
                    rs.getString("nomeV"),
                    rs.getInt("id"),
                    rs.getString("email"),
                    rs.getString("username"),
                    rs.getString("password")
            );
            cittadiniRegistratiTable.add(cittr);
        }
    }

    public ArrayList<CittadiniRegistrati> getCittadiniRegistratiTable(){
       return this.cittadiniRegistratiTable;
    }


    public void handleCittadiniVaccinatiSet(ResultSet rs) throws SQLException {
        //rs.first(); //così handle iniziano da prima riga
        while(rs.next()) {
            CittadiniVaccinati cittv = new CittadiniVaccinati(rs.getString("nome"),
                    rs.getString("cognome"),
                    rs.getString("nomeCV"),
                    rs.getString("cf"),
                    rs.getDate("data"),
                    rs.getString("nomeV"),
                    rs.getInt("id")
            );
            cittadiniVaccinatiTable.add(cittv);
        }
    }

    public ArrayList<CittadiniVaccinati> getCittadiniVaccinatiTable(){
        return this.cittadiniVaccinatiTable;
    }


    public String handleEventiAvversiSet(ResultSet rs) throws SQLException{
        String risultato = null;
        while (rs.next()){
            risultato.concat(rs.getString("febbre"));
            risultato.concat(String.valueOf(rs.getInt("media")));
        }
        return risultato;
    }

    /*
    public void handleEventiAvversiSet(ResultSet rs) throws SQLException {
        //rs.first(); //così handle iniziano da prima riga
        while(rs.next()) {
            EventiAvversi eventi = new EventiAvversi((rs.getString("cittadino"),
                    rs.getString("testa"),
                    rs.getString("noteTesta"),
                    rs.getString("febbre"),
                    rs.getString("noteFebbre"),
                    rs.getString("dolori"),
                    rs.getString("noteDolori"),
                    rs.getString("linfoadenopatia"),
                    rs.getString("noteLinfo"),
                    rs.getString("tachicardia"),
                    rs.getString("noteTach"),
                    rs.getString("crisiI"),
                    rs.getString("noteCrisiI"));
            cittadiniVaccinatiTable.add(eventi);
        }
    }

    public ArrayList<EventiAvversi> getEventiAvversiTables(){
        return this.eventiAvversiTable;
    }
     */
}
