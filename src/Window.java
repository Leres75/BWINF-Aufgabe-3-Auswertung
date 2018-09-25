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
	private static int[] markers = {50,150,250,350,450,550,650,750,850,950};
	private static JTextField[] inputMarkers = new JTextField[10];
	private static String filepath = "beispiel1.txt";
	static JPanel panel = new JPanel();
	static JLabel lbMoneyMadeOutput = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		if(args.length >= 10){
			for (int i = 0; i < 10; i++) {
				markers[i] = Integer.valueOf(args[i]);
			}
			if(args.length >= 11)filepath = args[10];
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
					frame.calculate();
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
		setBounds(100, 100, 1040, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		InputFilePath = new JTextField();
		InputFilePath.setFont(new Font("Tahoma", Font.PLAIN, 40));
		InputFilePath.setText(filepath);
		InputFilePath.setBounds(10, 11, 1000, 70);
		InputFilePath.setColumns(10);

		for (int i = 0; i < inputMarkers.length; i++) {
			inputMarkers[i] = new JTextField();
			inputMarkers[i].setColumns(10);
			inputMarkers[i].setText(markers[i] + "");
			inputMarkers[i].setFont(new Font("Tahoma", Font.PLAIN, 50));
			inputMarkers[i].setBounds(10 + (i * 101), 100, 90, 70);

		}

		JLabel lbMoneyLabel = new JLabel("Money Made:");
		lbMoneyLabel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lbMoneyLabel.setBounds(30, 290, 318, 70);

		
		lbMoneyMadeOutput.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lbMoneyMadeOutput.setBounds(800, 290, 375, 70);

		
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 385, 1000, 50);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				calculate();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnNewButton.setBounds(10, 190, 1000, 70);
		contentPane.add(btnNewButton);
		contentPane.add(panel);
		contentPane.add(lbMoneyMadeOutput);
		contentPane.add(lbMoneyLabel);
		contentPane.add(InputFilePath);
		for (int i = 0; i < inputMarkers.length; i++) {
			contentPane.add(inputMarkers[i]);
		}
		//if(startImmediately)calculate();

	}
	
	private void calculate(){
		numbers = Payouts.readFile(InputFilePath.getText());
		for (int i = 0; i < inputMarkers.length; i++) {
			markers[i] = Integer.valueOf(inputMarkers[i].getText());
		}
		lbMoneyMadeOutput.setText("" + (numbers.size() * 25 - Payouts.getPayouts(markers, numbers)));
		DynamicShapes dynamicShapes = new DynamicShapes(numbers, markers);
		dynamicShapes.setBounds(0, 5, 1000, 40);
		panel.add(dynamicShapes);
		dynamicShapes.paintComponent(dynamicShapes.getGraphics());
	}
}
