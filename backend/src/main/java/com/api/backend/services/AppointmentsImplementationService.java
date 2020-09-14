package com.api.backend.services;

import com.api.backend.models.appointments.Appointments;
import com.api.backend.repositories.AppointmentsRepository.AppointmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.*;

@Component("appointmentService")
public class AppointmentsImplementationService implements AppointmentsService {

    @Autowired
    AppointmentsRepository appointmentsRepository;

    public AppointmentsImplementationService() {
    }

    public AppointmentsImplementationService(AppointmentsRepository appointmentsRepository) {
        this.appointmentsRepository = appointmentsRepository;
    }

    @Override
    public Optional<Appointments> findById(Long appointmentId) {
        return appointmentsRepository.findById(appointmentId);
    }

    @Override
    public List<Appointments> findAll() {
        return appointmentsRepository.findAll();
    }

    @Override
    public List<Appointments> findByDateRangeSortedByPrice(LocalDate startDate, LocalDate endDate) {
        return appointmentsRepository.findAllByAppointmentDateBetweenOrderByPriceAsc(startDate, endDate);
    }

    @Override
    public Appointments create(Appointments appointment) {
        return appointmentsRepository.save(appointment);
    }

    @Override
    public Appointments update(Long appointmentId, Appointments appointment) {
        return appointmentsRepository.save(appointment);
    }

    @Override
    public Appointments updateStatus(Long appointmentId, Appointments appointment) {

        Optional<Appointments> appointmentList = appointmentsRepository.findById(appointmentId);

        if(appointmentList.isPresent()){
            if(appointment.getStatus() != null){
                appointmentList.get().setStatus(appointment.getStatus());
            }
            return appointmentsRepository.save(appointmentList.get());
        }
        return null;
    }

    @Override
    public void deleteById(Long appointmentId) {
        appointmentsRepository.deleteById(appointmentId);
    }
}