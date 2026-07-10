package com.design_patterns.behavioural.cor;

public class Main {

    public static void main(String[] args) {

        LeaveApprover teamLead = new TeamLead();
        LeaveApprover manager = new Manager();
        LeaveApprover director = new Director();
        LeaveApprover ceo = new CEO();

        teamLead.setNextApprover(manager);
        manager.setNextApprover(director);
        director.setNextApprover(ceo);

        LeaveRequest request = new LeaveRequest(15);

        teamLead.approveLeave(request);

    }

}
