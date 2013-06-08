package org.bgj05.main;

import java.util.Random;
import org.isjaki.*;
import org.lwjgl.opengl.GL11;

public class MainComponent extends Base2DGame {
	public static int SCREEN_WIDTH 	= 1280;
	public static int SCREEN_HEIGHT	= 720;
	
	/* This is the part where I wish Java inherited
	 * properties from C#, oh god why not omfg */
	private static ScreenManager screenManager;
	public static ScreenManager screenManager() { return screenManager; }
	
	private static Random random;
	public static Random random() { return random; }
	
	private static Content content;
	public static Content content() { return content; }
	
	public MainComponent() {
		super("BGJ 05", SCREEN_WIDTH, SCREEN_HEIGHT, true, false);
	}

	/* Muh jewish stylez */
	protected void init() {
		screenManager = new ScreenManager();
		random 		  = new Random();
		content 	  = new Content();
	}
	
	protected void update() {
		Isjaki.update();
		screenManager.currentScreen().update();
	}
	
	protected void render() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
		screenManager.currentScreen().render();
	}
	
	public static void main(String[] arguments) {
		new MainComponent().start();
	}
}
