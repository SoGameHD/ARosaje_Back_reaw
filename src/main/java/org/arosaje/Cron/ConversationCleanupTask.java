package org.arosaje.Cron;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.arosaje.entities.conversation.Conversation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ConversationCleanupTask {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @PostConstruct
    public void init() {
        cleanupConversations();
    }

    @Scheduled(cron = "0 0 0 * * ?") // Exécuter tous les soirs à minuit
    public void scheduledCleanupConversations() {
        cleanupConversations();
    }

    private void cleanupConversations() {
        System.out.println("CRON : START CONVERSATION CLEANUP TASK");
        LocalDateTime limitDate = LocalDateTime.now();

        TransactionStatus transactionStatus = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try {
            Query deleteQuery = entityManager.createQuery("DELETE FROM message m WHERE m.date < :limitDate");
            deleteQuery.setParameter("limitDate", limitDate);
            int deletedCount = deleteQuery.executeUpdate();
            System.out.println(deletedCount + " messages deleted");

            Query emptyConversationsQuery = entityManager.createQuery("SELECT c FROM Conversation c WHERE c.message IS EMPTY");
            List<Conversation> emptyConversations = emptyConversationsQuery.getResultList();

            for (Conversation conversation : emptyConversations) {
                entityManager.remove(conversation);
            }

            transactionManager.commit(transactionStatus);
        } catch (Exception e) {
            transactionManager.rollback(transactionStatus);
            throw e;
        }

        System.out.println("CRON : END CONVERSATION CLEANUP TASK");
    }
}