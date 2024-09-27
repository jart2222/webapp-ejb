package org.aguzman.webapp.ejb.service;


import jakarta.ejb.Stateful;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;
import org.aguzman.webapp.ejb.models.Producto;

import java.util.ArrayList;
import java.util.List;

//@RequestScoped
@Stateless  //un objeto distinto por cliente
//@Stateless //sin estado, es decir que es un objeto para todos los clientes, y no importa el contexto cdi
public class ServiceEjb implements ServiceEjbLocal {
    private int contador;
    public String saludar(String nombre){
        System.out.println("imprimiendo dentro del ejb con instancia: "+this);
        contador++;
        System.out.println("Valor del contador en metodo saludar: "+ contador);
        return "Hola que tal "+ nombre;
    }

    @Override
    public List<Producto> listar() {
        List<Producto> productos=new ArrayList<>();
        productos.add(new Producto("peras"));
        productos.add(new Producto("manzanas"));
        productos.add(new Producto("naranjas"));
        return productos;
    }

    @Override
    public Producto crear(Producto producto) {
        System.out.println("Guardando productos ..."+ producto);
        Producto p= new Producto();
        p.setNombre(producto.getNombre());
        return p;
    }
}
