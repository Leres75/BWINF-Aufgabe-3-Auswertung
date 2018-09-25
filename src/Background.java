import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class Background {
	int x, y, width, height;

    public Background(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Rectangle2D.Double circle = new Rectangle2D.Double(0, 0, width, height);

        g2d.setColor(Color.white);
        g2d.fill(circle);
    }
}
