//пакет - дерево каталогов, для группировки и идентификации классов
package com.home;

//пакет java.lang.* импортируется автоматически
import java.lang.String; //импорт конкретного класса
import java.util.*; //импорт всех классов пакета (без подкаталогов)

//имя public класса должно совпадать с именем файла (в одном файле мб только один стандартный (не вложенный) public класс)
public class Main {
    //private - модификатор доступа, доступ только внутри класса
    //default (private-package) - модификатор доступа, доступ внутри классов одного пакета
    //protected - модификатор доступа, доступ внутри классов одного пакета и в классах наследниках
    //public - модификатор доступа, доступ из любого класса
    //static - кл. слово, поле общее для всех экземпляров класса, доступно после загрузки класса, без создания экземпляра
    static private long count;

    //блок кода - между {} - для инициализации переменных, мб (не)static
    static {
        count = 0;
        System.out.println("Static block of code");
    }

    //private - для инкапсуляции данных, в данном случае для инициализации исп. конструктор, для получения геттер
    private long id;
    String description;
    int x;
    {
        x = 1;
        System.out.println("Block of code");
    }
    //int x = 1; //то же самое, что и инициализация в блоке кода

    //метод main - точка "входа" в программу
    public static void main(String[] args) {
        System.out.println("Count of Main objects: " + Main.count);
        Main m1 = new Main();
        Main m2 = new Main();
        Main m3 = new Main("My desc");
        System.out.println("Count of Main objects: " + Main.count);
    }

    //констурктор класса
    //конструктор по умолчанию (без параметров) - с пустым телом, создается автоматически,
    //если нет пользовательских конструкторов
    public Main(){
        this("default description"); //this - для вызова другого констурктора класса, должен быть первой строкой
        System.out.println("Main() - called");
    }

    public Main(String description){
        this.description = description; //this - исп. для указания переменной класса, если имена совпадают
        id = count;
        count++;
        System.out.println("Main(String description) - called");
    }

    //геттер - исп. для получения значения private поля
    public long getId() {
        return id;
    }

    public static long getCount(){
        return count;
    }
}



