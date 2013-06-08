package org.bgj05.entity;

import org.bgj05.main.Content;
import org.isjaki.utils.Time;
import org.lwjgl.util.vector.Vector2f;

public class DynamicEntity implements IEntity {
	private Vector2f position;
	public Vector2f position() { return position; }
	public void setPosition(Vector2f ny) { position = ny; }
	
	private Vector2f velocity;
	public Vector2f velocity() { return velocity; }
	public void setVelocity(Vector2f ny) { velocity = ny; }
	public void addVelocity(Vector2f ny) { 
		this.velocity.x += ny.x; 
		this.velocity.y += ny.y;
	}
	
	private float rotation;
	public float rotation() { return rotation; }
	public void setRotation(float ny) { rotation = ny; }
	public void rotate(float ny) { rotation += ny; }
	
	private String textureName;
	public String textureName() { return textureName; }
	
	private CollideRect collisionBox;
	public CollideRect getCollideRect(){
		return collisionBox;
	}
	
	public boolean collides(DynamicEntity target){
		return collisionBox.collides(target.getCollideRect());
	}
	
	
	public DynamicEntity(String texture_name, Vector2f pos, Vector2f init_vel) {		
		this.textureName = texture_name;
		this.position = pos;
		this.velocity = init_vel;
		//make a collisionBox at position, the size of the texture
		collisionBox = new CollideRect(pos, Content.getTexture(texture_name).dimensions());
	}
	
	public void render() {
		Content.getTexture(textureName).render(position, rotation);
	}

	public void update() { 
		position.x += velocity.x * Time.getDeltaRelation();
		position.y += velocity.y * Time.getDeltaRelation();
		
		collisionBox.update(position);
	}
}
