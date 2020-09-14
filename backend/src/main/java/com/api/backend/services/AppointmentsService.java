package com.api.backend.services;

import com.api.backend.models.appointments.Appointments;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AppointmentsService {

    Optional<Appointments> findById(Long appointmentId);

    List<Appointments> findAll();

    List<Appointments> findByDateRangeSortedByPrice(LocalDate startDate, LocalDate endDate);

    Appointments create(Appointments appointment);

    Appointments update(Long appointmentId, Appointments appointment);

    Appointments updateStatus(Long appointmentId, Appointments appointment);

    void deleteById(Long appointmentId);

}