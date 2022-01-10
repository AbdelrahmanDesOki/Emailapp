package project;

import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;
import javax.swing.*;

public class GUI_chk extends GUI {

	//logic behind the button action listener
	public static JFrame in_frame;

	@SuppressWarnings("unchecked")
	public static void meth() {

		a = liss.getSelectedItem().toString();
		b = sub_txt.getText();
		c = body_txt.getText();

		try {
			//checking the array list
			if (!receivers.contains(a)) {
				receivers.add(a);
			}
            //serializing the element
			Boolean hell = serial.serializeLink(receivers, "ser_file.txt");
			//sending the Jsonobject data with email,sub and body
			JSONObject h = Request.send(a, b, c);
			Request.getResponse(h);
			try {
				//deserializing the data from the file 
				receivers = (ArrayList<String>) serial.deserializeLink("ser_file.txt");
				liss.setModel(new DefaultComboBoxModel(receivers.toArray()));

			} catch (ClassNotFoundException e1) {

				e1.printStackTrace();
			}
		} catch (IOException | JSONException e1) {

			e1.printStackTrace();
		}
		//pop up window for sending correct email
		 in_frame = new JFrame();
		JOptionPane.showMessageDialog(in_frame, "Your Email has sent Successfully!");

		in_frame.pack();
		in_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		in_frame.setVisible(true);

	}

	public static Boolean meth_mistake() {
		//pop up window for sending email in wrong format
		 in_frame = new JFrame();
		JOptionPane.showMessageDialog(in_frame, "Please insert a valid email Address");
		in_frame.pack();
		in_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		in_frame.setVisible(true);
		return true;
	}

}
