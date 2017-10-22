package udemy.saurabh.springguru201restfulfruits.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;

	private String name;

}
