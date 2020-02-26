package dijalozi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import oblici.Circle;
import oblici.Point;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DijalogCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Circle circle;
	private JLabel lblXKoordinata;
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtRadius;
	private JLabel lblRadius;
	private JLabel lblYKoordinata;
	private JLabel lblInnerColor;
	private JLabel lblRimColor;
	public String xKoordinata;
	public String yKoordinata;
	public String radius;
	
	public JColorChooser cmbBoxColorInner;
	public JColorChooser cmbBoxColorRim;
	public Color colorInner;
	public Color colorRim;
	
	
	
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			DijalogCircle dialog = new DijalogCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 * @param c 
	 */
	public DijalogCircle(Circle c) {
		setModal(true);
		setTitle("Circle");
		setResizable(false);
		this.circle = c;
		setBounds(100, 100, 639, 654);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblXKoordinata = new JLabel("x koordinata");
		}
		{
			lblYKoordinata = new JLabel("y koordinata");
		}
		{
			lblRadius = new JLabel("Radius");
		}
		{
			lblInnerColor = new JLabel("Inner color");
		}
		{
			lblRimColor = new JLabel("Rim color");
		}
		{
			txtX = new JTextField();
			txtX.setText("0");
			txtX.setColumns(10);
		}
		{
			txtY = new JTextField();
			txtY.setText("0");
			txtY.setColumns(10);
		}
		{
			txtRadius = new JTextField();
			txtRadius.setText("0");
			txtRadius.setColumns(10);
		}
		
		JColorChooser cmbBoxColorInner = new JColorChooser();
		{
			cmbBoxColorRim = new JColorChooser();
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(7)
							.addComponent(lblInnerColor, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblRimColor, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(5)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(2)
									.addComponent(lblXKoordinata, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblRadius, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(2)
									.addComponent(lblYKoordinata, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)))))
					.addGap(67)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbBoxColorRim, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbBoxColorInner, GroupLayout.PREFERRED_SIZE, 407, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtY, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtX, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE))
					.addGap(28))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(16)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblXKoordinata, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtX, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
							.addGap(38)
							.addComponent(lblRadius, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(32)
							.addComponent(lblYKoordinata, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(40)
							.addComponent(txtY, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
							.addGap(11)
							.addComponent(txtRadius, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)))
					.addGap(22)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblInnerColor, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(8)
							.addComponent(cmbBoxColorInner, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(cmbBoxColorRim, GroupLayout.PREFERRED_SIZE, 190, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRimColor, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(29))
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
						radius  = txtRadius.getText();
						int r = 0;
						colorInner = cmbBoxColorInner.getColor();
						colorRim = cmbBoxColorRim.getColor();
						
						boolean imaGreska = false;
						if(xKoordinata.length() > 0) {
							try {
								x = (int) Double.parseDouble(xKoordinata);
							} catch (NumberFormatException ee) {
								JOptionPane.showMessageDialog(null, 
										"Morate uneti ceo broj za x koordinatu!", 
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
								x = (int) Double.parseDouble(yKoordinata);
							} catch (NumberFormatException ee) {
								JOptionPane.showMessageDialog(null, 
										"Morate uneti ceo broj za y koordinatu!", 
										"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
								imaGreska = true;
							}
						} else {
							JOptionPane.showMessageDialog(null, 
									"Morate uneti ceo broj za y koordinatu!", 
									"Greska", JOptionPane.ERROR_MESSAGE);
							imaGreska = true;
						}
						if(radius.length() > 0) {
							try {
								x = (int) Double.parseDouble(radius);
							} catch (NumberFormatException ee) {
								JOptionPane.showMessageDialog(null, 
										"Morate uneti ceo broj za radius!", 
										"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
								imaGreska = true;
							}
						} else {
							JOptionPane.showMessageDialog(null, 
									"Morate uneti ceo broj za radius!", 
									"Greska", JOptionPane.ERROR_MESSAGE);
							imaGreska = true;
						}
						if (imaGreska == false) {
							circle.setCenter(new Point(x,y));
							circle.setRadius(r);
							circle.setColor(colorRim);
							circle.setColor(colorInner);
							circle.setSelected(false);
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
