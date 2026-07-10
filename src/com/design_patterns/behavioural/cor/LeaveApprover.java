package com.design_patterns.behavioural.cor;

public abstract class LeaveApprover {

    protected LeaveApprover nextApprover;

    public void setNextApprover(LeaveApprover nextApprover) {
        this.nextApprover = nextApprover;
    }

    public abstract void approveLeave(LeaveRequest request);

}
