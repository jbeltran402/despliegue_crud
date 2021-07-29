package com.example.crud_empleados.controller;


import com.example.crud_empleados.entity.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.PrintStream;
import java.util.Collections;

@RestController
public class Controller {

    @GetMapping("/hola")
    public String hola(){
        return "Hola mundo tortuoso de spring";
    }

    @Autowired
    private com.example.crud_empleados.dao.UsuariosDao UsuariosDao;

    @GetMapping("/empleados")
    public Iterable<Usuarios> getUsuario(){
        return UsuariosDao.findAll();
    }

    @GetMapping(value = "/empleados/{id}")
    public Iterable<Usuarios> getUsuarioById(@PathVariable("id") Long id)
    {
        return UsuariosDao.findAllById(Collections.singleton(id));
    }

    @PostMapping("/empleados")
    public PrintStream addUsuario(@RequestBody Usuarios usuarios)
    {
     try {
         UsuariosDao.save(usuarios);
     }catch (Exception e){
         return System.out.printf(String.valueOf(usuarios));
     }
        return System.out.printf("ok");
     }


    @PutMapping(value = "/empleados/{id}")
    public Iterable<Usuarios> editUsuario(@PathVariable("id") Long id, @RequestBody Usuarios usuarios){
        usuarios.setId(id);
        UsuariosDao.save(usuarios);
        return UsuariosDao.findAllById(Collections.singleton(id));
    }

    @DeleteMapping(value = "/{id}")
    public Iterable<Usuarios> deleteUsuario(@PathVariable("id") Long id ){
        UsuariosDao.deleteById(id);
        return UsuariosDao.findAll();
    }
}





/*Usuarios usuarios = getUsuarioById(id);
        usuarios.setEstado(false);
        UsuariosDao.save(usuarios);*/
