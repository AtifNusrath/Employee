package com.bridgelabz;

import java.util.ArrayList;
import java.util.HashMap;

interface IEmployeeComputationWage
{
    void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs);
    void calculateTotalWage();
}

class EmpWage {
    final String companyName;
    static int WAGE_PER_HR;
    static int MAX_WORKING_DAYS;
    static int MAX_WORKING_HRS;
    int totalEmpWage;


    public EmpWage(String companyName, int WAGE_PER_HR, int MAX_WORKING_DAYS, int MAX_WORKING_HRS) {

        this.WAGE_PER_HR = WAGE_PER_HR;
        this.MAX_WORKING_DAYS = MAX_WORKING_DAYS;
        this.MAX_WORKING_HRS = MAX_WORKING_HRS;
        totalEmpWage = 0;

        this.companyName = companyName;
    }
    void setTotalEmployeeWage(int totalEmpWage)
    {
        this.totalEmpWage = totalEmpWage;
    }
    @Override
    public String toString() {
        System.out.println("Details of " + companyName + " employee");

        System.err.println("Wage per hour:" + WAGE_PER_HR);
        System.out.println("Maximum working days:" + MAX_WORKING_DAYS);
        System.out.println("Maximum working hours:" + MAX_WORKING_HRS);
        return "Total wage for a month of " + companyName + " employee is " + totalEmpWage + "\n";
    }
}


class EmpCom implements IEmployeeComputationWage {
    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;

    ArrayList<EmpWage> companies;
    HashMap<String, Integer> totalEmpWages;

    public EmpCom()
    {
        companies = new ArrayList<>();
        totalEmpWages = new HashMap<>();
    }
    @Override
    public void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
        EmpWage company = new EmpWage(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
        companies.add(company);
        totalEmpWages.put(companyName,0);

    }
    @Override
    public void calculateTotalWage()
    {
        for (EmpWage company : companies)
        {
            int totalWage = calculateTotalWage(company);
            company.setTotalEmployeeWage(totalWage);
            System.out.println(company);
        }
    }


    public int calculateTotalWage(EmpWage empWage) {
        int workingHrs;
        int totalWage = 0;
        System.out.println("Computation of total wage of " + empWage.companyName + " employee");
        System.out.printf("%5s     %5s    %5s     %5s\n", "Day", "WorkingHrs","Wage",  "Total working hrs");
        for (int day = 1, totalWorkingHrs = 0; day <= EmpWage.MAX_WORKING_DAYS && totalWorkingHrs < EmpWage.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs) {

            int empType = (int) (Math.random() * 100) % 3;
            switch (empType) {
                case FULL_TIME:
                    workingHrs = 8;
                    break;
                case PART_TIME:
                    workingHrs = 4;
                    break;
                default:
                    workingHrs = 0;
                    break;
            }
            int wage = workingHrs * EmpWage.WAGE_PER_HR;

            totalWage += wage;
            System.out.printf("%5d       %5d      %5d      %5d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);
        }
        totalEmpWages.put(empWage.companyName, totalWage);
        return totalWage;
    }

    void printTotalEmpWage()
    {
        System.out.println("The Companies and their total Employee Wages are:");
        for (String companyName : totalEmpWages.keySet())
        {
            System.out.println(companyName + ": " + totalEmpWages.get(companyName));
        }

    }

    public static void main(String args[])
    {
        EmpCom empWag = new EmpCom();
        empWag.addCompany("Microsoft", 4, 30, 100);
        empWag.addCompany("Google", 5, 40, 170);
        empWag.addCompany("Apple", 9, 10, 70);
        empWag.calculateTotalWage();
        empWag.printTotalEmpWage();
    }
}

