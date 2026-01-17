package com.example.instaCatBack.service;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import com.example.instaCatBack.application.CatServiceImpl;
import com.example.instaCatBack.infrastructure.remote.CatsApiResponse;
import com.example.instaCatBack.infrastructure.repository.CatRepository;

@ExtendWith(MockitoExtension.class)
public class CatServiceTest {

	@Mock
	private CatRepository catRepository;

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private CatServiceImpl catService;

	private static final String CATS_URL = "https://data.latelier.co/cats.json";

	@Test
	void loadCatsFromRemoteIfEmpty_shouldDoNothing_whenRepositoryNotEmpty() {

		given(catRepository.count()).willReturn(5L);

		catService.loadCatsFromRemoteIfEmpty();

		then(restTemplate).should(never()).getForObject(anyString(), eq(CatsApiResponse.class));
		then(catRepository).should(never()).saveAll(anyList());

	}

}
