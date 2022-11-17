package com.example.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Null;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

@Service
public class AppService {

    private static Logger logger = LoggerFactory.getLogger(AppService.class);
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
        List<GuildTable> out = guildTableRepository.findByParentidOrId(id, id);
        try {
            Map resp = Map.of(
                    "Name", Objects.requireNonNull(out.stream().filter(k -> k.getId() == id).findFirst().orElse(null)),
                    "Sub Class", out.stream().filter(k-> k.getId()!=id).collect(toList()));
            return resp;
        } catch (NullPointerException nullPointerException) {
            logger.error("No record found for : " + id);
            return Map.of();
        }
    }

    public List getAll() {
        long count = guildTableRepository.count();
        Page<GuildTable> out = guildTableRepository.findAll(PageRequest.of(0, (int)count));
        List resp = out.stream()
                .filter(k -> k.getParentid() > 0)
                .collect(Collectors.groupingBy(GuildTable::getParentid))
                .entrySet().stream()
                .map(v1 -> Map.of("Name", Objects.requireNonNull(out.stream().filter(k -> k.getId() == v1.getKey()).map(GuildTable::getName).findFirst().orElse("")),
                                  "Sub Classes", v1.getValue()))
                .collect(toList());
        return resp;
    }
}
