import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
		
		Post p1 = new Post("1", 5);
		Post p2 = new Post("2", 11);
		Post p3 = new Post("3", 63);
		Post p4 = new Post("4", 11);
		Post p5 = new Post("5", 100);
		
		List<Post> data = new ArrayList<>();
		data.add(p1);
		data.add(p2);
		data.add(p3);
		data.add(p4);
		data.add(p5);
		
		
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
		
		return data;
		
	}
	
	public static List<Post> formatPosts(List<Post> posts) {
		
		
		List<Post> data = new ArrayList<>(posts);
	
		
		
		data.sort(Comparator.comparing(Post::getNumberofPosts, Comparator.reverseOrder()).thenComparing(Post::getUserID, Comparator.reverseOrder()));
		
		
		for (Post post : data) {
			System.out.println(post);
		}
		
		return data;
		
	}

	public static void main(String[] args) throws IOException {
		List<Post> posts = fetchPosts();
		
		System.out.println(posts);
		
		List<Post> formattedPosts = formatPosts(posts);
		
		System.out.println(formattedPosts);
	}

}
