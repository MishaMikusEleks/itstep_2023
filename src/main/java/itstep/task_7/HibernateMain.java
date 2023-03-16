package itstep.task_7;

import itstep.task_6.entity.Device;
import itstep.task_6.entity.Phone;
import itstep.task_6.entity.SocialMedia;
import itstep.task_6.entity.User;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.HashSet;

import static itstep.task_6.HibernateUtil.getSessionFactory;

public class HibernateMain {

//    Implement OneToOne, OneToMany, ManyToMany relations in your models from previous task. (add some additional tables if need)
//    Test it by CRUD.


    public static void main(String[] args) {
        User user = new User("Misha",33);

        Session session = getSessionFactory().getCurrentSession();
        session.beginTransaction();

        //OneToOne
        user.setPhone(new Phone("+380999999"));
        Long id = (Long) session.save(user);
        System.out.println("OneToOne "+session.get(User.class,id));

        //OneToMany
        user.setDevices(new HashSet<>(Arrays.asList(new Device("iPhone"),new Device("MAC"))));
        session.saveOrUpdate(user);
        user.getDevices().forEach(session::save);
        System.out.println("OneToMany "+session.get(User.class,id));

        //ManyToMany
        User user2=new User("Vasyl",22);
        SocialMedia facebook=new SocialMedia("facebook");
        SocialMedia fiktok=new SocialMedia("fiktok");
        Long id2 = (Long) session.save(user2);

        session.save(facebook);
        session.save(fiktok);

        user.setSocialMedia(Arrays.asList(facebook));
        user2.setSocialMedia(Arrays.asList(facebook,fiktok));

        session.saveOrUpdate(user);
        session.save(user2);

        System.out.println("ManyToMany "+session.get(User.class,id));
        System.out.println("ManyToMany "+session.get(User.class,id2));

        session.getTransaction().commit();
        session.close();
        System.exit(0);
    }

}
