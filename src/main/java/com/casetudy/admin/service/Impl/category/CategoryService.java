package com.casetudy.admin.service.Impl.category;

import com.casetudy.dto.CategoryDto;
import com.casetudy.entity.Category;
import com.casetudy.repository.CategoryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryService implements ICategoryService {
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    public CategoryService(ModelMapper modelMapper, CategoryRepository categoryRepository) {
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
    }
    @Override
    public Iterable<CategoryDto> findAll() {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.parallelStream()
                .map(category -> modelMapper.map(category, CategoryDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto findById(Integer id) {
        Category category = categoryRepository.findById(id).get();
        return modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public void save(CategoryDto categoryDto) {
        Category category = modelMapper.map(categoryDto, Category.class);
        categoryRepository.save(category);
    }

    @Override
    public void remove(Integer id) {

    }
//    @Override
//    public void remove(Integer id) {
//
//    }
}