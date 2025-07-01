package com.gautam.rest.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class MyCoursesController {

    @Autowired
    private MyCoursesHardcodeService service;

    @GetMapping
    public List<MyCourses> getAllCourses() {
        return service.findAll();
    }

    @PostMapping
    public ResponseEntity<MyCourses> addCourse(@RequestBody MyCourses course) {
        MyCourses createdCourse = service.Save(course);
        return ResponseEntity.created(URI.create("/courses/" + createdCourse.getId())).body(createdCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable long id) {
        MyCourses deleted = service.deleteById(id);
        if (deleted != null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
} 