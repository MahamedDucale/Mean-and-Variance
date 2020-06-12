package com.elec0021;

import java.util.*; // needed for the Scanner class in the enhanced version
public class MeanAndVariance {
    private double[] data;
    public double mean () {
        int i = 0;
        double sum = 0;
        while(true){
            sum = sum + this.data[i];
            if(i == this.data.length - 1){
                return (sum/(i+1));
            }else{
                i++;
                continue;
            }
        }// method implementation here
    }
    public double variance () {
        int i = 0;
        double mean = this.mean();
        double sum_of_squares = 0;
        while(true){
            sum_of_squares = sum_of_squares + ((mean - (this.data[i]))*(mean - (this.data[i])));
            if(i == this.data.length - 1){
                return (sum_of_squares/(i+1));
            }else{
                i++;
                continue;
            }
        }// method implementation here
    }
    public double[] getData () {
        return data;
    }
    public void setData (double[] newData) {
        data = newData;
    }
    @Override // overrides Object toString - all Java classes inherit (ultimately) from Object
    public String toString () {
        return Arrays.toString(this.data);// method implementation here
    }
    public MeanAndVariance (double[] myData) { // constructor, called indirectly via new
        data = myData;
    }
    public MeanAndVariance () { // constructor with no data, called indirectly via new
        data = null;
    }
    private static int getNumOfData (Scanner input) {
        System.out.printf("Enter the number of arguments followed by data:\n");
        int ndata;
        while (true) { // loop until we get it correctly
            ndata = input.nextInt();
            if (ndata < 2) {
                System.out.printf("the number of data should be >=2 !\n");
                continue; // continue looping
            }
            break; // we got it correctly, so break out of the loop
        }
        return ndata;
    }
    public void getDataSet (Scanner input) {
        int ndata = getNumOfData(input);
        int i = 0;
        data = new double[ndata]; // we create the array instance variable
        while (true){
            data[i] = input.nextDouble();
            if(i == ndata - 1){
                break;
            }else{
                i++;
                continue;
            }
        }
        // here you should write code that gets exactly ndata numbers
        // from the standard input and initialises the array elements
        // you will need a while (true) loop as above
        // and you should use the Scanner nextDouble method
    }
    public static void main (String[] args) {
        // create first new Scanner object instance that reads the standard input
        Scanner input = new Scanner(System.in);
        // create new MeanAndVariance object instance
        MeanAndVariance mv = new MeanAndVariance();
        mv.getDataSet(input); // get data set 1
        System.out.printf("The mean and variance of the following numbers are:\n");
        System.out.printf("Numbers: %s\n", mv.toString());
        System.out.printf("Mean: %f Variance: %f\n", mv.mean(), mv.variance());
        System.out.printf("\n");
        mv.getDataSet(input); // get data set 2
        System.out.printf("\nThe mean and variance of the following numbers are:\n");
        System.out.printf("Numbers: %s\n", mv.toString());
        System.out.printf("Mean: %f Variance: %f\n", mv.mean(), mv.variance());
    }
} // end class

