package com.example.crud_empleados.dao;

import com.example.crud_empleados.entity.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface UsuariosDao extends CrudRepository<Usuarios, Long> {
}
