package uch;

public class IdManager {
	
	private int currentId;

	public IdManager(int currentId) {
		super();
		this.currentId = currentId;
	}
	
	public int getNewId() {
		currentId++;
		return currentId;
	}
	

}
