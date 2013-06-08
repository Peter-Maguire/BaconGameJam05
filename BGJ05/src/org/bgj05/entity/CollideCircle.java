package org.bgj05.entity;

import org.lwjgl.util.vector.Vector2f;

public class CollideCircle {

	protected Vector2f position;
	protected float size;
	
	public Vector2f getPos(){ return position; }
	public void setPos(Vector2f pos){
		this.position = new Vector2f(pos.x, pos.y);
	}
	public void linkPos(Vector2f pos){
		//I forgot how java does pointers and stuff.
		//This might be very very bad.
		this.position = pos;
	}
	
	
	public float getSize(){ return size; }
	
	public CollideCircle(Vector2f position, float size) {
		this.position = new Vector2f (position.x, position.y);
		this.size = size;
	}
	
	public boolean collides(CollideCircle target){
		float dist;
		Vector2f temp = new Vector2f();
		
		//get the absolute length of the difference of the vectors
		Vector2f.sub(this.position, target.position, temp);
		dist = Math.abs(temp.length());
		
		//if the distance between is shorter than both sizes
		return (dist < this.size + target.size);
		
	}

}
