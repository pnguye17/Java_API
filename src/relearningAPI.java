import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

import java.io.IOException;
import java.net.*;
import java.net.http.HttpRequest;



public class relearningAPI {
	
	
	public static List<Post> fetchPosts() throws IOException {
		
		Post p1 = new Post(1, 5);
		Post p2 = new Post(2, 10);
	
		
		List<Post> data = new ArrayList<>();
		data.add(p1);
		data.add(p2);
		
		
		URL url = new URL("https://restcountries.com/v3.1/name/Italy");
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		int responseCode = connection.getResponseCode();
		
		if (responseCode == HttpsURLConnection.HTTP_OK) {
			StringBuilder sb = new StringBuilder();
			Scanner scanner = new Scanner(connection.getInputStream());
			
			while(scanner.hasNext()) {
				sb.append(scanner.next());
			}
//			System.out.println(sb);
		} else {
			System.out.println("Error in sending GET request" + " code: " +responseCode);
		}
		
		System.out.println(data);
		return data;
		
	}
	
	public static List<Map<String, Integer>> formatPosts(List<Post> posts) {
		
		
		
		Map<String, Integer> obj1 = new HashMap<>();
		
		
		return null;
		
	}

	public static void main(String[] args) throws IOException {
		List<Post> posts = fetchPosts();
		
		List<Map<String, Integer>> formattedPosts = formatPosts(posts);
		
		System.out.println(formattedPosts);
	}

}
