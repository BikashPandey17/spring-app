package com.example.app;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuildTableRepository extends JpaRepository<GuildTable, Integer> {
    List<GuildTable> findByParentid(int parentid);

    List<GuildTable> findByParentidOrId(int parentId, int id);
}