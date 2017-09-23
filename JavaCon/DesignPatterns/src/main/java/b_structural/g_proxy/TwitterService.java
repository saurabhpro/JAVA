package b_structural.g_proxy;

interface TwitterService {
	@SuppressWarnings("SameReturnValue")
	String getTimeline(String screenName);

	@SuppressWarnings("EmptyMethod")
	void postToTimeline(String screenName, String message);
}
