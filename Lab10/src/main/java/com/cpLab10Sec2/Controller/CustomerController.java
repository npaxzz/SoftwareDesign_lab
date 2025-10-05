package com.cpLab10Sec2.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cpLab10Sec2.DTO.CustomerRequest;
import com.cpLab10Sec2.DTO.CustomerResponse;
import com.cpLab10Sec2.service.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
	private final CustomerService service;

	public CustomerController(CustomerService service) {
		this.service = service;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CustomerResponse create(@RequestBody @Validated CustomerRequest req) {
		return service.create(req);
	}

	@GetMapping("/{id}")
	public CustomerResponse get(@PathVariable Long id) {
		return service.get(id);
	}

}
