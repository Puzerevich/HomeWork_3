package HomeWork_3;

import HomeWork_3.Exception.TooEnoughStudentsException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Konstantin on 16.04.2018.
 */
public class StudentGroup extends JFrame implements Voenkom{

    private Student[] groupStudent = new Student[10];
    private String grName;

    public StudentGroup() {
    }

    public StudentGroup(String grName) {
        this.grName = grName;
    }

    public StudentGroup(Student[] groupStudent) {
        this.groupStudent = groupStudent;
        this.grName = "Unknown group name";
    }

    public StudentGroup(Student[] groupStudent, String grName) {
        this.groupStudent = groupStudent;
        this.grName = grName;
    }

    public Student[] getGroupStudent() {
        return groupStudent;
    }

    public void setGroupStudent(Student[] groupStudent) {
        this.groupStudent = groupStudent;
    }

    public String getGrName() {
        return grName;
    }

    public void setGrName(String grName) {
        this.grName = grName;
    }

    public void addStudent(Student student) throws TooEnoughStudentsException {
        if (student == null) {
            throw new IllegalArgumentException("Field empty. Add student.");
        }
        for (int i = 0; i < groupStudent.length; i++) {
            if (groupStudent[i] == null) {
                groupStudent[i] = student;
                return;
            }
        }
        throw new TooEnoughStudentsException();
    }

    public void delStudent(int scoreBookId) {
        for (int i = 0; i < groupStudent.length; i++) {
            if (groupStudent[i].getScoreBookId() == scoreBookId && groupStudent[i]!=null) {
                groupStudent[i] = null;
            }
        }
    }

    public String findStudent(String surname) {
        String findRes = "";
        for(int i=0;i<groupStudent.length;i++) {
            if(groupStudent[i]!=null && groupStudent[i].getSurname().equals(surname)) {
                findRes=groupStudent[i].toString();
            }
        }
        return findRes;
    }

    private int compareStudent(Student a, Student b) {
        if (a != null && b == null) {
            return 1;
        }
        if (a == null && b != null) {
            return -1;
        }
        if (a == null && b == null) {
            return 0;
        }
        return a.getName().compareTo(b.getName());
    }

    private int compareStudentBySurname(Student a, Student b) {
        if (a != null && b == null) {
            return 1;
        }
        if (a == null && b != null) {
            return -1;
        }
        if (a == null && b == null) {
            return 0;
        }
        return a.getSurname().compareTo(b.getSurname());
    }

     public void sortByName() {
        for (int i = 0; i < groupStudent.length - 1; i++) {
            for (int j = i + 1; j < groupStudent.length; j++) {
                if (compareStudent(groupStudent[i], groupStudent[j]) > 0){
                    Student temp = groupStudent[i];
                    groupStudent[i] = groupStudent[j];
                    groupStudent[j] = temp;
                }
            }
        }
    }

// Interactive dialog window
    private static JTextField firstName, secondName, age, scoreBook, universityName, averageScore, groupName;
    public static JButton btnAdd, btnCancel;
    private JCheckBox sex;

public void addStudentInteractive()  {
    final JFrame frame = new JFrame("Student group form");

    JPanel panel = new JPanel();
    frame.add(panel);
    panel.setLayout(new GridLayout(9,2));

    panel.add(new JLabel("Enter name: "));
    panel.add(firstName = new JTextField());
    panel.add(new JLabel("Enter surname: "));
    panel.add(secondName = new JTextField());
    panel.add(new JLabel("Enter age: "));
    panel.add(age = new JTextField());
    panel.add(new JLabel(""));
    panel.add(sex = new JCheckBox("Male"));
    panel.add(new JLabel("Enter university name: "));
    panel.add(universityName = new JTextField());
    panel.add(new JLabel("Enter number of your \"zachetka\": "));
    panel.add(scoreBook = new JTextField());
    panel.add(new JLabel("Enter group name: "));
    panel.add(groupName = new JTextField());

    panel.setVisible(true);

    panel.add(btnAdd = new JButton("Add student to group"));
    panel.add(btnCancel = new JButton("Cancel"));


    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocation(600,400);
    frame.setSize(400, 250);
    frame.setVisible(true);

    btnAdd.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(firstName.getText().trim().length()>0 &&
                    secondName.getText().trim().length()>0 &&
                    universityName.getText().trim().length()>0 &&
                    groupName.getText().trim().length()>0
                    ) {

                Student st12 = new Student(firstName.getText(), secondName.getText(), Integer.valueOf(age.getText()), sex.isSelected(),
                        universityName.getText(),  Integer.valueOf(scoreBook.getText()), 0, groupName.getText());

                for (int i = 0; i < groupStudent.length; i++) {
                    if (groupStudent[i] == null) {
                        groupStudent[i] = st12;
                        return;
                    }else
                        System.out.println(groupStudent[i].toString()+" \n");
                }
            }
            else {
                JOptionPane.showMessageDialog(frame, "Все поля должны быть заполнены!");
            }

        }
    });

    btnCancel.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            frame.dispose();
        }
    });

  }





    @Override
    public String toString() {
        sortByName();
        for (int i = 0; i < groupStudent.length; i++) {
            if (groupStudent[i] != null) {
                System.out.println(i+")"+groupStudent[i].getName()+" "+groupStudent[i].getSurname()+", score: "+groupStudent[i].getAverageScore()+", "+groupStudent[i].getUniversityName()+" "+groupStudent[i].getGroup());
            }
        }
        return "";
    }


    @Override
    public Student[] getInArmy() {

        int n = 0;
        for (Student std : groupStudent) {
            if (std != null && std.getSex() && std.getAge() >= 18) {
                n += 1;
            }
        }
        Student[] recArr = new Student[n];
        int i = 0;
        for (Student student : this.groupStudent) {
            if (student != null && student.getSex() && student.getAge() >= 18) {
                recArr[i++] = student;
            }
        }
        return recArr;

    }


}

