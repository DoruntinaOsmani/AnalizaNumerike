import javax.swing.*;
import java.text.*;
import java.awt.*;
import java.awt.geom.GeneralPath;
import java.awt.Graphics;

public class Shpejtesia1 extends JFrame {

	public static double P, r, M1, M2, M3 ,M4, M5;
	
	public Shpejtesia1() {
		super("Diagrami");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(new Diagramii());
		setSize(900, 900);
		setVisible(true);
	}
	
		public static void main(String [] args){
		new Shpejtesia1();
	}
}

class Diagramii extends JPanel {
public static double s, R1, R2, R3 ,R4, R5,v;
public static int a ,b ,c, d, e;

 public Diagramii(){
		setPreferredSize(new Dimension(800, 800));
		setBackground(Color.white);
      llogaritRenien();
	}
   public void llogaritRenien() {
   v = Double.parseDouble(JOptionPane.showInputDialog("Cakto shpejtesine: "));
        if(v != 0){
         DecimalFormat a = new DecimalFormat("0.00");
       R1 = v*1;
     JOptionPane.showMessageDialog(null,"Rruga qe pershkon trupi me shpejtesi " + v + " m/s per 1 ore: "+ a.format(R1)+ " metra");
       R2 = v*2;
     JOptionPane.showMessageDialog(null,"Rruga qe pershkon trupi me shpejtesi " + v + " m/s per 2 ore: "+ a.format(R2)+ " metra");
       R3 = v*3;
     JOptionPane.showMessageDialog(null,"Rruga qe pershkon trupi me shpejtesi " + v + " m/s per 3 ore: "+ a.format(R3)+ " metra");
       R4 = v*4;
     JOptionPane.showMessageDialog(null,"Rruga qe pershkon trupi me shpejtesi " + v + " m/s per 4 ore: "+ a.format(R4)+ " metra");
       R5 = v*5;
     JOptionPane.showMessageDialog(null,"Rruga qe pershkon trupi me shpejtesi " + v + " m/s per 5 ore: "+ a.format(R4)+ " metra");
     } else {
            System.exit(0);
     }
}

	public void paintComponent(Graphics g) {
     a = (int)R1;
      b = (int)R2;
      c = (int)R3;
      d = (int)R4;
      e = (int)R5;
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		GeneralPath p = new GeneralPath();
		p.moveTo(70,40);
		p.lineTo(70,600);
		p.lineTo(620,600);
      g2.setColor(Color.pink);
		g2.drawString("Rruga",40,40);
		int j = 5;
		for(int i = 100; i <= 500; i+= 100)
			g2.drawString(j-- + "00", 40, i);
		j = 1;
		for(int i = 140; i <= 484; i+= 86) {
			g2.drawString(j + "", i, 620);
			j += 1;
		}
		g2.drawString("Koha", 620, 620);
      g2.setColor(Color.blue);
      p.moveTo(140,600 -a);
      p.lineTo(226,600 -b);
      p.lineTo(312,600 -c);
      p.lineTo(398,600 -d);
      p.lineTo(484,600 -e);
      g2.drawString("Me shpejtesi "+ v+" m/s"+" me periudhe kohore prej 1 ore, rruga e pershkuar: "+ a + " metra", 40, 640);
      g2.drawString("Me shpejtesi "+ v+" m/s"+" me periudhe kohore prej 2 ore, rruga e pershkuar: "+ b + " metra", 40, 660);
      g2.drawString("Me shpejtesi "+ v+" m/s"+" me periudhe kohore prej 3 ore, rruga e pershkuar: "+ c + " metra", 40, 680);
      g2.drawString("Me shpejtesi "+ v+" m/s"+" me periudhe kohore prej 4 ore, rruga e pershkuar: "+ d + " metra", 40, 700);
      g2.drawString("Me shpejtesi "+ v+" m/s"+" me periudhe kohore prej 5 ore, rruga e pershkuar: "+ e + " metra", 40, 720);
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