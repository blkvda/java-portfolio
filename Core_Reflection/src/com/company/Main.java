package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {

    public static void main(String[] args) {
        try {
            //Создание экземпляра класса с использованием Reflection
            Class clazz = Test.class;
            Test reflect = (Test)clazz.newInstance();

            //Название класса указанного экземпляра (вместе с пакетами)
            System.out.println("'reflect' full class name: " + clazz.getName());

            //получение суперкласса
            Class superClass = clazz.getSuperclass();
            System.out.println("'reflect' full superclass name: " + superClass.getName());

            //получение модификатора доступа класса
            int mods = clazz.getModifiers();
            switch (mods) {
                case (Modifier.PUBLIC): {
                    System.out.println("'reflect' modifier: PUBLIC");
                    break;
                }
                case (Modifier.PROTECTED): {
                    System.out.println("'reflect' modifier: PROTECTED");
                    break;
                }
                case (Modifier.PRIVATE): {
                    System.out.println("'reflect' modifier: PRIVATE");
                    break;
                }
            }

            //получение информации об интерфейсах
            Class<?>[] interfaces = Test.class.getInterfaces();
            if (interfaces.length > 0) {
                System.out.println("'Test.class' interfaces:");
            }
            for (Class<?> intfcs : interfaces) {
                System.out.println("\t" + intfcs.getName());
            }

            //получение информации о public конструкторах
            Constructor[] сonstrctrs = Test.class.getConstructors();
            if (interfaces.length > 0) {
                System.out.println("'Test.class' constructors:");
            }
            for (Constructor сon : сonstrctrs) {
                Class<?>[] params = сon.getParameterTypes();
                System.out.print("Constructor params: ");
                for (Class<?> param : params) {
                    System.out.print(param.getName() + " ");
                }
                System.out.println();
            }

            //получение информации о всех public полях
            Field[] fields = Test.class.getFields();
            if (fields.length > 0) {
                System.out.println("'Test.class' only public fields(" + fields.length + "):");
            }
            for (Field f : fields) {
                System.out.println("\tname: " + f.getName() + "\ttype: " + f.getType().getName());
            }

            //получение информации о всех объявленных в коде полях
            fields = Test.class.getDeclaredFields();
            if (fields.length > 0) {
                System.out.println("'Test.class' all declared fields(" + fields.length + "):");
            }
            for (Field f : fields) {
                System.out.println("\tname: " + f.getName() + "\ttype: " + f.getType().getName());
            }

            //получение информации о всех public методах
            Method[] methods = Test.class.getMethods();
            if (methods.length > 0) {
                System.out.println("'Test.class' public methods(" + methods.length + "):");
            }
            for (Method method : methods) {
                System.out.print("\tname : " + method.getName() +
                        "\treturn type : " + method.getReturnType().getName() + "\n");
            }

            //получение информации о всех объявленных в коде класса методах
            methods = Test.class.getDeclaredMethods();
            if (methods.length > 0) {
                System.out.println("'Test.class' all methods(" + methods.length + "):");
            }
            for (Method method : methods) {
                System.out.print("\tname : " + method.getName() +
                        "\treturn type : " + method.getReturnType().getName() + "\n");
            }

            //создание экземпляра с использованием конструктора
            Constructor c = clazz.getConstructor(int.class, String.class);
            Test reflectFromCon = (Test)c.newInstance(5, "Hello");
            System.out.println("Before change field value:\n" + reflectFromCon);
            Field field = reflectFromCon.getClass().getField("pub");
            field.set(reflectFromCon, "Hi reflection");
            System.out.println("After change field value:\n" + reflectFromCon);

            //чтение и изменение полей экземпляра класса
            //protected
            Field protectedField = reflectFromCon.getClass().getDeclaredField("prot");
            System.out.println("Protected field: " + protectedField.get(reflectFromCon));
            protectedField.set(reflectFromCon, "Hi protected reflect");
            System.out.println("Protected field: " + protectedField.get(reflectFromCon));
            //private
            Field privateField = reflectFromCon.getClass().getDeclaredField("priv");
            privateField.setAccessible(true); //необходимо для доступа к private полям
            System.out.println("Private field: " + privateField.get(reflectFromCon));
            privateField.set(reflectFromCon, "Hi private reflect");
            System.out.println("Private field: " + privateField.get(reflectFromCon));
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
