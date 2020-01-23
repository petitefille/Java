import java.io.File;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.geometry.Pos;
import javafx.stage.FileChooser;
import javafx.geometry.Insets;

public class Oblig7 extends Application{ //Gjoer Oblig7 til en subklasse av Application

  private Stage hovedVindu;
  private int teller = 0;

  public static void main(String[] args) {
    launch(args);
  }


  @Override
  public void start(Stage vindu) throws Exception{
    this.hovedVindu = vindu;
    velgfFil();
    VBox vbox = new VBox();

    vindu.setTitle("Oblig 7 - jonasrol");
  }


  private void settScene(Scene scene){
    hovedVindu.setScene(scene);
    if(teller == 0){ //vinduet er sentrert kun paa starten og kan flyttes uten at den sentrerer seg igjen
      hovedVindu.centerOnScreen();
      teller++;
    }
    hovedVindu.show();
  }


  public void velgfFil(){
    File fil = null;
    FileChooser fc = new FileChooser();
    FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Labyrinter", "*.in");
    fc.getExtensionFilters().add(filter);
    fil = fc.showOpenDialog(hovedVindu);
    if(fil != null){
      velgRute(fil);
    }
  }


  public void velgRute(File fil){

    try{
      VBox vbox = new VBox();
      Scene velgRute = new Scene(vbox);
      Labyrint l = Labyrint.lesFraFil(fil);

      vbox.setSpacing(30);
      vbox.setPadding(new Insets(30, 30, 30, 30));
      //vbox.setAlignment(Pos.CENTER);

      Text overskrift = new Text("Velg en rute:");
      overskrift.setFont(Font.font("Arial", 20));

      GridPane lab = skrivLab(l);
      Button annenFil = new Button("Velg fil");
        annenFil.setOnAction(action -> {velgfFil();});
        annenFil.setMaxWidth(Double.MAX_VALUE);

      vbox.getChildren().addAll(overskrift, lab, annenFil);

      hovedVindu.sizeToScene();
      settScene(velgRute);
    }catch(FileNotFoundException fnfe){
      velgfFil();
    }
  }


  public GridPane skrivLab(Labyrint l){
    GridPane lab = new GridPane();
    lab.setStyle("-fx-background-color: BLACK;");
    boolean[][] boolskLab = l.lagBoolskLab();

    for(int i = 0; i < boolskLab.length; i++){
      for(int j = 0; j < boolskLab[i].length; j++){
        if (boolskLab[i][j]){
          int rad = i + 1;
          int kol = j + 1;
          Button rute = new Button(" ");
            rute.setMaxWidth(Double.MAX_VALUE);
            rute.setOnAction(action -> {loesLab(l, kol, rad);});
            lab.add(rute, j, i);
        }
        else{
          Rectangle rute = new Rectangle(0, 0, 28, 28);
            lab.add(rute, j, i);
        }
      }
    }
    return lab;
  }


  private void loesLab(Labyrint l, int kol, int rad){
    VBox vbox = new VBox();
    Scene loesLab = new Scene(vbox);

    vbox.setSpacing(30);
    vbox.setPadding(new Insets(30, 30, 30, 30));
    //vbox.setAlignment(Pos.CENTER);

    Text overskrift = new Text();
    String overskriftTekst = String.format("Loesning fra rute: (%2d, %2d)", kol, rad);
    overskrift.setText(overskriftTekst);
    overskrift.setFont(Font.font("Arial", 20));

    OrdnetLenkeliste<Utvei> utveier = (OrdnetLenkeliste<Utvei>) l.finnUtveiFra(kol, rad);

    if(utveier.storrelse() > 0){
      GridPane[] loesninger = new GridPane[utveier.storrelse()];

      int teller = 0;
      for(Utvei u : utveier){
        GridPane lab = new GridPane();
        lab.setStyle("-fx-background-color: BLACK;");

        boolean[][] boolskLab = l.lagBoolskLab();
        boolean[][] loestBoolskLab = losningStringTilTabell(u.hentVei(), l.hentKol(), l.hentRader());

        for(int i = 0; i < boolskLab.length; i++){
          for(int j = 0; j < boolskLab[i].length; j++){
            if(boolskLab[i][j]){
              int lRad = i + 1;
              int lKol = j + 1;

              Button rute = new Button(" ");
                rute.setMaxWidth(Double.MAX_VALUE);
                rute.setOnAction(action -> {loesLab(l, lKol, lRad);});
                lab.add(rute, j, i);

              if (loestBoolskLab[i][j]){
                  rute.setStyle("-fx-color: GREEN;");
              }
            }
            else{
              Rectangle rute = new Rectangle(0, 0, 28, 28);
                  lab.add(rute, j, i);
            }
          }
        }
        loesninger[teller] = lab;
        teller++;
      }

      vbox.getChildren().addAll(overskrift, loesninger[0]);
    }
    else{
      overskriftTekst = String.format("Ingen utveier fra denne ruten: (%2d, %2d)", kol, rad);
      overskrift.setText(overskriftTekst);

      GridPane tomLab = skrivLab(l);

      vbox.getChildren().addAll(overskrift, tomLab);
    }
    Button annenFil = new Button("Velg fil");
      annenFil.setOnAction(action -> {velgfFil();});
      annenFil.setMaxWidth(Double.MAX_VALUE);

    vbox.getChildren().addAll(annenFil);
    hovedVindu.sizeToScene();
    settScene(loesLab);
  }


  static boolean[][] losningStringTilTabell(String losningString, int bredde, int hoyde) {
    boolean[][] losning = new boolean[hoyde][bredde];
    java.util.regex.Pattern p = java.util.regex.Pattern.compile("\\(([0-9]+),([0-9]+)\\)");
    java.util.regex.Matcher m = p.matcher(losningString.replaceAll("\\s",""));
    while(m.find()) {
        int x = Integer.parseInt(m.group(1))-1;
        int y = Integer.parseInt(m.group(2))-1;
        losning[y][x] = true;
    }
    return losning;
  }
}