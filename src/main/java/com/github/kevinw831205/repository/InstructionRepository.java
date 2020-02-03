package com.github.kevinw831205.repository;

import com.github.kevinw831205.model.Instruction;
import com.github.kevinw831205.model.Template;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructionRepository extends CrudRepository<Instruction, Long> {
    @Query("select i from Instruction i where i.recipeId like ?1")
    List<Instruction> findAllByRecipeId(Long id);
}
