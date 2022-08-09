package br.com.innmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.innmanager.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
