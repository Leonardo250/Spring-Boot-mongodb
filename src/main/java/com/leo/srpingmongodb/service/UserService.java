package com.leo.srpingmongodb.service;

import com.leo.srpingmongodb.domain.User;
import com.leo.srpingmongodb.dto.UserDTO;
import com.leo.srpingmongodb.repository.UserRepository;
import com.leo.srpingmongodb.service.Exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findByID(String id) {
        return repo.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(),objDto.getName(),objDto.getEmail());
    }

    public void delete(String id){
        findByID(id);
        repo.deleteById(id);
    }

    public User update(User obj){
        User newObj = repo.findById(obj.getId()).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado! ID: " + obj.getId()));
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }
}
