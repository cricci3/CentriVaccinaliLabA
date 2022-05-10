import java.util.*;

public class CittadiniRegistrati extends CittadiniVaccinati {
    public String email;
    public String username;
    public String password;

    CittadiniRegistrati(String nome, String cognome, String nomeCV, String cf, Date data, String nomeV, int id, String email, String username, String password) {
        super(nome, cognome, nomeCV, cf, data, nomeV, id);
        this.email = email;
        this.username= username;
        this.password = password;
    }

    public String getEmail() {
        return this.email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    @Override
    public String toString() {
        return "Cittadino Registrato -> nome: "+nome+", cognome: "+cognome+", nomeCV: "+nomeCV+", cf: "+cf+", dataVaccinazione: "+dataVaccinazione+", nomeVaccino: "+nomeVaccino+", idUnivoco: "+idUnivoco+"email: "+email+", username: "+username+", password: "+password;
    }
}
