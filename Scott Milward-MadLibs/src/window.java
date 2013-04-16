//	------				Scott Milward     			--------------------- //
//	------				3/31/13						--------------------- //
// 	------				Simple Mad Lib Program		--------------------- //
//-------------------------------------------------------------------------//
//-------------------------------------------------------------------------//

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.Color;

public class window {

	private JFrame frame;
	private int NumOfFiles; // keeps track of number of mad lib files in folder
	private int fileindex;
	private List<String> placeholders;
	private int placeholderindex;
	private String title;
	private MadLibs x = new MadLibs();
	private JTextField txtPlaceholder; 
	private List<String> answers = new ArrayList<String>(); //holds users answers
	private int status; //keeps track of current number question

	public static void main(String[] args) {

		//set control theme
		try{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} 
		  catch (UnsupportedLookAndFeelException e) {
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					window window = new window();
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
	public window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setBounds(100, 100, 514, 393);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JButton btnNewMadLib = new JButton("Next Mad Lib");
		btnNewMadLib.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		btnNewMadLib.setBounds(372, 326, 116, 23);
		frame.getContentPane().add(btnNewMadLib);

		JLabel lblScottMilward = new JLabel("Scott Milward - MAD LIBS - 3/31/2013");
		lblScottMilward.setForeground(new Color(255, 255, 255));
		lblScottMilward.setHorizontalAlignment(SwingConstants.CENTER);
		lblScottMilward.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 25));
		lblScottMilward.setBounds(10, 11, 478, 44);
		frame.getContentPane().add(lblScottMilward);

		JButton btnPreviousMadLib = new JButton("Previous Mad Lib");
		btnPreviousMadLib.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		btnPreviousMadLib.setBounds(10, 326, 116, 23);
		frame.getContentPane().add(btnPreviousMadLib);

		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setForeground(new Color(204, 204, 204));
		lblTitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblTitle.setBounds(10, 87, 46, 14);
		frame.getContentPane().add(lblTitle);

		final JLabel lblMadLibTitle = new JLabel("..");
		lblMadLibTitle.setForeground(new Color(255, 140, 0));
		lblMadLibTitle.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
		lblMadLibTitle.setBounds(52, 87, 342, 14);
		frame.getContentPane().add(lblMadLibTitle);

		final JLabel lblPlaceholder = new JLabel("..");
		lblPlaceholder.setForeground(new Color(0, 153, 255));
		lblPlaceholder.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlaceholder.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 20));
		lblPlaceholder.setBounds(10, 128, 478, 44);
		frame.getContentPane().add(lblPlaceholder);

		txtPlaceholder = new JTextField();
		txtPlaceholder.setHorizontalAlignment(SwingConstants.CENTER);
		txtPlaceholder.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 20));
		txtPlaceholder.setBounds(10, 183, 478, 43);
		frame.getContentPane().add(txtPlaceholder);
		txtPlaceholder.setColumns(10);
		
		final JLabel lblstatus = new JLabel("..");
		lblstatus.setForeground(new Color(0, 153, 255));
		lblstatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblstatus.setFont(new Font("Segoe UI Symbol", Font.PLAIN, 15));
		lblstatus.setBounds(195, 238, 102, 23);
		frame.getContentPane().add(lblstatus);

		// ---------------------------------------------------------------------------------------------

		// Initialize Starting/default MadLib to show

		NumOfFiles = x.getfilesize();
		fileindex = 0;
		status = 0;
		title = x.getMadLibTitle(fileindex);
		lblMadLibTitle.setText(title);
		placeholderindex = 0;
		placeholders = x.getPlaceholders(title);
		lblPlaceholder.setText(placeholders.get(placeholderindex));
		lblstatus.setText(String.valueOf(status) + " / " + placeholders.size());
		

		// user enter answers here
		txtPlaceholder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				answers.add(txtPlaceholder.getText());
				placeholderindex++;
				lblstatus.setText(String.valueOf(++status) + " / " + placeholders.size());  //update status label
				if (placeholderindex == placeholders.size()) //last placeholder is answered
					x.GenerateText(answers, title);
				else {
					lblPlaceholder.setText(placeholders.get(placeholderindex));
					txtPlaceholder.setText(null);
				}

			}
		});

		// show next madlib file
		btnNewMadLib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				placeholders.clear(); //new mad lib is selected so clear previous placeholders list
				answers.clear();  //clear the answers list
				placeholderindex = 0;
				fileindex++;
				status = 0;

				if (fileindex == NumOfFiles)  //user is at end of file so switch back to starting file
					fileindex = 0;

				title = x.getMadLibTitle(fileindex);
				lblMadLibTitle.setText(title);
				placeholders = x.getPlaceholders(title);
				lblPlaceholder.setText(placeholders.get(placeholderindex));
				txtPlaceholder.setText(null);
				lblstatus.setText(String.valueOf(status) + " / " + placeholders.size());

			}
		});

		// show previous madlib file
		btnPreviousMadLib.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				placeholders.clear();
				answers.clear();
				placeholderindex = 0;
				fileindex--;
				status = 0;
				
				if (fileindex < 0)
					fileindex = NumOfFiles - 1;

				title = x.getMadLibTitle(fileindex);
				lblMadLibTitle.setText(title);
				placeholders = x.getPlaceholders(title);
				lblPlaceholder.setText(placeholders.get(placeholderindex));
				txtPlaceholder.setText(null);
				lblstatus.setText(String.valueOf(status) + " / " + placeholders.size());
			}
		});

	}
}
