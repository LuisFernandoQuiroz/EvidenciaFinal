package Models;

import java.time.LocalDate;

public class users {
	private String u;
	private String w;
	private Float i;
	private String d;
	
	public users(String un){
		this.setUser(un);
	}
	
	public void setUser(String user){
		this.u = user;
	}
	
	public String getUser() {
		return u;
	}
	
	public String getW() {
		return w;
	}

	public void setI(Float height, Float weight){
		i = weight / (height * height);
	}
	
	public Float getI() {
		return i;
	}

	public void setD(){
		LocalDate date = LocalDate.now();
		d = date.toString();
	}
	
	public String getD() {
		return d;
	}
}
