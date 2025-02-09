package com;

public class JUCMain
{
    public static void main(String[] args)
    {
        Thread thread = new Thread(() -> System.out.println("Current " + Thread.currentThread().getName()));

        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());

        System.out.println("Program finished.");

    }
}
