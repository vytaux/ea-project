package com.tg5.controller;

import com.tg5.domain.*;
import com.tg5.repository.LocationRepository;
import com.tg5.service.seeder.SeederService;
import com.tg5.service.seeder.SeederServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seeder")
public class SeederController {

    private final SeederService seederService;

    private final LocationRepository locationRepository;

    public int getRandomInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @GetMapping(value="/{amount}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public StreamingResponseBody seed(@PathVariable Integer amount) {
        return outputStream -> {
            for (int i = 0; i < amount; i++) {
                outputStream.write(("Generating event #" + i + "...").getBytes());
                outputStream.flush();

                generateEvent(i);
            }
        };
    }

    private void generateEvent(int seed) {
        // Location
        Location location = new Location();
        location.setName("location" + seed);
        // TODO randomize
        location.setLocationType(LocationType.CLASSROOM);
        locationRepository.save(location);

        // Account currency
        AccountCurrency accountCurrency = new AccountCurrency();
        accountCurrency.setBalance(BigDecimal.valueOf(1000));
        // TODO randomize
        accountCurrency.setMoneyType(AccountCurrency.MoneyType.Points);

        // Account type
        AccountType accountType = new AccountType();
        accountType.setName("accountType" + seed);
        accountType.setBalance(accountCurrency);
        accountType.setDescription("description" + seed);



        // event
        Event event = new Event();
        event.setName("event" + seed);
        event.setStartDateTime(LocalDateTime.parse("2024-01-02T00:00:00"));
        event.setEndDateTime(LocalDateTime.parse("2024-06-06T00:00:00"));
        event.setLocation(location);
        event.setAccountType(accountType);
        event.setMembers(null);
        event.setSessions(null);

        // create scanners
        // create accountType
        // create accounts
        // create roles
        // create members
        // create events
        // create sessions
        // create records
    }
}
