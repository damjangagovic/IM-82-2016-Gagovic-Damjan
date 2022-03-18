package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.CardLayout;
import javax.swing.BoxLayout;

public class PointDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldXcoordinate;
	private JTextField textFieldYcoordinate;
	private Color color;
	private boolean ok;
	private JButton pickAcolorButton;
	private JButton okButton;
	private JButton cancelButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PointDialog dialog = new PointDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setTextXcoordinateEnabled (boolean b){
		textFieldXcoordinate.setEditable(b);
	}
	
	public void setTextYcoordinateEnabled (boolean b){
		textFieldYcoordinate.setEditable(b);
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
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	/**
	 * Create the dialog.
	 */
	public PointDialog() {
		setResizable(false);
		setTitle("Point properties");
		setBounds(100, 100, 295, 155);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBackground(new Color(220, 220, 220));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		textFieldYcoordinate = new JTextField();
		textFieldYcoordinate.setColumns(10);
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
		
		textFieldXcoordinate = new JTextField();
		textFieldXcoordinate.setColumns(10);
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
		
		JLabel lblXcoordinate = new JLabel("X Coordinate:");
		
		JLabel label = new JLabel("");
		
		JLabel label_1 = new JLabel("");
		
		JLabel label_2 = new JLabel("");
		
		JLabel lblYcoordinate = new JLabel("Y Coordinate:");
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(17)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblYcoordinate)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(lblXcoordinate)
							.addGap(14)
							.addComponent(label)
							.addGap(5)
							.addComponent(label_1)
							.addGap(5)
							.addComponent(label_2)))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(textFieldXcoordinate)
						.addComponent(textFieldYcoordinate, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
					.addContainerGap(24, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGap(3)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(12)
							.addComponent(label))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(12)
							.addComponent(label_1))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(12)
							.addComponent(label_2))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(3)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldXcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblXcoordinate))))
					.addGap(12)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYcoordinate)
						.addComponent(textFieldYcoordinate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setBackground(new Color(220, 220, 220));
			buttonPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
			getContentPane().add(buttonPanel, BorderLayout.SOUTH);
			{
				pickAcolorButton = new JButton("Pick a color");
				pickAcolorButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				pickAcolorButton.setBackground(new Color(95, 158, 160));
				pickAcolorButton.setForeground(new Color(245, 245, 245));
				pickAcolorButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						color = JColorChooser.showDialog(null, "Color picker", color);
					}
				});
			}
			{
				okButton = new JButton("OK");
				okButton.setFont(new Font("Tahoma", Font.BOLD, 11));
				okButton.setBackground(new Color(95, 158, 160));
				okButton.setForeground(new Color(245, 245, 245));
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
				cancelButton.setBackground(new Color(95, 158, 160));
				cancelButton.setForeground(new Color(245, 245, 245));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
			}
			GroupLayout gl_buttonPanel = new GroupLayout(buttonPanel);
			gl_buttonPanel.setHorizontalGroup(
				gl_buttonPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPanel.createSequentialGroup()
						.addContainerGap()
						.addComponent(pickAcolorButton)
						.addGap(30)
						.addComponent(okButton)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(cancelButton)
						.addContainerGap(30, Short.MAX_VALUE))
			);
			gl_buttonPanel.setVerticalGroup(
				gl_buttonPanel.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_buttonPanel.createSequentialGroup()
						.addGroup(gl_buttonPanel.createParallelGroup(Alignment.BASELINE)
							.addComponent(pickAcolorButton)
							.addComponent(okButton)
							.addComponent(cancelButton))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			buttonPanel.setLayout(gl_buttonPanel);
		}
	}
}
