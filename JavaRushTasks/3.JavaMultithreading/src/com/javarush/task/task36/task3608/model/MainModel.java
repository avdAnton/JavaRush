package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.model.ModelData;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class MainModel implements Model {
    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    public void loadDeletedUsers() {
        modelData.setDisplayDeletedUserList(true);
        modelData.setUsers(userService.getAllDeletedUsers());
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    @Override
    public void deleteUserById(long id) {
        userService.deleteUser(id);
        modelData.setUsers(getAllUsers());
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        userService.createOrUpdateUser(name, id, level);
        modelData.setUsers(getAllUsers());
    }

    @Override
    public ModelData getModelData() {
        return this.modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setUsers(getAllUsers());
        modelData.setDisplayDeletedUserList(false);
    }

    private List<User> getAllUsers() {
        return userService.filterOnlyActiveUsers(userService.getUsersBetweenLevels(1, 100));
    }
}
