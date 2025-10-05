package com.cpLab10Sec2.DTO;

public record CustomerResponse(Long id, String name, String email, AddressResponse address) {
}
