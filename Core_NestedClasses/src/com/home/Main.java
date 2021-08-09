package com.home;

public class Main {
    private static String hotelName = "FiveStar";
    private int yearOfConstruction = 1992;

    //статический вложенный класс - static класс мб описан только внутри другого класса
    //мб любой модификаотр доступа
    private static class StaticNestedClass{
        //внешний класс имеет доступ к методам и полям статического вложенного класса
        static String phrase = "\nHello from StaticNestedClass";
        public static void sayPhrase(){
            System.out.println(phrase);
        }
    }

    //вложенный член-класс (Member Inner Class)
    //мб любой модификаотр доступа
    //мб abstract или final
    class Doorman extends Person implements Greeting{
        //во вложенном член-классе не могут определяться static методы и классы
        //static int id = 0;
        //static int getId(){
        //    return Doorman.id;
        //}
        private int experience;

        public Doorman(String name, int age, int experience) {
            super(name, age);
            if(experience < 0){
                throw new IllegalArgumentException("'experience' parameter = illegal argument (<0)");
            }
            this.experience = experience;
        }

        @Override
        public void greeting() {
            //имеет доступ к переменным родительского класса с любым модиф. доступа
            System.out.println(String.format("Welcome to the %s", hotelName));
        }

        public void ptintAllInfo(){
            System.out.println(String.format("name: %s\nage: %d\nexperience: %d\ncompany: %s",
                    getName(),
                    getAge(),
                    experience,
                    hotelName));
        }

        public int getExperience() {
            return experience;
        }
    }

    //локальный вложенный класс
    public void testLocalInnerClass(){
        String methodShortName = "testLocal";

        //не мб модификатора доступа
        //не мб. static, не может определять static методы и переменные
        //имеет доступ ко всем полям и методам внешнего класса
        //имеет доступ к локальным переменным меотда только если они final(или effectively final)
        class InnerLocal{
            private void printInfo(){
                System.out.println(String.format("method '%s' hotelName: %s year of construction: %d",
                        methodShortName,
                        hotelName,
                        yearOfConstruction));
            }
        }
        new InnerLocal().printInfo();
    }

    public static void main(String[] args) {
        System.out.println("Inner nested class: ");
        //вложенный член-класс не может существовать без экземпляра внешнего класса
        Doorman doorman1 = new Main().new Doorman("Bob",33 ,2);
        System.out.println(doorman1.getClass().getName());
        doorman1.ptintAllInfo();

        //локальный вложенный класс
        System.out.println();
        new Main().testLocalInnerClass();

        //анонимный вложенный класс - без имени
        //исп. для расширения сущ. классов или реализации интерфейсов
        Greeting greeting = new Greeting() {
            @Override
            public void greeting() {
                System.out.println("\nHello from anonymous inner class");
            }
        };
        greeting.greeting();

        //статический вложенный класс
        StaticNestedClass.sayPhrase();
    }
}
