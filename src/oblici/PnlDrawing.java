package oblici;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author Peki
 * Klasa koja opisuje panel za crtanje i sadrzi oblike
 * */



public class PnlDrawing extends JPanel {
	
	private ArrayList<Shape> shapes;
	private Shape selektovanOblik;
	
	public PnlDrawing() {
		shapes = new ArrayList<Shape>();
	}

	/**
	 * Create the panel.
	 */
	
	/*public static void main(String[] args) {
		JFrame frame = new JFrame("Crtez");
		frame.setSize(800, 600);
		PnlDrawing drawing = new PnlDrawing();
		frame.getContentPane().add(drawing);
		frame.setVisible(true);
	}
	*/
	/**
	 * Metoda za iscrtavanje, ovu metodu poziva repaint.
	 * */
	
	public void paint(Graphics g) {
		
		//za svaki oblik u listi
		for(Shape s : shapes) {
			s.draw(g);
		}
		
		//okvir
		g.setColor(Color.BLACK);
		g.drawRect(0,0, this.getWidth() - 1, this.getHeight() - 1);
	}
	
	
	public void dodajOblik(Shape s) {
		shapes.add(s);
	}
	
	public void obrisiOblik(Shape s) {
		shapes.remove(s);
		s.setSelected(false);
	}
	
	/**
	 * Trazi oblik na poziciji x i y i selektuj ga. 
	 * U slucaju da se dva oblika poklapaju, selektuje se zadnji
	 * dodati oblik u listi.
	 * 
	 * @param x
	 * @param y
	 * */
	
	public void selektujOblik(int x, int y) {
		if (selektovanOblik != null) {
			selektovanOblik.setSelected(false);
		}
		
		// za svaki oblik s u listi oblici
		
		for(Shape s : shapes) {
			if(s.constains(x, y)) {
				if(selektovanOblik != null) {
					selektovanOblik.setSelected(false);
				}
				selektovanOblik = s;
				s.setSelected(true);
			}
		}
	}
	
	public Shape getSelektovanOblik() {
		return selektovanOblik;
	}

}
