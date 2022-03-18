package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.Font;

public class CircleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldXcoordinate;
	private JTextField textFieldYcoordinate;
	private JTextField textFieldRadius;
	private Color borderColor;
	private Color innerColor;
	private boolean ok;
	private JButton btnBorderColor;
	private JButton btnInnerColor;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CircleDialog dialog = new CircleDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public String getTextFieldXcoordinate() {
		return textFieldXcoordinate.getText();
	}



	public void setTextFieldXcoordinate(String textFieldXcoordinate) {
		this.textFieldXcoordinate.setText(textFieldXcoordinate);
	}



	public String getTextFieldYcoordinate() {
		return textFieldYcoordinate.getText();
	}



	public void setTextFieldYcoordinate(String textFieldYcoordinate) {
		this.textFieldYcoordinate.setText(textFieldYcoordinate);
	}



	public String getTextFieldRadius() {
		return textFieldRadius.getText();
	}



	public void setTextFieldRadius(String textFieldRadius) {
		this.textFieldRadius.setText(textFieldRadius);
	}



	public Color getBorderColor() {
		return borderColor;
	}



	public void setBorderColor(Color corderColor) {
		this.borderColor = corderColor;
	}



	public Color getInnerColor() {
		return innerColor;
	}



	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}



	public boolean isOk() {
		return ok;
	}



	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public void setTextFieldXcoordinateEnabled(boolean b) {
		textFieldXcoordinate.setEditable(b);
	}

	public void setTextFieldYcoordinateEnabled(boolean b) {
		textFieldYcoordinate.setEditable(b);
	}


	/**
	 * Create the dialog.
	 */
	public CircleDialog() {
		setResizable(false);
		setTitle("Circle properties");
		setBounds(100, 100, 327, 266);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBackground(new Color(220, 220, 220));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblCenter = new JLabel("Center");
		JLabel lblXcoordinate = new JLabel("X Coordinate:");
		JLabel lblYcoordinate = new JLabel("Y Coordinate:");
		textFieldXcoordinate = new JTextField();
		textFieldXcoordinate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldXcoordinate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldXcoordinate.setColumns(10);
		textFieldYcoordinate = new JTextField();
		textFieldYcoordinate.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldYcoordinate.setColumns(10);
		JLabel lblRadius = new JLabel("Radius:");
		textFieldRadius = new JTextField();
		textFieldRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldRadius.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCenter))
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addGap(37)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
									.addComponent(lblXcoordinate)
									.addComponent(lblYcoordinate)))
							.addGroup(gl_contentPanel.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblRadius, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))))
					.addGap(41)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFieldRadius, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldYcoordinate, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldXcoordinate, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addGap(56))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblCenter)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXcoordinate)
						.addComponent(textFieldXcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYcoordinate)
						.addComponent(textFieldYcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRadius)
						.addComponent(textFieldRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(34, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(220, 220, 220));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnBorderColor = new JButton("Border Color");
				btnBorderColor.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnBorderColor.setForeground(new Color(220, 220, 220));
				btnBorderColor.setBackground(new Color(95, 158, 160));
				btnBorderColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						borderColor = JColorChooser.showDialog(null, "Color picker", borderColor);
					}
				});
			}
			{
				btnInnerColor = new JButton("Inner Color");
				btnInnerColor.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnInnerColor.setForeground(new Color(220, 220, 220));
				btnInnerColor.setBackground(new Color(95, 158, 160));
				btnInnerColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						innerColor = JColorChooser.showDialog(null, "Color picker", innerColor);
					}
				});
			}
			{
				okButton = new JButton("OK");
				okButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				okButton.setForeground(new Color(220, 220, 220));
				okButton.setBackground(new Color(95, 158, 160));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							setOk(true);
							dispose();
						}
				});
				okButton.setActionCommand("OK");
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				cancelButton.setForeground(new Color(220, 220, 220));
				cancelButton.setBackground(new Color(95, 158, 160));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnInnerColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnBorderColor, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(41)
						.addComponent(okButton)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cancelButton)
						.addGap(45))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_buttonPane.createSequentialGroup()
								.addComponent(btnBorderColor)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnInnerColor))
							.addGroup(gl_buttonPane.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(okButton)
									.addComponent(cancelButton))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}

}
