package saurabh.udemy.springguru103jokes.service;

import guru.springframework.norris.chuck.ChuckNorrisQuotes;
import org.springframework.stereotype.Service;

@Service
public class JokesProviderServiceImpl implements JokesProviderService {

	private final ChuckNorrisQuotes chuckNorrisQuotes;

	public JokesProviderServiceImpl(ChuckNorrisQuotes chuckNorrisQuotes) {
		this.chuckNorrisQuotes = chuckNorrisQuotes;
	}

	@Override
	public String getJokes() {
		return chuckNorrisQuotes.getRandomQuote();
	}
}
