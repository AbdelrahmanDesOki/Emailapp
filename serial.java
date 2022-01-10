package project;

import java.io.*;

public class serial extends GUI implements Serializable {

	//serialization part
	public static boolean serializeLink(Object inputLink, String filename) throws IOException {

		try {

			FileOutputStream file = new FileOutputStream(filename);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(inputLink);
			out.close();
			file.close();

			return true;

		}

		catch (IOException ex) {
			System.out.println("IOException is caught");
			return false;
		}

	}

	//deserialization
	public static Object deserializeLink(String fileName) throws IOException, ClassNotFoundException {

		FileInputStream file = new FileInputStream(fileName);
		@SuppressWarnings("resource")
		ObjectInputStream in = new ObjectInputStream(file);

		return (Object) in.readObject();

	}

}