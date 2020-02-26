package application.Examples;

public class Person {
    private String firstname;
    private String lastName;
    private String companyName;
    private String address;
    private String city;
    private String country;
    private String state;
    private long zip;
    private String phone1;
    private String phone2;

    public Person(String firstname, String lastName, String companyName, String address, String city,
                  String country, String state, long zip, String phone1, String phone2){
        this.firstname = firstname;
        this.lastName = lastName;
        this.companyName = companyName;
        this.address = address;
        this.city = city;
        this.country = country;
        this.state = state;
        this.zip = zip;
        this.phone1 =phone1;
        this.phone2 =phone2;
    }

    public String getFirstname() {
        System.out.println(firstname);
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastName() {
        System.out.println(lastName);
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompanyName() {
        System.out.println(companyName);
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        System.out.println(address);
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        System.out.println(city);
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        System.out.println(country);
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        System.out.println(state);
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public long getZip() {
        System.out.println(zip);
        return zip;
    }

    public void setZip(long zip) {
        this.zip = zip;
    }

    public String getPhone1() {
        System.out.println(phone1);
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        System.out.println(phone2);
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

}
