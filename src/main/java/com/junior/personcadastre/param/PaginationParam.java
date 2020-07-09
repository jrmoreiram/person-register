package com.junior.personcadastre.param;

import io.swagger.annotations.ApiParam;

/**
 * Objeto padrão de paginação.
 *
 * @author Júnior Moreira Martins
 */
public class PaginationParam {
    @ApiParam(name = "page", defaultValue = "0", value = "Número da página")
    private Integer page = 0;

    @ApiParam(name = "pageSize", defaultValue = "1000", value = "Número de informações por página")
    private Integer pageSize = 1000;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
