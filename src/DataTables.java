import java.sql.*;
import java.util.*;

public class DataTables {
    //permette di accedere al meccanismo dei cursori
    //permette di navigare tra le tuple come se fosse un DBMS
    private ArrayList<CentriVaccinali> centriVaccinaliTable;
    private ArrayList<CittadiniRegistrati> cittadiniRegistratiTable;
    private ArrayList<CittadiniVaccinati> cittadiniVaccinatiTable;
    private ArrayList<EventiAvversi> eventiAvversiTable;

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

}
