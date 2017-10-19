package udemy.saurabh.springguru104springmvcrecipies.model;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	private Integer prepTime;
	private Integer cookTime;
	private Integer servings;
	private String source;
	private String url;

	@Lob
	private String directions;

	/*
	 * How the enum values will look in DB, default in "ordinal"
	 */
	@Enumerated(value = EnumType.STRING)
	private Difficulty difficulty;

	/*
	 * Note that other than "categories"
	 * other name don't matter - so you can have "recipe_id" or something like "op"
	 * But be smart and choose good names, but it can create circular loop in Lombok
	 */
	@ManyToMany
	@JoinTable(name = "recipe_category",
			joinColumns = @JoinColumn(name = "op"),
			inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<>();

	/*
	 * The Cascade.All means any operation like Delete, Fetch etc will also be applied to other type in question
	 */
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "recipe")
	private Set<Ingredient> ingredients = new HashSet<>();

	/*
	 * To store large amount of data in DB
	 */
	@Lob
	private Byte[] image;

	/*
	 * Deleting a Recipe will delete the Notes related to it
	 */
	@OneToOne(cascade = CascadeType.ALL)
	private Notes notes;

	public void setNotes(Notes notes) {
		this.notes = notes;
		notes.setRecipe(this);
	}

	/**
	 * add <code>ingredient</code> to the set of ingredients
	 *
	 * @param ingredient to be added
	 */
	public void addIngredient(Ingredient ingredient) {
		ingredient.setRecipe(this);
		this.ingredients.add(ingredient);
	}
}
