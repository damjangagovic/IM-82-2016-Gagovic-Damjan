package stack;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;
import geometry.Rectangle;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class StackFrame extends JFrame {

	private JPanel contentPane;
	private DefaultListModel <Rectangle> rectangleDeafaultListModel = new DefaultListModel <Rectangle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StackFrame frame = new StackFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StackFrame() {
		setResizable(false);
		setTitle("IM 82-2016 Gagovic Damjan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RectangleDialog dialog = new RectangleDialog();
				dialog.setVisible(true);
				if(dialog.isOk()) {
					try {
						Point point = new Point(Integer.parseInt(dialog.getTextFieldXcoordinate().getText()), Integer.parseInt(dialog.getTextFieldYcoordinate().getText()));
						Rectangle rectangle = new Rectangle(point, Integer.parseInt(dialog.getTextFieldHeight().getText()), Integer.parseInt(dialog.getTextFieldWidth().getText()));
						rectangleDeafaultListModel.add(0,rectangle);
				
					} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Greška pri unosu!", "Error!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		panel.add(addButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RectangleDialog dialog = new RectangleDialog();
					try {
						dialog.getTextFieldXcoordinate().setText(Integer.toString(rectangleDeafaultListModel.get(0).getUpperLeft().getX()));
						dialog.getTextFieldYcoordinate().setText(Integer.toString(rectangleDeafaultListModel.get(0).getUpperLeft().getY()));
						dialog.getTextFieldHeight().setText(Integer.toString(rectangleDeafaultListModel.get(0).getHeight()));
						dialog.getTextFieldWidth().setText(Integer.toString(rectangleDeafaultListModel.get(0).getWidth()));
						dialog.getTextFieldWidth().setEditable(false);
						dialog.getTextFieldHeight().setEditable(false);
						dialog.getTextFieldXcoordinate().setEditable(false);
						dialog.getTextFieldYcoordinate().setEditable(false);
						dialog.setVisible(true);
						if (dialog.isOk()) {
							rectangleDeafaultListModel.remove(0);
						}
					} catch (ArrayIndexOutOfBoundsException ex) {
						JOptionPane.showMessageDialog(null, "List is empty!", "Error!", JOptionPane.ERROR_MESSAGE );
					}
				}
		});
		panel.add(deleteButton);
		
		JScrollPane scrollRectangle = new JScrollPane();
		contentPane.add(scrollRectangle, BorderLayout.CENTER);
		
		JList listRectangle = new JList();
		scrollRectangle.setViewportView(listRectangle);
		listRectangle.setModel(rectangleDeafaultListModel);
	}

}
