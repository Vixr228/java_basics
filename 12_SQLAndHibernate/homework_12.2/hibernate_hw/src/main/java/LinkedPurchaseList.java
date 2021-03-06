import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "LinkedPurchaseList")
//@IdClass(LinkedPurchaseKey.class)
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseKey id;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;
    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    LinkedPurchaseList(){
    }

    LinkedPurchaseList(LinkedPurchaseKey id, int studentId, int courseId){
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
    }



    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

}
