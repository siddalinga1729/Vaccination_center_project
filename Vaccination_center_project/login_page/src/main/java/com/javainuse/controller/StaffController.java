package com.javainuse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.DAOUser;
import com.javainuse.repo.UserRepo;


@RestController
@RequestMapping("/admin")
public class StaffController {
	@Autowired
	private UserRepo userRepo;

//	@RequestMapping("/welcome")
//	public String welocome() {
//		return "siddu";
//	}
	
	//we need to develop
	@PostMapping("/addStaff")
	public ResponseEntity<DAOUser> addStaff(@RequestBody DAOUser staff){
		DAOUser save = userRepo.save(staff);
		return new ResponseEntity<DAOUser>(save,HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<DAOUser>> getAllStaff(){
		List<DAOUser> findAll = userRepo.findAll();
		return new ResponseEntity<List<DAOUser>>(findAll,HttpStatus.OK);
	}
	@GetMapping("/delete/{id}")
	public ResponseEntity<String> deleteStaffById(@PathVariable Integer id){
		userRepo.deleteById(id);
		return new ResponseEntity<String>("Deleted Successfully",HttpStatus.OK);
	}
	
}
