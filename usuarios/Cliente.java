package usuarios;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import tareas.Habito;

public class Cliente extends Usuario {
    private String fechaNacimiento;
    private int puntos;
    private List<Habito> habitos;
    private List<String> logros;
    private List<String> items;

    public Cliente(String nombre, String email, int id, String fechaNacimiento, int puntos) {
        super(nombre, email, id);
        this.fechaNacimiento = fechaFormato(fechaNacimiento);
        this.puntos = puntos;
        this.logros = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    public int getPuntos() {
        return puntos;
    }

    public void agregarPuntos(int pts) {
        if (pts > 0) {
            this.puntos += pts;
        }
    }

    public void restarPuntos(int pts) {
        if (pts > 0 && pts <= puntos) {
            this.puntos -= pts;
        }
    }

    public void agregarLogro(String logro) {
        logros.add(logro);
    }

    public void agregarItem(String item) {
        items.add(item);
    }

    public List<String> getLogros() {
        return logros;
    }

    public List<String> getItems() {
        return items;
    }

    public String fechaFormato(String fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaNacimiento = formato.parse(fecha);
            return formato.format(fechaNacimiento);
        } catch (Exception e) {
            return "Fecha Inválida";
        }
    }
}