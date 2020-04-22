package mailbox;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="Mailbox_table")
public class Mailbox {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer receiver;
    private Integer sender;
    private String text;

    @PostPersist
    public void onPostPersist(){
        Saved saved = new Saved();
        BeanUtils.copyProperties(this, saved);
        saved.publish();


//        Readed readed = new Readed();
//        BeanUtils.copyProperties(this, readed);
//        readed.publish();


    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public Integer getReceiver() {
        return receiver;
    }

    public void setReceiver(Integer receiver) {
        this.receiver = receiver;
    }
    public Integer getSender() {
        return sender;
    }

    public void setSender(Integer sender) {
        this.sender = sender;
    }
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }




}
