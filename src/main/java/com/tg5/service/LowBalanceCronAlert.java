package com.tg5.service;

import com.tg5.domain.Account;
import com.tg5.domain.AccountType;
import com.tg5.domain.Member;
import com.tg5.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LowBalanceCronAlert {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Scheduled(fixedRate = 50000) // Execute every 50 seconds
    public void sendLowBalanceAlertMessage() {
        System.out.println("Checking all low balance accounts and sending mails.......");
//        messageProducer.sendMessage("ams",
//                "dip06ece@gmail.com"+"#"+"[Alerts] Low Balance! #"
//                        +"Your Balance for Account"
//                        +" XXXX"+" is Low!");   //simulation and test purpose

        List<Account> accounts = accountRepository.findAll();           //Reading list of all accounts
        for(Account account: accounts) {                                //For every account in list
            AccountType accountType = account.getType();                //Read AccountType
            Member member = account.getMember();                        //Read member
            double percentage = account.getBalance()/ accountType.getBalance().valueOf() * 100;
                                                                        //Calculate percentage
            if (percentage < 5) {                                       //If balance dropped less than 5 percent
                jmsTemplate.convertAndSend("ams",
                                            member.getEmail()+"#"+"[Alerts] Low Balance!#"
                                                        +"Your Balance for Account"
                                                        +accountType.getName()+"is Low!");
                                            //Email receiver, Subject and contents are combined in a string
            }
        }
    }
}
