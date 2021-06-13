import javax.persistence.Column;
import java.io.Serializable;
import java.util.Objects;

public class SubscriptionKey implements Serializable {

        @Column(name = "student_id")
        private int student;

        @Column(name = "course_id")
        private int course;

      SubscriptionKey(){

      }

      SubscriptionKey(int studentId, int courseId){
          this.student = studentId;
          this.course = courseId;
      }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubscriptionKey that = (SubscriptionKey) o;
        return student == that.student && course == that.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(student, course);
    }

         public int getStudentId() {
            return student;
        }

        public void setStudentId(int student) {
            this.student = student;
        }

        public int getCourseId() {
            return course;
        }

        public void setCourseId(int course) {
            this.course = course;
        }

}
