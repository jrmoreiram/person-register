package com.junior.personcadastre.api.dto;

import java.util.Collection;

/**
 * DTO de listagem base da aplicação.
 *
 * @author Júnior Moreira Martins
 */
public abstract class CollectionBaseDTO<T extends ObjectBaseDTO> extends ObjectBaseDTO {

    /**
     * Pessoas a serem retornadas.
     */
    private Collection<T> persons;

    /**
     * Indica se possui mais pessoas na próxima página.
     */
    private boolean hasNext;

    public CollectionBaseDTO(Collection<T> items, boolean hasNext) {
        this.persons = items;
        this.hasNext = hasNext;
    }

    public CollectionBaseDTO() {
    }

    public Collection<T> getPersons() {
        return persons;
    }

    public void setPersons(Collection<T> persons) {
        this.persons = persons;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }
}