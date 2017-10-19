package udemy.saurabh.springguru104springmvcrecipies.model;

import javax.persistence.*;

@Entity
public class UnitOfMeasure {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;

	@OneToOne
	private Ingredient ingredient;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}

	@Override
	public String toString() {
		return "UnitOfMeasure{" +
				"id=" + id +
				", description='" + description + '\'' +
				", ingredient=" + ingredient +
				'}';
	}
}
