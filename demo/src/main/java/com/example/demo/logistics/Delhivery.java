package com.example.demo.logistics;

public class Delhivery implements LogisticsCompany{

    Delhivery(){
        System.out.println("Constructor Call");
    }

    @Override
    public void deliverOrder() {

        System.out.println("Order Delivered by :: Delhivery");

    }

    @Override
    public void orderReturnRequest() {

        System.out.println("Order return request has been accepted by :: Delhivery");

    }

    @Override
    public void trackOrder() {

        System.out.println("Order tracked by :: Delhivery");

    }
}
