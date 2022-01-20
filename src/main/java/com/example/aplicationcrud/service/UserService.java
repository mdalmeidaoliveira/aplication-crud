package com.example.aplicationcrud.service;

import com.example.aplicationcrud.model.User;
import com.example.aplicationcrud.repository.UserRepository;
import com.example.aplicationcrud.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

@Service
public class UserService implements Serializable {
    private static final long serialVersionUID = 1L;

    @Autowired
    private UserRepository userRepository;

    // Lista todos usuários cadastrados
    public List<User> findAll(){
        return userRepository.findAll();
    }

    // Encontra usuário por id
    // função do tipo supplier arrow funccion(função lambida) não recebe argumentos
    public User findById(Integer id){
        return userRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("ID:" + id + " NOT FOUND!"));
    }

    // Salva usuário
    public User save(User obj){
        return userRepository.save(obj);
    }

    public void delete(Integer id){
        userRepository.deleteById(id);
    }
}
