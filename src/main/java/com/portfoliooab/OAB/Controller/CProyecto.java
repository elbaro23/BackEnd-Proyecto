package com.portfoliooab.OAB.Controller;

import com.portfoliooab.OAB.Dto.dtoProyecto;
import com.portfoliooab.OAB.Entity.Proyecto;
import com.portfoliooab.OAB.Security.Controller.Mensaje;
import com.portfoliooab.OAB.Service.SProyecto;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = {"https://frontend-oab.web.app", "http://localhost:4200"})
public class CProyecto {
    @Autowired
    SProyecto sProyecto;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Proyecto>> list() {
        List<Proyecto> list = sProyecto.list();
        return new ResponseEntity(list, HttpStatus.OK);   
    }
    
    @GetMapping("/detail/{id}")
    public ResponseEntity<Proyecto> getById(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        Proyecto proyecto = sProyecto.getOne(id).get();
        return new ResponseEntity(proyecto, HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        sProyecto.delete(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado"), HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoProyecto dtoproyecto) {
        //El Nombre es obligatorio
        if (StringUtils.isBlank(dtoproyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        //El Nombre no se puede repetir
        if (sProyecto.existsByNombreP(dtoproyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        //La Descripcion es obligatorio
        if (StringUtils.isBlank(dtoproyecto.getDescripcionP())) {
            return new ResponseEntity(new Mensaje("La descripción es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        Proyecto proyecto = new Proyecto(
                dtoproyecto.getNombreP(), 
                dtoproyecto.getDescripcionP(), 
                dtoproyecto.getPeriodoP(), 
                dtoproyecto.getLinkP(), 
                dtoproyecto.getImgP());
        sProyecto.save(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto creada"), HttpStatus.OK);

    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody dtoProyecto dtoproyecto) {
        //Validamos si existe el ID
        if (!sProyecto.existsById(id)) {
            return new ResponseEntity(new Mensaje("No existe el ID"), HttpStatus.NOT_FOUND);
        }
        //Compara nombre de experiencias
        if (sProyecto.existsByNombreP(dtoproyecto.getNombreP()) && sProyecto.getByNombreP(dtoproyecto.getNombreP()).get().getId() != id) {
            return new ResponseEntity(new Mensaje("Ese nombre ya existe"), HttpStatus.BAD_REQUEST);
        }
        //El Nombre es obligatorio
        if (StringUtils.isBlank(dtoproyecto.getNombreP())) {
            return new ResponseEntity(new Mensaje("El campo no puede estar vacio"), HttpStatus.BAD_REQUEST);
        }
        //La Descripción es obligatorio
        if (StringUtils.isBlank(dtoproyecto.getDescripcionP())) {
            return new ResponseEntity(new Mensaje("La Descripción es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        Proyecto proyecto = sProyecto.getOne(id).get();
        proyecto.setNombreP(dtoproyecto.getNombreP());
        proyecto.setDescripcionP(dtoproyecto.getDescripcionP());
        proyecto.setPeriodoP(dtoproyecto.getPeriodoP());
        proyecto.setLinkP(dtoproyecto.getLinkP());
        proyecto.setImgP(dtoproyecto.getImgP());

        sProyecto.save(proyecto);

        return new ResponseEntity(new Mensaje("Proyecto actualizada"), HttpStatus.OK);
    }
}
