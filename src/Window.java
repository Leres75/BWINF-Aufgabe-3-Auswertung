import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Font;

@SuppressWarnings("serial")
public class Window extends JFrame {
	private JPanel contentPane;
	private JTextField InputFilePath;
	private ArrayList<Integer> numbers;
	private int[] markers = new int[10];
	private JTextField[] inputMarkers = new JTextField[10];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
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
	public Window() {
		setTitle("BWINF Aufgabe 3 Auswertung");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 530, 227);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		InputFilePath = new JTextField();
		InputFilePath.setText("beispiel1.txt");
		InputFilePath.setBounds(10, 11, 500, 28);
		InputFilePath.setColumns(10);

		for (int i = 0; i < inputMarkers.length; i++) {
			inputMarkers[i] = new JTextField();
			inputMarkers[i].setColumns(10);
			inputMarkers[i].setText("" + (50 + (i*100)));
			inputMarkers[i].setBounds(10 + (i * 51), 50, 40, 30);

		}

		JLabel lbMoneyLabel = new JLabel("Money Made:");
		lbMoneyLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbMoneyLabel.setBounds(10, 119, 115, 28);

		JLabel lbMoneyMadeOutput = new JLabel("");
		lbMoneyMadeOutput.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbMoneyMadeOutput.setBounds(135, 119, 375, 28);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(5, 150, 500, 25);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				numbers = Payouts.readFile(InputFilePath.getText());
				for (int i = 0; i < inputMarkers.length; i++) {
					inputMarkers[i].setForeground(Color.green);
					markers[i] = Integer.valueOf(inputMarkers[i].getText());
					inputMarkers[i].setEditable(false);
				}
				InputFilePath.setEditable(false);
				btnNewButton.setEnabled(false);
				InputFilePath.setForeground(Color.green);
				lbMoneyMadeOutput.setText("" + (numbers.size() * 25 - Payouts.getPayouts(markers, numbers)));
				DynamicShapes dynamicShapes = new DynamicShapes(numbers, markers);
				dynamicShapes.setBounds(0, 5, 500, 20);
				panel.add(dynamicShapes);
				dynamicShapes.paintComponent(dynamicShapes.getGraphics());
			}
		});
		btnNewButton.setBounds(10, 90, 500, 28);
		contentPane.add(btnNewButton);
		contentPane.add(panel);
		contentPane.add(lbMoneyMadeOutput);
		contentPane.add(lbMoneyLabel);
		contentPane.add(InputFilePath);
		for (int i = 0; i < inputMarkers.length; i++) {
			contentPane.add(inputMarkers[i]);
		}

	}
}
