package com.moses.configClient.preKnowledge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Spring自定义事件/监听器
 */
public class SpringEventListenerDemo {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册监听器
        context.addApplicationListener(new ApplicationListener<MyApplicationEvent>() {

            //监听器得到事件
            @Override
            public void onApplicationEvent(MyApplicationEvent applicationEvent) {
                System.out.println("接收到事件" + applicationEvent.getSource() + ", " + applicationEvent.getContext());
            }
        });

        context.refresh();
        //发布事件
        context.publishEvent(new MyApplicationEvent(context, "Hello world."));
        context.publishEvent(new MyApplicationEvent(context,1));
        context.publishEvent(new MyApplicationEvent(context, new Integer(100)));
    }


    private static class MyApplicationEvent extends ApplicationEvent{
        private final ApplicationContext context;
        public MyApplicationEvent(ApplicationContext context, Object source) {
            super(source);
            this.context = context;
        }

        public ApplicationContext getContext() {
            return context;
        }
    }
}
