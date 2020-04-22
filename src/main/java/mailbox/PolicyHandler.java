package mailbox;

import mailbox.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{

    @Autowired
    MailboxRepository mailboxRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverSent_메세지전송(@Payload Sent sent){

        if(sent.isMe()){
            System.out.println("##### listener 메세지전송 : " + sent.toJson());

            //DB에 저장하는 부분 Sent -> Malibox 변환
            Mailbox mailbox = new Mailbox();
            mailbox.setId(sent.getId());
            mailbox.setReceiver(sent.getReceiver());
            mailbox.setSender(sent.getUser());
            mailbox.setText(sent.getText());
            mailboxRepository.save(mailbox);

        }
    }

}
