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

public class RectangleDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldXcoordinate;
	private JTextField textFieldYcoordinate;
	private JTextField textFieldWidth;
	private JTextField textFieldHeight;
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
			RectangleDialog dialog = new RectangleDialog();
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



	public String getTextFieldWidth() {
		return textFieldWidth.getText();
	}



	public void setTextFieldWidth(JTextField textFieldWidth) {
		this.textFieldWidth = textFieldWidth;
	}



	public String getTextFieldHeight() {
		return textFieldHeight.getText();
	}



	public void setTextFieldHeight(JTextField textFieldHeight) {
		this.textFieldHeight = textFieldHeight;
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
	
	public void setTextFieldWidth(String textFieldWidth) {
		this.textFieldWidth.setText(textFieldWidth);
	}

	public void setTextFieldHeight(String textFieldHeight) {
		this.textFieldHeight.setText(textFieldHeight);
	}


	/**
	 * Create the dialog.
	 */
	public RectangleDialog() {
		setResizable(false);
		setTitle("Rectangle properties");
		setBounds(100, 100, 338, 278);
		BorderLayout borderLayout = new BorderLayout();
		getContentPane().setLayout(borderLayout);
		setModal(true);
		contentPanel.setBackground(new Color(220, 220, 220));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblStartPoint = new JLabel("Start Point");
		JLabel lblXcoordinate = new JLabel("X Coordinate:");
		JLabel lblYcoordinate = new JLabel("Y Coordinate:");
		textFieldXcoordinate = new JTextField();
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
		JLabel lblWidth = new JLabel("Width:");
		JLabel lblHeight = new JLabel("Height:");
		textFieldWidth = new JTextField();
		textFieldWidth.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldWidth.setColumns(10);
		textFieldHeight = new JTextField();
		textFieldHeight.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		textFieldHeight.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblStartPoint))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(36)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblYcoordinate)
								.addComponent(lblXcoordinate)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblWidth, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblHeight, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(textFieldYcoordinate, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldXcoordinate, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldWidth, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldHeight, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE))
					.addGap(34))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStartPoint)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXcoordinate)
						.addComponent(textFieldXcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYcoordinate)
						.addComponent(textFieldYcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblWidth)
						.addComponent(textFieldWidth, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblHeight)
						.addComponent(textFieldHeight, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(220, 220, 220));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnInnerColor = new JButton("Inner Color");
				btnInnerColor.setBackground(new Color(95, 158, 160));
				btnInnerColor.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnInnerColor.setForeground(new Color(245, 245, 245));
				btnInnerColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						innerColor = JColorChooser.showDialog(null, "Color picker", innerColor);
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
			{
				btnBorderColor = new JButton("Border Color");
				btnBorderColor.setForeground(new Color(245, 245, 245));
				btnBorderColor.setFont(new Font("Tahoma", Font.BOLD, 11));
				btnBorderColor.setBackground(new Color(95, 158, 160));
				btnBorderColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						borderColor = JColorChooser.showDialog(null, "Color picker", borderColor);
					}
				});
			}
			GroupLayout gl_buttonPane = new GroupLayout(buttonPane);
			gl_buttonPane.setHorizontalGroup(
				gl_buttonPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.LEADING, false)
							.addComponent(btnInnerColor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnBorderColor, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE))
						.addPreferredGap(ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
						.addComponent(okButton)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cancelButton)
						.addGap(37))
			);
			gl_buttonPane.setVerticalGroup(
				gl_buttonPane.createParallelGroup(Alignment.TRAILING)
					.addGroup(Alignment.LEADING, gl_buttonPane.createSequentialGroup()
						.addContainerGap()
						.addComponent(btnBorderColor)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnInnerColor)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGroup(Alignment.LEADING, gl_buttonPane.createSequentialGroup()
						.addGap(25)
						.addGroup(gl_buttonPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(okButton)
							.addComponent(cancelButton))
						.addContainerGap(26, Short.MAX_VALUE))
			);
			buttonPane.setLayout(gl_buttonPane);
		}
	}

}
