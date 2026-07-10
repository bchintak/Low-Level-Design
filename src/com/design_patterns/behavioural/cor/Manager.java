package com.design_patterns.behavioural.cor;

public class Manager extends LeaveApprover {

    @Override
    public void approveLeave(LeaveRequest request) {

        if(request.getNumberOfDays() <= 10){

            System.out.println("Approved by Manager");

        }else{

            nextApprover.approveLeave(request);

        }

    }

}
