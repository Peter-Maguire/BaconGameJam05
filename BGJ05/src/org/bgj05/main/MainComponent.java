package org.bgj05.main;

import org.isjaki.*;
import org.lwjgl.opengl.GL11;

public class MainComponent extends Base2DGame {
	public static int SCREEN_WIDTH 	= 1280;
	public static int SCREEN_HEIGHT	= 720;
	
	public MainComponent() {
		super("BGJ 05", SCREEN_WIDTH, SCREEN_HEIGHT, true, false);
	}

	protected void init() {
		
	}
	
	protected void update() {
		Isjaki.update();
	}
	
	protected void render() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
	}
	
	public static void main(String[] arguments) {
		new MainComponent().start();
	}
}
