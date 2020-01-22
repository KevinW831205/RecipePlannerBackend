package com.github.kevinw831205.service;

import com.github.kevinw831205.model.Instruction;
import com.github.kevinw831205.repository.InstructionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstructionService {
    private InstructionRepository instructionRepository;

    @Autowired
    public InstructionService(InstructionRepository instructionRepository) {
        this.instructionRepository = instructionRepository;
    }

    public Iterable<Instruction> findAll() {
        return instructionRepository.findAll();
    }

    public Instruction findById(Long id){
        return instructionRepository.findById(id).get();
    }

    public Instruction create(Instruction instruction){
        return instructionRepository.save(instruction);
    }

    public Instruction update(Long id, Instruction instruction) {
        Instruction instructionInDatabase = findById(id);
        if(instructionInDatabase == null){
            return null;
        }
        instructionRepository.save(instruction);
        return instruction;
    }

    public Instruction delete(Long id) {
        Instruction instruction = findById(id);
        instructionRepository.delete(instruction);
        return instruction;
    }
}
