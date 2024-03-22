package com.tg5.controller;

import com.tg5.domain.*;
import com.tg5.domain.Record;
import com.tg5.service.seeder.SeederService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seeder")
public class SeederController {

    private final SeederService seederService;

    @GetMapping("/{amount}")
    public String seed(@PathVariable Integer amount) {
        seederService.seed(amount);
        return "Done";
    }
}
