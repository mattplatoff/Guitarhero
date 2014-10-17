package maingame;

import java.io.IOException;

public class MusicPlayerTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Gui g = new Gui();
		MusicPlayer mp = new MusicPlayer("./music/test.mp3", g);
		try {
			mp.generateTextFile("H:\\git\\Guitarhero\\SteveGuitarHero\\Music\\textfile.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}