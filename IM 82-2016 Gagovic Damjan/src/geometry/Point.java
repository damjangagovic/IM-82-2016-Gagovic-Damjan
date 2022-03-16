package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Point extends Shape{
	private int x;
	private int y;
	protected Color color;
	
	
	public Point() {
		
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, Color color, boolean selected) {
		this(x, y);
		this.setSelected(selected);
	}
	
	

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	

	public String toString() {
		// (x,y)
		return "(" + x + "," + y + ")";
	}
	
	public double distance(Point p) {
		int dx = this.x - p.x;
		int dy = this.y - p.y;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
	}
	
	public boolean contains(int x, int y) {
		Point clickPosition = new Point(x, y);
		return this.distance(clickPosition) < 2;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point p = (Point) obj;
			if(this.x == p.x && this.y == p.y) {
				return true;
			} else {
				return false;
			}
		}else {
			return false;
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getColor());
		g.drawLine(this.x - 2, this.y, this.x + 2, this.y);
		g.drawLine(this.x, this.y - 2, this.x, this.y + 2);
		
		if (isSelected()) {
			g.setColor(Color.BLACK);
			g.drawRect(this.x - 3, this.y - 3, 6, 6);
		}
	}

	@Override
	public void moveTo(int byX, int byY) {
		this.x = byX;
		this.y = byY;
	}

	@Override
	public void moveBy(int byX, int byY) {
		this.x = this.x + byX;
		this.y = this.y + byY;
	}
	

}
