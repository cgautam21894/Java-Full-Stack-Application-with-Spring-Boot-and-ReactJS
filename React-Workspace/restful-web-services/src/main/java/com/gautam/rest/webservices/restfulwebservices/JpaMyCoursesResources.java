package com.gautam.rest.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class JpaMyCoursesResources {

    @Autowired(required = true)
    private MyCoursesHardcodeService mycoursesservice;

    @Autowired(required = true)
    private MyCourcesJpaRepository myCourseJpaRepo;

    @GetMapping(path = "/jpa/users/{username}/mycourses")
    public List<MyCourses> getAllMyCourses(@PathVariable String username) {
        return myCourseJpaRepo.findAll();
    }

    @GetMapping(path = "/jpa/users/{username}/mycourses/{id}")
    public MyCourses getSingleMyCourse(@PathVariable String username, @PathVariable long id) {
        return myCourseJpaRepo.findById(id).get();
    }


    @DeleteMapping(path = "/jpa/users/{username}/mycourses/{id}")
    public ResponseEntity<Void> deleteMyCourses(@PathVariable String username, @PathVariable long id) {
        myCourseJpaRepo.deleteById(id);
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/jpa/users/{username}/mycourses/{id}")
    public ResponseEntity<MyCourses> updateCourses(@PathVariable String username, @PathVariable long id,
                                                   @RequestBody MyCourses myCourses) {
        myCourses.setUsername(username);
        MyCourses updatedCourse = myCourseJpaRepo.save(myCourses);
        return new ResponseEntity<MyCourses>(myCourses, HttpStatus.OK);

    }

    @PostMapping(path = "/jpa/users/{username}/mycourses")
    public ResponseEntity<Void> createNewCourse(@PathVariable String username,
                                                @RequestBody MyCourses myCourses) {
        myCourses.setUsername(username);
        MyCourses createdCourse = myCourseJpaRepo.save(myCourses);
        //Get Current URL location and append it with new created ID
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdCourse.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }
}
