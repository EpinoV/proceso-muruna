package cl.muruna.epv.procesomuruna.repository;

import cl.muruna.epv.procesomuruna.model.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PhoneRepository extends JpaRepository<Phone, Integer> {
    @Override
    Optional<Phone> findById(Integer integer);
}
