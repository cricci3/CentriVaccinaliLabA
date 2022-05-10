import java.sql.*;
import java.util.*;

public class TestDB {

    public static void main(String[] args) throws SQLException {
        Database db = Database.getInstance();
        DataTables dt = new DataTables();

        Scanner sc = new Scanner(System.in);

        //prova per inserire centri vaccinali nel db
        System.out.println("inserire nome del centro vaccinale");
        String nomeCV = sc.nextLine();

        System.out.println("inserire l'indirizzo in forma via/vial/corso nomeVia, numero");
        String indirizzo = sc.nextLine();

        System.out.println("inserire comune");
        String comune = sc.nextLine();

        System.out.println("inserire sigla della provincia");
        String provincia = sc.nextLine();

        System.out.println("inserire tipologia del centro vaccinale (hub/ospedale/aziendale)");
        String tipologia = sc.nextLine();

        System.out.println("inserire cap del comune");
        int cap = sc.nextInt();

        String query = "INSERT INTO CentriVaccinali VALUES "+
                "('"+nomeCV+"','"+indirizzo+"','"+comune+"','"+provincia+"','"+cap+"','"+tipologia+"')";

        db.submitQuery(query);

        String query2 = "CREATE TABLE Vaccinati_"+nomeCV+" ("
                +"idcittadino NUMERIC(8) PRIMARY KEY,"
                +"nome VARCHAR(50) NOT NULL,"
                +"cognome VARCHAR(50) NOT NULL,"
                +"cf VARCHAR(16) NOT NULL,"
                +"dataVaccinazione DATE NOT NULL,"
                +"nomeVaccino VARCHAR(50) NOT NULL )";
        db.submitQuery(query2);


        ResultSet centriVaccinali = db.submitQuery("SELECT nome FROM CentriVaccinali WHERE nome='emilio'");
        System.out.println(centriVaccinali);
        dt.handleCentriVaccinaliSet(centriVaccinali);

        for(CentriVaccinali cv: dt.getCentriVaccinaliTable()) { //per ogni studente S contento in ...
            System.out.println(cv);
        }

/*
        //prova per inserire un vaccinato nel db
        System.out.println("inserire nome del centro vaccinale in cui il cittadino viene vaccinato");
        String nomeCV = sc.nextLine();

        System.out.println("inserire nome cittadino");
        String nome = sc.nextLine();

        System.out.println("inserire cognome");
        String cognome = sc.nextLine();

        System.out.println("inserire cf");
        String cf = sc.nextLine();

        System.out.println("inserire data");
        String data = sc.nextLine();

        System.out.println("inserire nome vaccino");
        String nomeVaccino = sc.nextLine();

        System.out.println("inserire id cittadino");
        int id = sc.nextInt();

        String query = "INSERT INTO Cittadini VALUES "+
                "('"+nome+"','"+indirizzo+"','"+comune+"','"+provincia+"','"+cap+"','"+tipologia+"')";

        db.submitQuery(query);

        ResultSet centriVaccinali = db.submitQuery("SELECT * FROM CentriVaccinali");
        System.out.println(centriVaccinali);
        dt.handleCentriVaccinaliSet(centriVaccinali);

        for(CentriVaccinali cv: dt.getCentriVaccinaliTable()) { //per ogni studente S contento in ...
            System.out.println(cv);
        }
 */
    }
}