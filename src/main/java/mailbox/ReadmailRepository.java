package mailbox;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReadmailRepository extends CrudRepository<Readmail, Long> {


}