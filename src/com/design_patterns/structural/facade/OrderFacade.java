package com.design_patterns.structural.facade;

public class OrderFacade {

    private final InventoryService inventoryService;
    private final PaymentService paymentService;
    private final InvoiceService invoiceService;
    private final DeliveryService deliveryService;
    private final NotificationService notificationService;

    public OrderFacade() {

        inventoryService = new InventoryService();
        paymentService = new PaymentService();
        invoiceService = new InvoiceService();
        deliveryService = new DeliveryService();
        notificationService = new NotificationService();
    }

    public void placeOrder() {

        inventoryService.checkStock();

        paymentService.makePayment();

        invoiceService.generateInvoice();

        deliveryService.scheduleDelivery();

        notificationService.sendNotification();
    }
}