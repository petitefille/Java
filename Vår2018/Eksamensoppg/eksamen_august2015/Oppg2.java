import java.util.HashMap; // Import er ikke viktig på eksamen

class VareRegister {
    // initialisering kan også gjøres i en konstruktør
    HashMap<String,Vare> alleVarer = new HashMap<String,Vare>();

    String leie(String varenavn) {
        Vare vare = alleVarer.get(varenavn);

        if (vare == null) {
            return "Beklager, finnes ikke";
        }
        else if (vare instanceof TilUtleie) {
            TilUtleie leieVare = (TilUtleie) vare;
            if (leieVare.erUtleid()) {
                return "Beklager, allerede utleid";
            }
            else {
                leieVare.leiUt();
                return "Vær så god, varen er din til leie";
            }
        }
        else {
            return "Beklager, denne leier vi ikke ut";
        }
    }

    String levereTilbake(String varenavn) {
        Vare vare = alleVarer.get(varenavn);

        if (vare == null) {
            return "Denne varen finnes ikke";
        }
        else if (vare instanceof TilUtleie) {
            TilUtleie leieVare = (TilUtleie) vare;
            if (leieVare.erUtleid()) {
                leieVare.leverTilbake();
                return "Takk for at du leverte tilbake";
            }
        }

        // Obs, sørg for at det alltid er en return
        return "Beklager, denne varen er ikke utleid";
    }
}
