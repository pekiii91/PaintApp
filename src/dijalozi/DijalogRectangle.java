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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import oblici.Point;
import oblici.Rectangle;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	public Rectangle rectangle;

	
	public String xKoordinata;
	public String yKoordinata;
	public String height;	// visina
	public String width;	// sirina
	public Color innerColor;	// Boja Unutrasnjosti
	public Color rimColor;		// Boja oboda
	
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtHeight;
	private JTextField txtWidth;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		try {
			DijalogRectangle dialog = new DijalogRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public DijalogRectangle(Rectangle r) {
		setTitle("Rectangle");
		setModal(true);
		setResizable(false);
		this.rectangle = r;
		
		setBounds(100, 100, 668, 724);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblVisinaPravougaonika = new JLabel("Height rectangle");
		JLabel lblSirinaPravougaonika = new JLabel("Width rectangle");
		JLabel lblBojaUnutrasnjosti = new JLabel("Inner color");
		JLabel lblBojaOboda = new JLabel("Rim color");
		JLabel lblKoordinate = new JLabel("koordinate");
		
		///JComboBox cmbBoxColorInner = new JComboBox();
		JColorChooser cmbBoxColorInner = new JColorChooser();
		
		//JComboBox cmbBoxColorRim = new JComboBox();
		JColorChooser cmbBoxColorRim = new JColorChooser();

		
		txtX = new JTextField();
		txtX.setText("0");
		txtX.setColumns(10);
		
		txtY = new JTextField();
		txtY.setText("0");
		txtY.setColumns(10);
		
		txtHeight = new JTextField();
		txtHeight.setText("0");
		txtHeight.setColumns(10);
		
		txtWidth = new JTextField();
		txtWidth.setText("0");
		txtWidth.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblKoordinate)
						.addComponent(lblVisinaPravougaonika)
						.addComponent(lblBojaUnutrasnjosti)
						.addComponent(lblSirinaPravougaonika)
						.addComponent(lblBojaOboda, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
					.addGap(72)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(38)
							.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
							.addComponent(cmbBoxColorRim, 0, 0, Short.MAX_VALUE)
							.addComponent(cmbBoxColorInner, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(37, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblKoordinate)
								.addComponent(txtX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(txtHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
								.addComponent(txtWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSirinaPravougaonika)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(38)
							.addComponent(lblVisinaPravougaonika)))
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(14)
							.addComponent(lblBojaUnutrasnjosti))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(18)
							.addComponent(cmbBoxColorInner, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)))
					.addGap(40)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(cmbBoxColorRim, GroupLayout.PREFERRED_SIZE, 171, Short.MAX_VALUE)
						.addComponent(lblBojaOboda, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
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
						height = txtHeight.getText();
						int s = 0;
						width = txtWidth.getText();
						int v = 0;
						innerColor = cmbBoxColorInner.getColor();
						rimColor = cmbBoxColorRim.getColor();
						
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
						
						if(height.length() > 0) {
							try {
								x = (int) Double.parseDouble(height);
							} catch (NumberFormatException ee) {
								JOptionPane.showMessageDialog(null, 
										"Morate uneti ceo broj za visinu!",
										"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
								imaGreska = true;
							}
						} else {
							JOptionPane.showMessageDialog(null, 
									"Morate uneti ceo broj za visinu!", 
									"Greska", JOptionPane.ERROR_MESSAGE);
								imaGreska = true;
						}
						if(width.length() > 0) {
							try {
								x = (int) Double.parseDouble(width);
							} catch (NumberFormatException ee) {
								JOptionPane.showMessageDialog(null, 
										"Morate uneti ceo broj sirinu!",
										"Obavestenje", JOptionPane.INFORMATION_MESSAGE);
								imaGreska = true;
							}
						} else {
							JOptionPane.showMessageDialog(null, 
									"Morate uneti ceo broj za sirinu!", 
									"Greska", JOptionPane.ERROR_MESSAGE);
								imaGreska = true;
						}
						
						if (imaGreska == false) {
							r.setUpperLeftPoint(new Point(x,y));
							r.setHeight(s);
							r.setColor(rimColor);
							r.setColor(innerColor);
							r.setSelected(false);
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
