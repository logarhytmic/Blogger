package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Recipes")
public class Recipe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column
	public int id;
	
	@Column
	public String name;
	
	@Column
	public int time;
	
	@Column
	public String type;
	
	public Recipe(int id, String name, int time, String type) {
		this.id = id;
		this.name = name;
		this.time = time;
		this.type = type;
	}
	
			
	public int getId() {
		return id;	
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getType() {
		return type;
	}	

	public void setType(String type) {
		this.type = type;
	}

	
}
