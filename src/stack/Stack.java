package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;





import stack.Rectangle;
import stack.Point;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Stack extends JFrame {

	private JPanel contentPane;

	DefaultListModel <Rectangle> r = new DefaultListModel();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stack frame = new Stack();
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
	public Stack() {
		
		getContentPane().setLayout(null);
		
		setTitle("Stek");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
	
		JPanel pnlZapad = new JPanel();
		contentPane.add(pnlZapad, BorderLayout.WEST);
		
		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent args0) {
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
		
		JButton btnIzadji = new JButton("Izadji");
		btnIzadji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JButton btnUzmi = new JButton("Uzmi");
		btnUzmi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DijalogRectangle dr = new DijalogRectangle();
				dr.txtX.setEditable(false);
				dr.txtY.setEditable(false);
				dr.txtVisina.setEditable(false);
				dr.txtSirina.setEditable(false);
				dr.setLocationRelativeTo(null);
				if (r.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Lista je prazna!", 
							"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
				} else {
					dr.txtX.setText(String.valueOf(r.getElementAt(0).getUpperLeftPoint()));
					dr.txtY.setText(String.valueOf(r.getElementAt(0).getUpperLeftPoint()));
					dr.txtVisina.setText(String.valueOf(r.getElementAt(0).getHeight()));
					dr.txtSirina.setText(String.valueOf(r.getElementAt(0).getWidth()));
					dr.setVisible(true);
					r.remove(0); //brisem sa vrha liste,prvi index(0)
				}
			}
		});
		GroupLayout gl_pnlZapad = new GroupLayout(pnlZapad);
		gl_pnlZapad.setHorizontalGroup(
			gl_pnlZapad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlZapad.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnlZapad.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDodaj)
						.addComponent(btnIzadji)
						.addComponent(btnUzmi))
					.addContainerGap(16, Short.MAX_VALUE))
		);
		gl_pnlZapad.setVerticalGroup(
			gl_pnlZapad.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlZapad.createSequentialGroup()
					.addGap(30)
					.addComponent(btnDodaj)
					.addGap(30)
					.addComponent(btnUzmi)
					.addGap(26)
					.addComponent(btnIzadji)
					.addContainerGap(97, Short.MAX_VALUE))
		);
		pnlZapad.setLayout(gl_pnlZapad);
		
		JPanel pnlCentar = new JPanel();
		contentPane.add(pnlCentar, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_pnlCentar = new GroupLayout(pnlCentar);
		gl_pnlCentar.setHorizontalGroup(
			gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlCentar.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_pnlCentar.setVerticalGroup(
			gl_pnlCentar.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_pnlCentar.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 281, Short.MAX_VALUE)
					.addGap(20))
		);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		pnlCentar.setLayout(gl_pnlCentar);
		// da se na listu dodaju objekti klase pravougaonik iz DefaultList modela
		list.setModel(r);
	}

}
