package ru.otus.demo.persistence.entitites;

import jakarta.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Item extends AbstractPersistableEntity {

    private String name;

    private LocalDate added;

    private boolean available;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item item)) return false;
        if (!super.equals(o)) return false;
        return available == item.available && name.equals(item.name) && added.equals(item.added);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, added, available);
    }

}