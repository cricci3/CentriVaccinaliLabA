import java.util.*;

public class CittadiniVaccinati {
    public String nome;
    public String cognome;
    public String nomeCV;
    public String cf;
    public Date dataVaccinazione;
    public String nomeVaccino;
    public int idUnivoco;

    CittadiniVaccinati(String nome, String cognome, String nomeCV, String cf, Date data, String nomeV, int id){
        this.nome=nome;
        this.cognome=cognome;
        this.nomeCV=nomeCV;
        this.cf=cf;
        this.dataVaccinazione=data;
        this.nomeVaccino=nomeV;
        this.idUnivoco=id;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCognome() {
        return this.cognome;
    }

    public String getNomeCV() {
        return this.nomeCV;
    }

    public String getCf() {
        return this.cf;
    }

    public Date getDataVaccinazione() {
        return this.dataVaccinazione;
    }

    public String getNomeVaccino() {
        return this.nomeVaccino;
    }

    public int getIdUnivoco() {
        return this.idUnivoco;
    }

    @Override
    public String toString() {
        return "Cittadino Vaccinato -> nome: "+nome+", cognome: "+cognome+", nomeCV: "+nomeCV+", cf: "+cf+", dataVaccinazione: "+dataVaccinazione+", nomeVaccino: "+nomeVaccino+", idUnivoco: " + idUnivoco;
    }
}
