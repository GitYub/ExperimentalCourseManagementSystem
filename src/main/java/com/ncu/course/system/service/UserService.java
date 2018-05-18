package com.ncu.course.system.service;

import com.ncu.course.system.domain.User;
import com.ncu.course.system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service("UserService")
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional(rollbackOn = Exception.class)
    @Modifying
    public void remove(long jobNumber) throws Exception{

        userRepository.deleteById(jobNumber);

    }

    @Transactional(rollbackOn = Exception.class)
    @Modifying
    public void add(User user) {

        userRepository.save(user);

    }

    public List<User> list() {
        Iterator<User> userIterator = userRepository.findAll().iterator();
        ArrayList<User> users = new ArrayList<>();

        while (userIterator.hasNext()) {
            users.add(userIterator.next());
        }

        return users;
    }

    public void modifyPwd(long jobNumber, String password) {
        userRepository.modifyPwd(jobNumber, password);
    }

    public Optional<User> getUsername(long jobNumber) { return userRepository.findById(jobNumber); }
}
