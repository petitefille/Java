import javax.swing.*;
import java.awt.*;

class Gui03 {
	public static void main(String[] a) {
		JFrame ramme = new JFrame("Ramme laget med klassen Gui03");
		ramme.setSize(700,400);
		
		JButton knapp = new JButton("Trykk her"); 
		JLabel etikett = new JLabel("Skriv inn navn");
		JTextField tekstfelt = new JTextField(30);
		JTextArea tekstvindu = new JTextArea(10,30);
		JScrollPane rullevindu = new JScrollPane(tekstvindu);
		
		JPanel panel = new JPanel();
		
		panel.add(knapp);
		panel.add(etikett);
		panel.add(tekstfelt);
		panel.add(rullevindu);
		    // tekstvindu er inne i rullevinduet
			
		ramme.add(panel); 
		ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramme.setVisible(true);
	}
}