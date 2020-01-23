
import krypto.*; //Importerer krypto.jar

public class Telegrafist implements Runnable{ //Telegrafist implementerer Runnable
    private Kanal kanal; //Referanse til kanalen som telegrafisten skal lytte paa
    private int kanalId; //kanalen sin ID
    private int sekvensNummer; //sekvensnummeret telegrafisten gir meldingene
    private Monitor kryptertMonitor; //referanse til monitoren for krypterte meldinger

    Telegrafist(Kanal kanal, int kanalId, Monitor kryptertMonitor){
        this.kanal = kanal;
        this.kanalId = kanalId;
        this.kryptertMonitor = kryptertMonitor;
        sekvensNummer = 0;
    }

    public void run(){ //run metoden som kjoeres naar traaden startes. Finner meldinger og legger de til i listen
        String m = kanal.lytt(); //Henter melding
        while (m != null){ //saa lenge m ikke er null
            Melding melding = new Melding(m, kanalId, sekvensNummer++); //lager ny melding
            kryptertMonitor.settInn(melding); //setter inn ny melding
            m = kanal.lytt(); //Henter neste melding
        }
        Oblig6.telegrafistAvsluttet(); //teller ned antall aktive telegrafister
    }
}