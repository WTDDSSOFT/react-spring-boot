package com.api.backend.models.appointments;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;

@Data
@Entity
@Table(name="Appointments")
public class Appointments {

    private @Id @GeneratedValue Long id;
    private Timestamp createdAt = new Timestamp(System.currentTimeMillis());
    private LocalDate appointmentDate;
    private Time appointmentStartTime;
    private Time appointmentEndTime;
    private String nameOfDoctor;
    private String nameOfCoustumer;
    private String Description;
    private AppointmentsStatus status = AppointmentsStatus.Booked;
    private BigDecimal price;

    public Appointments() {

    }

    public Appointments(Timestamp createdAt, LocalDate appointmentDate, Time appointmentStartTime, Time appointmentEndTime, String nameOfDoctor,String nameOfCoustumer, String description, AppointmentsStatus status, BigDecimal price) {
        this.createdAt = createdAt;
        this.appointmentDate = appointmentDate;
        this.nameOfDoctor = nameOfDoctor;
        this.nameOfCoustumer = nameOfCoustumer;
        this.Description = description;
        this.status = status;
        this.price = price;
    }

    public String getNameOfCoustumer() {
        return nameOfCoustumer;
    }

    public void setNameOfCoustumer(String nameOfCoustumer) {
        this.nameOfCoustumer = nameOfCoustumer;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public Appointments(LocalDate appointmentDate, Time appointmentStartTime, Time appointmentEndTime, String nameOfDoctor, BigDecimal price) {
        this.appointmentDate = appointmentDate;
        this.appointmentStartTime = appointmentStartTime;
        this.appointmentEndTime = appointmentEndTime;
        this.nameOfDoctor = nameOfDoctor;
        this.price = price;
    }

    public Appointments(LocalDate appointmentDate, String nameOfDoctor, BigDecimal price) {
        this.appointmentDate = appointmentDate;
        this.nameOfDoctor = nameOfDoctor;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Time getAppointmentStartTime() {
        return appointmentStartTime;
    }

    public void setAppointmentStartTime(Time appointmentStartTime) {
        this.appointmentStartTime = appointmentStartTime;
    }

    public Time getAppointmentEndTime() {
        return appointmentEndTime;
    }

    public void setAppointmentEndTime(Time appointmentEndTime) {
        this.appointmentEndTime = appointmentEndTime;
    }

    public String getNameOfDoctor() {
        return nameOfDoctor;
    }

    public void setNameOfDoctor(String nameOfDoctor) {
        this.nameOfDoctor = nameOfDoctor;
    }

    public AppointmentsStatus getStatus() {
        return status;
    }

    public void setStatus(AppointmentsStatus status) {
        this.status = status;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}