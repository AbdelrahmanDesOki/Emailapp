package project;

import org.json.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Request {

	public static String getResponse(JSONObject h) throws IOException {
        
		//initializing the url to set up the connection
		URL url = new URL("https://maker.ifttt.com/trigger/SendDesoki/with/key/bXbznZvSrcZKxoGvGk02r1");
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		//type of request
		http.setRequestMethod("POST");
		http.setDoOutput(true);
		http.setRequestProperty("Accept", "application/json");
		http.setRequestProperty("Content-Type", "application/json");
		OutputStream stream = http.getOutputStream();
		OutputStreamWriter osw = new OutputStreamWriter(stream, "UTF-8");
		osw.write(h.toString());
		osw.close();

		return (http.getResponseMessage());

	}

	//sending the data of the email using json object
	public static JSONObject send(String a, String b, String c) throws IOException, JSONException {

		JSONObject data = new JSONObject();

		data.put("value1", a);
		data.put("value2", b);
		data.put("value3", c);
		return data;

	}
}
