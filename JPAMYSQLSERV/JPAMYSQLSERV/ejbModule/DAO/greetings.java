package DAO;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="greetings") 
public class greetings implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;

	@Column(name="Name")
	private String name;

	public greetings() {
	}
	
	public greetings(String name) {
		this.name = name;

	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}



public String toString() {
    return "Greeting id=" + id + ", Name=" + name ;
}


}
