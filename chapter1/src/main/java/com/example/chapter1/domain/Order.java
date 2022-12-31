package com.example.chapter1.domain;

public class Order{

    private List<OrderLines> orderLines;
    private int totalAmounts;
    private ShippingInfo shippingInfo;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo){
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if(shippingInfo == null){
            throw new IllegalArgumentException("no shippingInfo");
        }
        this.shippingInfo = shippingInfo;
    }

    public void setOrderLines(List<OrderLine> orderLines){
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines){
        if(orderLines == null || orderLines.isEmpty()){
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    private void calculateTotalAmounts(){
        this.totalAmounts = new Money(orderLines.stream().mapToint(x -> x.getAmounts().getValue()).sum());
    }
}