import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        JDBCConnector.session.beginTransaction();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<PurchaseList> purchaseListQuery = builder.createQuery(PurchaseList.class);
//
//        Root<PurchaseList> root = purchaseListQuery.from(PurchaseList.class);
//
//        purchaseListQuery.select(root);
//        List<PurchaseList> purchaseList = session.createQuery(purchaseListQuery).getResultList();
//
//        for(PurchaseList purchase : purchaseList){
//            Student student = (Student) session.createQuery("FROM " + Student.class.getSimpleName() + " WHERE name='" + purchase.getStudentName() + "'").getSingleResult();
//            Course course = (Course) session.createQuery("FROM " + Course.class.getSimpleName() + " WHERE name ='" + purchase.getCourseName() + "'").getSingleResult();
//            session.save(new LinkedPurchaseList(new LinkedPurchaseKey(student.getId(), course.getId()), student.getId(), course.getId()));
//        }


        Student student = JDBCConnector.session.get(Student.class, 54);
        Course course = JDBCConnector.session.get(Course.class, 2);
        PurchaseList purchaseList = JDBCConnector.session.get(PurchaseList.class, new PurchaseKey(student.getName(),course.getName()));
        System.out.println(purchaseList);

        List<PurchaseList> listSt = student.getPurchaseList();
        for(PurchaseList purchase : listSt){
            System.out.println(purchase);
        }

        List<PurchaseList> listCs = course.getPurchaseList();
        for(PurchaseList purchase : listCs){
            System.out.println(purchase);
        }


        JDBCConnector.session.getTransaction().commit();
        JDBCConnector.sessionFactory.close();

    }
}
