package com.example.demo.logistics;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Amazon {

//    public static void main(String[] args) {
//        /*
//        Example of a tightly coupled code
//
//       1. someone won't be able to change the logistics company easily,
//        need to create an object(code)
//
//        EcommExpress ecommExpress = new EcommExpress();
//        ecommExpress.deliverOrder();
//        ecommExpress.trackOrder();
//
//        Springs facilitated this decoupling
//         */
//        Delhivery delhivery = new Delhivery();
//        delhivery.deliverOrder();
//        delhivery.trackOrder();
//
//        // another approach, utilising core java but not completely loosely coupled
//
//        LogisticsCompany logistics = new Delhivery();
//        logistics.deliverOrder();
//    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("application configured");
        // configured by the beans.xml
        LogisticsCompany logisticsCompany = (LogisticsCompany) context.getBean("logistics");
        logisticsCompany.deliverOrder();
        logisticsCompany.trackOrder();
    }

}
