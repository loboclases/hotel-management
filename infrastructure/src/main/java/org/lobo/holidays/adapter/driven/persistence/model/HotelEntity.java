package org.lobo.holidays.adapter.driven.persistence.model;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("HOTEL")
public class HotelEntity {
  @Id
  @Column("id")
  private Long id;
  @Column("stars")
  private Integer stars;
  @Column("name")
  private String name;
  @Column("description")
  private String description;
  @Column("avg_valuation")
  private Float avgValuation;
  @Column("location")
  private String location;
}
