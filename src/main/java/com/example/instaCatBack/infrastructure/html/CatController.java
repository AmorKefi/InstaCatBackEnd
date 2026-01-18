package com.example.instaCatBack.infrastructure.html;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.instaCatBack.application.CatService;
import com.example.instaCatBack.domain.Cat;

@RestController
@RequestMapping("V1/api/cats")
public class CatController {

	private final CatService catService;

	public CatController(CatService catService) {
		this.catService = catService;
	}

	@GetMapping
	public List<Cat> getAllCats() {
		return catService.getAllCats();
	}

}
	