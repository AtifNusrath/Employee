package com.bridgelabz;

public class CompanyEmpWage {

    final String company;
    static int WAGE_PER_HR;
    static int MAX_WORKING_DAYS;
    static int MAX_WORKING_HRS;
    public int wage;
    int totalEmpWage;


    public CompanyEmpWage(String company, int WAGE_PER_HR, int MAX_WORKING_DAYS, int MAX_WORKING_HRS) {
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

class EmpWageArray{
    int noOfCompanies, index;
    public static final int PART_TIME = 1;
    public static final int FULL_TIME = 2;
    CompanyEmpWage[] companies;
    void addCompany(String company, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
    {
        companies[index++] = new CompanyEmpWage(company, wagePerHr, maxWorkingDays, maxWorkingHrs);
    }

    public EmpWageArray(int noOfCompanies) {
        this.noOfCompanies = noOfCompanies;
        companies = new CompanyEmpWage[noOfCompanies];
        index = 0;
    }
    void calculateTotalWage()
    {
        for (CompanyEmpWage company : companies)
        {
            int totalWage = calculateTotalWage(company);
            company.setTotalEmployeeWage(totalWage);
            System.out.println(company);
        }
    }
    int calculateTotalWage(CompanyEmpWage company)
    {

        int workingHrs = 0;
        int totalWage = 0;
        System.out.printf("%5s     %5s     %5s\n", "Day", "WorkingHrs", "Total working hrs");
        for (int day = 1, totalWorkingHrs = 0; day <= CompanyEmpWage.MAX_WORKING_DAYS && totalWorkingHrs < CompanyEmpWage.MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs) {

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
        return totalWage * CompanyEmpWage.WAGE_PER_HR;
    }
    public static void main(String args[])
    {
        EmpWageArray employeeWageComputation = new EmpWageArray(3);
        employeeWageComputation.addCompany("Microsoft", 4, 30, 100);
        employeeWageComputation.addCompany("Google", 5, 40, 170);
        employeeWageComputation.addCompany("Apple", 9, 10, 70);
        employeeWageComputation.calculateTotalWage();
    }
}
