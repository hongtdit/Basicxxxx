package rikkei.academy.service;

import rikkei.academy.config.Config;
import rikkei.academy.model.Category;

import java.util.List;

public class CategoryServiceIMPL implements ICategoryService {
    List<Category> categoryList =new Config<Category>().readFromFile(Config.PATH_CATEGORY);
    static String PATH_CATEGORY ="F:\\mudule3\\File\\src\\rikkei\\academy\\database\\category.txt";


    @Override
    public List<Category> findAll() {
        return categoryList;
    }

    @Override
    public void save(Category category) {
        if(findById(category.getId())==null){
            categoryList.add(category);
        }
        else {
//            Category category1=findById(category.getId());
//            category1.setName(category.getName());
            //c2
            categoryList.set(categoryList.indexOf(findById(category.getId())),category);
        }

        new Config<Category>().writeToFile(Config.PATH_CATEGORY,categoryList);

    }

    @Override
    public Category findById(int id) {
        for (int i = 0; i <categoryList.size(); i++) {
            if(categoryList.get(i).getId()==id){
                return categoryList.get(i);
            }

        }
        return null;
    }

    public void deleteById(int id) {
//        int index=categoryList.indexOf(findById(id));
        categoryList.remove(findById(id));
        new Config<Category>().writeToFile(Config.PATH_CATEGORY,categoryList);

    }


}
