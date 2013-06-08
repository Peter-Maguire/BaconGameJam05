package org.bgj05.entity;

import org.lwjgl.util.vector.Vector2f;

public class Asteroid extends DynamicEntity {

	private static final String texture = "placeholder.png";
	
	
	public Asteroid(Vector2f pos, Vector2f init_vel) {
		super(texture, pos, init_vel);
		// TODO Auto-generated constructor stub
	}
	
	public void onCollides(DynamicEntity target){
		//put all the collision logic here
		
		if(target instanceof Asteroid){
			bounce(this, (Asteroid)target);
		}
		
	}
	
	private static void bounce(Asteroid a, Asteroid b){
		//bustin out the physics book
		//v_a2 = 2m_b v_b / m_a + m_b
		
		Vector2f a_2 = b.velocity();
		Vector2f b_2 = a.velocity();
		
		a_2.scale(b.getCollideCircle().getSize() * 2);
		b_2.scale(a.getCollideCircle().getSize() * 2);
		
		
		float m_net = a.getCollideCircle().getSize() + b.getCollideCircle().getSize();
		a_2.scale(1 / m_net);
		b_2.scale(1 / m_net);
		
		a.setVelocity(a_2);
		b.setVelocity(b_2);
		
	}

}
