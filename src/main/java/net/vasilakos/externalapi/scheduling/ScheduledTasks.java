package net.vasilakos.externalapi.scheduling;

import net.vasilakos.externalapi.service.SendArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    @Autowired
    private SendArticleService sendArticleService;

    @Component
    public class MailScheduler {

        @Scheduled(cron = "0 0 10,16 * * *")
        public void sendMail() {
            sendArticleService.sendArticles();

        }
    }
}
