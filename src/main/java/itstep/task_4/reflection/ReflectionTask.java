package itstep.task_4.reflection;

import java.lang.reflect.Field;

public class ReflectionTask {

    public static void main(String[] args) throws IllegalAccessException {
//Write a method which can work with any object using reflection. End user should be able use it like this:
//      get(object,”fieldName”) - return value of field
//		put(object,”fieldName”,value) - put the value to field
//		clear(object,”fieldName”) - put null or 0 to the field.

          CustomClass customObject=new CustomClass();
          System.out.println(customObject);

        getByFieldName(customObject,"stringField");
    }

    private static void getByFieldName(CustomClass customObject, String name) throws IllegalAccessException {
        Class clazz = customObject.getClass();
        Field[] fieldsArray=clazz.getDeclaredFields();
        for(Field f:fieldsArray){
           // System.out.println(f.getName());
            if(name.equals(f.getName())){
                f.setAccessible(true);
                System.out.println(name+" = "+f.get(customObject));
            }
        }
    }

}
