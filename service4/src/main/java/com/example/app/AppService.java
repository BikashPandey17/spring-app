package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
public class AppService {

    private static final Logger logger = LoggerFactory.getLogger(AppService.class);
    private final GuildTableRepository guildTableRepository;

    @Autowired
    public AppService(GuildTableRepository guildTableRepository) {
        this.guildTableRepository = guildTableRepository;
    }

    @LogMethodParam
    public void insertTableRow(GuildTableInsertRequest data) {
        GuildTable row = GuildTable.builder()
                .id(data.getId())
                .name(data.getName())
                .color(data.getColor())
                .parentid(data.getParentid())
                .build();

        guildTableRepository.save(row);
    }

    @LogMethodParam
    public Map getOne(int id) {
//        List<GuildTable> out = guildTableRepository.findByParentidOrId(id, id);
        long count = guildTableRepository.count();
        Page<GuildTable> out = guildTableRepository.findAll(PageRequest.of(0, (int)count));
        Map<Integer, List<GuildTable>> data = out.stream()
                .filter(k -> k.getParentid() > 0)
                .collect(Collectors.groupingBy(GuildTable::getParentid));
        try {
            Map<String, Object> resp = Map.of(
                    "Name", out.stream().filter(k -> k.getId() == id).map(GuildTable::getName).findFirst().orElse(""),
                    "Sub Class", AppService.getData(data, data.get(id)));
            return resp;
        } catch (NullPointerException nullPointerException) {
            logger.error("No record found for : " + id);
            return Map.of();
        }
    }

    public List<Map<String, Object>> getAll() {
        long count = guildTableRepository.count();
        Page<GuildTable> out = guildTableRepository.findAll(PageRequest.of(0, (int)count));
        // worst case approach

        Map<Integer, List<GuildTable>> data = out.stream()
                .filter(k -> k.getParentid() > 0)
                .collect(Collectors.groupingBy(GuildTable::getParentid));
        ArrayList<Map<String, Object>> output = new ArrayList<>();

        data.forEach((key, value) -> {
            output.add(Map.of("Name", out.stream().filter(k -> k.getId() == key).map(GuildTable::getName).findFirst().orElse(""),
                    "Sub Classes", AppService.getData(data, value)));
                });
        return output;
    }

    private static ArrayList<Map<String, Object>> getData(Map<Integer, List<GuildTable>> data, List<GuildTable> guildTables) {
        ArrayList<Map<String, Object>> out = new ArrayList<>();
        for(GuildTable guildTable: guildTables) {
            if(data.containsKey(guildTable.getId())){
                out.add(Map.of("Name", guildTable.getName(),
                        "Sub Classes", getData(data, data.get(guildTable.getId()))));
            } else {
                out.add(Map.of("Name", guildTable.getName()));
            }
        }
        return out;
    }
}
