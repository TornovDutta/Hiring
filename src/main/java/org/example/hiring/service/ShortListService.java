package org.example.hiring.service;

import org.example.hiring.DAO.JobSeekerRepo;
import org.example.hiring.DAO.ResumeRepo;
import org.example.hiring.model.Resume;
import org.example.hiring.model.JobSeeker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShortListService {

    @Autowired
    private JobSeekerRepo jobSeekerRepo;

    @Autowired
    private ResumeRepo resumeRepo;


    public ResponseEntity<List<Resume>> getAll() {
        try {
            List<Resume> resumes = resumeRepo.findAll();
            return new ResponseEntity<>(resumes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<Resume> getResume(String name) {

        JobSeeker jobSeeker = jobSeekerRepo.findByName(name);

        if (jobSeeker != null) {
            Resume resume= jobSeeker.getResume();

            return new ResponseEntity<>(resume, HttpStatus.OK);
        } else {

            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<JobSeeker>> getAllJobsheeker() {
        try {
            List<JobSeeker> jobSheekers = jobSeekerRepo.findAll();
            return new ResponseEntity<>(jobSheekers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
