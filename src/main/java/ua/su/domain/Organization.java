package ua.su.domain;
import java.util.List;
/**
 * Created by User on 5/17/2019.
 */
public class Organization {
    private String name;
    private String phoneNumber;
    private String adress;
    private Region reg;
    private String country;
    private String city;
    private Boolean cctive;
    private String cpecialization;
    private Integer cfficeNumber;
    private List<Employees> employees ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Region getReg() {
        return reg;
    }

    public void setReg(Region reg) {
        this.reg = reg;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Boolean getCctive() {
        return cctive;
    }

    public void setCctive(Boolean cctive) {
        this.cctive = cctive;
    }

    public String getCpecialization() {
        return cpecialization;
    }

    public void setCpecialization(String cpecialization) {
        this.cpecialization = cpecialization;
    }

    public Integer getCfficeNumber() {
        return cfficeNumber;
    }

    public void setCfficeNumber(Integer cfficeNumber) {
        this.cfficeNumber = cfficeNumber;
    }

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }
}
