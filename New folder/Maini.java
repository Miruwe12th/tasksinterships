import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

class Student {
    String name;
    int rollNumber;
    String dob; 
    int totalMarks;
    String grade;

    Student(String name, int rollNumber, String dob, int totalMarks, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.dob = dob;
        this.totalMarks = totalMarks;
        this.grade = grade;
    }


    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Date of Birth: " + dob + ", Total Marks: " + totalMarks + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    ArrayList<Student> students = new ArrayList<>();

    void addStudent(Student student) {
        students.add(student);
    }

    void removeStudent(int rollNumber) {
        students.removeIf(student -> student.rollNumber == rollNumber);
    }

    Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.rollNumber == rollNumber) {
                return student;
            }
        }
        return null;
    }

    void displayAllStudents(JTextArea textArea) {
        textArea.setText("");
        for (Student student : students) {
            textArea.append(student.toString() + "\n");
        }
    }
}

public class Maini {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();

        JFrame frame = new JFrame("Student Management System");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);

        JPanel inputPanel = new JPanel(new GridLayout(5, 2));
        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField nameField = new JTextField();
        nameField.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel rollLabel = new JLabel("Roll Number");
        rollLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField rollField = new JTextField();
        rollField.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel dobLabel = new JLabel("Date of Birth (dd/mm/yyyy)");
        dobLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField dobField = new JTextField();
        dobField.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel marksLabel = new JLabel("Total Marks(Out of 500)");
        marksLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField marksField = new JTextField();
        marksField.setFont(new Font("Arial", Font.PLAIN, 20));
        JLabel gradeLabel = new JLabel("Grade");
        gradeLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextField gradeField = new JTextField();
        gradeField.setFont(new Font("Arial", Font.PLAIN, 20));
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(rollLabel);
        inputPanel.add(rollField);
        inputPanel.add(dobLabel);
        inputPanel.add(dobField);
        inputPanel.add(marksLabel);
        inputPanel.add(marksField);
        inputPanel.add(gradeLabel);
        inputPanel.add(gradeField);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Add Student");
        addButton.setFont(new Font("Arial", Font.PLAIN, 20));
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                int rollNumber = Integer.parseInt(rollField.getText());
                String dob = dobField.getText();
                int totalMarks = Integer.parseInt(marksField.getText());
                String grade = gradeField.getText();
                sms.addStudent(new Student(name, rollNumber, dob, totalMarks, grade));
                
                nameField.setText("");
                rollField.setText("");
                dobField.setText("");
                marksField.setText("");
                gradeField.setText("");
            }
        });
        JButton removeButton = new JButton("Remove Student");
        removeButton.setFont(new Font("Arial", Font.PLAIN, 20));
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int rollNumber = Integer.parseInt(rollField.getText());
                sms.removeStudent(rollNumber);
            }
        });
        JButton searchButton = new JButton("Search Student");
        searchButton.setFont(new Font("Arial", Font.PLAIN, 20));
        JTextArea textArea = new JTextArea();
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(450, 300));
        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int rollNumber = Integer.parseInt(rollField.getText());
                Student student = sms.searchStudent(rollNumber);
                if (student != null) {
                    textArea.setText(student.toString());
                } else {
                    textArea.setText("Student not found");
                }
            }
        });
        JButton displayButton = new JButton("Display All Students");
        displayButton.setFont(new Font("Arial", Font.PLAIN, 20));
        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sms.displayAllStudents(textArea);
            }
        });
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        buttonPanel.add(searchButton);
        buttonPanel.add(displayButton);

        panel.add(inputPanel);
        panel.add(buttonPanel);
        panel.add(scrollPane);

        frame.setVisible(true);
    }
}
