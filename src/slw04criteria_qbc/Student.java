package slw04criteria_qbc;

import java.util.Set;

public class Student {
	private int studentId;
	private String studentName;
	private  Set<Book> booksSet = null;
	public Student() {}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public Set<Book> getBooksSet() {
		return booksSet;
	}
	public void setBooksSet(Set<Book> booksSet) {
		this.booksSet = booksSet;
	}
}
