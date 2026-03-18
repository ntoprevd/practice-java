package com.itheima.extendsdemo3;

public class Test {
    public static void main(String[] args) {
        Manager m = new Manager("001", "zhangsan", 15000, 8000);
        System.out.println(m.getId() + "," + m.getName() + "," + m.getSalary() + "," + m.getBonus());
        m.eat();
        m.work();

        Cook c = new Cook();
        c.setId("002");
        c.setName("lisi");
        c.setSalary(12000);
        System.out.println(c.getId() + "," + c.getName() + "," + c.getSalary());
        c.work();
        c.eat();
    }
}
