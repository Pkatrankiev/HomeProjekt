package Game;

import java.awt.Color;

public class MovingObject extends GameObject {

	private int speed = 4;
	private int level = 1;

	public MovingObject(String name, String object, Color color, int speed,
			int level) {
		super(name, object, color);
		this.setSpeedObject(speed);
		this.setLevel(level);
	}

	public int getSpeedObject() {
		return speed;
	}

	public void setSpeedObject(int speed) {
		this.speed = speed;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void move(int level) {
		this.speed = this.speed + 2 * level;

	}

}
