package Game;

import java.awt.Color;

public class GameObject {
	private String nameObject;
	private Color colorObject;
	private String tapeObject;
	
	public GameObject(String name, String object, Color color){
		this.setNameObject(name);
		this.setTapeObject(object);
		this.setColorObject(color);
	}
		public GameObject(){
			this.setNameObject("Brick wall");
			this.setTapeObject("Îbstacle");
			this.setColorObject(Color.red);
			}

	public String getNameObject() {
		return nameObject;
	}

	public void setNameObject(String nameObject) {
		this.nameObject = nameObject;
	}

	public Color getColorObject() {
		return colorObject;
	}

	public void setColorObject(Color colorObject) {
		this.colorObject = colorObject;
	}

	public String getTapeObject() {
		return tapeObject;
	}

	public void setTapeObject(String tapeObject) {
		this.tapeObject = tapeObject;
	}

	
	

}
