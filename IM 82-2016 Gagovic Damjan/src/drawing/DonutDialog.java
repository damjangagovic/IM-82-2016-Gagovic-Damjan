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

public class DonutDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldXcoordinate;
	private JTextField textFieldYcoordinate;
	private JTextField textFieldInnerRadius;
	private JTextField textFieldOuterRadius;
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
			DonutDialog dialog = new DonutDialog();
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



	public String getTextFieldInnerRadius() {
		return textFieldInnerRadius.getText();
	}



	public void setTextFieldInnerRadius(String textFieldInnerRadius) {
		this.textFieldInnerRadius.setText(textFieldInnerRadius);
	}



	public String getTextFieldOuterRadius() {
		return textFieldOuterRadius.getText();
	}



	public void setTextFieldOuterRadius(String textFieldOuterRadius) {
		this.textFieldOuterRadius.setText(textFieldOuterRadius);
	}



	public Color getBorderColor() {
		return borderColor;
	}



	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
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
	
	public void setTextFieldXcoordinateEnabled (boolean b){
		textFieldXcoordinate.setEditable(b);
	}
	public void setTextFieldYcoordinateEnabled (boolean b){
		textFieldYcoordinate.setEditable(b);
	}

	/**
	 * Create the dialog.
	 */
	public DonutDialog() {
		setResizable(false);
		setTitle("Donut properties");
		setBounds(100, 100, 307, 309);
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
		textFieldXcoordinate.setColumns(10);
		textFieldYcoordinate = new JTextField();
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
		textFieldYcoordinate.setColumns(10);
		JLabel lblRadius = new JLabel("Radius");
		JLabel lblInnerRadius = new JLabel("Inner:");
		JLabel lblOuterRadius = new JLabel("Outer:");
		textFieldInnerRadius = new JTextField();
		textFieldInnerRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldInnerRadius.setColumns(10);
		textFieldOuterRadius = new JTextField();
		textFieldOuterRadius.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldOuterRadius.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblCenter))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblRadius))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(30)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblXcoordinate)
								.addComponent(lblYcoordinate)
								.addComponent(lblOuterRadius, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblInnerRadius))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGap(27)
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addGap(10)
											.addComponent(textFieldYcoordinate))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addGap(10)
											.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
												.addComponent(textFieldInnerRadius, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
												.addComponent(textFieldOuterRadius, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textFieldXcoordinate, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)))))
					.addContainerGap(44, Short.MAX_VALUE))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYcoordinate)
						.addComponent(textFieldYcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addComponent(lblRadius)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblInnerRadius)
						.addComponent(textFieldInnerRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblOuterRadius)
						.addComponent(textFieldOuterRadius, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(220, 220, 220));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnBorderColor = new JButton("Border Color");
				btnBorderColor.setForeground(new Color(245, 245, 245));
				btnBorderColor.setBackground(new Color(95, 158, 160));
				btnBorderColor.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnBorderColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						borderColor = JColorChooser.showDialog(null, "Color picker", null);
					}
				});
			}
			{
				btnInnerColor = new JButton("Inner Color");
				btnInnerColor.setBackground(new Color(95, 158, 160));
				btnInnerColor.setForeground(new Color(245, 245, 245));
				btnInnerColor.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnInnerColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						innerColor = JColorChooser.showDialog(null, "Color picker", null);
					}
				});
			}
			{
				okButton = new JButton("OK");
				okButton.setForeground(new Color(245, 245, 245));
				okButton.setFont(new Font("Tahoma", Font.BOLD, 11));
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
				cancelButton.setBackground(new Color(95, 158, 160));
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				cancelButton.setForeground(new Color(245, 245, 245));
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
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.TRAILING)
							.addComponent(btnInnerColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
							.addComponent(btnBorderColor, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGap(26)
						.addComponent(okButton)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cancelButton)
						.addGap(197))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBorderColor)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnInnerColor)
						.addContainerGap())
					.addGroup(Alignment.TRAILING, gl_buttonPane.createSequentialGroup()
						.addContainerGap(27, Short.MAX_VALUE)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(okButton)
							.addComponent(cancelButton))
						.addGap(24))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}

}
