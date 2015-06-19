package com.company;


public class Main {

    public static void main(String[] args) {
        int threads = 60;
        for (int i=0; i<threads; i++) {
           Thread thread =  new Thread(new LoginThread());
            thread.setName(Integer.toString(i));
            thread.start();
        }
    }
}
