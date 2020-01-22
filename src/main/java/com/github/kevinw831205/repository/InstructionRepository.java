package com.github.kevinw831205.repository;

import com.github.kevinw831205.model.Instruction;
import com.github.kevinw831205.model.Template;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionRepository extends CrudRepository<Instruction, Long> {
}
