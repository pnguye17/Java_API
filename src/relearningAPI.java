import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpRequest;

public class relearningAPI {
	
	
	public static List<Post> fetchPosts() throws IOException {
		URL url = new URL("https://restcountries.com/v3.1/name/Italy");
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		int responseCode = connection.getResponseCode();
		
		if (responseCode == HttpsURLConnection.HTTP_OK) {
			System.out.println(responseCode);
			StringBuilder sb = new StringBuilder();
			Scanner scanner = new Scanner(connection.getInputStream());
			
			while(scanner.hasNext()) {
				sb.append(scanner.next());
			}
			System.out.println(sb);
		} else {
			System.out.println("Error in sending GET request" + " code: " +responseCode);
		}
		
		
		return null;
		
	}
	
	public static List<Map<String, Integer>> formatPosts(List<Post> posts) {
		return null;
		
	}

	public static void main(String[] args) throws IOException {
		System.out.println("hellow workd");
		fetchPosts();
	}

}
