package com.example.app;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GuildTable {
    @Id
    private Integer id;
    private Integer parentid;
    private String name;
    private String color;
}
