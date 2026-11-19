package com.example.NutreAPP.validations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import com.example.NutreAPP.models.Usuario;
import com.example.NutreAPP.repositories.IUsuarioRepositorio;

@Component 
public class UsuarioValidacion {

    @Autowired
    private IUsuarioRepositorio repositorio;

    // validaciones de formato

    // 1. validar que un campo sea obligatorio
    public void validarTextoObligatorio(String valor, String campo) {
        if (valor == null || valor.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El campo " + campo + " es obligatorio");
        }
    }

    // .2 validar la longitud de un nombre
    public void validarNombre(String nombre) {
        if (nombre.trim().length() < 3 || nombre.trim().length() > 100) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre debe tener 3 y 100 caracteres");
        }
    }

    /// 3. EXPRESIONES REGULARES PARA VALIDAR QUE UN CORREO SI SEA UN CORREO
    // algo@algo.algo
    public void validarCorreo(String correo) {
        if (correo.matches("^[\\w.+-]+@[\\w-]+\\.[\\w.]+$")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El correo no cumple el formato esperado");
        }
    }

    //// 4. validar que la contraseña tenga minimo 8 caracteres
    public void validarContraseña(String contraseña) {
        if (contraseña.length() < 8) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"La contraeña debe ser mas grande de 8 caracteres");
        }
    }

    // validaciones del negocio

    // 1. validar que el correo de un usuario que se requiere registar no exista en
    // la BD
    public void validarUsuarioNuevo(Usuario datos) {
        String correoEntregado = datos.getCorreo();
        this.repositorio.existsByCorreo(correoEntregado);
        if(this.repositorio.existsByCorreo(correoEntregado)){
             throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El correo entregado ya existe en BD");
        }
    }

        // --- VALIDACIONES DE VIDEO ---

    // V1. Título obligatorio y entre 5 y 120 caracteres.
    public void validarTituloVideo(String titulo) {
        if (titulo == null || titulo.trim().length() < 5 || titulo.trim().length() > 120) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "V1. El título debe tener entre 5 y 120 caracteres.");
        }
    }

    // V2. La URL es obligatoria y debe empezar por "http://" o "https://".
    public void validarUrlVideo(String url) {
        if (url == null || (!url.startsWith("http://") && !url.startsWith("https://"))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "V2. La URL es obligatoria y debe empezar por http:// o https://");
        }
    }

    // V3. La categoría es obligatoria (no puede llegar null).
    public void validarCategoriaVideo(String categoria) {
        if (categoria == null || categoria.isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "V3. La categoría es obligatoria.");
        }
    }

    // V4. La descripción es opcional, pero si viene no puede superar 500 caracteres.
    public void validarDescripcionVideo(String descripcion) {
        if (descripcion != null && descripcion.length() > 500) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "V4. La descripción no puede superar los 500 caracteres.");
        }
    }

    // --- VALIDACIONES DE VISUALIZACION ---

    // V1. La fecha de visualización es obligatoria.
    public void validarFechaVisualizacion(java.time.LocalDate fecha) {
        if (fecha == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "V1. La fecha de visualización es obligatoria.");
        }
    }

    // V2. La fecha no puede ser futura.
    public void validarFechaNoFutura(java.time.LocalDate fecha) {
        if (fecha != null && fecha.isAfter(java.time.LocalDate.now())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "V2. La fecha no puede ser futura.");
        }
    }

    // V3. El campo completado es obligatorio.
    public void validarCompletado(Boolean completado) {
        if (completado == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "V3. El campo completado es obligatorio.");
        }
    }

}
