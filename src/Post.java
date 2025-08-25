import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Post implements Comparable<Post>{
	
	String userID;
	Integer numberofPosts;
	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}
	/**
	 * @return the numberofPosts
	 */
	public Integer getNumberofPosts() {
		return numberofPosts;
	}
	/**
	 * @param numberofPosts the numberofPosts to set
	 */
	public void setNumberofPosts(Integer numberofPosts) {
		this.numberofPosts = numberofPosts;
	}
	@Override
	public String toString() {
		return "{userID=" + userID + ", numberofPosts=" + numberofPosts + "}";
	}
	@Override
	public int hashCode() {
		return Objects.hash(numberofPosts, userID);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(numberofPosts, other.numberofPosts) && Objects.equals(userID, other.userID);
	}
	public Post(String userID, Integer numberofPosts) {
		super();
		this.userID = userID;
		this.numberofPosts = numberofPosts;
	}
	@Override
	public int compareTo(Post o) {
		return Integer.compare(o.numberofPosts, this.numberofPosts);
	}
	
	
	public Map<String, Integer> toMap(){
		Map<String, Integer> map = new HashMap<>();
		map.put(userID, numberofPosts);
		return map;
	}
	
	
	
	
}
