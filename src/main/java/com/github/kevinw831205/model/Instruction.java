package com.github.kevinw831205.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Table(name = "instruction")
@Entity
public class Instruction {
    @Id
    @NotNull
    @Column(name = "instruction_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "instruction_generator")
    private Long id;

    @Column(name = "recipe_id")
//    @NotNull
    private Long recipeId;

    private String instruction;
    private Integer instructionOrder;

    public Instruction() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Long getRecipeId() {
//        return recipeId;
//    }
//
//    public void setRecipeId(Long recipeId) {
//        this.recipeId = recipeId;
//    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Integer getInstructionOrder() {
        return instructionOrder;
    }

    public void setInstructionOrder(Integer instructionOrder) {
        this.instructionOrder = instructionOrder;
    }

    public Long getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Long recipeId) {
        this.recipeId = recipeId;
    }


}
