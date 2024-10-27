package ru.clevertec.controller;

import com.google.gson.Gson;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.clevertec.dto.UserDto;
import ru.clevertec.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserController", urlPatterns = "/users")
@RequiredArgsConstructor
@Slf4j
public class UserController extends HttpServlet {
    private final UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        log.info("UserController inited");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        String username = request.getParameter("username");
        UserDto userDto = new UserDto(id, username);
        UserDto savedUser = userService.saveUser(userDto);
        String json = new Gson().toJson(savedUser);
        response.getWriter().write(json);
        response.setStatus(HttpServletResponse.SC_CREATED);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        List<UserDto> users = userService.findAllUsers();
        String json = new Gson().toJson(users);
        response.getWriter().write(json);
        response.setStatus(HttpServletResponse.SC_OK);
    }
}