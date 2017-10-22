package udemy.saurabh.springguru201restfulfruits.api.v1.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CategoryDTO;
import udemy.saurabh.springguru201restfulfruits.model.Category;

@Mapper
public interface ICategoryMapper {

	ICategoryMapper INSTANCE = Mappers.getMapper(ICategoryMapper.class);

	CategoryDTO categoryToCategoryDTO(Category category);
}