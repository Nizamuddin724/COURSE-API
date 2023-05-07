package nizam.in.binding;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;


@Entity
@Data
public class Courses {
	
	@Id
	private long id;
	
	private String title;
	
	private String description;

	/*
	 * public Courses(long id, String title, String description) { super(); this.id
	 * = id; this.title = title; this.description = description; }
	 */
	

}
