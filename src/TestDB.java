import java.sql.*;

public class TestDB {

    public static void main(String[] args) throws SQLException {
        Database db = Database.getInstance();
        DataTables dt = new DataTables();

        ResultSet centriVaccinali = db.submitQuery("SELECT * FROM CentriVaccinali");
        System.out.println(centriVaccinali);
        dt.handleCentriVaccinaliSet(centriVaccinali);

        for(CentriVaccinali cv: dt.getCentriVaccinaliTable()) { //per ogni studente S contento in ...
            System.out.println(cv);
        }
    }
}