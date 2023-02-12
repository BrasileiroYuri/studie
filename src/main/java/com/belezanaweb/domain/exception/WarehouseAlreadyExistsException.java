package com.belezanaweb.domain.exception;

public class WarehouseAlreadyExistsException extends RuntimeException {

    public static final String
            WAREHOUSE_WHIT_ID_D_ALREADY_EXISTS = "Warehouse whit id %d already exists!";

    public WarehouseAlreadyExistsException(String message) {
        super(message);
    }

    public WarehouseAlreadyExistsException(Long id) {
        this(String.format(WAREHOUSE_WHIT_ID_D_ALREADY_EXISTS, id));
    }

}
