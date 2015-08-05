package Game;

import java.awt.Color;

public class FlappyBird extends MovingObject {

	private boolean push;
	private boolean crash;

	public FlappyBird(String name, String object, Color color, int speed,
			int level, boolean crash, boolean push) {
		super(name, object, color, speed, level);
	}

	public boolean isPush() {
		return push;
	}

	public void setPush(boolean push) {
		this.push = push;
	}

	public boolean isCrash() {
		return crash;
	}

	public void setCrash(boolean crash) {
		this.crash = crash;
	}

	public void fly(boolean push) {
		if (push) {
			System.out.println("Kloop");
		}
	}

	public boolean alive(boolean crash) {
		if (crash) {
			System.out.println("Oh");
			return false;
		} else
			return true;
	}
}
