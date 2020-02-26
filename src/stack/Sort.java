package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;





import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Sort extends JFrame {

	DefaultListModel <Rectangle> r = new DefaultListModel();

	
	private JPanel contentPane;
	int brojac;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sort frame = new Sort();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Sort() {
		setTitle("Sort");
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlCentar = new JPanel();
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlCentar = new GroupLayout(pnlCentar);
		gl_pnlCentar.setHorizontalGroup(
			gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlCentar.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_pnlCentar.setVerticalGroup(
			gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		pnlCentar.setLayout(gl_pnlCentar);
		
		list.setModel(r);
		
		JPanel pnlZapad = new JPanel();
		contentPane.add(pnlZapad, BorderLayout.WEST);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DijalogRectangle dr = new DijalogRectangle();
				dr.setLocationRelativeTo(null);
				dr.setVisible(true);
				
				try{
					Rectangle rc = new Rectangle(new Point(Integer.parseInt(dr.xKoordinata), Integer.parseInt(dr.yKoordinata)), 
							Integer.parseInt(dr.visina), Integer.parseInt(dr.sirina)); 						
							
					r.add(0, rc);
				} catch (NumberFormatException ee){
					
				}
				
			
			}
		});
		
		JButton btnSortiraj = new JButton("Sortiraj");
		btnSortiraj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(r.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Lista je prazna!", 
							"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
				} else {
					/* kreiram niz rectangle (pravougaonik) koji je duzine moje liste i kopiram
					 * elemente iz liste u niz, sortiram niz i brisem sve elemente iz liste na 
					 * kraju prolazim kroz sortiran niz i dodajem ponovo elemente u listu
					 * */ 
					Object[] rectangle = new Object[r.getSize()];
					r.copyInto(rectangle);
					//sortiram rectangle
					Arrays.sort(rectangle);
					r.removeAllElements();
					//prolazim kroz sortiran niz i dodajem element u moj niz rectangle
					for(int i=0; i< rectangle.length; i++) {
						r.addElement((Rectangle) rectangle[i]); //ovde je greska, ne sortira nista
					}
				}
			}
		});
		
		JButton btnIzadji = new JButton("Izadji");
		btnIzadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		GroupLayout gl_pnlZapad = new GroupLayout(pnlZapad);
		gl_pnlZapad.setHorizontalGroup(
			gl_pnlZapad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlZapad.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlZapad.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSortiraj, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDodaj, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
						.addComponent(btnIzadji, GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_pnlZapad.setVerticalGroup(
			gl_pnlZapad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlZapad.createSequentialGroup()
					.addGap(55)
					.addComponent(btnDodaj, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSortiraj, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnIzadji, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(146, Short.MAX_VALUE))
		);
		pnlZapad.setLayout(gl_pnlZapad);
	}
}
