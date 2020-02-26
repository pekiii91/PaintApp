package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogRectangle extends JDialog {
	// public sam stavio da bude vidljiv svim klasama
	public JTextField txtX;
	public JTextField txtY;
	public JTextField txtVisina;
	public  JTextField txtSirina;
	
	public String xKoordinata;
	public String yKoordinata;
	public String visina;
	public String sirina;
	
	boolean isOk;

	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtVisina() {
		return txtVisina;
	}

	public void setTxtVisina(JTextField txtVisina) {
		this.txtVisina = txtVisina;
	}

	public JTextField getTxtSirina() {
		return txtSirina;
	}

	public void setTxtSirina(JTextField txtSirina) {
		this.txtSirina = txtSirina;
	}

	public String getxKoodinata() {
		return xKoordinata;
	}

	public void setxKoodinata(String xKoodinata) {
		this.xKoordinata = xKoodinata;
	}

	public String getyKoordinata() {
		return yKoordinata;
	}

	public void setyKoordinata(String yKoordinata) {
		this.yKoordinata = yKoordinata;
	}

	public String getVisina() {
		return visina;
	}

	public void setVisina(String visina) {
		this.visina = visina;
	}

	public String getSirina() {
		return sirina;
	}

	public void setSirina(String sirina) {
		this.sirina = sirina;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DijalogRectangle dialog = new DijalogRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DijalogRectangle() {
		setModal(true);
		setTitle("Rectangle");
		setResizable(false);
		setSize(650,550);
		setBounds(100, 100, 485, 390);
		getContentPane().setLayout(null);
		{
			JLabel lblXKoordinata = new JLabel("x koordinata");
			lblXKoordinata.setBounds(10, 25, 108, 29);
			getContentPane().add(lblXKoordinata);
		}
		{
			JLabel lblYKoordinata = new JLabel("y koordinata");
			lblYKoordinata.setBounds(10, 82, 126, 29);
			getContentPane().add(lblYKoordinata);
		}
		{
			JLabel lblVisina = new JLabel("Visina");
			lblVisina.setBounds(10, 122, 108, 35);
			getContentPane().add(lblVisina);
		}
		{
			JLabel lblSirina = new JLabel("Sirina");
			lblSirina.setBounds(10, 173, 108, 29);
			getContentPane().add(lblSirina);
		}
		{
			txtX = new JTextField();
			txtX.setBounds(207, 25, 113, 29);
			getContentPane().add(txtX);
			txtX.setColumns(10);
		}
		{
			txtY = new JTextField();
			txtY.setBounds(207, 82, 113, 29);
			getContentPane().add(txtY);
			txtY.setColumns(10);
		}
		{
			txtVisina = new JTextField();
			txtVisina.setBounds(207, 128, 113, 29);
			getContentPane().add(txtVisina);
			txtVisina.setColumns(10);
		}
		{
			txtSirina = new JTextField();
			txtSirina.setBounds(207, 173, 113, 29);
			getContentPane().add(txtSirina);
			txtSirina.setColumns(10);
		}
		{
			JButton btnOk = new JButton("Ok");
			btnOk.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				//pretvaranje unesenih vrednosti u string
				xKoordinata = txtX.getText();
				yKoordinata = txtY.getText();
				visina = txtVisina.getText();
				sirina = txtSirina.getText();
				boolean greska = false;
				
				if (xKoordinata.length() > 0){
					try{
						Integer.parseInt(xKoordinata);
					}catch (NumberFormatException ee){
						JOptionPane.showMessageDialog(null, 
								"Morate uneti ceo broj za x koordinatu!", 
								"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
							greska = true;
						} 
					} else {
						JOptionPane.showMessageDialog(null, "Morate uneti ceo broj za x koordinatu!", 
								"Greska", JOptionPane.ERROR_MESSAGE);
						greska = true;
				} 
				
				if (yKoordinata.length() > 0){
					try{
						Integer.parseInt(yKoordinata);
					}catch (NumberFormatException ee){
						JOptionPane.showMessageDialog(null, 
								"Morate uneti ceo broj za y koordinatu!", 
								"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
							greska = true;
						} 
					} else {
						JOptionPane.showMessageDialog(null, "Morate uneti ceo broj za y koordinatu!", 
								"Greska", JOptionPane.ERROR_MESSAGE);
						greska = true;
				} 
				
				if (visina.length() > 0){
					try{
						Integer.parseInt(visina);
					}catch (NumberFormatException ee){
						JOptionPane.showMessageDialog(null, 
								"Morate uneti ceo broj za visinu!", 
								"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
							greska = true;
						} 
					} else {
						JOptionPane.showMessageDialog(null, "Morate uneti ceo broj za visinu!", 
								"Greska", JOptionPane.ERROR_MESSAGE);
						greska = true;
				} 
				
				if (sirina.length() > 0){
					try{
						Integer.parseInt(sirina);
					}catch (NumberFormatException ee){
						JOptionPane.showMessageDialog(null, 
								"Morate uneti ceo broj sirinu!", 
								"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
							greska = true;
						} 
					} else {
						JOptionPane.showMessageDialog(null, "Morate uneti ceo broj za sirinu!", 
								"Greska", JOptionPane.ERROR_MESSAGE);
						greska = true;
				} 
				
				if(greska == false)
					setVisible(false);
				
				}
			});
			btnOk.setBounds(21, 249, 97, 36);
			getContentPane().add(btnOk);
		}
		{
			JButton btnExit = new JButton("Exit");
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnExit.setBounds(213, 249, 107, 36);
			getContentPane().add(btnExit);
		}
	}

}
