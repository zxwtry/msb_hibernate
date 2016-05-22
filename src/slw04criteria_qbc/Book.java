package slw04criteria_qbc;

public class Book {
	private int bookId;
	private String bookName;
	private Student student;
	public Student getStudent() {
		return student;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
}
