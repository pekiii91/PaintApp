package dijalozi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import oblici.Donut;
import oblici.Point;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogDonut extends JDialog {

	private Donut donut;
	
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtInnerRadius;
	public String xKoordinata;
	public String yKoordinata;
	public String innerRadius;
	
	public Color colorInner;
	public Color colorRim;
	public JColorChooser cmbBoxColorInner;
	public JColorChooser cmbBoxColorRim;
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			DijalogDonut dialog = new DijalogDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public DijalogDonut(Donut d) {
		setModal(true);
		setTitle("Donut");
		setResizable(false);
		this.donut = d;
		setBounds(100, 100, 636, 738);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		
		JLabel lblKoordinatePoint = new JLabel("x koordinata");
		
		JLabel lblInnerRadius = new JLabel("Inner radius");
		
		JLabel lblInnerColor = new JLabel("Inner color");
		
		txtX = new JTextField();
		txtX.setText("0");
		txtX.setColumns(10);
		
		txtY = new JTextField();
		txtY.setText("0");
		txtY.setColumns(10);
		
		txtInnerRadius = new JTextField();
		txtInnerRadius.setText("0");
		txtInnerRadius.setColumns(10);
		
		JColorChooser cmbBoxColorInner = new JColorChooser();
		
		JColorChooser cmbBoxColorRim = new JColorChooser();
		
		JLabel lblRimColor = new JLabel("Rim color");
		
		JLabel lblYKoordinata = new JLabel("y koordinata");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
							.addComponent(lblRimColor, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
							.addGap(59)
							.addComponent(cmbBoxColorRim, 0, 459, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, gl_contentPanel.createSequentialGroup()
							.addComponent(lblInnerColor)
							.addGap(65)
							.addComponent(cmbBoxColorInner, 0, 459, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblYKoordinata)
								.addComponent(lblKoordinatePoint)
								.addComponent(lblInnerRadius))
							.addGap(57)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 373, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(29)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblKoordinatePoint))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYKoordinata))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInnerRadius))
							.addGap(36)
							.addComponent(cmbBoxColorInner, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(88)
							.addComponent(lblInnerColor)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(35)
							.addComponent(cmbBoxColorRim, GroupLayout.PREFERRED_SIZE, 209, Short.MAX_VALUE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(54)
							.addComponent(lblRimColor, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						xKoordinata = txtX.getText();
						int x = 0;
						yKoordinata = txtY.getText();
						int y = 0;
						innerRadius = txtInnerRadius.getText();
						int ir = 0;
						
						boolean imaGreska = false;
						if(xKoordinata.length() > 0) {
							try {
								x = (int) Double.parseDouble(xKoordinata);
							} catch (NumberFormatException ee) {
								JOptionPane.showMessageDialog(null, 
										"Morate uneti ceo broj za x koordinatu!",
										"Obavesetenje", JOptionPane.INFORMATION_MESSAGE);
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
								x = (int) Double.parseDouble(yKoordinata);
							} catch (NumberFormatException ee) {
								JOptionPane.showMessageDialog(null, 
										"Morate uneti ceo broj za y koordinatu!",
										"Obavesetenje", JOptionPane.INFORMATION_MESSAGE);
								imaGreska = true;
							}
						} else {
							JOptionPane.showMessageDialog(null, 
									"Morate uneti ceo broj za y koordinatu!",
									"Greska", JOptionPane.ERROR_MESSAGE);
							imaGreska = true;
						}
						if(innerRadius.length() > 0) {
							try {
								x = (int) Double.parseDouble(innerRadius);
							} catch (NumberFormatException ee) {
								JOptionPane.showMessageDialog(null, 
										"Morate uneti ceo broj za unutrasnji precnik!",
										"Obavesetenje", JOptionPane.INFORMATION_MESSAGE);
								imaGreska = true;
							}
						} else {
							JOptionPane.showMessageDialog(null, 
									"Morate uneti ceo broj za unutrasnji precnik!",
									"Greska", JOptionPane.ERROR_MESSAGE);
							imaGreska = true;
						}
						
						if(imaGreska == false) {
							d.setCenter(new Point(x,y));
							d.setRadius(ir);
							d.setColor(colorRim);
							d.setColor(colorInner);
							d.setSelected(false);
							setVisible(false);
						}
						
						 
						
						
						
						
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
