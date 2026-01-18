package com.example.instaCatBack.application;

import java.util.List;

import com.example.instaCatBack.domain.Cat;

public interface CatService {

	void loadCatsFromRemoteIfEmpty();

	List<Cat> getAllCats();

	Cat voteFor(String catId);

}
