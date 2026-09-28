package edu.wctc.distjavazodiac.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="calendar_month")
public class Month {
    @Id
    @Column(name="num")
    private int num;

    @Column(name="nm")
    private String name;
}
