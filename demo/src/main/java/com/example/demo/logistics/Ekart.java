package com.example.demo.logistics;

public class Ekart implements LogisticsCompany{
    @Override
    public void deliverOrder() {

        System.out.println("Order Delivered by :: Ekart");

    }

    @Override
    public void orderReturnRequest() {

        System.out.println("Order return request has been accepted by :: Ekart");

    }

    @Override
    public void trackOrder() {

        System.out.println("Order tracked by :: Ekart");

    }
}
