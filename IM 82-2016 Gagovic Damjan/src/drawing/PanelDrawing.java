package drawing;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class PanelDrawing extends JPanel {

	private FrameDrawing frame;
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private Point startPoint;
	private Shape selected;
	
	public PanelDrawing() {
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				thisMouseClicked(e);
			}
		});
	}

	public PanelDrawing(FrameDrawing frame) {
		this.frame = frame;
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				thisMouseClicked(e);
			}
		});
	}
	
	public ArrayList<Shape> getShapes() {
		return shapes;
	}

	public void setShapes(ArrayList<Shape> shapes) {
		this.shapes = shapes;
	}

	public Shape getSelected() {
		return selected;
	}

	public void setSelected(Shape selected) {
		this.selected = selected;
	}

	public void thisMouseClicked(MouseEvent e) {
		if(frame.getTglbtnSelect()) {
			selected = null;
			Iterator<Shape> it = shapes.iterator();
			
			while (it.hasNext()) {
				Shape shape = it.next();
				shape.setSelected(false);
				if (shape.contains(e.getX(), e.getY())) {
					selected = shape;
				}
			}
		}
		if (frame.getTglbtnPoint()) {
			Point point = new Point(e.getX(), e.getY());
			PointDialog dialog = new PointDialog();
			dialog.setTextFieldXcoordinate(Integer.toString(point.getX()));
			dialog.setTextFieldYcoordinate(Integer.toString(point.getY()));
			dialog.setTextXcoordinateEnabled(false);
			dialog.setTextYcoordinateEnabled(false);
			dialog.setVisible(true);
			point.setColor(dialog.getColor());
			if (dialog.isOk()) {
				shapes.add(point);
			}
			frame.tglbtnSelect.setSelected(true);
			frame.tglbtnPoint.setSelected(false);
		}
		else if (frame.getTglbtnLine()) {
			LineDialog dialog = new LineDialog();
			Point p = new Point(e.getX(), e.getY());
			if (startPoint == null) {
				startPoint = new Point(e.getX(), e.getY());
			}
			else {
				dialog.setTextFieldXsp(Integer.toString(startPoint.getX()));
				dialog.setTextFieldYsp(Integer.toString(startPoint.getY()));
				dialog.setTextFieldXspEnabled(false);
				dialog.setTextFieldYspEnabled(false);
				Line line = new Line(startPoint, new Point(e.getX(), e.getY()));
				dialog.setTextFieldXep(Integer.toString(p.getX()));
				dialog.setTextFieldYep(Integer.toString(p.getY()));
				dialog.setTextFieldXepEnabled(false);
				dialog.setTextFieldYepEnabled(false);
				dialog.setVisible(true);
				line.setColor(dialog.getColor());
				if (dialog.isOk())
					shapes.add(line);
				startPoint = null;
				frame.tglbtnSelect.setSelected(true);
				frame.tglbtnLine.setSelected(false);
			}
				
		}
		else if (frame.getTglbtnRectangle()) {
			Point point = new Point(e.getX(), e.getY());
			RectangleDialog dialog = new RectangleDialog();
			dialog.setTextFieldXcoordinate(Integer.toString(point.getX()));
			dialog.setTextFieldYcoordinate(Integer.toString(point.getY()));
			dialog.setTextFieldXcoordinateEnabled(false);
			dialog.setTextFieldYcoordinateEnabled(false);
			dialog.setVisible(true);
			if (dialog.isOk()) {
				try {
					int width = Integer.parseInt(dialog.getTextFieldWidth());
					int height = Integer.parseInt(dialog.getTextFieldHeight());
					if (width > 0 && height > 0) {
						Rectangle rectangle = new Rectangle(point, width, height);
						rectangle.setColor(dialog.getBorderColor());
						rectangle.setInnerColor(dialog.getInnerColor());
						shapes.add(rectangle);
					} else
						JOptionPane.showMessageDialog(new JFrame(), "Values must be greater than 0!", "Error!",
								JOptionPane.WARNING_MESSAGE);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(new JFrame(), "Invalid data!", "Error!",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			frame.tglbtnSelect.setSelected(true);
			frame.tglbtnRectangle.setSelected(false);
		}
		else if (frame.getTglbtnCircle()) {
			Point center = new Point(e.getX(), e.getY());
			CircleDialog dialog = new CircleDialog();
			dialog.setTextFieldXcoordinate(Integer.toString(center.getX()));
			dialog.setTextFieldYcoordinate(Integer.toString(center.getY()));
			dialog.setTextFieldXcoordinateEnabled(false);
			dialog.setTextFieldYcoordinateEnabled(false);
			dialog.setVisible(true);
			if (dialog.isOk()) {
				try {
					int radius = Integer.parseInt(dialog.getTextFieldRadius());
					if (radius <= 0)
						JOptionPane.showMessageDialog(new JFrame(), "Values must be greater than 0!", "Error!",
								JOptionPane.WARNING_MESSAGE);
					else {
						Circle circle = new Circle(center, radius);
						circle.setColor(dialog.getBorderColor());
						circle.setInnerColor(dialog.getInnerColor());
						shapes.add(circle);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(new JFrame(), "Invalid data!", "Error!",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			frame.tglbtnSelect.setSelected(true);
			frame.tglbtnCircle.setSelected(false);
		}
		else if (frame.getTglbtnDonut()) {
			Point center = new Point(e.getX(), e.getY());
			DonutDialog dialog = new DonutDialog();
			dialog.setTextFieldXcoordinate(Integer.toString(center.getX()));
			dialog.setTextFieldYcoordinate(Integer.toString(center.getY()));
			dialog.setTextFieldXcoordinateEnabled(false);
			dialog.setTextFieldYcoordinateEnabled(false);
			dialog.setVisible(true);
			if (dialog.isOk()) {
				try {
					int innerRadius = Integer.parseInt(dialog.getTextFieldInnerRadius());
					int outerRadius = Integer.parseInt(dialog.getTextFieldOuterRadius());
					if (innerRadius > 0 && outerRadius > 0 && innerRadius < outerRadius) {
						Donut donut = new Donut(center, outerRadius, innerRadius);
						donut.setColor(dialog.getBorderColor());
						donut.setInnerBorderColor(dialog.getBorderColor());
						donut.setInnerColor(dialog.getInnerColor());
						donut.setInnerCircleColor(dialog.getInnerColor());
						shapes.add(donut);
					} else {
						JOptionPane.showMessageDialog(new JFrame(), "Invalid data!", "Error!",
								JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(new JFrame(), "Invalid data!", "Error!",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			frame.tglbtnSelect.setSelected(true);
			frame.tglbtnDonut.setSelected(false);
		}
		else if (selected != null) {
			selected.setSelected(true);
		}
		if (shapes != null) {
			repaint();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Iterator<Shape> it = shapes.iterator();
		while (it.hasNext()) {
			it.next().draw(g);
		}
	}


}
