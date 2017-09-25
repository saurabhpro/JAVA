/*
 * Copyright 2017 Saurabh Kumar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.saurabh.pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class LinkGetter {
	private final Pattern htmltag;
	private final Pattern link;

	public LinkGetter() {
		htmltag = Pattern.compile("<a\\b[^>]*href=\"[^>]*>(.*?)</a>");
		link = Pattern.compile("href=\"[^>]*\">");
	}

	public List<String> getLinks(String url) {
		List<String> links = new ArrayList<>();

		try {
			try (BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(new URL(url).openStream()))) {

				String s;
				StringBuilder builder = new StringBuilder();

				while ((s = bufferedReader.readLine()) != null) {
					builder.append(s);
				}

				Matcher tagmatch = htmltag.matcher(builder.toString());

				while (tagmatch.find()) {
					Matcher matcher = link.matcher(tagmatch.group());

					System.out.println(matcher.find());

					String link = matcher.group()
							.replaceFirst("href=\"", "")
							.replaceFirst("\">", "")
							.replaceFirst("\"[\\s]?target=\"[a-zA-Z_0-9]*", "");

					if (valid(link)) {
						links.add(makeAbsolute(url, link));
					}
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return links;
	}

	private boolean valid(String s) {
		return !s.matches("javascript:.*|mailto:.*");
	}

	private String makeAbsolute(String url, String link) {
		if (link.matches("http://.*")) {
			return link;
		}
		if (link.matches("/.*") && url.matches(".*$[^/]")) {
			return url + "/" + link;
		}
		if (link.matches("[^/].*") && url.matches(".*[^/]")) {
			return url + "/" + link;
		}
		if (link.matches("/.*") && url.matches(".*[/]")) {
			return url + link;
		}
		if (link.matches("/.*") && url.matches(".*[^/]")) {
			return url + link;
		}
		throw new RuntimeException("Cannot make the link absolute. Url: " + url
				+ " Link " + link);
	}
}