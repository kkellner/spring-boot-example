package com.example.demo.repository;

import java.util.List;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.example.demo.domain.Person2;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface Person2Repository  extends PagingAndSortingRepository<Person2, Long> {

	List<Person2> findByLastName(@Param("name") String name);

}