package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppService {

    private static Logger logger = LoggerFactory.getLogger(AppService.class);
    private final GuildTableRepository guildTableRepository;

    @Autowired
    public AppService(GuildTableRepository guildTableRepository) {
        this.guildTableRepository = guildTableRepository;
    }

    public void insertTableRow(GuildTableInsertRequest data) {
        GuildTable row = GuildTable.builder()
                .name(data.getName())
                .color(data.getColor())
                .parentid(data.getParentid())
                .build();

        guildTableRepository.save(row);
    }
}
