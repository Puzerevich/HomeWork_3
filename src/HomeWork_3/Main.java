package HomeWork_3;


import HomeWork_3.Exception.TooEnoughStudentsException;

public class Main {

    public static void main(String[] args) throws TooEnoughStudentsException {

        Student st1 = new Student("Павел", "Матвеев", 34, true, "Kiev Polytechnic", 100501,47,"DP-11");
        Student st2 = new Student("Денис ", "Матвеев", 39, true, "Kiev Polytechnic", 100502, 45,"DP-11");
        Student st3 = new Student("Владимир", "Васильев", 27, true, "National Transport University", 100508, 52);
        Student st4 = new Student("Элина", "Ишмухаметова", 44, false,  "National Transport University", 100508, 37);
        Student st5 = new Student("Екатерина", "Крицкая", 26, false,  "National Transport University", 100509, 41);
        Student st6 = new Student("Иван", "Кубарев", 29, true, "Kiev Polytechnic",  100503,42,"DP-11");
        Student st7 = new Student("Данил", "Шенкер", 29, true, "Kiev Polytechnic", 100504,42,"DP-11");
        Student st8 = new Student("Кристиан", "Пегасин", 17, false, "KNU", 100505,37);
        Student st9 = new Student("Елизавета", "Пескишева", 26, false, "KNU", 100506,42);
        Student st10 = new Student("Артем", "Смирнов", 29, true, "Kiev Polytechnic", 100510,52,"DP-11");
        Student st11 = new Student("Борис", "Чертов", 27, true, "KNU", 100507, 42);

        StudentGroup studgroup = new StudentGroup();

//      System.out.println("Add student in group! ------------------------------");
        studgroup.addStudent(st1);
        studgroup.addStudent(st2);
        studgroup.addStudent(st3);
        studgroup.addStudent(st4);
        studgroup.addStudent(st5);
        studgroup.addStudent(st6);
        studgroup.addStudent(st7);
        studgroup.addStudent(st8);
        studgroup.addStudent(st9);
        studgroup.addStudent(st10);

        studgroup.addStudentInteractive(); // Interactive input of information

      // Розкоменитировать для проверки добавления 11 студанта
      //  studgroup.addStudent(st11); /// Exception because more than 10 student


        System.out.println(
                studgroup.toString()
        );

        System.out.println("You need your country solder:");
        Student[] recrutsStudent = studgroup.getInArmy();
        for (int i = 0; i < recrutsStudent.length; i++) {
           System.out.println(recrutsStudent[i].toString());
        }
    }
}
