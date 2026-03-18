package com.itheima.extendsdemo3;

public class Cook extends Employee{
    public Cook() {
    }

    public Cook(String id, String name, double salary) {
        super(id, name, salary);
    }

    // 工作
    @Override
    public void work() {
        System.out.println("厨师在炒菜");
    }
}
