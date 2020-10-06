package training;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

class User{
   private String firstname;
   private String lastname;
   private String email;
   private String status;
   private Integer age;
   private LocalDate timestamp;
   private Integer id;

  void User(String id1, String firstname, String  lastname,String age1, String email, String status, String timestamp2)
    {
        Integer id = Integer.parseInt(id1);

        this.id= id;
        LocalDate timestamp = LocalDate.parse(timestamp2);
        this.timestamp= timestamp;
        this.status =status;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        Integer age = Integer.parseInt(age1);
        this.age = age;

    }
    //-----------------------Setters-------------------------------------------
   public void setFirstname(String firstname)
    {
        this.firstname = firstname;
    }
   public void setId(String id1){
       Integer id = Integer.parseInt(id1);

       this.id = id;
   }
   public void setLastname(String lastname)
    {
        this.lastname = lastname;
    }
   public void setEmail(String email)
    {
        this.email = email;
    }
   public void setStatus(String status)
    {
        this.status = status;
    }
   public void setAge(String age2)
    {
        Integer age = Integer.parseInt(age2);
        this.age = age;
    }
    public void setTimestamp(String timestamp1)
    {
       LocalDate timestamp = LocalDate.parse(timestamp1);
        this.timestamp = timestamp;
    }
//-----------------------------------------------Getters---------------------
    public String getEmail() {
        return email;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public String getTimestamp() {
      String date = timestamp.toString();
        return date;
    }
    //---------------------------------------------Set status Active for new members registred earlier than yesterday Method----------------
    public void setStatusActive(ArrayList<User> list)
    {
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minus(Period.ofDays(1));

            for (User s: list)
            {
                LocalDate d1 = LocalDate.parse(s.getTimestamp());
                if (s.getStatus()=="NEW" && d1.compareTo(yesterday)<0 )
                {

                             s.setStatus("ACTIVE");


                }
                System.out.println("User no. "+s.getId()+", named "+s.getFirstname()+" "+s.getLastname()+", is "+s.getAge() +" years old. The email is "+s.getEmail()+".The status is "+ s.getStatus()+ " and is registred on "+ s.getTimestamp());

            }

    }
    //---------------------------------------Bonus Task>> Changing status to Blocked for inactive users registred more than 1 month ago------------------------------
    public void setStatusBlocked(ArrayList<User> list)
    {
        LocalDate today = LocalDate.now();
        LocalDate monthAgo = today.minus(Period.ofDays(31));

        for (User s: list)
        {
            LocalDate d1 = LocalDate.parse(s.getTimestamp());
            if (s.getStatus()=="INACTIVE" && d1.compareTo(monthAgo)<0 )
            {

                s.setStatus("BLOCKED");


            }
            System.out.println("User no. "+s.getId()+", named "+s.getFirstname()+" "+s.getLastname()+", is "+s.getAge() +" years old. The email is "+s.getEmail()+".The status is "+ s.getStatus()+ " and is registred on "+ s.getTimestamp());

        }
    }
}

public class Application {

    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList();
        //------------------------Creating users--------------------------------
        User user1 = new User();
        user1.User("1","Iulik","Fintina", "26", "fintna@asd.com","NEW","2020-03-15");
        list.add(user1);

        User user2 =new User();
        user2.User("2","Lucia","Turuta","18","asfr@bk.ru","ACTIVE","2020-10-01");
        list.add(user2);

        User user3 =new User();
        user3.User("3","Aton","Fantan","36","asddf@gmail.ru","BLOCKED","2020-10-01");
        list.add(user3);

        User user4 =new User();
        user4.User("4","Grivei","Merita","42","iukdf@asd.com","NEW","2020-10-01");
        list.add(user4);

        User user5 =new User();
        user5.User("5","Marina","Prodan","35","asem@ase.md","NEW","2020-10-01");
        list.add(user5);

        User user6 =new User();
        user6.User("6","NIna","Tacic","22","asdaffdg@reg.es","INACTIVE","2020-10-01");
        list.add(user6);

        User user7 =new User();
        user7.User("7","Vasea","Jdanov","21","jdanov@ase.md","INACTIVE","2020-04-01");
        list.add(user7);

        User user8 =new User();
        user8.User("8","Vasea","Scutaru","28","scutaru@ase.md","NEW","2020-10-05");
        list.add(user8);

        User user9 = new User();
        user9.User("9","Iuliana","Fintina","17","iuliana@ase.md","INACTIVE","2020-08-05");
        list.add(user9);
        System.out.println("List after changing status to Active from New:");

        user9.setStatusActive(list);
        System.out.println();

        System.out.println("List after changing status to Blocked from Inactive:");
        user9.setStatusBlocked(list);








    }
}
