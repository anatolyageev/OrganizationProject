package ua.su.domain;

/**
 * Created by Anatolii Ageev on 5/17/2019.
 */
public class Employees {
    private String Name;
    private String Surname;
    private  String Position;
    private boolean MaritalStatus;
    private float YearsWorked;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public boolean getMaritalStatus() {
        return MaritalStatus;
    }

    public void setMaritalStatus(boolean maritalStatus) {
        MaritalStatus = maritalStatus;
    }

    public float getYearsWorked() {
        return YearsWorked;
    }

    public void setYearsWorked(float yearsWorked) {
        YearsWorked = yearsWorked;
    }
}
