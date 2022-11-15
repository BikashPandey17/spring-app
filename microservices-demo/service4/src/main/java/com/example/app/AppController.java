package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("api/v1/service4")
public class AppController {

    private static Logger logger = LoggerFactory.getLogger(AppController.class);

    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

    @PostMapping
    public void registerTable(@RequestBody GuildTableInsertRequest guildTableInsertRequest) {
        logger.info("New Row added to table {}", guildTableInsertRequest);
        appService.insertTableRow(guildTableInsertRequest);
    }
}
