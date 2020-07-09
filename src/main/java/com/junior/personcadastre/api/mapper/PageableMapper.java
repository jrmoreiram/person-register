package com.junior.personcadastre.api.mapper;

import com.junior.personcadastre.api.param.PaginationParam;
import com.junior.personcadastre.api.param.SortParam;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * @author Júnior Moreira Martins
 */
public class PageableMapper {
    public static Pageable paramsToPageable(PaginationParam pagination, SortParam sort) {
        return PageRequest.of(pagination.getPage(), pagination.getPageSize(), PageableMapper.orderToSort(sort));
    }

    public static Sort orderToSort(SortParam items) {
        if (items.getPersons() != null) {
            String direction = items.getDirection() == null ? "ASC" : items.getDirection().toUpperCase();
            direction = !direction.equals("ASC") && !direction.equals("DESC") ? "ASC" : direction;

            return Sort.by(Sort.Direction.valueOf(direction), items.getPersons().toArray(new String[0]));
        } else {
            return Sort.unsorted();
        }
    }
}
