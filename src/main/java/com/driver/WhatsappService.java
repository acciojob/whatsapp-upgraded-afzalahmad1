package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class WhatsappService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    GroupRepository groupRepository;

    public String createUser(String name,String mobile)throws Exception{
        if (userRepository.existByMobile(mobile)){
            throw new Exception("User already exists");
        }
        User user = new User();
        user.setName(name);
        user.setMobile(mobile);
        userRepository.save(user);

        return "user added successfully";
    }

    public Group createGroup(List<User> users){
        List<User> userList = new ArrayList<>();
        Group group = new Group();
        group.setNumberOfParticipants(users.size());
        for(User user : userList){
            group.setName(user.getName());
            groupRepository.save(group);

        }

        return group;
    }

    public int createMessage(String content){
        Message message = new Message();
        message.setContent(content);
        messageRepository.save(message);
        return message.getId();
    }

    public int sendMessage(Message message, User sender, Group group){
        Message message1 = new Message();
        Group group1 = groupRepository.findById(group.getId()).get();


        return group1.getId();
    }

    public String changeAdmin(User approver, User user, Group group){
        return "yess";
    }

    public int removeUser(User user){
        return 0;
    }

    public String findMessage(Date start, Date end, int K){


        return "ss";
    }
}
