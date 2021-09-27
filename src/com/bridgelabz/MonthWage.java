package com.bridgelabz;

public class MonthWage {
    public static void main(String[] args)
    {
        final int PART_TIME = 0;
        final int FULL_TIME = 1;
        final int WAGE_PER_HR = 20;
        final int Num_of_Working_Days = 20;
        int totalEmpWage = 0;

        int empType = (int) (Math.random() * 100) % 2;
        int workingHours =0;
        for ( int day = 1; day <= Num_of_Working_Days; day++){
            switch (empType)
            {
                case FULL_TIME:
                    System.out.println("Employee is Present Full time");
                    workingHours = 8;
                    break;
                case PART_TIME:
                    System.out.println("Employee is Present Part time");
                    workingHours = 4;
                    break;
                default:
                    System.out.println("Employee is Absent");
            }
            int wage = workingHours * WAGE_PER_HR;
            totalEmpWage +=wage;
            System.out.println("Employee Wage for " + day +" is " + wage);
        }
        System.out.println("Total Emp Wage: " + totalEmpWage);
    }
}
