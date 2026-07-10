package com.design_patterns.behavioural.cor;

public class TeamLead extends LeaveApprover {

    @Override
    public void approveLeave(LeaveRequest request) {

        if(request.getNumberOfDays() <= 2){

            System.out.println("Approved by Team Lead");

        }else{

            nextApprover.approveLeave(request);

        }
    }

}
