package ua.su.domain;
/**
 * Created by Anatolii Ageev on 5/17/2019.
 */
public class Employees {
    private String name;
    private String surname;
    private String position;
    private Boolean maritalStatus;

    public Employees(String name, String surname, String position, Boolean maritalStatus, Float yearsWorked) {
        this.name = name;
        this.surname = surname;
        this.position = position;
        this.maritalStatus = maritalStatus;
        this.yearsWorked = yearsWorked;
    }
    private Float yearsWorked;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Boolean getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(Boolean maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Float getYearsWorked() {
        return yearsWorked;
    }

    public void setYearsWorked(Float yearsWorked) {
        this.yearsWorked = yearsWorked;
    }
}
