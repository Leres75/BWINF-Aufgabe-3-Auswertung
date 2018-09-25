import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Number {
	int x, y, width, height = 35;

    public Number(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getY(){
    	return y;
    }

    public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double number = new Rectangle2D.Double(x, y, 3, height);

        g2d.setColor(new Color(255, 50, 50, 150));
        g2d.fill(number);
    }
}
