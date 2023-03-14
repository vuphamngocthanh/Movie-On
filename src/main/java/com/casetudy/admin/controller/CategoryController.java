package com.casetudy.admin.controller;

import com.casetudy.admin.service.Impl.category.ICategoryService;
import com.casetudy.dto.CategoryDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/admin-movie")
public class CategoryController {
    private final ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/category-list")
    public ModelAndView categoryList(){
        ModelAndView modelAndView = new ModelAndView("admin/category/list");
        Iterable<CategoryDto> categoryDtoList = categoryService.findAll();
        modelAndView.addObject("categories",categoryDtoList);
        return modelAndView;
    }
    @GetMapping("/create-category")
    public ModelAndView createCategory(){
        ModelAndView modelAndView = new ModelAndView("admin/category/create");
        modelAndView.addObject("category",new CategoryDto());
        return modelAndView;
    }
    @PostMapping("/create-category/save")
    public ModelAndView saveCategory(CategoryDto categoryDto){
        categoryService.save(categoryDto);
        return new ModelAndView("redirect:/admin-movie/category-list");
    }
    @GetMapping("/category-list/edit-{id}")
    public ModelAndView editCategory(@PathVariable(value = "id") Integer id){
        ModelAndView modelAndView = new ModelAndView("admin/category/edit");
        modelAndView.addObject("category",categoryService.findById(id));
        return modelAndView;
    }
}
