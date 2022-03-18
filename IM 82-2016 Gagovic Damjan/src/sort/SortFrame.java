package sort;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

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
import java.awt.Color;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class SortFrame extends JFrame {

	private JPanel contentPane;
	private DefaultListModel <Rectangle> rectangleDefaultListModel = new DefaultListModel <Rectangle>();
	private ArrayList<Rectangle> rectangleList = new ArrayList<Rectangle>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SortFrame frame = new SortFrame();
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
	public SortFrame() {
		setResizable(false);
		setTitle("IM 82-2016 Gagovic Damjan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton addButton = new JButton("Add");
		addButton.setBackground(new Color(220, 220, 220));
		addButton.setForeground(new Color(105, 105, 105));
		addButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RectangleDialog dialog = new RectangleDialog();
				dialog.setVisible(true);
				if(dialog.isOk()) {
					try {
						Point point = new Point(Integer.parseInt(dialog.getTextFieldXcoordinate().getText()), Integer.parseInt(dialog.getTextFieldYcoordinate().getText()));
						Rectangle rectangle = new Rectangle(point, Integer.parseInt(dialog.getTextFieldHeight().getText()), Integer.parseInt(dialog.getTextFieldWidth().getText()));
						rectangleDefaultListModel.add(0,rectangle);
				
					} catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Greška pri unosu!", "Error!", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
		});
		
		JButton sortButton = new JButton("Sort");
		sortButton.setBackground(new Color(220, 220, 220));
		sortButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		sortButton.setForeground(new Color(105, 105, 105));
		sortButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Rectangle rectangle = null;
				
				if(rectangleDefaultListModel.isEmpty()){
					JOptionPane.showMessageDialog(null, "List is empty");
				} else {
					int rectangleDefaultListModelSize = rectangleDefaultListModel.getSize();
					
					for(int i = 0; i < rectangleDefaultListModelSize; i++){
						rectangleList.add(rectangleDefaultListModel.getElementAt(i));
					}
					for(int i = rectangleList.size(); i > 0; i--){
						for(int j = 0; j < i - 1; j++){
							if((rectangleList.get(j)).compareTo(rectangleList.get(j + 1)) > 0)
							{
								rectangle = rectangleList.get(j);
								rectangleList.set(j, rectangleList.get(j + 1));
								rectangleList.set(j + 1, rectangle);
							}
						}
					}
					
				}
				
				rectangleDefaultListModel.removeAllElements();
				
				for(int i = 0; i < rectangleList.size(); i++)
				{
					rectangleDefaultListModel.addElement(rectangleList.get(i));
				}
				
				rectangleList.clear();
			}
		});
		panel.add(sortButton);
		panel.add(addButton);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBackground(new Color(220, 220, 220));
		deleteButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		deleteButton.setForeground(new Color(105, 105, 105));
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RectangleDialog dialog = new RectangleDialog();
					try {
						dialog.getTextFieldXcoordinate().setText(Integer.toString(rectangleDefaultListModel.get(0).getUpperLeft().getX()));
						dialog.getTextFieldYcoordinate().setText(Integer.toString(rectangleDefaultListModel.get(0).getUpperLeft().getY()));
						dialog.getTextFieldHeight().setText(Integer.toString(rectangleDefaultListModel.get(0).getHeight()));
						dialog.getTextFieldWidth().setText(Integer.toString(rectangleDefaultListModel.get(0).getWidth()));
						dialog.getTextFieldWidth().setEditable(false);
						dialog.getTextFieldHeight().setEditable(false);
						dialog.getTextFieldXcoordinate().setEditable(false);
						dialog.getTextFieldYcoordinate().setEditable(false);
						dialog.setVisible(true);
						if (dialog.isOk()) {
							rectangleDefaultListModel.remove(0);
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
		listRectangle.setModel(rectangleDefaultListModel);
	}

}
