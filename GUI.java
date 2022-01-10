package project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.*;

public class GUI implements ActionListener {

	public static String a;
	static String b;
	static String c;
	static String chk;
	static String x;

	protected static JLabel sub, body, combo_addr;
	protected static JTextField sub_txt, body_txt;
	public static JButton button_up;
	public static JComboBox liss;

	// this array list I will use to store recent people, who the user send to them
	// email.
	public static ArrayList<String> receivers = new ArrayList<String>();

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// serialization location
		File file = new File("ser_file.txt");
		if (file.length() == 0) {
		} else {
			receivers = (ArrayList<String>) serial.deserializeLink("ser_file.txt");
		}
		liss = new JComboBox(receivers.toArray());

		chk = (String) liss.getSelectedItem();

		liss.setEditable(true);
		liss.setBounds(100, 70, 390, 25);
		liss.setSelectedItem(null);
		JFrame frame = new JFrame("Email App 📨📩");
		JPanel northPanel = new JPanel();
		frame.setSize(650, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		northPanel.setForeground(Color.LIGHT_GRAY);
		northPanel.setBackground(Color.LIGHT_GRAY);
		frame.add(northPanel);

		northPanel.setLayout(null);
		combo_addr = new JLabel("Receiver: ");
		Font font = new Font("Courier", Font.BOLD, 13);
		combo_addr.setFont(font);
		combo_addr.setBounds(15, 70, 80, 25);
		northPanel.add(combo_addr);
		northPanel.add(liss);

		sub = new JLabel("Subject: ");
		Font font1 = new Font("Courier", Font.BOLD, 13);
		sub.setFont(font1);
		sub.setBounds(15, 120, 80, 25);
		northPanel.add(sub);
		sub_txt = new JTextField(50);
		sub_txt.setBounds(100, 120, 390, 25);
		northPanel.add(sub_txt);

		body = new JLabel("Body: ");
		Font font11 = new Font("Courier", Font.BOLD, 13);
		body.setFont(font11);
		body.setBounds(15, 160, 80, 25);
		northPanel.add(body);
		body_txt = new JTextField(400);
		body_txt.setBounds(100, 170, 390, 150);
		northPanel.add(body_txt);

		button_up = new JButton("SEND EMAIL");
		button_up.setBounds(210, 350, 140, 25);

		button_up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				chk = (String) liss.getSelectedItem();
				// checking the format of the email
				if (chk.contains("@")) {
					GUI_chk.meth();
				} else {
					GUI_chk.meth_mistake();
				}
			}

		});
		northPanel.add(button_up);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
