package net.vasilakos.externalapi.service;

import net.vasilakos.externalapi.model.Articles;
import net.vasilakos.externalapi.model.Email;
import net.vasilakos.externalapi.repository.EmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class SendArticleService {

    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private ArticleService articleService;

    public void sendArticles(){
        Articles articles = new Articles();

        articles = articleService.getTopArticles();

        String body = null;

        for(int i=0;i<articles.getArticles().length;i++){
            body += articles.getArticles()[i];
            body+="\n";
        }

        String email;
        ArrayList<Email> emails = emailRepository.findAll();

        for(int i=0;i<emails.size();i++){
            email=emails.get(i).getEmail();
            emailSenderService.sendEmail(email,"News",body);
        }

    }

    public Email registerEmail(String e_mail) throws Exception {
        Email email = new Email(e_mail);
        Email check = emailRepository.findByEmail(e_mail);

        if(check!=null){
            throw new Exception();
        }

        email.setEmailId(sequenceGeneratorService.generateSequence(Email.SEQUENCE_NAME));
        emailRepository.save(email);

        return email;
    }

    @Transactional
    public void unsub(String email) throws Exception {

        Email check = emailRepository.findByEmail(email);

        if(check==null){
            throw new Exception();
        }

        emailRepository.deleteByEmail(email);
    }
}
