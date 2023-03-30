package rikkei.academy.controller;

import rikkei.academy.model.Category;
import rikkei.academy.service.CategoryServiceIMPL;
import rikkei.academy.service.ICategoryService;

import java.util.List;

public class CategoryController {
    ICategoryService categoryService =new CategoryServiceIMPL();
    public List<Category> getListCategory(){
        return categoryService.findAll();
    }
    public void creatCategory(Category category){
        categoryService.save(category);


    }
    public Category detailCategory(int id){
        return categoryService.findById(id);
    }
    public void updateCategory(Category category){
        categoryService.save(category);
    }
    public Category findById(int id){
        return categoryService.findById(id);
    }
    public void deleteCategory(int id){
        categoryService.deleteById(id);


    }
}
