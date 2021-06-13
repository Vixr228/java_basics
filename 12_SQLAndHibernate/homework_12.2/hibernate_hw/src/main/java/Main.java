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
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> purchaseListQuery = builder.createQuery(PurchaseList.class);

        Root<PurchaseList> root = purchaseListQuery.from(PurchaseList.class);

        purchaseListQuery.select(root);
        List<PurchaseList> purchaseList = session.createQuery(purchaseListQuery).getResultList();

        for(PurchaseList purchase : purchaseList){
            Student student = (Student) session.createQuery("FROM " + Student.class.getSimpleName() + " WHERE name='" + purchase.getStudentName() + "'").getSingleResult();
            Course course = (Course) session.createQuery("FROM " + Course.class.getSimpleName() + " WHERE name ='" + purchase.getCourseName() + "'").getSingleResult();
            session.save(new LinkedPurchaseList(new LinkedPurchaseKey(student.getId(), course.getId()), student.getId(), course.getId()));
        }

        session.getTransaction().commit();
        sessionFactory.close();

    }
}
