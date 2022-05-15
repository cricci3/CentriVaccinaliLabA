import java.rmi.registry.*;
import java.util.*;

public class ClientRMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Registry registro = LocateRegistry.getRegistry(1099);
            InterfaceRMI stub = (InterfaceRMI) registro.lookup("CentriVaccinali");

/*
            //prova per inserire centri vaccinali nel db
            System.out.println("inserire nome del centro vaccinale");
            String nomeCV = sc.nextLine();
            nomeCV.replaceAll(" ", "_");

            System.out.println("inserire l'indirizzo in forma via/via/corso nomeVia, numero");
            String indirizzo = sc.nextLine();

            System.out.println("inserire comune");
            String comune = sc.nextLine();

            System.out.println("inserire sigla della provincia");
            String provincia = sc.nextLine();

            System.out.println("inserire tipologia del centro vaccinale (hub/ospedale/aziendale)");
            String tipologia = sc.nextLine();

            System.out.println("inserire cap del comune");
            int cap = sc.nextInt();
            CentroVaccinale centro = new CentroVaccinale(nomeCV, indirizzo, comune, provincia, cap, tipologia);

            boolean response = stub.addCentroVaccinale(centro);
            if(response){
                System.out.println("OK centro aggiunto");
            }else
                System.out.println("PROBLEMA");

            //----------------------------------------------------------------------------------------------------------------------




            //prova per inserire un vaccinato nel db
            System.out.println("inserire nome del centro vaccinale in cui il cittadino viene vaccinato");
            String nomeCentro = sc.nextLine();

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

            System.out.println("inserire id cittadino"); //da implementare generazione casuale id a 8 cifre
            int id = sc.nextInt();

            CittadinoVaccinato cittadinoVaccinato = new CittadinoVaccinato(nomeCentro, id,nome,cognome,cf,data,nomeVaccino);
            boolean resp = stub.addCittadinoVaccinato(cittadinoVaccinato);

            if(resp){
                System.out.println("OK vaccinato aggiunto a vaccinati_"+nomeCentro);
            }else
                System.out.println("PROBLEMA");
            //---------------------------------------------------------------------------------------------------------------------


            //prova per inserire un registrato (già vaccinato) nel db
            System.out.println("inserire nome del centro vaccinale dove si è effettuata la registrazione");
            String nomeCentroV = sc.nextLine();

            System.out.println("inserire id cittadino"); //da implementare generazione casuale id a 8 cifre
            id = sc.nextInt();

            System.out.println("inserire nome cittadino");
            nome = sc.nextLine();

            System.out.println("inserire cognome");
            cognome = sc.nextLine();

            System.out.println("inserire cf");
            cf = sc.nextLine();

            System.out.println("inserire data");
            data = sc.nextLine();

            System.out.println("inserire nome vaccino");
            nomeVaccino = sc.nextLine();

            System.out.println("inserire email");
            String email = sc.nextLine();

            System.out.println("inserire username");
            String username = sc.nextLine();

            System.out.println("inserire password");
            String password = sc.nextLine();

            CittadinoRegistrato cittadinoRegistrato = new CittadinoRegistrato(nomeCentroV, id,nome,cognome,cf,data,nomeVaccino, email, username, password);
            response = stub.addCittadinoRegistrato(cittadinoRegistrato);

            if(response){
                System.out.println("OK registrato aggiunto a cittadini_registrati");
            }else
                System.out.println("PROBLEMA, cittadino già registrato");
            //------------------------------------------------------------------------------------------------------------------------------
            */

            //prova per inserire eventi avversi
            System.out.println("Inserire il proprio id");
            int id = sc.nextInt();

            System.out.println("inserire note testa [opzionale]");
            String noteMdT = sc.nextLine();

            System.out.println("inserire centro vaccinale");
            String nomeCentroV = sc.nextLine();

            System.out.println("inserire valore febbre");
            int febbre = sc.nextInt();
            System.out.println("inserire note febbre [opzionale]");
            String noteF = sc.nextLine();

            System.out.println("inserire valore testa");
            int testa = sc.nextInt();


            System.out.println("inserire valore dolori musc");
            int doloriM = sc.nextInt();
            System.out.println("inserire note dolori musc [opzionale]");
            String noteD = sc.nextLine();

            System.out.println("inserire valore linfo");
            int linfo = sc.nextInt();
            System.out.println("inserire note linfo [opzionale]");
            String noteL = sc.nextLine();

            System.out.println("inserire valore tachi");
            int tachi = sc.nextInt();
            System.out.println("inserire note tachic [opzionale]");
            String noteT = sc.nextLine();

            System.out.println("inserire valore crisi I");
            int crisiI = sc.nextInt();
            System.out.println("inserire note crisi [opzionale]");
            String noteC = sc.nextLine();


            EventiAvversi eventi = new EventiAvversi(id, nomeCentroV, febbre, noteF, testa, noteMdT, doloriM, noteD, linfo, noteL, tachi, noteT, crisiI, noteC);
            boolean response = stub.addEventiAvversi(eventi);

            if(response){
                System.out.println("eventi aggiunti correttamente");
            }else{
                System.out.println("errore in inserimento eventi");
            }

            /*
            //prova per cercare informazioni riguardo al centro + prospetto riassuntivo eventi avversi, NON FUNZIONA
            CentroVaccinale centroCercato = new CentroVaccinale("emilio", "via daverio", "daverio", "va", 21100, "hub");
            String risposta = stub.visualizzaInfoCentroVaccinale(centroCercato);
            System.out.println(risposta);
            //---------------------------------------------------------------------------------------------------------------------



            //prova per cercare tutti i centri contenenti nel nome la parola emilio
            System.out.println("cerco centri vaccinali contenenti nel nome la parola emilio");
            ArrayList<CentroVaccinale> arrayList = stub.cercaCentroVaccinale("emilio");

            //DataTables dt = new DataTables();
            //dt.handleCentriVaccinaliSet(rs);
            //return dt.getCentriVaccinaliTable();
            for(CentroVaccinale cv : arrayList)
                System.out.println(cv);
            //---------------------------------------------------------------------------------------------------------

             */
        } catch (Exception e) {
            e.printStackTrace();
        }


        //FINE MAIN
        }

}
