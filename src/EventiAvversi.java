public class EventiAvversi {
    private CittadiniRegistrati cittadino;
    private int valoreMalDiTesta;
    private int valoreFebbre;
    private int valoreDolori;
    private int valoreLinfoadenopatia;
    private int valoreTachicardia;
    private int valoreCrisiI;

    EventiAvversi(CittadiniRegistrati cittadino, int testa, int febbre, int dolori, int linfoadenopatia, int tachicardia, int crisi){
        this.cittadino=cittadino;
        this.valoreMalDiTesta=testa;
        this.valoreFebbre=febbre;
        this.valoreDolori=dolori;
        this.valoreLinfoadenopatia=linfoadenopatia;
        this.valoreTachicardia=tachicardia;
        this.valoreCrisiI=crisi;

    }
}
