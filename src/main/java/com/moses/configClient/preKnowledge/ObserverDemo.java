package com.moses.configClient.preKnowledge;

import java.util.*;

public class ObserverDemo {

    public static void main(String[] args) {
        MyObservable observable = new MyObservable();

        //增加订阅者
        observable.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object value) {
                System.out.println(value);
            }
        });
        observable.setChanged();
        //发布者通知，订阅者是被动感知（推模式）
        observable.notifyObservers("Hello, world");
    }

    private static void echoIterable(){
        List<Integer> values = Arrays.asList(1,2 ,3, 4, 5);
        Iterator<Integer> integerIterator = values.iterator();
        while(integerIterator.hasNext()){       //通过循环主动获取
            System.out.println(integerIterator.next());
        }
    }

    public static class MyObservable extends Observable{
        public synchronized void setChanged(){
            super.setChanged();
        }
    }
}
