package com.libraryapp.entities;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity()
@Table(name = "CUSTOMERS")

public class Customers {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long customer_id;

    @Column(name = "first_name")
    private String first_name;

    private String last_name;

    private long phone_number;

    private String email_address;

    private String ident_type;

    private String ident_number;

    private String address_first_line;

    private String address_sec_line;

    private String city;

    private String state;

    private String zipcode;

//    @OneToMany(mappedBy = "reservedByCustomers")
//    private List<Rents> reservedByRents;
//
//    @OneToMany(mappedBy = "reservedByCustomers")
//    private List<CustomersEvents> reservedByCustomerEvents;

//    @OneToMany(mappedBy = "reservedByCustomers")
//    private List<Bookings> reservedByBookings;

    public Set<Bookings> getBook() {
        return book;
    }

    public void setBook(Set<Bookings> book) {
        this.book = book;
    }

    @OneToMany(targetEntity = Bookings.class, mappedBy = "customer", orphanRemoval = false, fetch = FetchType.LAZY)
    private Set<Bookings> book;

    public Customers(){}

    public Customers(long customer_id, String first_name, String last_name, long phone_number, String email_address, String ident_type, String ident_number, String address_first_line, String address_sec_line, String city, String state, String zipcode) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phone_number = phone_number;
        this.email_address = email_address;
        this.ident_type = ident_type;
        this.ident_number = ident_number;
        this.address_first_line = address_first_line;
        this.address_sec_line = address_sec_line;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
//        this.reservedByRents = reservedByRents;
//        this.reservedByCustomerEvents = reservedByCustomerEvents;
//        this.reservedByBookings = reservedByBookings;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public long getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(long phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getIdent_type() {
        return ident_type;
    }

    public void setIdent_type(String ident_type) {
        this.ident_type = ident_type;
    }

    public String getIdent_number() {
        return ident_number;
    }

    public void setIdent_number(String ident_number) {
        this.ident_number = ident_number;
    }

    public String getAddress_first_line() {
        return address_first_line;
    }

    public void setAddress_first_line(String address_first_line) {
        this.address_first_line = address_first_line;
    }

    public String getAddress_sec_line() {
        return address_sec_line;
    }

    public void setAddress_sec_line(String address_sec_line) {
        this.address_sec_line = address_sec_line;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

//    public List<Rents> getReservedByRents() {
//        return reservedByRents;
//    }
//
//    public void setReservedByRents(List<Rents> reservedByRents) {
//        this.reservedByRents = reservedByRents;
//    }
//
//    public List<CustomersEvents> getReservedByCustomerEvents() {
//        return reservedByCustomerEvents;
//    }
//
//    public void setReservedByCustomerEvents(List<CustomersEvents> reservedByCustomerEvents) {
//        this.reservedByCustomerEvents = reservedByCustomerEvents;
//    }

//    public List<Bookings> getReservedByBookings() {
//        return reservedByBookings;
//    }
//
//    public void setReservedByBookings(List<Bookings> reservedByBookings) {
//        this.reservedByBookings = reservedByBookings;
//    }
}
