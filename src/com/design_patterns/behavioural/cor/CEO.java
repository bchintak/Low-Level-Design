package com.design_patterns.behavioural.cor;

public class CEO extends LeaveApprover {

    @Override
    public void approveLeave(LeaveRequest request) {

        System.out.println("Approved by CEO");

    }

}
