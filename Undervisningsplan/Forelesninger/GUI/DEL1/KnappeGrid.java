import javax.swing.*;
import java.awt.*;

class KnappeGrid {
	public static void main(String[] a) {
		JFrame ramme = new JFrame("Grid av knapper (JButton)");
		ramme.setSize(300, 300);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(5,5)); // 5 x 5 ruter
		
		JButton knapp1 = new JButton("1");
		knapp1.setBorder(BorderFactory.createMatteBorder(4,1,1,1,Color.black));
		
		JButton knapp2 = new JButton("2");
		knapp2.setBorder(BorderFactory.createMatteBorder(1,4,1,1,Color.black));
		
		JButton knapp3 = new JButton("3");
		knapp3.setBorder(BorderFactory.createMatteBorder(1,1,4,1,Color.black));
		
		JButton knapp4 = new JButton("4");
		knapp4.setBorder(BorderFactory.createMatteBorder(1,1,1,4,Color.green));
		
		JButton knapp5 = new JButton("5");
		knapp5.setBorder(BorderFactory.createMatteBorder(5,5,1,1,Color.red));
		
		knapp1.setFont(new Font("SansSerif", Font.BOLD, 48));
		knapp2.setFont(new Font("SansSerif", Font.BOLD, 48));
		knapp3.setFont(new Font("SansSerif", Font.BOLD, 48));
		knapp4.setFont(new Font("SansSerif", Font.BOLD, 48));
		knapp5.setFont(new Font("SansSerif", Font.BOLD, 48));
		
		panel.add(new JButton("1"));
		panel.add(knapp2);
		panel.add(new JButton("3"));
		panel.add(new JButton("4"));
		panel.add(new JButton("5"));
		
		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(knapp4);
		panel.add(new JButton("5"));
		
		panel.add(knapp1);
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("4"));
		panel.add(new JButton("5"));
		
		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(new JButton("3"));
		panel.add(new JButton("4"));
		panel.add(knapp5);
		
		panel.add(new JButton("1"));
		panel.add(new JButton("2"));
		panel.add(knapp3);
		panel.add(new JButton("4"));
		panel.add(new JButton("5"));
		
		ramme.add(panel);
		ramme.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ramme.setVisible(true);		
	}
}