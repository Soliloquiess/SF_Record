package lab.ssafy.corona.virus;

import com.ssafy.FakeVirus;


public class Corona extends Virus{
	
	private int spreadSpeed;

	public int getSpreadSpeed() {
		return spreadSpeed;
	}

	public void setSpreadSpeed(int spreadSpeed) {
		this.spreadSpeed = spreadSpeed;
	}
	
	public void showInfo() {
		String info =  super.getName() + " " + super.getLevel() + " " + this.spreadSpeed;
		System.out.println(info);
	}
	
	public Corona() {}
	
	public Corona(String name, int level, int spreadSpeed ) {
		super.name = name;
		super.level = level;
		this.spreadSpeed = spreadSpeed;
	}
}
	
	
	
	

