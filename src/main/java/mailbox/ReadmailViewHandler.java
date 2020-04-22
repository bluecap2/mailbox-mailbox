package mailbox;

import mailbox.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class ReadmailViewHandler {


    @Autowired
    private ReadmailRepository readmailRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenSaved_then_CREATE_1 (@Payload Saved saved) {
        try {
            if (saved.isMe()) {
                // view 객체 생성
                Readmail readmail = new Readmail();
                // view 객체에 이벤트의 Value 를 set 함
                readmail.setId(saved.getId());
                readmail.setSender(saved.getSender());
                readmail.setReceiver(saved.getReceiver());
                readmail.setText(saved.getText());
                // view 레파지 토리에 save
                readmailRepository.save(readmail);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



}