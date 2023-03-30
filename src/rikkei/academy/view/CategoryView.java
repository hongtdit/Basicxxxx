package rikkei.academy.view;

import rikkei.academy.config.Config;
import rikkei.academy.controller.CategoryController;
import rikkei.academy.model.Category;

import java.util.List;

public class CategoryView {
    CategoryController categoryController =new CategoryController();
    List<Category> categoryList=categoryController.getListCategory();
    public void showListCategory() {
        System.out.println(categoryList);
        System.out.println("enter  quit to return menu");
        String BackMenu = Config.scanner().nextLine();
        if (BackMenu.equalsIgnoreCase("quit")) {
            new Narbar();

        }
    }
//        for (Category a: categoryList
//             ) {
//            System.out.println(categoryList);
//        }
////        System.out.println(categoryList);
//    }
    public void formCreatCategory(){
        while (true){
            int id=0;
            if (categoryList.size()==0){
                id=1;

            }else {
                id=categoryList.get(categoryList.size()-1).getId()+1;
            }
            System.out.println("Enter your name: ");
            String name = Config.scanner().nextLine();
            Category category=new Category(id,name);
            categoryController.creatCategory(category);
            System.out.println("Them thanh cong: ");
            System.out.println("enter any key to continue or quit to return menu");
            String BackMenu =Config.scanner().nextLine();
            if(BackMenu.equalsIgnoreCase("quit")){
                new Narbar();
                break;
            }

        }

    }
    public void updateCategory(){
        while (true){
            System.out.println("nhập id để update: ");
            int id=Config.scanner().nextInt();
            if(categoryController.detailCategory(id)==null){
                System.out.println("ID kHÔNG HỢP LỆ: ");
            }else {
                System.out.println("Enter the name category: ");
                String name =Config.scanner().nextLine();
                Category category=new Category(id,name);
                categoryController.updateCategory(category);
                System.out.println("enter any key to continue or quit to return menu");
                String BackMenu =Config.scanner().nextLine();
                if(BackMenu.equalsIgnoreCase("quit")){
                    new Narbar();
                    break;
            }
        }

    }
    }
    public void deleteCategory() {
        while (true) {
            System.out.println("Enter id category cần xóa: ");
            int id = Integer.parseInt(Config.scanner().nextLine());
            if (categoryController.findById(id) == null) {
                System.out.println("Id does not exist");
            } else {
                categoryController.deleteCategory(id);
                System.out.println("Delete success!");
                System.out.println("Enter back to return Menu");
                String backMenu = Config.scanner().nextLine();
                if (backMenu.equalsIgnoreCase("back")) {
                    new Narbar();
                    break;

                }

            }
        }

    }





}
