package com.api.backend.resources;

import com.api.backend.models.appointments.Appointments;
import com.api.backend.services.AppointmentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/appointments")
public class AppointmentsController {

    @Autowired
    private AppointmentsService appointmentService;

    public AppointmentsController() {
    }

    public AppointmentsController(AppointmentsService appointmentService) {
        this.appointmentService = appointmentService;
    }

    /** GET request to return specific appointments **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.GET)
    public Optional<Appointments> findById(@PathVariable Long appointmentId) {
        return appointmentService.findById(appointmentId);
    }

    /** GET request to return all appointments **/
    @RequestMapping(path = "/", method = RequestMethod.GET)
    List<Appointments> findAll() {
        return appointmentService.findAll();
    }

    /** GET request to return all appointments based on a date range and ordered by price **/
    @RequestMapping(method = RequestMethod.GET)
    public List<Appointments> findByDateRangeSortedByPrice(@DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("startDate") LocalDate startDate,
                                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @RequestParam("endDate") LocalDate endDate) {
        return appointmentService.findByDateRangeSortedByPrice(startDate, endDate);
    }

    /** POST request to add new appointments **/
    @RequestMapping(path = "/createAppointments",method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Appointments create(@RequestBody Appointments appointment) {
        return appointmentService.create(appointment);
    }

    /** PUT request to update appointments **/
    @RequestMapping(path = "/update/{appointmentId}", method = RequestMethod.PUT, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Appointments update(@PathVariable Long appointmentId, @RequestBody Appointments appointment) {
        return appointmentService.update(appointmentId, appointment);
    }

    /** PATCH request to update status of an appointment **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.PATCH, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Appointments updateStatus(@PathVariable Long appointmentId, @RequestBody Appointments appointment) {
        return appointmentService.updateStatus(appointmentId, appointment);
    }

    /** DELETE request to delete specific appointments **/
    @RequestMapping(path = "/{appointmentId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    void deleteById(@PathVariable Long appointmentId) {
        appointmentService.deleteById(appointmentId);
    }
}