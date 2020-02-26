package osluskivac;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import oblici.Circle;
import oblici.Donut;
import oblici.Line;
import oblici.Point;
import oblici.Rectangle;
import main.GlavniPrz;

/** 
 * Klasa koja implementira mouse listener i mouse motion listener u kojima su
 *  metode koje se pozivaju na dogadjaj misa.
 *  
 *  @author Peki
 * */


public class MouseListenerZaCrtez implements MouseListener, MouseMotionListener {
	private GlavniPrz gp;
	private Line line;
	private Circle circle;
	private Rectangle rectangle;
	private Donut donut;

	public MouseListenerZaCrtez(GlavniPrz gp) {
		this.gp = gp;
	}
	
	
	/**
	 * Metoda koja se poziva pritiskom na levi klik. Kreira oblik na osnovu dugmeta
	 * koji je selektovan na glavnom prozoru. Na kraju poziva ponovno iscrtavanje.
	 * */


	@Override
	public void mousePressed(MouseEvent e) {
		// System.out.println("Mouse pressed. x = " + e.getX() + " y = " + e.getY());
		if (gp.btnSelektuj.isSelected() ==true) {
			gp.crtez.selektujOblik(e.getX(), e.getY()); 
		}
		if (gp.btnPoint.isSelected() == true) {
			gp.crtez.dodajOblik(new Point(e.getX(), e.getY()));
		}
		if (gp.btnLine.isSelected() == true) {
			if (line == null) {
				line = new Line(new Point(e.getX(), e.getY()), new Point(e.getX() + 1, e.getX() + 1));
				gp.crtez.dodajOblik(line);
			}
		}
		if (gp.btnRectangle.isSelected() == true) {
			if (rectangle == null) {
				rectangle = new Rectangle(new Point(e.getX() , e.getY()), 2, 2);
				gp.crtez.dodajOblik(rectangle);
			}
		}
		if(gp.btnCircle.isSelected() == true) {
			if (circle == null) {
				circle = new Circle(new Point(e.getX(), e.getY()),2);
				gp.crtez.dodajOblik(circle);
			}
		}
		if(gp.btnDonut.isSelected() == true) {
			if(donut == null) {
				donut = new Donut(new Point(e.getX(), e.getY()), 3, 3);
				gp.crtez.dodajOblik(donut);
			}
		}
		gp.repaint();

	}
	
	

	/**
	 * Metoda koja se poziva kad se mis vuce. Ova metoda postavlja atribute odredjenog oblika 
	 * i poziva ponovno iscrtavanje glavnog prozora.
	 * */
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		if (line != null) {
			line.setEndPoint(new Point(e.getX(), e.getY()));
		}
		if (circle != null) {
			int newRadius = Math.max(Math.abs(circle.getCenter().getY() - e.getY()),
									Math.abs(circle.getCenter().getX() - e.getX()));
			circle.setRadius(newRadius);
		}
		if (donut != null) {
			int newInnerRadius = Math.abs(donut.getCenter().getX() - e.getX());
			donut.setInnerRadius(newInnerRadius);
		}
		if (rectangle != null) {
			int newWidth = Math.abs(rectangle.getUpperLeftPoint().getX() - e.getX());
			int newHeight = Math.abs(rectangle.getUpperLeftPoint().getY() - e.getY());
			rectangle.setWidth(newWidth);
			rectangle.setHeight(newHeight);
		}
		gp.repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	} 

    @Override
    public void mouseClicked(MouseEvent e) {
    }

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	

	/**
	 * Metoda koja se poziva nakon pustanja klika. Ova metoda zavrsava
	 * iscrtavanje odredjenog oblika.
	 * */
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if (line != null) {
			line.setEndPoint(new Point (e.getX(), e.getY()));
			line = null;
		}
		if (circle != null) {
			int newRadius = Math.max(Math.abs(circle.getCenter().getY() - e.getY()),
					Math.abs(circle.getCenter().getX() - e.getX()));
			circle.setRadius(newRadius);
			circle = null;
		}
		if (donut != null) {
			int newInnerRadius = Math.abs(donut.getCenter().getX() - e.getX());
			donut.setInnerRadius(newInnerRadius);
			donut = null;
		}
		if (rectangle != null) {
			int newWidth = Math.abs(rectangle.getUpperLeftPoint().getX() - e.getX());
			int newHeight = Math.abs(rectangle.getUpperLeftPoint().getY() - e.getY());
			rectangle.setWidth(newWidth);
			rectangle.setHeight(newHeight);
			rectangle = null;
		}
		
		gp.repaint();
		
	}
	

}
