package com.gautam.rest.webservices.restfulwebservices;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MyCoursesHardcodeService {

    private static List<MyCourses> myCourses = new ArrayList<>();
    private static long inCounter = 0;

    static {
        myCourses.add(new MyCourses(++inCounter, "pravin", "Learn ReactJS && Anular", new Date(), false));
        myCourses.add(new MyCourses(++inCounter, "gautam", "Learn JS", new Date(), false));
        myCourses.add(new MyCourses(++inCounter, "minu", "Learn Dance", new Date(), false));
    }

    public List<MyCourses> findAll() {
        return myCourses;
    }

    public MyCourses deleteById(long id) {
        MyCourses mycourse = findById(id);
        if (mycourse == null) {
            return null;
        }
        if (myCourses.remove(mycourse)) {
            return mycourse;
        }
        return null;
    }

    MyCourses findById(long id) {
        for (MyCourses mycourse : myCourses) {
            if (mycourse.getId() == id ) {
                return mycourse;
            }
        }
        return null;
    }

    public MyCourses save(MyCourses myCourse) {
        if (myCourse.getId() == -1 || myCourse.getId() == 0) {
            myCourse.setId(++inCounter);
            myCourses.add(myCourse);
        } else {
            deleteById(myCourse.getId());
            myCourses.add(myCourse);
        }
        return myCourse;
    }

}
