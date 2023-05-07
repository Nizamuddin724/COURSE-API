package nizam.in.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import nizam.in.binding.Courses;

public interface CourseRepo extends JpaRepository<Courses, Long>{

    Optional<Courses> findById(Long courseId);


}
