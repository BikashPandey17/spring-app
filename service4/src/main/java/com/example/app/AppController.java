package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Validated
@RestController
@RequestMapping("api/v1/service4")
public class AppController {

    private static Logger logger = LoggerFactory.getLogger(AppController.class);

    private final AppService appService;

    public AppController(AppService appService) {
        this.appService = appService;
    }

//    @GetMapping(path="{id}")
//    public ResponseEntity getMethod(@PathVariable String id) {
//        logger.info("Service 4 get request: " + id);
//
//    }

    /**
     * Gives the complete list of objects
     * */
    @GetMapping()
    public List getAll() {
        logger.info("Service 4 getAll request");
        return appService.getAll();
    }

    @GetMapping("{id}")
    public Map getOne(@PathVariable int id) {
        logger.info("Service 4 getAll request");
        return appService.getOne(id);
    }

    @PostMapping
    public void registerTable(@RequestBody GuildTableInsertRequest guildTableInsertRequest) {
        logger.info("New Row added to table {}", guildTableInsertRequest);
        appService.insertTableRow(guildTableInsertRequest);
    }
}
