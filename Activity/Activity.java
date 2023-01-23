package Activity;

public class Activity {
    private int day;
    private int month;
    private int year;

    private void defaultError() {
        System.out.println("Invalid date.");
    }

    public Activity() {
        this.day = 1;
        this.month = 1;
        this.year = 1;
    }

    public Activity(int dayIn, int monthIn, int yearIn) {
        setDate(dayIn, monthIn, yearIn);
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

    public void setDate(int dayIn, int monthIn, int yearIn) {
        if (dayIn < 0 || dayIn > 31) {
            // invalid date
            defaultError();
            return;
        } else if (monthIn < 1 || monthIn > 12) {
            // invalid date
            defaultError();
            return;
        } else if (year < 0) {
            defaultError();
            return;
        } else {
            // Valid date, continue normally
            this.day = dayIn;
            this.month = monthIn;
            this.year = yearIn;
        }

        this.day = dayIn;
        this.month = monthIn;
        this.year = yearIn;
    }

    public void printDate() {
        System.out.println(day + "." + month + "." + year);
    }
}
