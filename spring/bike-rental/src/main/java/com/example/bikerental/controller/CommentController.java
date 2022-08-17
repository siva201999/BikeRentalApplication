package com.example.bikerental.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bikerental.model.BikeModel;
import com.example.bikerental.model.Comments;
import com.example.bikerental.model.RenterModel;
import com.example.bikerental.service.CommentService;
import com.example.bikerental.service.RenterService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	
	@PostMapping("/comments/{id}")
	public ResponseEntity<?> addBikes(@PathVariable("id") Long id,@RequestBody Comments comments){
		return commentService.addComments(id,comments);
	}
}
