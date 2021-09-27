package com.bridgelabz;

public class EmpWageCompany {

    static final int PART_TIME = 1;
    static final int FULL_TIME = 2;
    private static int WAGE_PER_HR;
    private static String company;
    private static int MAX_WORKING_DAYS;
    private static int MAX_WORKING_HRS;
    int wage;


    public EmpWageCompany(String company, int WAGE_PER_HR, int MAX_WORKING_DAYS, int MAX_WORKING_HRS) {
        this.company = company;
        this.WAGE_PER_HR = WAGE_PER_HR;
        this.MAX_WORKING_DAYS = MAX_WORKING_DAYS;
        this.MAX_WORKING_HRS = MAX_WORKING_HRS;

    }

    public void computeEmpWage() {
        int workingHrs = 0;
        int totalWage = 0;
        System.out.printf("%5s     %5s     %5s\n", "Day", "WorkingHrs", "Total working hrs");
        for (int day = 1, totalWorkingHrs = 0; day <= MAX_WORKING_DAYS && totalWorkingHrs < MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs) {

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
        wage = totalWage * WAGE_PER_HR;
    }

   @Override
    public String toString() {
        return "Total Empwage for Company: " + company + " is: " + wage;
    }

    public static void main(String[] args) {
        EmpWageCompany google = new EmpWageCompany("Google", 20, 2, 10);
        google.computeEmpWage();
        System.out.println(google);
        EmpWageCompany metro = new EmpWageCompany("Metro", 10, 4, 20);
        metro.computeEmpWage();
        System.out.println(metro);
    }
}
