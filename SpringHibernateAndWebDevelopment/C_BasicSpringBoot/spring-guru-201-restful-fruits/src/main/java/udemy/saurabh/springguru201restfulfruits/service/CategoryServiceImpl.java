package udemy.saurabh.springguru201restfulfruits.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import udemy.saurabh.springguru201restfulfruits.api.v1.mapper.ICategoryMapper;
import udemy.saurabh.springguru201restfulfruits.api.v1.model.CategoryDTO;
import udemy.saurabh.springguru201restfulfruits.repository.ICategoryRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements ICategoryService {
	private final ICategoryMapper categoryMapper;
	private final ICategoryRepository categoryRepository;

	@Autowired
	public CategoryServiceImpl(ICategoryMapper ICategoryMapper, ICategoryRepository categoryRepository) {
		this.categoryMapper = ICategoryMapper;
		this.categoryRepository = categoryRepository;
	}

	@Override
	public List<CategoryDTO> getAllCategories() {

		return categoryRepository.findAll()
				.stream()
				.map(category -> categoryMapper.categoryToCategoryDTO(category))
				.collect(Collectors.toList());
	}

	@Override
	public CategoryDTO getCategoryByName(String name) {
		return categoryMapper.categoryToCategoryDTO(categoryRepository.findByName(name));
	}
}
