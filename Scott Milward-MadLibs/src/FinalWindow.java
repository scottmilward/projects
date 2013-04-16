//	------				Scott Milward     			--------------------- //
//	------				3/31/13						--------------------- //
// 	------				Simple Mad Lib Program		--------------------- //
//-------------------------------------------------------------------------//
//-------------------------------------------------------------------------//

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class FinalWindow {

	private JFrame frame;
	private static List<Character> charlist = new ArrayList<Character>();

	public static void open(List<Character> charl) {

		charlist = charl;

		try {
			UIManager
					.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (UnsupportedLookAndFeelException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalWindow window = new FinalWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FinalWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 585, 500);
		frame.getContentPane().setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 579, 472);
		frame.getContentPane().add(scrollPane);

		JTextArea txtFinalText = new JTextArea();
		txtFinalText.setBackground(new Color(51, 51, 51));
		txtFinalText.setForeground(new Color(255, 255, 255));
		scrollPane.setViewportView(txtFinalText);
		txtFinalText.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 25));
		txtFinalText.setWrapStyleWord(true);
		txtFinalText.setLineWrap(true);

		for (char x : charlist)
			txtFinalText.append(String.valueOf(x));
	}
}
