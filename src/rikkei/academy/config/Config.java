package rikkei.academy.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Config<T> {
    //doc file voi tham so generic
    public static final String PATH_CATEGORY="F:\\mudule3\\File\\src\\rikkei\\academy\\database\\category.txt";
    public static Scanner scanner(){
        Scanner scanner=new Scanner(System.in);
        return scanner;
    }

public List<T> readFromFile(String pathFile){
 List<T> tList=new ArrayList<>();
 try{
     FileInputStream fileInputStream =new FileInputStream(pathFile);
     ObjectInputStream objectInputStream =new ObjectInputStream(fileInputStream);
     tList = (List<T>) objectInputStream.readObject();
     fileInputStream.close();
     objectInputStream.close();

 }catch (FileNotFoundException f){
     System.out.println("file not found: ");
 }catch (IOException i){
     System.out.println("Ioe exception: ");
 }catch (ClassNotFoundException c){
     System.out.println("Class not found: ");
 }
return tList;
}
//xay dung phuong thuc ghi phai tham so generic
    public  void writeToFile(String pathFile, List<T> tList){
    try{
        FileOutputStream fileOutputStream =new FileOutputStream(pathFile);
ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
objectOutputStream.writeObject(tList);
fileOutputStream.close();
objectOutputStream.close();

    }catch (FileNotFoundException f){
        System.out.println("File not Fond: ");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }

    }
}
