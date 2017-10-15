package saurabh.udemy.springguru103jokes.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokesProviderServiceImpl implements JokesProviderService {

	private final ChuckNorrisQuotes chuckNorrisQuotes;

	public JokesProviderServiceImpl() {
		this.chuckNorrisQuotes = new ChuckNorrisQuotes();
	}

	@Override
	public String getJokes() {
		return chuckNorrisQuotes.getRandomQuote();
	}
}
