package ua.su.domain;

import java.util.ArrayList;

/**
 * Created by User on 5/17/2019.
 */
public class Organization {
    private String Name;
    private String PhoneNumber;
    private  String Adress;
    private Region Reg;
    private  String Country;
    private  String City;
    private  boolean Active;
    private  String Specialization;
    private  int OfficeNumber;
    private ArrayList<Employees> employees = new ArrayList<>();

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public Region getReg() {
        return Reg;
    }

    public void setReg(Region reg) {
        Reg = reg;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    public String getSpecialization() {
        return Specialization;
    }

    public void setSpecialization(String specialization) {
        Specialization = specialization;
    }

    public int getOfficeNumber() {
        return OfficeNumber;
    }

    public void setOfficeNumber(int officeNumber) {
        OfficeNumber = officeNumber;
    }

    public ArrayList<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employees> employees) {
        this.employees = employees;
    }
}
