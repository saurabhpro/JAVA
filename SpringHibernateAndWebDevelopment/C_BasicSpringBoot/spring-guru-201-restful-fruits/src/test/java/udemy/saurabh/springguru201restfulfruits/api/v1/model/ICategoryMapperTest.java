package udemy.saurabh.springguru201restfulfruits.api.v1.model;

import org.junit.Test;
import udemy.saurabh.springguru201restfulfruits.api.v1.mapper.ICategoryMapper;
import udemy.saurabh.springguru201restfulfruits.model.Category;

import static org.junit.Assert.assertEquals;

public class ICategoryMapperTest {
	private static final String NAME = "Joe";
	private static final long ID = 1L;

	private final ICategoryMapper categoryMapper = ICategoryMapper.INSTANCE;

	@Test
	public void categoryToCategoryDTO() throws Exception {

		//given
		Category category = new Category();
		category.setName(NAME);
		category.setId(ID);

		//when
		CategoryDTO categoryDTO = categoryMapper.categoryToCategoryDTO(category);

		//then
		assertEquals(Long.valueOf(ID), categoryDTO.getId());
		assertEquals(NAME, categoryDTO.getName());
	}


}