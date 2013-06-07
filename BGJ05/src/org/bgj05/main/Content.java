package org.bgj05.main;

import java.io.IOException;
import java.util.HashMap;
import org.isjaki.Isjaki;
import org.isjaki.audio.Waveform;
import org.isjaki.graphics.Texture2D;

public class Content {
	private HashMap<String, Texture2D> textureMap;
	private HashMap<String, Waveform>  audioMap;
	
	public Texture2D getTexture(String name) {
		return textureMap.get(name);
	}
	
	public Waveform getWaveform(String name) {
		return audioMap.get(name);
	}
	
	public void loadTexture(String name, String path) {
		try {
			textureMap.put(name, Isjaki.loadTexture(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadWaveform(String name, String path) {
		try {
			audioMap.put(name, Isjaki.loadWaveform(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
