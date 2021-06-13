import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class PurchaseKey implements Serializable {

    // @JoinColumn(name = "student_id", insertable = false, updatable = false)
    @Column(name = "student_name")
    private String studentName;

    @Column(name = "course_name")
    private String courseName;


    PurchaseKey(){

    }

    PurchaseKey(String name, String course){
        this.studentName = name;
        this.courseName = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseKey that = (PurchaseKey) o;
        return Objects.equals(studentName, that.studentName) && Objects.equals(courseName, that.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentName, courseName);
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
