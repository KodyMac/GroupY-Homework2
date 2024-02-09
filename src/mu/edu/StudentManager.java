package mu.edu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class StudentManager {
	private Student[] students;
	public StudentManager() {
		students = new Student[calculateArraySize("studentData.txt")];
	}
	
	
	public boolean readFromFile(String fileName) throws FileNotFoundException {  //not sure how this goes
		File file = new File(fileName);
		Scanner scanner = new Scanner(file);
		
		int index = 0;
		while(scanner.hasNext()) {  //i think this is how the scanner works
			int id = scanner.nextInt();
			String name = scanner.next();
			double grade = scanner.nextDouble();
			students[index++] = new Student(id, name, grade);
		}
		
		scanner.close();
		return true;

	}
	
	public void displayStudent() {
		if(students.length==0) {
			System.out.println("No students found.");
			return;
		}
		
		for(Student student : students) {
			if(student!=null) {
				System.out.println(student.toString());
			}
		}
	}
	
	public boolean searchStudentById(int id) {
		for(Student student : students) {
			if(student!=null && student.getId()==id) {
				System.out.println("Student found: " + student.toString());
				return true;
			}
		}
		System.out.println("Student not found with ID: " + id);
		return false;
	}
	
	public boolean updateStudentGradeById(int id, double grade) {
		for(Student student : students) {
			if(student != null && student.getId()==id) {
				student.setGrade(grade);
				System.out.println("Student grade updated");
				return true;
			}
		}
		return false;
			}
	
	
	public int calculateArraySize(String fileName) {
        int lines = 0;

        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                lines++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return lines;
    }
}
