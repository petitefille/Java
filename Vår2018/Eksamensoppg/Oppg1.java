interface NavnOgPris {
    String hentNavn();
    double hentPris();
}

abstract class Vare implements NavnOgPris {
    String navn; // navn
    double pris; // nettopris

    public Vare(String navn, double pris) {
        this.navn = navn;
        this.pris = pris;
    }

    public String hentNavn() {
        return navn;
    }
}

abstract class Maskin extends Vare {
    int antHestekrefter; // motorkraft

    public Maskin(String navn, double pris, int antHestekrefter) {
        super(navn, pris);
        this.antHestekrefter = antHestekrefter;
    }
}

abstract class Verktøy extends Vare {
    int vekt;

    public Verktøy(String navn, double pris, int vekt) {
        super(navn, pris);
        this.vekt = vekt;
    }
}

interface TilUtleie {
    void leiUt();
    void leverTilbake();
    boolean erUtleid();
}

class MaskinerTilUtleie extends Maskin implements TilUtleie {
    boolean utleid = false;

    public MaskinerTilUtleie(String navn, double pris, int antHestekrefter) {
        super(navn, pris, antHestekrefter);
    }

    public void leiUt() {
        utleid = true;
    }

    public void leverTilbake() {
        utleid = false;
    }

    public boolean erUtleid() {
        return utleid;
    }

    public double hentPris() {
        return pris * 2;
    }
}

class MaskinerTilSalgs extends Maskin {
    public MaskinerTilSalgs(String navn, double pris, int antHestekrefter) {
        super(navn, pris, antHestekrefter);
    }

    public double hentPris() {
        return pris * 1.25;
    }
}

class VerktøyTilUtleie extends Verktøy implements TilUtleie {
    boolean utleid = false;

    public VerktøyTilUtleie(String navn, double pris, int vekt) {
        super(navn, pris, vekt);
    }

    public void leiUt() {
        utleid = true;
    }

    public void leverTilbake() {
        utleid = false;
    }

    public boolean erUtleid() {
        return utleid;
    }

    public double hentPris() {
        return pris * 1.5;
    }
}

class VerktøyTilSalgs extends Verktøy {
    public VerktøyTilSalgs(String navn, double pris, int vekt) {
        super(navn, pris, vekt);
    }

    public double hentPris() {
        return pris * 1.1;
    }
}
