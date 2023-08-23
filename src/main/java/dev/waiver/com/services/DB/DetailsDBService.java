package dev.waiver.com.services.DB;

import dev.waiver.com.models.Details;
import dev.waiver.com.repositories.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class DetailsDBService {

    private DetailsRepository detailsRepository;

    //Method Injection
    @Autowired
    private void setDetailsRepository(DetailsRepository detailsRepository){
        this.detailsRepository=detailsRepository;
    }

    @Transactional
    public Details updateViaPatch(Details details){
        return details;
    }

    @Transactional(readOnly = false)
    public void save(Details details){
        detailsRepository.save(details);
    }
}
