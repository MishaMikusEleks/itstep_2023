package itstep.task_6;

import itstep.task_6.entity.User;
import org.hibernate.Session;

import static itstep.task_6.HibernateUtil.getSessionFactory;

public class HibernateMain {

    //General:
    //Install MySQL server
    //Make at least two tables (Entities from previous task or any additional if need)
    //Make models for those Entities (from Task_5)
    //Setup Hibernate for those Entities and local DB
    //Check basic CRUD (create, read, update, delete the BD records using Hibernate)
    //Generate few rows into all tabled

    public static void main(String[] args) {
        User user = new User("Misha",33);

        Session session = getSessionFactory().getCurrentSession();

        session.beginTransaction();
        //CRUD (create, read, update, delete

        //create
        Long id = (Long) session.save(user);
        System.out.println("id "+id);

        //read
        User userRead=session.get(User.class,id);
        System.out.println("userRead "+userRead);

        //update
        User userUpdate=userRead;
        userUpdate.setName("Ivan");
        session.saveOrUpdate(userUpdate);
        System.out.println("userUpdate " + session.get(User.class,id));

        //delete
        session.delete(user);

        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }

}
