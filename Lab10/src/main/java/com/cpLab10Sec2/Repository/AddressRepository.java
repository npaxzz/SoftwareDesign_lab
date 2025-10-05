package com.cpLab10Sec2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cpLab10Sec2.Entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {
}