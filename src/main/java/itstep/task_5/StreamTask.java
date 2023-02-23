package itstep.task_5;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTask {

    public static void main(String[] args) {
        //Stream
        //Input - collection of employees(simple model with few fields: name, mail, salary…).
        //Using stream functionality sort the list,
        //filter it (ex: salary should be more than 1000$).
        //Collect it to the String List with names.

        //step 1 init User collection

        Integer n=10;
        if(args.length>0){
            try{
            n=Integer.parseInt(args[0]);}catch (Exception e){
                System.out.println("cant parse int from "+args[0]);
                e.printStackTrace();
            }
        }

        List<User> userList=generateUserList(n);
        System.out.println(userList);

        //step 2  sort
        System.out.println("sort");
        System.out.println(userList.stream().sorted().collect(Collectors.toList()));
        System.out.println(userList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList()));
        System.out.println(userList.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList()));
        System.out.println(userList.stream().sorted((o1, o2) -> o1.getAge().compareTo(o2.getAge()) * o1.getName().compareTo(o2.getName())).collect(Collectors.toList()));

        //step 3 filter
        System.out.println("filter");
        System.out.println(userList.stream().filter(u-> { return u.getAge() > 4;}).collect(Collectors.toList()));

        //step 4 mapping
        System.out.println("stringList");
        System.out.println(userList.stream().map(User::getName).collect(Collectors.toList()));
    }

    private static List<User> generateUserList(int n) {
        Random random=new Random();
        //List<User> userList=new ArrayList<>();
       return IntStream.range(1,n).mapToObj(i->{
            User user = new User();
            user.setName("userName"+ UUID.randomUUID().toString().substring(0,5));
            user.setAge(random.nextInt(100));
            return user;}
        ).collect(Collectors.toList());
       // return userList;
    }
}
