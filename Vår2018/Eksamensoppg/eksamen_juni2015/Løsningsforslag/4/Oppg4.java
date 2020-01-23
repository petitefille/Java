// Merk: Det er ikke nodvendig aa importere Java/JavaFX-biblioteker paa eksamen
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Oppgave 4a - klassen Skip
 */
class Skip {
	Hrute[][] brett;
	Hrute forsteRute;
	int lengde;
	public static int antallRuterMedSkip = 0;

	Skip (Hrute[][] brett, Hrute forsteRute, int lengde) {
		this.brett = brett;
		this.forsteRute = forsteRute;
		this.lengde = lengde;
		Skip.antallRuterMedSkip = Skip.antallRuterMedSkip + lengde;
	}
}

/**
 * Oppgave 4b - VSkip og HSkip
 */
class VSkip extends Skip {
	VSkip(Hrute[][] b, Hrute f, int l) {
		super(b, f, l);
		for(int i = f.rad; i < f.rad+l; i++) {
			b[i][f.kol].skipIRuta = this;
		}
	}
}

class HSkip extends Skip {
	HSkip(Hrute[][] b, Hrute f, int l) {
		super(b, f, l);
		for (int i = f.kol; i < f.kol+l ; i++) {
			b[f.rad][i].skipIRuta = this;
		}
	}
}

/**
 * Oppgave 4c - Hrute. Merk: Det er viktig aa forstaa at Hrute har tilgang
 * til metodene setImage og getImage fra ImageView
 */
class Hrute extends ImageView {
	Skip skipIRuta = null;
	int rad, kol;

	Hrute(int rad, int kol) {
		this.rad = rad;
		this.kol = kol;
	}
}

/**
 * Oppgave 4d
 */
public class Oppg4 extends Application {
	Hrute[][] ruter;
	Image skip = new Image("skip.png");
	Image hav = new Image("hav.png");
	int antallTreff = 0;
	int antallSkudd = 0;

	public void init() {
		ruter = EksternKlasse.lagHruteArray();
	}

	public void start(Stage s) {
		GridPane rutenett = new GridPane();

		for(int rad = 0; rad < 10; rad++) {
			for(int kol = 0; kol < 10; kol++) {
				ruter[rad][kol].setImage(hav);
				ruter[rad][kol].setOnMouseClicked(new RuteKlikk(ruter[rad][kol]));
				rutenett.add(ruter[rad][kol], kol, rad);
			}
		}

		s.setScene(new Scene(rutenett));
		s.show();
	}

	class RuteKlikk implements EventHandler<MouseEvent> {
		Hrute rute;

		RuteKlikk(Hrute rute) {
			this.rute = rute;
		}

		public void handle(MouseEvent e) {
			antallSkudd++;
			System.out.println(antallSkudd);
			if (rute.skipIRuta == null) return;
			if (rute.getImage() == skip) return;

			antallTreff++;
			rute.setImage(skip);

			if (Skip.antallRuterMedSkip == antallTreff) {
				System.out.println("Alle skip senket");
				System.out.println("Du brukte " + antallSkudd + " skudd");
			}
		}
	}

}

/**
 * Hjelpeklasse for å lage et Hrute-array. Skal ikke skrives i proveeksamen,
 * men er med her for aa ha et fungerende program
 */
class EksternKlasse {
	public static Hrute[][] lagHruteArray() {
		Hrute[][] hav = new Hrute[10][10];

		for(int rad = 0; rad < 10; rad++) {
			for(int kol = 0; kol < 10; kol++) {
				hav[rad][kol] = new Hrute(rad, kol);
			}
		}

		new HSkip(hav, hav[0][0], 2);
		new VSkip(hav, hav[0][7], 6);
		new HSkip(hav, hav[2][1], 4);
		new VSkip(hav, hav[4][3], 3);
		new VSkip(hav, hav[5][9], 4);
		new HSkip(hav, hav[8][5], 2);
		new HSkip(hav, hav[9][1], 3);

		return hav;
	}
}

