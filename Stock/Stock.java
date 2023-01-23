package Stock;

import java.util.Arrays;

public class Stock {
    private int day;
    private int month;
    private int year;
    private String name;
    private int[] values = new int[7];

    public Stock() {
        this.day = 1;
        this.month = 1;
        this.year = 1;
        this.name = "";
        Arrays.fill(values, 0);
    }

    private void initDefaultError() {
        this.day = 1;
        this.month = 1;
        this.year = 1;
        this.name = "";
        Arrays.fill(values, 0);
        System.out.println("Invalid date.");
    }

    public Stock(int dayIn, int monthIn, int yearIn, String nameIn, int[] valIn) {
        if (dayIn < 0 || dayIn > 31) {
            // invalid date
            initDefaultError();
            return;
        } else if (monthIn < 1 || monthIn > 12) {
            // invalid date
            initDefaultError();
            return;
        } else if (year < 0) {
            initDefaultError();
            return;
        } else if (valIn.length != 7) {
            // invalid values
            initDefaultError();
            return;
        } else {
            // check all values in valIn arr to make sure no negatives.
            for (int i = 0; i < valIn.length; i++) {
                if (valIn[i] < 0) {
                    // invalid, error and return.
                    initDefaultError();
                    return;
                }
            }

            // Valid date, continue normally
            this.values = valIn;
            this.day = dayIn;
            this.month = monthIn;
            this.year = yearIn;
            this.name = nameIn;
        }
    }

    public int getDay() {
        return this.day;
    }

    public int getMonth() {
        return this.month;
    }

    public int getYear() {
        return this.year;
    }

    public String getName() {
        return this.name;
    }

    public int getValue(int ind) {
        if (ind >= 6 || ind < 0) {
            // invalid index, error
            System.out.println("Invalid index getting value at index: " + ind);
            return -1;
        } else {
            return this.values[ind];
        }
    }

    public void setDate(int dayIn, int monthIn, int yearIn) {
        this.day = dayIn;
        this.month = monthIn;
        this.year = yearIn;
    }

    public void printDate() {
        System.out.println(day + "." + month + "." + year);
    }

    public void setName(String nameIn) {
        this.name = nameIn;
    }

    public void setValue(int val, int ind) {
        if (ind >= 6 || ind < 0) {
            // invalid index, error
            System.out.println("Invalid index getting value at index: " + ind);
            return;
        }
        // valid index
        this.values[ind] = val;
    }

    public void printStock() {
        String valString = "";
        for (int i = 0; i < this.values.length; i++) {
            valString += this.values[i] + ", ";
        }
        System.out.println(this.day + "." + this.month + "." + this.year + " values: \n" + valString);
    }

    public int getMean() {
        int sum = 0;
        for (int i = 0; i < this.values.length; i++) {
            sum += this.values[i];
        }
        return sum / this.values.length;
    }
}
