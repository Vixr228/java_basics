import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        Course course = session.get(Course.class, 1);
        System.out.println("Name: " + course.getName());
        System.out.println("Student amount: " + course.getStudents().size());
        System.out.println("Teacher: " + course.getTeacher().getName());
        List<Student> studentList = course.getStudents();
        studentList.forEach(student -> System.out.println(student.getName()));
        System.out.println("----");
        course.getSubscriptions().forEach(System.out::println);


        Student student = session.get(Student.class, 1);
        System.out.println("Name: " + student.getName());
        System.out.println("Age: " + student.getAge());
        System.out.println("Registration date: " + student.getRegistrationDate());
        student.getSubscriptions().forEach(System.out::println);

        sessionFactory.close();

    }
}
