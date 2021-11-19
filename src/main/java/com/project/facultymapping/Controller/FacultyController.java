package com.project.facultymapping.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.facultymapping.Model.Faculty;
import com.project.facultymapping.Repository.FacultyRepository;
import com.project.facultymapping.ResourceNotFoundException.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/Faculty")
public class FacultyController{
	
	@Autowired
	private FacultyRepository facultyRepository;
	
	@GetMapping("/addfaculty")
	public List<Faculty> getAllFaculty(){
		return facultyRepository.findAll();
		}
	// create rest api
	@PostMapping("/addfaculty")
	public Faculty createFaculty(@RequestBody  Faculty fc) {
		return facultyRepository.save(fc);
	}
	@GetMapping("/addfaculty/{id}")
	public ResponseEntity<Faculty>getFacultyById(@PathVariable Long id) {
		Faculty fc = facultyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
		return ResponseEntity.ok(fc);
	}
	
	//upadating 
	
	@PutMapping("/addfaculty/{id}")
	public ResponseEntity<Faculty> updateFaculty(@PathVariable Long id, @RequestBody Faculty details){
		Faculty fc= facultyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ID not exist with id :" + id));
		
		fc.setName(details.getName());		
	    fc.setDOB(details.getDOB());
		fc.setDept(details.getDept());
		fc.setGender(details.getGender());
		fc.setEmail_id(details.getEmail_id());
		fc.setPassword( details.getPassword());
		
		
	       Faculty updatedfaculty  =  facultyRepository.save(fc);
	        return ResponseEntity.ok(updatedfaculty);

}
	// Delete rest api
	@DeleteMapping("/addfaculty/{id}")
	public ResponseEntity<Map<String, Boolean>> deletefaculty(@PathVariable Long id){
	Faculty	fc= facultyRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
		
		facultyRepository.delete(fc);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
