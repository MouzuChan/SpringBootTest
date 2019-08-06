package com.imooc.multithreading;

public class Singleton {
	 // 为了记录这个 Singleton 类被实例化的次数
    // 声明一个 static 类型的计数器
    private static int count;
    // 把"唯一的"对象保存在单例类的属性里
    private static Singleton instance = null;

    // 构造器私有化,不能在类的外部随意创建对象
    private Singleton() {
        System.out.println("Singleton 私有的构造方法被实例化 " + (++count) + " 次。");
    }

    // 提供一个全局的访问点来获得这个"唯一"的对象
    // 请注意,这样的代码再多线程环境下是有问题的
    // 很可能 instance = new Singleton(); 会被执行多次
    // 我们可以模拟多线程环境来检验我们的猜想
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
