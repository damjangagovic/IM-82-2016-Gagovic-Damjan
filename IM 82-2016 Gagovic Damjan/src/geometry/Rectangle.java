
package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape{

	private Point upperLeft;
	private int height;
	private int width;
	private Color color;
	private Color innerColor;
	
	
	public Rectangle() {

	}
	
	public Rectangle(Point upperLeft, int height, int width) {
		this.upperLeft = upperLeft;
		this.height = height;
		this.width = width;
	}
	
	public Rectangle(Point upperLeft, int height, int width, boolean selected) {
		this(upperLeft, height, width);
		setSelected(selected);
	}

	
	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getInnerColor() {
		return innerColor;
	}

	public void setInnerColor(Color innerColor) {
		this.innerColor = innerColor;
	}
	
	
	public String toString() {
		return "Upper left point = " + this.getUpperLeft() + ", height = " + height + ", width = " + width + ";";
	}
	
	public boolean contains(int x, int y) {
		if (this.getUpperLeft().getX() <= x &&
				this.getUpperLeft().getY() <= y &&
				x <= this.getUpperLeft().getX() + width &&
				y <= this.getUpperLeft().getY() + height) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean contains(Point p) {
		if (this.getUpperLeft().getX() <= p.getX() && 
				this.getUpperLeft().getY() <= p.getY() &&
				p.getX() <= this.getUpperLeft().getX() + width &&
				p.getY() <= this.getUpperLeft().getY() + height) {
			return true;
		} else {
			return false;
		}
	}
	
	public int area() {
		return width * height;
	}
	
	public int volume() {
		return 2 * width + 2 * height;
	}
	
	public int compareTo(Object o) {
		if (o instanceof Rectangle) {
			return this.area() - ((Rectangle) o).area();
		}
		return 0;
	}
	
	@Override
	public void moveBy(int byX, int byY) {
		this.upperLeft.moveBy(byX, byY);
		
	}

	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void draw(Graphics g) {
		if (innerColor != null) {
			g.setColor(innerColor);
			g.fillRect(this.getUpperLeft().getX(), this.getUpperLeft().getY(), this.getWidth(), this.getHeight());
		}
	
		g.setColor(color);
		g.drawRect(this.getUpperLeft().getX(),
				this.getUpperLeft().getY(),
				this.width,
				this.height);
		
		if(selected) {
			g.drawRect(this.getUpperLeft().getX() - 3, this.getUpperLeft().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeft().getX() - 3 + this.width, this.getUpperLeft().getY() - 3, 6, 6);
			g.drawRect(this.getUpperLeft().getX() - 3, this.getUpperLeft().getY() - 3 + this.height, 6, 6);
			g.drawRect(this.getUpperLeft().getX() - 3 + this.width, this.getUpperLeft().getY() - 3 + this.height, 6, 6);
		}
	}
	
}
