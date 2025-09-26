package com.lucas.back;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.lucas.back.entity.Employee;
import com.lucas.back.entity.Tool;
import com.lucas.back.repository.EmployeeRepository;
import com.lucas.back.repository.ToolRepository;

@SpringBootApplication
public class BackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}


	// Inicializa o banco de dados com alguns dados de exemplo (apenas para testes, excluir em produção)
	@Bean
	CommandLineRunner initDataBase(ToolRepository toolRepository, EmployeeRepository employeeRepository) {
		return args -> { 
			toolRepository.deleteAll();
			employeeRepository.deleteAll();
			Employee employee = new Employee();
			employee.setName("Lucas");
			employeeRepository.save(employee);
			employee = new Employee();
			employee.setName("Pedro");
			employeeRepository.save(employee);
			employee = new Employee();
			employee.setName("João");
			employeeRepository.save(employee);

			Tool tool = new Tool();
			tool.setName("Alicate");
			tool.setAvailable(true);
			toolRepository.save(tool);
			tool = new Tool();
			tool.setName("Martelo");
			tool.setAvailable(true);
			toolRepository.save(tool);
			tool = new Tool();
			tool.setName("Chave de fenda");
			tool.setAvailable(true);
			toolRepository.save(tool);
			
		};
	}

}
