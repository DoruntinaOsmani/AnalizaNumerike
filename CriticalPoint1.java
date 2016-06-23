import javax.swing.*;
import java.text.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.Graphics;

public class CriticalPoint1 extends JFrame {

	public static double P, r, M1, M2, M3 ,M4, M5;
	
	public CriticalPoint1() {
		super("Diagrami");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Diagrami());
		setSize(900, 900);
		setVisible(true);
	}
	
		public static void main(String [] args){
		new CriticalPoint1();
	}
}

class Diagrami extends JPanel {
public static double P, r, M1, M2, M3 ,M4, M5;
public static int a ,b ,c, d, e;

 public Diagrami(){
		setPreferredSize(new Dimension(800, 800));
		setBackground(Color.white);
      llogaritKestin();
	}
   public void llogaritKestin() {
		P = Double.parseDouble(JOptionPane.showInputDialog("Shuma e kredise : "));
		r = Double.parseDouble(JOptionPane.showInputDialog("Perqindja e interesit per te cilen i eshte dhene shuma :"));
      if(P != 0 && r != 0){
      DecimalFormat a = new DecimalFormat("0.00");
      M1 = ((P*r)/12)/(1- Math.pow((1/(1+r/12)),12*1));
     JOptionPane.showMessageDialog(null,"Kesti qe duhet te paguani ne 12 muaj eshte : "+ a.format(M1) + "€");
       M2 = ((P*r)/12)/(1- Math.pow((1/(1+r/12)),12*2));
     JOptionPane.showMessageDialog(null,"Kesti qe duhet te paguani ne 24 muaj eshte : "+ a.format(M2) + "€");
       M3 = ((P*r)/12)/(1- Math.pow((1/(1+r/12)),12*3));
     JOptionPane.showMessageDialog(null,"Kesti qe duhet te paguani ne 36 muaj eshte : "+ a.format(M3) + "€");
       M4 = ((P*r)/12)/(1- Math.pow((1/(1+r/12)),12*4));
     JOptionPane.showMessageDialog(null,"Kesti qe duhet te paguani ne 48 muaj eshte : "+ a.format(M4) + "€");
       M5 = ((P*r)/12)/(1- Math.pow((1/(1+r/12)),12*5));
     JOptionPane.showMessageDialog(null,"Kesti qe duhet te paguani ne 60 muaj eshte : "+ a.format(M5) + "€");
     }
     else {
      JOptionPane.showMessageDialog(null," Nuk ekzsiton ajo kredi ");
      System.exit(0);}
}

	public void paintComponent(Graphics g) {
      a = (int)M1;
      b = (int)M2;
      c = (int)M3;
      d = (int)M4;
      e = (int)M5;
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		GeneralPath p = new GeneralPath();
		p.moveTo(70,40);
		p.lineTo(70,600);
		p.lineTo(620,600);
      g2.setColor(Color.black);
		g2.drawString("Kesti",40,40);
		int j = 5;
		for(int i = 100; i <= 500; i+= 100)
			g2.drawString(j-- + "00", 40, i);
		j = 12;
		for(int i = 140; i <= 484; i+= 86) {
			g2.drawString(j + "", i, 620);
			j += 12;
		}
		g2.drawString("Muajt", 620, 620);
      g2.setColor(Color.red);
      p.moveTo(140,600 -a);
      p.lineTo(226,600 -b);
      p.lineTo(312,600 -c);
      p.lineTo(398,600 -d);
      p.lineTo(484,600 -e);
      g2.drawString("Per 12 muaj shuma e kestit mujor eshte: "+ a + " €", 40, 640);
      g2.drawString("Per 24 muaj shuma e kestit mujor eshte: "+ b + " €", 40, 660);
      g2.drawString("Per 36 muaj shuma e kestit mujor eshte: "+ c + " €", 40, 680);
      g2.drawString("Per 48 muaj shuma e kestit mujor eshte: "+ d + " €", 40, 700);
      g2.drawString("Per 60 muaj shuma e kestit mujor eshte: "+ e + " €", 40, 720);
		g2.draw(p);
      float dash[] = { 10.0f };
      g2.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
      g2.setPaint(Color.blue);
      for(int n = 100; n<=500; n+=100){
      g2.drawLine(70, n, 620, n);
      }
      for(int m = 140; m <= 484; m += 86){
      g2.drawLine(m, 600, m, 50);
      }
   }
}