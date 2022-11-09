package com.example.demo.logistics;

public class EcommExpress implements LogisticsCompany{
    @Override
    public void deliverOrder() {

        System.out.println("Order Delivered by :: EcommExpress");

    }

    @Override
    public void orderReturnRequest() {

        System.out.println("Order return request has been accepted by :: EcommExpress");

    }

    @Override
    public void trackOrder() {

        System.out.println("Order tracked by :: EcommExpress");

    }
}
