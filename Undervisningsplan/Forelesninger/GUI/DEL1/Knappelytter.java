import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Knappelytter {
	public static void main(String[] a) {
		JFrame ramme = new JFrame("En lyttende knapp");
		ramme.setSize(300,200);
		JButton knapp = new JButton("Si <<hei>>");
		ramme.add(knapp);
		ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramme.setVisible(true);
		ActionListener knappelytter = new Lytter();
		knapp.addActionListener(knappelytter);
	}
}