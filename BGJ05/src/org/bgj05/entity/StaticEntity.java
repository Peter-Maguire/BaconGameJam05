package org.bgj05.entity;

import org.bgj05.main.Content;
import org.lwjgl.util.vector.Vector2f;

public class StaticEntity extends Collidable implements IEntity {
	private Vector2f position;
	public Vector2f position() { return position; }
	public void setPosition(Vector2f ny) { position = ny; }
	
	private float rotation;
	public float rotation() { return rotation; }
	public void setRotation(float ny) { rotation = ny; }
	public void rotate(float ny) { rotation += ny; }
	
	private String textureName;
	public String textureName() { return textureName; }
	
	public StaticEntity(String texture_name, Vector2f pos) {
		super(pos, Content.getTexture(texture_name).dimensions());
		
		this.textureName = texture_name;
		this.position = pos;
	}
	
	public void render() {
		Content.getTexture(textureName).render(position, rotation);
	}

	/* I don't fucking know */
	public void update() {}
}
