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

public class LineDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldXsp;
	private JTextField textFieldYsp;
	private JTextField textFieldXep;
	private JTextField textFieldYep;
	private Color color;
	private boolean ok;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LineDialog dialog = new LineDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public String getTextFieldXsp() {
		return textFieldXsp.getText();
	}



	public void setTextFieldXsp(String textFieldXsp) {
		this.textFieldXsp.setText(textFieldXsp);
	}



	public String getTextFieldYsp() {
		return textFieldYsp.getText();
	}



	public void setTextFieldYsp(String textFieldYsp) {
		this.textFieldYsp.setText(textFieldYsp);
	}



	public String getTextFieldXep() {
		return textFieldXep.getText();
	}



	public void setTextFieldXep(String textFieldXep) {
		this.textFieldXep.setText(textFieldXep);
	}



	public String getTextFieldYep() {
		return textFieldYep.getText();
	}



	public void setTextFieldYep(String textFieldYep) {
		this.textFieldYep.setText(textFieldYep);
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

	public void setTextFieldXspEnabled (boolean b){
		textFieldXsp.setEditable(b);
	}
	public void setTextFieldYspEnabled (boolean b){
		textFieldYsp.setEditable(b);
	}
	public void setTextFieldXepEnabled (boolean b){
		textFieldXep.setEditable(b);
	}
	public void setTextFieldYepEnabled (boolean b){
		textFieldYep.setEditable(b);
	}


	/**
	 * Create the dialog.
	 */
	public LineDialog() {
		setResizable(false);
		setTitle("Line properties");
		setBounds(100, 100, 440, 266);
		getContentPane().setLayout(new BorderLayout());
		setModal(true);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		JLabel lblStartPoint = new JLabel("Start Point");
		JLabel lblEndPoint = new JLabel("End Point");
		JLabel lblXcoordinateSp = new JLabel("X Coordinate:");
		JLabel lblYcoordinateSp = new JLabel("Y Coordinate:");
		
		textFieldXsp = new JTextField();
		textFieldXsp.setColumns(10);
		textFieldXsp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		textFieldYsp = new JTextField();
		textFieldYsp.setColumns(10);
		textFieldYsp.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		JLabel lblXcoordinateEp = new JLabel("X Coordinate:");
		
		
		JLabel lblYcoordinateEp = new JLabel("Y Coordinate:");
		
		textFieldXep = new JTextField();
		textFieldXep.setColumns(10);
		textFieldXep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		
		textFieldYep = new JTextField();
		textFieldYep.setColumns(10);
		textFieldYep.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGap(33)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblXcoordinateSp)
								.addComponent(lblYcoordinateSp)
								.addComponent(lblXcoordinateEp, Alignment.TRAILING)
								.addComponent(lblYcoordinateEp, Alignment.TRAILING))
							.addGap(26)
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
								.addComponent(textFieldYep, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
								.addComponent(textFieldXep, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
								.addComponent(textFieldYsp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
								.addComponent(textFieldXsp, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblStartPoint)))
					.addGap(171))
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEndPoint)
					.addContainerGap(369, Short.MAX_VALUE))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStartPoint)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXcoordinateSp)
						.addComponent(textFieldXsp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYcoordinateSp)
						.addComponent(textFieldYsp, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblEndPoint)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblXcoordinateEp)
						.addComponent(textFieldXep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYcoordinateEp)
						.addComponent(textFieldYep, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(53))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			buttonPane.setLayout(new MigLayout("", "[60][][][][][][][][][][47px][65px]", "[23px]"));
			{
				JButton pickAcolorButton = new JButton("Pick a color");
				buttonPane.add(pickAcolorButton, "cell 0 0");
				pickAcolorButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						color = JColorChooser.showDialog(null, "Color picker", color);
					}
				});
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
				buttonPane.add(okButton, "cell 10 0,alignx left,aligny top");
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
				buttonPane.add(cancelButton, "cell 11 0,alignx left,aligny top");
			}
		}
	}

}
