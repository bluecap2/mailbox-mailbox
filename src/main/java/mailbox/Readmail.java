package mailbox;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Readmail_table")
public class Readmail {

        @Id
        @GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;
        private Integer sender;
        private Integer receiver;
        private String text;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }
        public Integer getSender() {
            return sender;
        }

        public void setSender(Integer sender) {
            this.sender = sender;
        }
        public Integer getReceiver() {
            return receiver;
        }

        public void setReceiver(Integer receiver) {
            this.receiver = receiver;
        }
        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

}
