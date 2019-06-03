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
    private Boolean active;
    private String cpecialization;
    private Integer OfficeNumber;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public String getCpecialization() {
        return cpecialization;
    }

    public void setCpecialization(String cpecialization) {
        this.cpecialization = cpecialization;
    }

    public Integer getOfficeNumber() {
        return OfficeNumber;
    }

    public void setOfficeNumber(Integer officeNumber) {
        this.OfficeNumber = officeNumber;
    }

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }
}
