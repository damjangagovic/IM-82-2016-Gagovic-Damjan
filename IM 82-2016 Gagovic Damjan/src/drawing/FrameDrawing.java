package drawing;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.UIManager;
import net.miginfocom.swing.MigLayout;
import javax.swing.JToggleButton;

public class FrameDrawing extends JFrame {

	private JPanel contentPane;
	JToggleButton tglbtnSelect;
	JToggleButton tglbtnModify;
	JToggleButton tglbtnDelete;
	JToggleButton tglbtnPoint;
	JToggleButton tglbtnLine;
	JToggleButton tglbtnRectangle;
	JToggleButton tglbtnCircle;
	JToggleButton tglbtnDonut;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameDrawing frame = new FrameDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public boolean getTglbtnSelect() {
		return tglbtnSelect.isSelected();
	}

	public boolean getTglbtnModify() {
		return tglbtnModify.isSelected();
	}

	public boolean getTglbtnDelete() {
		return tglbtnDelete.isSelected();
	}

	public boolean getTglbtnPoint() {
		return tglbtnPoint.isSelected();
	}

	public boolean getTglbtnLine() {
		return tglbtnLine.isSelected();
	}

	public boolean getTglbtnRectangle() {
		return tglbtnRectangle.isSelected();
	}

	public boolean getTglbtnCircle() {
		return tglbtnCircle.isSelected();
	}

	public boolean getTglbtnDonut() {
		return tglbtnDonut.isSelected();
	}
	

	/**
	 * Create the frame.
	 */
	public FrameDrawing() {
		setTitle("IM 82-2016 Gagović Damjan");
		PanelDrawing panel = new PanelDrawing(this);
		panel.setBackground(new Color(250, 250, 250));
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setSize(new Dimension(20, 40));
		panel.setPreferredSize(new Dimension(200, 400));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 666, 333);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		contentPane.add(panel);
		
		
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setBorder(null);
		buttonsPanel.setBackground(UIManager.getColor("CheckBoxMenuItem.selectionBackground"));
		contentPane.add(buttonsPanel, BorderLayout.NORTH);
		buttonsPanel.setLayout(new MigLayout("", "[128.00px][110px][360px]", "[36px]"));
		
		JPanel actions = new JPanel();
		actions.setBackground(Color.WHITE);
		buttonsPanel.add(actions, "cell 0 0,alignx left,aligny center");
		
		tglbtnSelect = new JToggleButton("Select");
		
		tglbtnModify = new JToggleButton("Modify");
		tglbtnModify.addMouseListener(new MouseAdapter() {
		public void mouseClicked(MouseEvent arg0) {
			if (panel.getSelected() != null) {
				Shape shape = panel.getSelected();
				ArrayList<Shape> list = panel.getShapes();
				int index = list.indexOf(shape);
				if (panel.getSelected() instanceof Point) {
					PointDialog point = new PointDialog();
					point.setTextFieldXcoordinate(Integer.toString(((Point) shape).getX()));
					point.setTextFieldYcoordinate(Integer.toString(((Point) shape).getY()));
					point.setColor(((Point) shape).getColor());
					int x = Integer.parseInt(point.getTextFieldXcoordinate());
					int y = Integer.parseInt(point.getTextFieldYcoordinate());
					Color color = point.getColor();
					point.setVisible(true);
					try {
						((Point) shape).setX(Integer.parseInt(point.getTextFieldXcoordinate()));
						((Point) shape).setY(Integer.parseInt(point.getTextFieldYcoordinate()));
						((Point) shape).setColor(point.getColor());
						
						if(point.isOk()) {
							list.set(index, shape);
							panel.setShapes(list);
							shape.setSelected(true);
							panel.setSelected(shape);
							panel.repaint();
						} else {
							((Point) shape).setX(x);
							((Point) shape).setY(y);
							((Point) shape).setColor(color);
						}
					} catch (NumberFormatException e) {
						JOptionPane.showMessageDialog(new JFrame(), "Invalid data!", "Error!",
								JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(new JFrame(), "Invalid data!", "Error!",
								JOptionPane.ERROR_MESSAGE);
						// TODO Auto-generated catch block
						
					}
				} else if (panel.getSelected() instanceof Line) {
					LineDialog line = new LineDialog();
					line.setTextFieldXsp(Integer.toString(((Line) shape).getStartPoint().getX()));
					line.setTextFieldYsp(Integer.toString(((Line) shape).getStartPoint().getY()));
					line.setTextFieldXep(Integer.toString(((Line) shape).getEndPoint().getX()));
					line.setTextFieldYep(Integer.toString(((Line) shape).getEndPoint().getY()));
					line.setColor(((Line) shape).getColor());
					int spX = Integer.parseInt(line.getTextFieldXsp());
					int spY = Integer.parseInt(line.getTextFieldYsp());
					int epX = Integer.parseInt(line.getTextFieldXep());
					int epY = Integer.parseInt(line.getTextFieldYep());
					Color color = line.getColor();
					line.setVisible(true);
					try {
						((Line) shape).setStartPoint(new Point((Integer.parseInt(line.getTextFieldXsp())),
								(Integer.parseInt(line.getTextFieldYsp()))));
						((Line) shape).setEndPoint(new Point((Integer.parseInt(line.getTextFieldXep())),
								(Integer.parseInt(line.getTextFieldYep()))));
						((Line) shape).setColor(line.getColor());

						if (line.isOk()) {
							list.set(index, shape);
							panel.setShapes(list);
							shape.setSelected(true);
							panel.setSelected(shape);
							panel.repaint();
						} else {
							((Line) shape).setStartPoint(new Point (spX,spY));
							((Line) shape).setEndPoint(new Point(epX,epY));
							((Line) shape).setColor(color);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(new JFrame(), "Invalid data!", "Error!",
								JOptionPane.ERROR_MESSAGE);
						// TODO: handle exception
					}
				} else if (panel.getSelected() instanceof Rectangle) {
					RectangleDialog rectangle = new RectangleDialog();
					rectangle.setTextFieldXcoordinate(Integer.toString(((Rectangle) shape).getUpperLeft().getX()));
					rectangle.setTextFieldYcoordinate(Integer.toString(((Rectangle) shape).getUpperLeft().getY()));
					rectangle.setTextFieldWidth(Integer.toString(((Rectangle) shape).getWidth()));
					rectangle.setTextFieldHeight(Integer.toString(((Rectangle) shape).getHeight()));
					rectangle.setBorderColor(((Rectangle) shape).getColor());
					rectangle.setInnerColor(((Rectangle) shape).getInnerColor());
					int x = Integer.parseInt(rectangle.getTextFieldXcoordinate());
					int y = Integer.parseInt(rectangle.getTextFieldYcoordinate());
					int width = Integer.parseInt(rectangle.getTextFieldWidth());
					int height = Integer.parseInt(rectangle.getTextFieldHeight());
					Color borderColor = rectangle.getBorderColor();
					Color innerColor = rectangle.getInnerColor();
					
					
					rectangle.setVisible(true);
					
					try {
						((Rectangle) shape).setUpperLeft(
								new Point(Integer.parseInt(rectangle.getTextFieldXcoordinate()), Integer.parseInt(rectangle.getTextFieldYcoordinate())));
						((Rectangle) shape).setWidth(Integer.parseInt(rectangle.getTextFieldWidth()));
						((Rectangle) shape).setHeight(Integer.parseInt(rectangle.getTextFieldHeight()));
						((Rectangle) shape).setColor(rectangle.getBorderColor());
						((Rectangle) shape).setInnerColor(rectangle.getInnerColor());
						if (rectangle.isOk()) {
							list.set(index, shape);
							panel.setShapes(list);
							shape.setSelected(true);
							panel.setSelected(shape);
							panel.repaint();
						} else {
							((Rectangle) shape).setHeight(height);
							((Rectangle) shape).setWidth(width);
							((Rectangle) shape).setColor(borderColor);
							((Rectangle) shape).setInnerColor(innerColor);
							((Rectangle) shape).setUpperLeft(new Point(x,y));
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(new JFrame(), "Invalid data!", "Error!",
								JOptionPane.ERROR_MESSAGE);
					}

				} else if (panel.getSelected() instanceof Donut) {
					DonutDialog donut = new DonutDialog();
					donut.setTextFieldXcoordinate(Integer.toString(((Donut) shape).getCenter().getX()));
					donut.setTextFieldYcoordinate(Integer.toString(((Donut) shape).getCenter().getY()));
					donut.setTextFieldInnerRadius(Integer.toString(((Donut) shape).getInnerRadius()));
					donut.setTextFieldOuterRadius(Integer.toString(((Donut) shape).getRadius()));
					donut.setBorderColor(((Donut) shape).getInnerBorderColor());
					donut.setInnerColor(((Donut) shape).getInnerCircleColor());
					int x = Integer.parseInt(donut.getTextFieldXcoordinate());
					int y = Integer.parseInt(donut.getTextFieldYcoordinate());
					int innerRadius = Integer.parseInt(donut.getTextFieldInnerRadius());
					int outerRadius = Integer.parseInt(donut.getTextFieldOuterRadius());
					Color borderColor = donut.getBorderColor();
					Color innerColor = donut.getInnerColor();
					donut.setVisible(true);
					
					try {
						((Donut) shape).setCenter(
								new Point(Integer.parseInt(donut.getTextFieldXcoordinate()), Integer.parseInt(donut.getTextFieldYcoordinate())));
						((Donut) shape).setInnerRadius(Integer.parseInt(donut.getTextFieldInnerRadius()));
						((Donut) shape).setRadius(Integer.parseInt(donut.getTextFieldOuterRadius()));
						((Donut) shape).setColor(donut.getBorderColor());
						((Donut) shape).setInnerBorderColor(donut.getBorderColor());
						((Donut) shape).setInnerColor(donut.getInnerColor());
						((Donut) shape).setInnerCircleColor(donut.getInnerColor());
						if (donut.isOk() && ((Donut) shape).getInnerRadius() < ((Donut) shape).getRadius())  {
							list.set(index, shape);
							panel.setShapes(list);
							shape.setSelected(true);
							panel.setSelected(shape);
							panel.repaint();
						} else {
							((Donut) shape).setColor(borderColor);
							((Donut) shape).setInnerBorderColor(borderColor);
							((Donut) shape).setInnerColor(innerColor);
							((Donut) shape).setInnerCircleColor(innerColor);
							((Donut) shape).setCenter(new Point(x,y));
							((Donut) shape).setInnerRadius(innerRadius);
							((Donut) shape).setRadius(outerRadius);
							JOptionPane.showMessageDialog(new JFrame(), "Invalid data! Inner radius must be less than outer radius!", "Error!",
									JOptionPane.ERROR_MESSAGE );
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(new JFrame(), "Invalid data", "Error!",
								JOptionPane.ERROR_MESSAGE);
					}

				} else if (panel.getSelected() instanceof Circle) {
					CircleDialog circle = new CircleDialog();

					circle.setTextFieldXcoordinate(Integer.toString(((Circle) shape).getCenter().getX()));
					circle.setTextFieldYcoordinate(Integer.toString(((Circle) shape).getCenter().getY()));
					circle.setTextFieldRadius(Integer.toString(((Circle) shape).getRadius()));
					circle.setBorderColor(((Circle) shape).getColor());
					circle.setInnerColor(((Circle) shape).getInnerColor());
					int x = Integer.parseInt(circle.getTextFieldXcoordinate());
					int y = Integer.parseInt(circle.getTextFieldYcoordinate());
					int radius = Integer.parseInt(circle.getTextFieldRadius());
					Color borderColor = circle.getBorderColor();
					Color innerColor = circle.getInnerColor();
					circle.setVisible(true);

					try {
						((Circle) shape).setRadius(Integer.parseInt(circle.getTextFieldRadius()));
						((Circle) shape).setCenter(new Point(Integer.parseInt(circle.getTextFieldXcoordinate()),
								Integer.parseInt(circle.getTextFieldYcoordinate())));
						((Circle) shape).setColor(circle.getBorderColor());
						((Circle) shape).setInnerColor(circle.getInnerColor());
						if (circle.isOk()) {
							shape.setSelected(false);

							list.set(index, shape);
							panel.setShapes(list);
							shape.setSelected(true);
							panel.setSelected(shape);
							panel.repaint();

						} else {
							((Circle) shape).setColor(borderColor);
							((Circle) shape).setInnerColor(innerColor);
							((Circle) shape).setCenter(new Point(x,y));
							((Circle) shape).setRadius(radius);
						}
					} catch (Exception e) {
						JOptionPane.showMessageDialog(new JFrame(), "Invalid data!", "Error!",
								JOptionPane.ERROR_MESSAGE);
					}
				}

			} else {
				JOptionPane.showMessageDialog(new JFrame(), "No shape has been selected!", "Error!",
						JOptionPane.WARNING_MESSAGE);
				
			}
		}
	});
	
		tglbtnDelete = new JToggleButton("Delete");
		tglbtnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (panel.getSelected() != null) {
					Shape pomocniOblik = panel.getSelected();
					ArrayList<Shape> lista = panel.getShapes();
					int index = lista.indexOf(pomocniOblik);
					if (JOptionPane.showConfirmDialog(new JFrame(),
							"Are you sure you want to delete this shape?", "Delete a shape.",
							JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						lista.remove(index);
						panel.setShapes(lista);
					}
					panel.setSelected(null); 
					panel.repaint();

				} else {
					JOptionPane.showMessageDialog(new JFrame(), "No shape has been selected!", "Error!",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		actions.setLayout(new MigLayout("", "[61px][65px][63px]", "[23px]"));
		actions.add(tglbtnSelect, "cell 0 0,alignx left,aligny top");
		actions.add(tglbtnModify, "cell 1 0,alignx left,aligny top");
		actions.add(tglbtnDelete, "cell 2 0,alignx left,aligny top");
		
		JPanel shapes = new JPanel();
		shapes.setBackground(Color.WHITE);
		buttonsPanel.add(shapes, "cell 2 0,alignx left,aligny top");
		shapes.setLayout(new MigLayout("", "[57px][51px][81px][59px][61px]", "[23px]"));
		
		tglbtnPoint = new JToggleButton("Point");
		shapes.add(tglbtnPoint, "cell 0 0,alignx left,aligny top");
		
		tglbtnLine = new JToggleButton("Line");
		shapes.add(tglbtnLine, "cell 1 0,alignx left,aligny top");
		
		tglbtnRectangle = new JToggleButton("Rectangle");
		shapes.add(tglbtnRectangle, "cell 2 0,alignx left,aligny top");
		
		tglbtnCircle = new JToggleButton("Circle");
		shapes.add(tglbtnCircle, "cell 3 0,alignx left,aligny top");
		
		tglbtnDonut = new JToggleButton("Donut");
		shapes.add(tglbtnDonut, "cell 4 0,alignx left,aligny top");
		
//		JPanel drawingPanel = new JPanel();
//		drawingPanel.setBackground(Color.WHITE);
//		contentPane.add(drawingPanel, BorderLayout.CENTER);
//		//drawingPanel.setLayout(null);
//		
		
	}
}
