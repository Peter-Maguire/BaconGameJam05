package org.bgj05.main;

import java.util.HashMap;

import org.bgj05.screen.*;

public class ScreenManager {
	private HashMap<String, IScreen> screenMap;
	
	private String currentScreen;
	public IScreen currentScreen() { return screenMap.get(currentScreen); }
	
	public ScreenManager() {
		screenMap = new HashMap<String, IScreen>();
		this.init();
	}
	
	private void init() {
		screenMap.put("Game_Screen", new GameScreen());
		screenMap.put("Pause_Screen", new PauseScreen());
		screenMap.put("Intro_Screen", new IntroScreen());
		screenMap.put("Credits_Screen", new CreditsScreen());
		
		currentScreen = "Game_Screen";
	}
	
	public void setScreen(String screen) {
		
	}
}
