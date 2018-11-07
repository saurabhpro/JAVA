/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package pluralsight.whatsnew.demo05.httpclient;

//add --add-modules jdk.incubator.httpclient to java compiler preference


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;


public class BAsyncHttpBuilderExample {

	public static void main(String... args) {
		HttpClient.Builder builder = HttpClient.newBuilder();

		builder.version(HttpClient.Version.HTTP_2)
				.followRedirects(HttpClient.Redirect.ALWAYS);

		HttpClient client = builder.build();

		HttpRequest request = HttpRequest.newBuilder(URI.create("https://www.google.com"))
				.header("User-Agent", "Java")
				.timeout(Duration.ofMillis(500))
				.GET()
				.build();

		CompletableFuture<HttpResponse<String>> response =
				client.sendAsync(request, HttpResponse.BodyHandlers.ofString());

		response.thenAccept(r -> {
			System.out.println("Version: " + r.version());
			System.out.println(r.body());
		});

		response.join();
	}
}
