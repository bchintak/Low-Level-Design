package com.design_patterns.behavioural.cor;

public class Director extends LeaveApprover {

    @Override
    public void approveLeave(LeaveRequest request) {

        if(request.getNumberOfDays() <= 30){

            System.out.println("Approved by Director");

        }else{

            nextApprover.approveLeave(request);

        }

    }

}
