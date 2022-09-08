package com.leonardo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.leonardo.model.Course;
import com.leonardo.repository.CourseRepository;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseController {

	@Autowired
	private final CourseRepository courseRepository;
	
	
	@GetMapping
	public List<Course> list(){
		return courseRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Course create(@RequestBody Course course){ //caso fosse usar o ResponseEntity na criacao do metodo, deve usar ResponseEntity<Course>
//		System.out.println(course.getName()); teste para ver se chegou a informacao
		return courseRepository.save(course); //neste cenario onde so queremos devolver o codigo correto e o response simples, pode ser usado dessa forma
//		return ResponseEntity.status(HttpStatus.CREATED).body(courseRepository.save(course)); Response entity se faz necessario quando precisamos manipular melhor o response
	}
}
