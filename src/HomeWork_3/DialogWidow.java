package HomeWork_3;


import HomeWork_3.Exception.TooEnoughStudentsException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Konstantin on 16.04.2018.
 */
public class DialogWidow extends JFrame{

    private static final long serialVersionUID = 1L;
    private static JTextField firstName, secondName, age, scoreBook, universityName, averageScore, groupName;
    public static JButton btnAdd, btnCancel;
    private JCheckBox sex;


    public DialogWidow(){

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

                    StudentGroup stg = new StudentGroup();
                    try {
                        stg.addStudent(st12);
                    } catch (TooEnoughStudentsException e1) {
                        e1.printStackTrace();
                    }
                    System.out.println(stg);
                 //   JOptionPane.showMessageDialog(frame, stg.toString());
                }
                else
                    JOptionPane.showMessageDialog(frame, "Все поля должны быть заполнены!");

            }
        });

        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

    }

}
