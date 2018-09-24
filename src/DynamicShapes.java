import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class DynamicShapes extends JPanel {
	/**
	 * 
	 */

	private List<Object> shapes = new ArrayList<>();
	private static final long serialVersionUID = 1L;
	public DynamicShapes(ArrayList<Integer> numbers, int[] markers) {
		this.removeAll();
		redraw(numbers, markers);
    }
	public void redraw(ArrayList<Integer> numbers, int[] markers){
        setBackground(Color.BLACK);
        Random rnd = new Random();
        for (Integer number : numbers) {
        	int y = rnd.nextInt(5);
			addNumber(number/2, y);
		}
        for (int marker : markers) {
			addMarker(marker/2, 5);
		}
        setPreferredSize(new Dimension(500, 50));
		
	}
	
	protected void paintComponent(Graphics g) {
		System.out.println("paintComponent");
        super.paintComponents(g);
        for (Object s : shapes) {
            if (s instanceof Marker) {
                ((Marker) s).draw(g);
            } else if (s instanceof Number) {
                ((Number) s).draw(g);
            }
        }
    }
	
	
    public void addNumber(int x, int y) {
        shapes.add(new Number(x, y));
        repaint();
    }

    public void addMarker(int x, int y) {
        shapes.add(new Marker(x, y));
        repaint();
    }
}
