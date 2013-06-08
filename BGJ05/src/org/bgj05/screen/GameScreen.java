package org.bgj05.screen;

import java.util.ArrayList;
import org.bgj05.entity.*;
import org.lwjgl.util.vector.Vector2f;

public class GameScreen implements IScreen {
	public GameScreen() { this.init(); }
	
	//all entities on screen
	private ArrayList<DynamicEntity> entities = new ArrayList<DynamicEntity>();
	//entities that need to be removed
	//private ArrayList<DynamicEntity> removeList = new ArrayList<DynamicEntity>();
	
	
	public void init() {
		//add the player
		//add the sun
		//add the rockspawner
		//add a lot of things
		
		Asteroid testrock = new Asteroid(new Vector2f(320,320), new Vector2f(1,1));
		entities.add(testrock);
		
	}
	public void render() {
		
		
		for(DynamicEntity entity : entities ){
			entity.render();
		}
		
	}
	
	public void update() {
		
		for(DynamicEntity entity : entities ){
			entity.update();
		}
		
		
		//check all collisions, call collides on entities that collide
		for(int i = 0; i < entities.size(); i++){
			for(int j = i + 1; j < entities.size(); j++){
				DynamicEntity a = entities.get(i);
				DynamicEntity b = entities.get(j);
				
				//We probably need some way of checking to avoid double collisions
				
				if(a.collides(b)){
					a.onCollide(b);
					b.onCollide(a);
				}
				
			}
		}
		
		
		
	}
	
	public void destroy() {
		
	}

	

}
