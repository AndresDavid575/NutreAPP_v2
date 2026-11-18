package com.example.NutreAPP.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NutreAPP.models.Visualizacion;
import com.example.NutreAPP.repositories.IVisualizacionRepositorio;

@Service 
public class VisualizacionServicio {
    //metodo para buscar por id

    //metodo para buscar todos

    //metodo para buscar para modificar

    //metodo para eliminar

    //metodo para buscar por fecha_visualizacion

    //metodo para buscar por completado

    @Autowired 
    private IVisualizacionRepositorio repositorio;
    public Visualizacion guardar(Visualizacion datos){
       return   this.repositorio.save(datos);

    }


}
