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
import com.project.facultymapping.Model.Subject;
import com.project.facultymapping.Repository.FacultyRepository;
import com.project.facultymapping.Repository.SubjectRepository;
import com.project.facultymapping.ResourceNotFoundException.ResourceNotFoundException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/Subject")
public class SubjectController{
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@GetMapping("/addsubject")
	public List<Subject> getAllSubject(){
		return subjectRepository.findAll();
		}
	// create rest api
	@PostMapping("/addsubject")
	public Subject createSubject(@RequestBody  Subject sb) {
		return subjectRepository.save(sb);
	}
	@GetMapping("/addsubject/{id}")
	public ResponseEntity<Subject>getSubjectById(@PathVariable Long id) {
		Subject sb = subjectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
		return ResponseEntity.ok(sb);
	}
	
	//upadating 
	
	@PutMapping("/addsubject/{id}")
	public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject details){
		Subject sb= subjectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ID not exist with id :" + id));
		
			
	    sb.setDname(details.getDname());
		sb.setDcode(details.getDcode());
		sb.setSubject(details.getSubject());
		
		
		
	       Subject updatedsubject  =  subjectRepository.save(sb);
	        return ResponseEntity.ok(updatedsubject);

}
	// Delete rest api
	@DeleteMapping("/addsubject/{id}")
	public ResponseEntity<Map<String, Boolean>> deletesubject(@PathVariable Long id){
	Subject	sb= subjectRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Id not exist with id :" + id));
		
		subjectRepository.delete(sb);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
