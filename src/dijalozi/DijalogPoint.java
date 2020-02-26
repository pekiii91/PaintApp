package dijalozi;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import oblici.Point;;

public class DijalogPoint extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JButton btnOk;
	private JLabel lblKoordinataX;
	private JLabel lblKoordinataY;
	public String xKoordinata;
	public String yKoordinata;
	private JLabel lblBojaTacke;
	public Color colorPoint;
	private Point point;
	private JButton btnCancel;
	private JTextField txtX;
	private JTextField txtY;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			DijalogPoint dialog = new DijalogPoint();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */	public DijalogPoint(Point p) {
		setTitle("Point");
		setResizable(false);
		setModal(true);
		setSize(660, 400);
		this.point = p;
		setBounds(100, 100, 660, 400);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
	//	txtY.setText(Integer.toString(point.getY()));

		
	//	JComboBox cmbBoxBojaTacke = new JComboBox();
		JColorChooser cmbBoxBojaTacke = new JColorChooser();
		
		
		lblKoordinataX = new JLabel("koordinata x");
		
		lblKoordinataY = new JLabel("koordinata y");
		
		lblBojaTacke = new JLabel("Color point");
		
		txtX = new JTextField();
		txtX.setText("0");
		txtX.setColumns(10);
		
		txtY = new JTextField();
		txtY.setText("0");
		txtY.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(20)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblKoordinataY, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKoordinataX, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBojaTacke, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
					.addGap(90)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addContainerGap())
							.addComponent(cmbBoxBojaTacke, GroupLayout.PREFERRED_SIZE, 387, Short.MAX_VALUE))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(51)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblKoordinataX, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(14)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoordinataY, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblBojaTacke, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
							.addGap(146))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(cmbBoxBojaTacke, GroupLayout.PREFERRED_SIZE, 169, Short.MAX_VALUE)
							.addContainerGap())))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnOk = new JButton("OK");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						xKoordinata = txtX.getText();
						int x = 0;
						yKoordinata = txtY.getText();
						int y = 0;
						colorPoint = cmbBoxBojaTacke.getColor();
						
						boolean imaGreska = false;
						if(xKoordinata.length() > 0) {
							try {
								x = (int) Double.parseDouble(xKoordinata);
							} catch (NumberFormatException ee) {
								JOptionPane.showMessageDialog(null, 
										"Morate uneti ceo broj za x koordinatu!" ,
										"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
								imaGreska = true;
							} 
						} else {
							JOptionPane.showMessageDialog(null,
									"Morate uneti ceo broj za x koordinatu!", 
									"Greska", JOptionPane.ERROR_MESSAGE);
							imaGreska = true;
						}
						if(yKoordinata.length() > 0) {
							try {
								y = (int) Double.parseDouble(yKoordinata);
							} catch (NumberFormatException ee) {
								JOptionPane.showMessageDialog(null, 
										"Morate uneti ceo broj za y koordinatu!" ,
										"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
								imaGreska = true;
							} 
						} else {
							JOptionPane.showMessageDialog(null,
									"Morate uneti ceo broj za y koordinatu!", 
									"Greska", JOptionPane.ERROR_MESSAGE);
							imaGreska = true;
						}
						
						if(imaGreska == false) {
							point.setX(txtX.getX());
							point.setY(txtY.getY());
							point.setColor(colorPoint);
							point.setSelected(false);
							setVisible(false);
						}
						
						
						
					}
				});
				btnOk.setActionCommand("OK");
				getRootPane().setDefaultButton(btnOk);
			}
			
			btnCancel = new JButton("Cancel");
			btnCancel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(496)
						.addComponent(btnOk)
						.addGap(36)
						.addComponent(btnCancel)
						.addContainerGap())
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGap(5)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnCancel)
							.addComponent(btnOk)))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}
}
