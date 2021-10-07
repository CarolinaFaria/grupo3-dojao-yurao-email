package br.com.zup.email.repository;

import br.com.zup.email.model.EventoEmail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoEmailRepository extends JpaRepository<EventoEmail, Long> {
}
