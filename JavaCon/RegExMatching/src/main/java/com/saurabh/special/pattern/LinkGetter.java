/*
 * Copyright (c) 2018 Saurabh Kumar
 */

package com.saurabh.special.pattern;

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