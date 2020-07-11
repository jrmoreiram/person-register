package com.junior.personcadastre.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
@Getter
@Setter
@ToString
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int personId;
    private String firstName;
    private String lastName;
    private int personAge;

    /**
     * Builder para classe {@link Person}
     *
     * @author Júnior Moreira Martins
     */
    public static final class PersonBuilder {

        private Person entity;

        private PersonBuilder() {
            entity = new Person();
        }

        public static PersonBuilder of() {
            return new PersonBuilder();
        }

        public PersonBuilder personId(int personId) {
            entity.setPersonId(personId);
            return this;
        }

        public PersonBuilder firstName(String firstName) {
            entity.setFirstName(firstName);
            return this;
        }

        public PersonBuilder lastName(String lastName) {
            entity.setLastName(lastName);
            return this;
        }

        public PersonBuilder personAge(int personAge) {
            entity.setPersonAge(personAge);
            return this;
        }

        public Person build() {
            return entity;
        }
    }
}