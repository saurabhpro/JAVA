/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package pluralsight.whatsnew.demo05.httpclient;

//add --add-modules jdk.incubator.httpclient to java compiler preference

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;

import java.net.URI;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;


public class BAsyncHttpBuilderExample {

	public static void main(String... args) throws Exception {
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
				client.sendAsync(request, HttpResponse.BodyHandler.asString());

		response.thenAccept(r -> {
			System.out.println("Version: " + r.version());
			System.out.println(r.body());
		});

		response.join();
	}
}
