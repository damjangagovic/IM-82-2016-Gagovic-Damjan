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

public class DonutDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldXcoordinate;
	private JTextField textFieldYcoordinate;
	private JTextField textFieldInnerRadius;
	private JTextField textFieldOuterRadius;
	private Color borderColor;
	private Color innerColor;
	private boolean ok;

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
		setBounds(100, 100, 450, 268);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
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
							.addGap(27)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldOuterRadius, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldInnerRadius, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
									.addComponent(textFieldYcoordinate)
									.addComponent(textFieldXcoordinate, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))))
					.addContainerGap(187, Short.MAX_VALUE))
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
					.addContainerGap(65, Short.MAX_VALUE))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new MigLayout("", "[][][][][][][][][47px][65px]", "[23px]"));
			{
				JButton btnBorderColor = new JButton("Border Color");
				btnBorderColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						borderColor = JColorChooser.showDialog(null, "Color picker", borderColor);
					}
				});
				buttonPane.add(btnBorderColor, "cell 0 0");
			}
			{
				JButton btnInnerColor = new JButton("Inner Color");
				btnInnerColor.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						innerColor = JColorChooser.showDialog(null, "Color picker", innerColor);
					}
				});
				buttonPane.add(btnInnerColor, "cell 1 0");
			}
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							setOk(true);
							dispose();
						}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton, "cell 8 0,alignx left,aligny top");
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton, "cell 9 0,alignx left,aligny top");
			}
		}
	}

}
