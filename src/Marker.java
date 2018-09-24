import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Marker {
	int x, y, width, height;

    public Marker(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double circle = new Rectangle2D.Double(x, y, 5, 10);

        g2d.setColor(Color.BLACK);
        g2d.fill(circle);
    }
}
