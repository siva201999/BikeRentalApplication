package com.example.bikerental.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.bikerental.model.Comments;
import com.example.bikerental.repository.CommentRepository;
import com.example.bikerental.repository.RenterRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class CommentService {

    @Autowired
	private CommentRepository commentRepository;
    @Autowired
	private RenterRepository renterRepository;
	public ResponseEntity<?> addComments(Long id, Comments comments) {	
		renterRepository.findById(id).map(ac->
		ac.getNewComment().add(comments));
		return new ResponseEntity<>(commentRepository.save(comments),HttpStatus.OK);
	}

}
