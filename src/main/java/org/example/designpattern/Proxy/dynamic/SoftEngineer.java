package org.example.designpattern.Proxy.dynamic;

// 程序员类
public class SoftEngineer implements Person{
    private String name;
    @Override
    public void goWorking(String name, String dst) {
        System.out.println( name + "去" + dst + "工作");
    }

    @Override
    public String GetName() {
        return name;
    }

    @Override
    public void SetName(String name) {
        this.name = name;
    }
}
