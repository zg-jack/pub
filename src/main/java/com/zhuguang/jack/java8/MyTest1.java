package com.zhuguang.jack.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTest1 {
    
    public static void main(String[] args) {
        //        new Thread(new Runnable() {
        //            @Override
        //            public void run() {
        //                System.out.println("匿名类的run方法的写法！！");
        //            }
        //        }).start();
        //        
        //        //用lambda表达式进行改写
        //        new Thread(() -> {
        //            System.out.println("lambda的run方法的写法！！");
        //        }).start();
        
        List<String> names = Arrays.asList("Jack", "Roy", "Walker", "Lucy");
        
        //        names.sort(new Comparator<String>() {
        //            @Override
        //            public int compare(String o1, String o2) {
        //                // TODO Auto-generated method stub
        //                return o1.compareTo(o2);
        //            }
        //        });
        //        names.sort((o1, o2) -> {
        //            return o1.compareTo(o2);
        //        });
        names.sort((o1, o2) -> o1.compareTo(o2));
        names.forEach((name) -> {
            System.out.print(name + "**");
        });
        
        FuncitonalIntf2 intf2 = (num) -> {
            return String.valueOf(num);
        };
        //        System.out.println(intf2.convert(2018));
        
        FuncitonalIntf2 intf3 = String::valueOf;
        System.out.println(intf3.convert(2018));
        
        //引用类的构造方法  Person::new == new Person();
        PersonFactory pf = new PersonFactory(Person::new);
        
        List<Person> persons = new ArrayList<Person>() {
            {
                add(new Person("Jack"));
                add(new Person("Roy"));
                add(new Person("Walker"));
                add(new Person("Lucy"));
            }
        };
        
        //静态方法的引用
        //        persons.sort(MyTest1::compare);
        //        persons.sort(new Comparator<Person>() {
        //            @Override
        //            public int compare(Person o1, Person o2) {
        //                return o1.getName().compareTo(o2.getName());
        //            }
        //        });
        //对象实例的引用方法
        //        persons.sort(pf.getPerson()::compare);
        //引用类的接口实现方法
        persons.sort(Person::compareTo);
        persons.forEach((name) -> {
            System.out.print(name.getName() + "%%");
        });
        
        System.out.println(intf3.doSomething(""));
        
    }
    
    public static int compare(Person p1, Person p2) {
        return p2.getName().compareTo(p1.getName());
    }
    
}
