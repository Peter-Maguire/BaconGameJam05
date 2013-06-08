package org.bgj05.main;

import java.io.IOException;
import java.util.HashMap;
import org.isjaki.Isjaki;
import org.isjaki.audio.Waveform;
import org.isjaki.graphics.Texture2D;

public class Content {
	private static HashMap<String, Texture2D> textureMap;
	private static HashMap<String, Waveform>  audioMap;
	
	public Content() {
		textureMap = new HashMap<String, Texture2D>();
		audioMap   = new HashMap<String, Waveform>();
		this.init();
	}
	
	public static Texture2D getTexture(String name) {
		return textureMap.get(name);
	}
	
	public static Waveform getWaveform(String name) {
		return audioMap.get(name);
	}
	
	protected void loadTexture(String name, String path) {
		if (textureMap.containsKey(name)) {
			System.out.println("Texture \"" + name + "\" already exists!");
			return; 
		}
		
		try { textureMap.put(name, Isjaki.loadTexture(path)); } 
		catch (IOException e) { e.printStackTrace(); }
	}
	
	protected void loadWaveform(String name, String path) {
		if (textureMap.containsKey(name)) {
			System.out.println("Waveform \"" + name + "\" already exists!");
			return; 
		}
		
		try { audioMap.put(name, Isjaki.loadWaveform(path)); } 
		catch (IOException e) { e.printStackTrace(); }
	}
	
	/* Fuck you github, fuck you. */
	public void init() {
		//this.loadTexture("Name", "Path");
		//this.loadWaveform("Name", "Path");
	}
}
