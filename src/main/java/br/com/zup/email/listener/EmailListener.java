package br.com.zup.email.listener;

import br.com.zup.email.dto.EventoExtratoDto;
import br.com.zup.email.model.EventoEmail;
import br.com.zup.email.repository.EventoEmailRepository;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class EmailListener {

    @Autowired
    private EventoEmailRepository repository;

    @KafkaListener(topics = "email_transacao")
    public void ouvir(EventoExtratoDto request) {
        System.out.println(request.toString());
        EventoEmail email = new EventoEmail(request.toString());
        repository.save(email);
    }
}
