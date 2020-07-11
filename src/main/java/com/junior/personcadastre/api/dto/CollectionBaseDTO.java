package com.junior.personcadastre.api.dto;

import java.util.Collection;

/**
 * DTO base application list.
 *
 * @author Júnior Moreira Martins
 */
public abstract class CollectionBaseDTO<T extends ObjectBaseDTO> extends ObjectBaseDTO {

    /**
     * People to be returned.
     */
    private Collection<T> persons;

    /**
     * Indicates if you have more people on the next page.
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