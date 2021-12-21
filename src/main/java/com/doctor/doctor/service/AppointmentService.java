package com.doctor.doctor.service;

import com.doctor.doctor.dto.Appointment;
import com.doctor.doctor.dto.Patient;
import com.doctor.doctor.entity.AppointmentEntity;
import com.doctor.doctor.exception.NotFoundException;
import com.doctor.doctor.mapper.AppointmentMapper;
import com.doctor.doctor.repository.AppointmentRepository;
import com.doctor.doctor.request.AppointmentRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final PatientService patientService;

    public AppointmentService(AppointmentRepository appointmentRepository, PatientService patientService) {
        this.appointmentRepository = appointmentRepository;
        this.patientService = patientService;
    }

    public Appointment getById(String appointmentId) {
        return AppointmentMapper.INSTANCE.toDto(findEntityById(appointmentId));
    }

    public List<Appointment> getAllByDate(Date start, Date end) {
        List<AppointmentEntity> appointmentEntityList = appointmentRepository
                .findAllByStartGreaterThanEqualAndEndLessThanEqual(start, end);
        List<String> patientIdList = appointmentEntityList.stream().map(AppointmentEntity::getPatientId)
                .collect(Collectors.toList());

        List<Patient> patientList = patientService.findAllByIds(patientIdList);

        return appointmentEntityList.stream().map(a -> {
            Optional<Patient> patientOpt = patientList.stream().filter(p -> p.getId().equals(a.getPatientId()))
                    .findFirst();
            Appointment appointment = AppointmentMapper.INSTANCE.toDto(a);
            patientOpt.ifPresent(appointment::setPatient);

            return appointment;
        }).collect(Collectors.toList());
    }

    public Appointment create(AppointmentRequest appointmentRequest) {

        Patient patient = patientService.findById(appointmentRequest.getPatientId());
        Appointment appointment = AppointmentMapper.INSTANCE
                .toDto(appointmentRepository.save(AppointmentMapper.INSTANCE.toEntity(appointmentRequest)));

        appointment.setPatient(patient);

        return appointment;
    }

    public Appointment update(String appointmentId, AppointmentRequest appointmentRequest) {

        AppointmentEntity appointmentEntity = findEntityById(appointmentId);
        Patient patient = patientService.findById(appointmentRequest.getPatientId());
        AppointmentEntity appointmentEntityUpdated = appointmentRepository
                .save(AppointmentMapper.INSTANCE.merge(appointmentEntity, appointmentRequest));

        Appointment appointment = AppointmentMapper.INSTANCE.toDto(appointmentEntityUpdated);
        appointment.setPatient(patient);

        return appointment;
    }

    private AppointmentEntity findEntityById(String id) {
        return appointmentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("Not found appointment by id = %s", id)));

    }

    public void delete(String id) {
        appointmentRepository.deleteById(id);
    }
}
