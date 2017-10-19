package udemy.saurabh.springguru104springmvcrecipies.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(exclude = {"recipe"})    // so that we don't run into circular references
@Entity
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	private Recipe recipe;

	@Lob
	private String recipeNotes;

}