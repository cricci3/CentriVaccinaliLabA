import java.rmi.registry.*;
import java.util.*;

public class ClientRMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Registry registro = LocateRegistry.getRegistry(1099);
            InterfaceRMI stub = (InterfaceRMI) registro.lookup("CentriVaccinali");
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

            CentriVaccinali centro = new CentriVaccinali(nomeCV, tipologia, indirizzo, comune, cap, provincia);
            boolean response = stub.addCentroVaccinale(centro);
        } catch (Exception e) {
            e.printStackTrace();
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
