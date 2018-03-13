package streams.collect;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summingInt;

class Ballot {
	private String name;
	private int judgeNumber;
	private int score;

	public Ballot(String name, int judgeNumber, int score) {
		this.name = name;
		this.judgeNumber = judgeNumber;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}

class Speaking {
	public static void main(String[] args) {
		Stream<Ballot> ballots = Stream.of(new Ballot("Mario", 1, 10),
				new Ballot("Christina", 1, 8),
				new Ballot("Mario", 2, 9),
				new Ballot("Christina", 2, 8));

		Map<String, Integer> scores = ballots.collect(groupingBy(Ballot::getName, summingInt(Ballot::getScore))); // w1

		System.out.println(scores);
		System.out.println(scores.get("Mario"));

		Stream<String> ohMy = Stream.of("lions", "tigers", "bears").parallel();

		ConcurrentMap<Integer, List<String>> map =
				ohMy.collect(
						Collectors.groupingByConcurrent(String::length));

		System.out.println(map); // {5=[lions, bears], 6=[tigers]}
	}
}
