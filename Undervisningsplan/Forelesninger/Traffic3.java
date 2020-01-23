import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Traffic3 extends JFrame 
       implements ActionListener, ItemListener {

  /* The fourth Traffic Light program
   *                              by J M Bishop Oct 1996
   *             Java 1.1 version by T Abbott Oct 1997
   *         enhanced and revised by J M Bishop Oct 1997
   * Enables the different lengths of lights
   * entered as durations to be used in
   * practice.
   */
    
    private JPanel area;
    private int lightsPosition = 105;
    private static final int lightsWidth = 150;
    private SetOfLights[] lights = new SetOfLights[3];
    private int nLights = 0, setWanted = 0;
    private JTextField duration;
    private JComboBox colours;
    private int light;
    private JButton newSetButton;
    private JButton walkButton;
    private JButton closeButton;

    public Traffic3() {
      setTitle("Traffic Lights Version 3");
      
      add("North",new Label ("Traffic Light Simulation",Label.CENTER));

      area = new JPanel();
      area.addMouseListener(new MouseEvtHandler());
      add("Center",area);

      JPanel buttons = new JPanel();
        newSetButton = new JButton("New Set");
          newSetButton.addActionListener(this);
          buttons.add(newSetButton);
        colours = new JComboBox();
          colours.addItem("Red");
          colours.addItem("Green");
          colours.addItem("Yellow");
          colours.addItem("Walk");
		  colours.setEditable(false);
          colours.addItemListener(this);
          light = 0;
          buttons.add(colours);

        buttons.add(new JLabel("Duration"));

        duration = new JTextField("", 4);  
          duration.addActionListener(this);
          buttons.add(duration);
        walkButton = new JButton("Walk");
          walkButton.addActionListener(this);
          buttons.add(walkButton);
        closeButton = new JButton("Close");
          closeButton.addActionListener(this);
          buttons.add(closeButton);
        add("South",buttons);
    }

    public void itemStateChanged(ItemEvent e) {
        String s = (String) e.getItem();
        if (s=="Red")    {light = 0;} else
        if (s=="Green")  {light = 1;} else
        if (s=="Yellow") {light = 2;} else
        if (s=="Walk")   {light = 3;}
    }

    class MouseEvtHandler extends MouseAdapter {
      public void mousePressed(MouseEvent e) {
        int n = e.getX() / lightsWidth;
        if (n < nLights)
        setWanted = n;
      }
    }

    public void actionPerformed(ActionEvent e) {
      Object event = e.getSource();
      if (event == newSetButton) {
        lights[nLights] = new SetOfLights(area, lightsPosition);
        lights[nLights].start();
        lightsPosition += lightsWidth;
        nLights++;
        if (nLights == 3)
        newSetButton.setEnabled(false);
      } else if (event == walkButton) {
        lights[setWanted].walk = true;
      } else if (event == duration) {
        lights[setWanted].time[light]=
          Integer.parseInt(duration.getText());
          duration.setText("");
          repaint();
      } else if (event == closeButton) {
      //  for (int i = 0; i<nLights; i++) 
      //    lights[i].stop();
        setVisible(false);
        dispose();
        System.exit(0); 
      }
    }

    public static void main(String[] args) {
      JFrame f = new Traffic3();
      f.setSize(500, 210);
      f.setVisible(true);
      f.addWindowListener(new WindowAdapter () {
        public void windowClosing(WindowEvent e) {  
          System.exit(0);
        }
      });
    }


  class SetOfLights extends Thread {

    private int red = 0;
    private JPanel area;
    private int x;
    private int light;

    // public variables
    boolean walk = false;
    boolean walkOn = false;
    int time [] = {500, 500, 500, 500};

    public SetOfLights(JPanel c, int x) {
      area = c;
      this.x = x;
    }

    public void run() {
      while (true) {
        for (int light = 0; light < 3; light++) {
          if (light == red & walk) {
            walkOn = false;
            for (int i = 0; i < 11; i++) {
              draw(light);
              try { sleep(time[3]);} 
              catch (InterruptedException e) { }
              walkOn = !walkOn;
            }
            walk = false;
          } else {
            draw(light);
            try { sleep(time[light]); } 
            catch (InterruptedException e) { }
          }
        }
      }
    }

    void draw(int light) {
      Graphics g = area.getGraphics();
      g.setColor(Color.black);
      g.drawOval(x-8, 10, 30, 68);
      g.setColor(Color.cyan);
      g.fillRect(x-90,10,70,100);
      g.setColor(Color.black);
      g.drawString(""+time[0], x-70, 28);
      g.drawString(""+time[2], x-70, 48);
      g.drawString(""+time[1], x-70, 68);
      g.drawString(""+time[3], x-70, 98);

      switch (light) {
        case 0: 
          g.setColor(Color.red);
          g.fillOval(x, 15, 15, 15);
          g.setColor(Color.lightGray);
          g.fillOval(x, 35, 15, 15);
          g.fillOval(x, 55, 15, 15);
          break;
        case 1: 
          g.setColor(Color.green);
          g.fillOval(x, 55, 15, 15);
          g.setColor(Color.lightGray);
          g.fillOval(x, 15, 15, 15);
          g.fillOval(x, 35, 15, 15);
          break;
        case 2: 
          g.setColor(Color.yellow);
          g.fillOval(x, 35, 15, 15);
          g.setColor(Color.lightGray);
          g.fillOval(x, 15, 15, 15);
          g.fillOval(x, 55, 15, 15);
          break;
      }

      if (light == red & walk) {
        if (walkOn) 
          g.setColor(Color.green);
        else 
          g.setColor(Color.white);
        g.fillOval(x+1, 85, 14, 14);
      } else {
        g.setColor(Color.black);
        g.drawOval(x, 85, 15, 15);
      }
    }
  }
}



