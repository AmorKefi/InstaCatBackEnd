package com.example.instaCatBack.application;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.example.instaCatBack.domain.Cat;
import com.example.instaCatBack.infrastructure.remote.CatsApiResponse;
import com.example.instaCatBack.infrastructure.repository.CatRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service("CatService")
@Slf4j
public class CatServiceImpl implements CatService {

	private final CatRepository catRepository;
	private final RestTemplate restTemplate;

	private static final String CATS_URL = "https://data.latelier.co/cats.json";

	public CatServiceImpl(CatRepository catRepository) {
		this.catRepository = catRepository;
		this.restTemplate = new RestTemplate();
	}

	@Override
	@Transactional
	public void loadCatsFromRemoteIfEmpty() {
		Long catNumber = catRepository.count();

		if (catNumber > 0) {
			log.info("Cats is already initialized in your database");
			return;
		}

		log.info("Loading cats from remote API: {}", CATS_URL);

		CatsApiResponse catsResponse = restTemplate.getForObject(CATS_URL, CatsApiResponse.class);

		if (null == catsResponse || null == catsResponse.images() || catsResponse.images().isEmpty()) {
			throw new RuntimeException("Empty Cats List From Remote");
		}

		List<Cat> fetchedCats = catsResponse.images().stream().map(cat -> new Cat(cat.id(), cat.url(), 0))
				.collect(Collectors.toList());

		catRepository.saveAll(fetchedCats);

		log.info("Cats added successfully {} cats has been added", fetchedCats.size());
	}

	@Override
	@Transactional(readOnly = true)
	public List<Cat> getAllCats() {
		return this.catRepository.findAll();
	}

	@Override
	public Cat voteFor(String catId) {
		Cat cat = this.catRepository.findById(catId)
				.orElseThrow(() -> new EntityNotFoundException("cat not found : " + catId));
		cat.setScore(cat.getScore() + 1);
		this.catRepository.save(cat);
		return cat;
	}

}
