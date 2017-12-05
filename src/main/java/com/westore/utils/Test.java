package com.westore.utils;

import com.westore.model.T_B_Goods;
import com.westore.model.T_B_Goods_Type;
import com.westore.service.CommomService;

import javax.annotation.Resource;
import java.util.*;


    // 抽象类Animal，包含了一个抽象方法cry
    abstract class Animal
    {
        public abstract void cry();

        public void eat(){
            System.out.println("Animal eat");
        }

        public abstract void run();
    }

    // 子类Dog继承的抽象类Animal，必须实现其抽象方法cry
    class Dog extends Animal
    {
        public void cry()
        {
            System.out.println("Dog cry");
        }

        @Override
        public void run() {
            System.out.println("Dog run");
        }
    }
    // 同样，子类Cat继承的抽象类Animal，必须实现其抽象方法cry
    class Cat extends Animal
    {
        public void cry()
        {
            System.out.println("Cat cry");
        }

        @Override
        public void run() {
            System.out.println("Cat run");
        }
    }

    public class Test
    {
        public static void main(String[] args) {
            Animal a1 = new Dog();  // 抽象类引用指向子类实例
            Animal a2 = new Cat();

            a1.cry();
            a2.cry();
        }
    }

