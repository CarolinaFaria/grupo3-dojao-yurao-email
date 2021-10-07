package br.com.zup.email.listener;

import br.com.zup.email.model.EventoEmail;
import br.com.zup.email.repository.EventoEmailRepository;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

public class EmailListener {

    @Autowired
    private EventoEmailRepository repository;

    @KafkaListener(topics = "conta_email")
    public void ouvir(String mensagem) {
        EventoEmail email = new EventoEmail(mensagem);
        repository.save(email);
    }
}
