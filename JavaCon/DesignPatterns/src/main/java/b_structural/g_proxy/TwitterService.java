package b_structural.g_proxy;

public interface TwitterService {
	String getTimeline(String screenName);

	void postToTimeline(String screenName, String message);
}
