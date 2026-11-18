package com.example.NutreAPP.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.NutreAPP.models.Video;
import com.example.NutreAPP.repositories.IVideoRepositorio;

@Service 
public class VideoServicio {
    //metodo para buscar por id

    //metodo para buscar todos

    //metodo para buscar para modificar

    //metodo para eliminar

    // metodo para buscar por titulo

    // metodo para buscar por descripcion

    // metodo para buscar por url
    @Autowired 
    private IVideoRepositorio repositorio;

    public Video guardar(Video datos){
       return  this.repositorio.save(datos);
    }





}
