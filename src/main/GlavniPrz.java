package main;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import dijalozi.DijalogCircle;
import dijalozi.DijalogLine;
import dijalozi.DijalogRectangle;
import dijalozi.DijalogPoint;
import dijalozi.DijalogDonut;
import osluskivac.MouseListenerZaCrtez;
import oblici.PnlDrawing;
import oblici.Circle;
import oblici.Line;
import oblici.Shape;
import oblici.Rectangle;
import oblici.Point;
import oblici.Donut;

import javax.swing.border.EmptyBorder;


/**
 * Klasi Glavni Prozor sadrzi sve neophodne metoda za iscrtavanje
 * oblika i pozivanje dijaloga za modifikaciju oblika, kao i za brisanje istih
 * 
 * @author Peki
 * */


public class GlavniPrz extends JFrame {

	/**
	 * 
	 */
	private JPanel contentPane;
	
	public JButton btnSelektuj;
	public JButton btnPoint;
	public JButton btnLine;
	public JButton btnRectangle;
	public JButton btnCircle;
	public JButton btnDonut;
	
	public JButton btnModifikuj;
	public JButton btnObrisi;
	public JButton btnExit;
	private ButtonGroup btnGroup;

	public PnlDrawing crtez;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GlavniPrz gp = new GlavniPrz();
					gp.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Konstruktor Glavnog Prozora
	 */
	public GlavniPrz() {

		setLocationRelativeTo(null);
		setTitle("Drawing");
		setResizable(false);
		setSize(711,560);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	//	setBounds(100, 100, 648, 401);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
						
		JPanel pnlSever = new JPanel();
		contentPane.add(pnlSever, BorderLayout.NORTH);	
		
		btnModifikuj = new JButton("Modifikuj");
	//	pnlSever.add(btnModifikuj);
		
		btnModifikuj.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Shape s = crtez.getSelektovanOblik();
				if(s != null) {
					if(s instanceof Circle) {
						DijalogCircle dc = new DijalogCircle((Circle) s);
						dc.setVisible(true);
					}
					if(s instanceof Point) {
						DijalogPoint dp = new DijalogPoint((Point) s);
						dp.setVisible(true);
					}
					if(s instanceof Line) {
						DijalogLine dl = new DijalogLine((Line) s);
						dl.setVisible(true);
					}
					if(s instanceof Rectangle){
						DijalogRectangle dr = new DijalogRectangle((Rectangle) s);
						dr.setVisible(true);
					}
					if((s instanceof Donut) && !(s instanceof Circle)) {
						DijalogDonut dd = new DijalogDonut((Donut) s);
						dd.setVisible(true);
					}
 				}
				//getParent da bi mi se ceo prozor iscrtao ponovo promenjeno
				crtez.getParent().repaint();
			}
		});
		

		btnObrisi = new JButton("Obrisi");
	//	pnlSever.add(btnObrisi);
		
		btnObrisi.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Shape zaBrisanje = crtez.getSelektovanOblik();
				if(zaBrisanje != null) {
					crtez.obrisiOblik(zaBrisanje);
					crtez.getParent().repaint();
				}
			}
		});
		GroupLayout gl_pnlSever = new GroupLayout(pnlSever);
		gl_pnlSever.setHorizontalGroup(
			gl_pnlSever.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlSever.createSequentialGroup()
					.addGap(139)
					.addComponent(btnModifikuj)
					.addPreferredGap(ComponentPlacement.RELATED, 228, Short.MAX_VALUE)
					.addComponent(btnObrisi)
					.addGap(131))
		);
		gl_pnlSever.setVerticalGroup(
			gl_pnlSever.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlSever.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pnlSever.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnObrisi)
						.addComponent(btnModifikuj)))
		);
		pnlSever.setLayout(gl_pnlSever);
		
		JPanel pnlZapad = new JPanel();
		contentPane.add(pnlZapad, BorderLayout.WEST);
		
		btnGroup = new ButtonGroup();
		
		btnSelektuj = new JButton("Selektuj");
		pnlZapad.add(btnSelektuj);
		btnGroup.add(btnSelektuj);
		
		btnPoint = new JButton("Point");
		pnlZapad.add(btnPoint);
		btnGroup.add(btnPoint);
		
		btnLine = new JButton("Line");
		pnlZapad.add(btnLine);
		btnGroup.add(btnLine);
		
		btnRectangle = new JButton("Rectangle");
		pnlZapad.add(btnRectangle);
		btnGroup.add(btnRectangle);
		
		btnCircle = new JButton("Circle");
		pnlZapad.add(btnCircle);
		btnGroup.add(btnCircle);
		
		btnDonut = new JButton("Donut");
		pnlZapad.add(btnDonut);
		btnGroup.add(btnDonut);
		
		GroupLayout gl_pnlZapad = new GroupLayout(pnlZapad);
		gl_pnlZapad.setHorizontalGroup(
			gl_pnlZapad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlZapad.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlZapad.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSelektuj)
						.addComponent(btnPoint)
						.addComponent(btnLine)
						.addComponent(btnRectangle)
						.addComponent(btnCircle)
						.addComponent(btnDonut))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pnlZapad.setVerticalGroup(
			gl_pnlZapad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlZapad.createSequentialGroup()
					.addGap(23)
					.addComponent(btnSelektuj)
					.addGap(18)
					.addComponent(btnPoint)
					.addGap(18)
					.addComponent(btnLine)
					.addGap(18)
					.addComponent(btnRectangle)
					.addGap(18)
					.addComponent(btnCircle)
					.addGap(26)
					.addComponent(btnDonut)
					.addContainerGap(60, Short.MAX_VALUE))
		);
		pnlZapad.setLayout(gl_pnlZapad);
		
		JPanel pnlJug = new JPanel();
		contentPane.add(pnlJug, BorderLayout.SOUTH);
		
		btnExit = new JButton("Exit");
		
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GroupLayout gl_pnlJug = new GroupLayout(pnlJug);
		gl_pnlJug.setHorizontalGroup(
			gl_pnlJug.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlJug.createSequentialGroup()
					.addContainerGap(571, Short.MAX_VALUE)
					.addComponent(btnExit)
					.addContainerGap())
		);
		gl_pnlJug.setVerticalGroup(
			gl_pnlJug.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlJug.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnExit, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE))
		);
		pnlJug.setLayout(gl_pnlJug);
		
		JPanel pnlCentar = new JPanel();
		contentPane.add(pnlCentar, BorderLayout.CENTER);
	/* Kad dodajemo prozor za crtanje */	
		crtez = new PnlDrawing();
		
		MouseListenerZaCrtez ml = new MouseListenerZaCrtez(this);
		crtez.addMouseListener(ml);
		crtez.addMouseMotionListener(ml);
		pnlCentar.setLayout(null);
		
		
		
		pnlCentar.add(crtez);
		crtez.setLayout(null);

		GroupLayout gl_pnlCentar = new GroupLayout(pnlCentar);
		gl_pnlCentar.setHorizontalGroup(
			gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup()
					.addContainerGap()
					.addComponent(crtez, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlCentar.setVerticalGroup(
			gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup()
					.addContainerGap()
					.addComponent(crtez, GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
					.addContainerGap())
		);
		GroupLayout gl_crtez = new GroupLayout(crtez);
		gl_crtez.setHorizontalGroup(
			gl_crtez.createParallelGroup(Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE)
		);
		gl_crtez.setVerticalGroup(
			gl_crtez.createParallelGroup(Alignment.LEADING)
				.addGap(0, 0, Short.MAX_VALUE)
		);
		crtez.setLayout(gl_crtez);
		pnlCentar.setLayout(gl_pnlCentar);
		
	}
}
