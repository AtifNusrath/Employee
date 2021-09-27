package com.bridgelabz;

import java.util.ArrayList;

interface IEmployeeComputation
{
    void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs);
    void calculateTotalWage();
}
class CompanyWageEmp {

    final String company;
    static int WAGE_PER_HR;
    static int MAX_WORKING_DAYS;
    static int MAX_WORKING_HRS;
    public int wage;
    int totalEmpWage;


    public CompanyWageEmp(String company, int WAGE_PER_HR, int MAX_WORKING_DAYS, int MAX_WORKING_HRS) {
        this.company = company;
        this.WAGE_PER_HR = WAGE_PER_HR;
        this.MAX_WORKING_DAYS = MAX_WORKING_DAYS;
        this.MAX_WORKING_HRS = MAX_WORKING_HRS;

    }
    void setTotalEmployeeWage(int totalEmpWage)
    {
        this.totalEmpWage = totalEmpWage;
    }
    @Override
    public String toString() {
        return "Total Empwage for Company: " + company + " is: " + totalEmpWage;
    }
}


public class EmpArrayList implements IEmployeeWageComputation {
    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;

    ArrayList<CompanyWageEmp> companies;

    public EmpArrayList()
    {
        companies = new ArrayList<>();
    }
    @Override
    public void calculateTotalWage()
    {
        for (CompanyWageEmp company1 : companies)
        {
            int totalWage = calculateTotalWage(company1);
            company1.setTotalEmployeeWage(totalWage);
            System.out.println(company1);
        }
    }
    @Override
    public void addCompany(String company, int wagePerHr, int maxWorkingDays, int maxWorkingHrs) {
        CompanyWageEmp company1 = new CompanyWageEmp(company, wagePerHr, maxWorkingDays, maxWorkingHrs);
        companies.add(company1);

    }

    public int calculateTotalWage(CompanyWageEmp companyEmpWage) {
        int workingHrs = 0;
        int totalWage = 0;
        System.out.printf("%5s     %5s     %5s\n", "Day", "WorkingHrs", "Total working hrs");
        for (int day = 1, totalWorkingHrs = 0; day <= CompanyWageEmp.MAX_WORKING_DAYS && totalWorkingHrs < CompanyWageEmp.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs) {

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
            totalWage += workingHrs;
            System.out.printf("%5d       %5d         %5d\n", day, workingHrs, totalWorkingHrs + workingHrs);
        }
        return totalWage * CompanyWageEmp.WAGE_PER_HR;
    }

    public static void main(String args[])
    {
        EmpWageComputation employeeWageComputation = new EmpWageComputation(3);
        employeeWageComputation.addCompany("Microsoft", 4, 30, 100);
        employeeWageComputation.addCompany("Google", 5, 40, 170);
        employeeWageComputation.addCompany("Apple", 9, 10, 70);
        employeeWageComputation.calculateTotalWage();
    }
}
