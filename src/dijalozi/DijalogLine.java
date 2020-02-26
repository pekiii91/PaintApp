package dijalozi;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import oblici.Line;
import oblici.Point;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DijalogLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Line line;
	
	private JTextField txtXStart;
	private JTextField txtYStart;
	private JTextField txtXEnd;
	private JTextField txtYEnd;
	
	private JLabel lblLineColor;
	public Color colorLine;
	public String xStartPoint;
	public String yStartPoint;
	public String xEndPoint;
	public String yEndPoint;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			DijalogLine dialog = new DijalogLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public DijalogLine(Line l) {
		setBounds(100, 100, 690, 420);
		setResizable(false);
		setModal(true);
		setTitle("Line");
		setSize(690,420);
		this.line = l;
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblKoordinateStartPoint = new JLabel("koordinate start point");
		
		JLabel lblKoordinateEndPoint = new JLabel("koordinate end point");
		
		JLabel lblLineColor = new JLabel("Line color");
		
		txtXStart = new JTextField();
		txtXStart.setText("0");
		txtXStart.setColumns(10);
		
		txtYStart = new JTextField();
		txtYStart.setText("0");
		txtYStart.setColumns(10);
		
		txtXEnd = new JTextField();
		txtXEnd.setText("0");
		txtXEnd.setColumns(10);
		
		txtYEnd = new JTextField();
		txtYEnd.setText("0");
		txtYEnd.setColumns(10);
		
	//	JComboBox cmbBoxColorLine = new JComboBox();
	
		JColorChooser cmbBoxColorLine = new JColorChooser();
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(47)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblKoordinateStartPoint)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(lblLineColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblKoordinateEndPoint, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(63)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtXStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtXEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(55)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(txtYEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtYStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(cmbBoxColorLine, GroupLayout.PREFERRED_SIZE, 415, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(22, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblKoordinateStartPoint)
						.addComponent(txtXStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtYStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(txtXEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(txtYEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblKoordinateEndPoint))
					.addGap(31)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLineColor, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(cmbBoxColorLine, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(24, Short.MAX_VALUE))
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
						xStartPoint = txtXStart.getText();
						int x = 0;
						yStartPoint = txtYStart.getText();
						int y = 0;
						xEndPoint = txtXEnd.getText();
						int a = 0;
						yEndPoint = txtYEnd.getText();
						int b = 0;
						
						colorLine = cmbBoxColorLine.getColor();
						boolean imaGreska = false;
						if (xStartPoint.length() > 0) {
							try {
								x = (int) Double.parseDouble(xStartPoint);
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
						
						if (yStartPoint.length() > 0) {
							try {
								x = (int) Double.parseDouble(yStartPoint);
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
						
						if (xEndPoint.length() > 0) {
							try {
								x = (int) Double.parseDouble(xEndPoint);
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
						
						if (yEndPoint.length() > 0) {
							try {
								x = (int) Double.parseDouble(yEndPoint);
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
						
						if (imaGreska == false) {
							line.setStartPoint(new Point(x,y));
							line.setEndPoint(new Point(a,b));
							line.setColor(colorLine);
							line.setSelected(false);
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
