package Ch07_Object_Oriented_Design.Q7_03_Jukebox;


class SongSelector {
	private Song currentSong;

	public SongSelector(Song s) {
		currentSong = s;
	}

	public void setSong(Song s) {
		currentSong = s;
	}

	public Song getCurrentSong() {
		return currentSong;
	}
}

