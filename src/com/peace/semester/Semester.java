package com.peace.semester;


    // A program to calculate the CGPA of any length of year spent in school and any amount of courses entered per semester
import java.util.InputMismatchException; //it came automatically because of the first try and catch
import java.util.Scanner;
        public class Semester {
        public static void main(String[] args) {

            int totalUnitLoad = 0; //initializing totalUnitLoad
            int overallUnitLoad = 0; //initializing overallUnitLoad
            double overallTotal = 0; //initializing overallTotal
            double total = 0;
            double gpa, cgpa;
            Scanner in = new Scanner(System.in);

            System.out.println("A CGPA Calculator.");
            System.out.println("Start entering your unit loads and your grades. Type in the unit load and the grade on the same line separated by");
            System.out.println("A SPACE.");
            System.out.println();
            System.out.println("Start.");
            System.out.println("enter number of years: ");
            int numberOfYears = in.nextInt();

            try {
                int year, semester; //declaring our year and semester to integers, instead of inputting int in each loop

                for (year = 1; year <= numberOfYears; year++) {
                    System.out.println("year " + year + ".");              //request for number of years
                    for (semester = 1; semester <= 2; semester++) {
                        System.out.println("Semester " + semester + ":");   //already set semesters to be two
                        System.out.println("enter number of courses: ");
                        int numberOfCourses = in.nextInt();                 //requests for number of courses per semester
                        in.nextLine(); //to insert enter after the nextInt before the next input to prevent error

                        //  for (courses = 1; courses <= numberOfCourses; courses++) {
                        //    System.out.println(courses + ".");

                        int courseCount = 0;        // Initialize courseCount to zero for the beginning of every year.
                        //System.out.println("Semester " + (semester) + ":");
                        while (courseCount < numberOfCourses) {
                            try {
                                System.out.print(courseCount + 1 + ".  ");
                                String input = in.nextLine();
                                String[] inputs = input.split(" "); //use of arrays to accept inputs of unitLoad and grade
                                int temp = Integer.parseInt(inputs[0]);
                                total += grading(temp, inputs[1]); //helps us to input the unit load and grading
                                courseCount++;
                                totalUnitLoad += temp;
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        //  }
                        gpa = total / totalUnitLoad;
                        System.out.printf("GPA for the semester: %.2f\n", gpa);
                        overallTotal += total;
                        total = 0;      // re-initialize for the next year.
                        overallUnitLoad += totalUnitLoad;
                        totalUnitLoad = 0; // re-initialize
                    }
                }
                System.out.println();
                cgpa = overallTotal / overallUnitLoad;
                System.out.printf("Your cgpa at the end of " + numberOfYears + " years is %.2f\n", cgpa);
                String output;

                if (cgpa < 2.5)
                    output = "Pass";
                else if (cgpa < 3.5)
                    output = "Second Class Lower or two-two";
                else if (cgpa < 4.5)
                    output = "Second Class Upper or two-one";
                else
                    output = "First Class";

                System.out.println("Congrats, You graduated with " + output);

            } catch (InputMismatchException e) {
                System.out.println("Error" + e.getMessage());
            }
        }

        // Calculate for one unitLoad and one grade.
        public static double grading(int unitLoad, String grade) {
            int gradeScores = switch (grade) {
                case "A", "a" -> 5;
                case "B", "b" -> 4;
                case "C", "c" -> 3;
                case "D", "d" -> 2;
                case "E", "e" -> 1;
                case "F", "f" -> 0;
                default -> throw new IllegalArgumentException("Please input a valid character.");
            };
            return gradeScores * unitLoad;
        }
    }

