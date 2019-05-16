package cz.lundegaard.contactform.backend.repository;

import cz.lundegaard.contactform.backend.entity.ContactForm;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactFormRepository extends CrudRepository<ContactForm, Long> {}
