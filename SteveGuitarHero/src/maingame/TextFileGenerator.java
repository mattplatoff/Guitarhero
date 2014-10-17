package maingame;

import java.io.IOException;

public class TextFileGenerator  {

	public static void main(String[] args) throws IOException {
		Gui g=new Gui();
		MusicPlayer mp=new MusicPlayer("H:\\git\\Guitarhero\\SteveGuitarHero\\Music\\test.mp3",g);
		mp.generateTextFile("H:\\git\\Guitarhero\\SteveGuitarHero\\Music\\song1.txt");
	}

}
