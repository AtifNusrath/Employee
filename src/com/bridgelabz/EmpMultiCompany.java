package com.bridgelabz;

public class EmpMultiCompany {
    static final int PART_TIME = 1;
    static final int FULL_TIME = 2;

    public static void computeEmpWage(String company, int WAGE_PER_HR, int MAX_WORKING_DAYS, int MAX_WORKING_HRS) {
        int workingHrs = 0, totalWage = 0;
        int wage;
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
        wage = workingHrs * WAGE_PER_HR;
        System.out.println("Total Empwage for Company: " + company + " is: " + totalWage);
    }

    public static void main(String[] args) {
        computeEmpWage("Google", 20, 2, 10);
        computeEmpWage("Metro", 10, 4, 20);
    }
}

