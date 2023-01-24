package org.lobo.holidays.adapter.driven.persistence.model;

import lombok.Data;
import nonapi.io.github.classgraph.json.Id;
import org.lobo.holidays.domain.Guest;
import org.lobo.holidays.domain.ValuationStatus;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("VALUATION")
public class ValuationEntity {
  @Id
  @Column("id")
  private Long id;
  @Column("value")
  private Float value;
  @Column("comment")
  private String comment;
  @Column("author_id")
  private Long authorId;
  @Column("status")
  private ValuationStatus status;
  @Column("hotel_id")
  private Long hotelId;
}
