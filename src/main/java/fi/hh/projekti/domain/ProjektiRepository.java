package fi.hh.projekti.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProjektiRepository extends CrudRepository<Projekti, Long> {
	
	List<Projekti> findByTuote(String tuote);

}
