package com.bridgelabz;

public class EmpWageClassMethod {
    static final int PART_TIME = 1;
    static final int FULL_TIME = 2;
    static final int WAGE_PER_HR = 20;
    static final int MAX_WORKING_DAYS = 20;
    static final int MAX_WORKING_HRS = 100;

    static int totalWage = 0;
    static int workingHrs = 0;
    public static void computeEmpWage()
    {

        System.out.printf("%5s     %5s     %5s     %5s\n", "Day", "WorkingHrs", "Wage", "Total working hrs");
        for (int day = 1, totalWorkingHrs = 0; day <= MAX_WORKING_DAYS && totalWorkingHrs < MAX_WORKING_HRS; day++, totalWorkingHrs += workingHrs)
        {

            int empType = (int) (Math.random() * 100) % 3;
            switch (empType)
            {
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
            int wage = workingHrs * WAGE_PER_HR;
            totalWage += wage;
            System.out.printf("%5d       %5d      %5d      %5d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);

        }
        System.out.println("Total wage for a month is " + totalWage);
    }
    public static void main(String[] args)
    {
        computeEmpWage();
    }
}
