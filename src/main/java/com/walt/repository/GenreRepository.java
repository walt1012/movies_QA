package com.walt.repository;

import com.walt.model.Genre;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GenreRepository extends Neo4jRepository<Genre, Long> {

    List<Genre> findByName(@Param("name") String name);

}
