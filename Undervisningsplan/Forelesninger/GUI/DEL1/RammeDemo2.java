import javax.swing.*;
import java.awt.*;

class RammeDemo2 extends JFrame {
    RammeDemo2() {
	    super("Foerste vindu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(300,200);
		setVisible(true);
	}
	public static void main(String[] args) {
	    new RammeDemo2();
	}
}