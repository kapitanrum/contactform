package cz.lundegaard.contactform.backend.repository;

import cz.lundegaard.contactform.backend.entity.RequestKind;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestKindRepository extends CrudRepository<RequestKind, Long> {}
