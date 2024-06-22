package Datos;

import Actores.Alumno;
import Actores.Docente;
import Actores.Administrativo;

import java.util.ArrayList;
import java.util.List;

public class RegistroActor {
    private List<Alumno> alumnos;
    private List<Docente> docentes;
    private List<Administrativo> administrativos;

    public RegistroActor() {
        alumnos = new ArrayList<>();
        docentes = new ArrayList<>();
        administrativos = new ArrayList<>();
    }

    public void registrarAlumno(Alumno alumno) {
        alumnos.add(alumno);
    }

    public void registrarDocente(Docente docente) {
        docentes.add(docente);
    }

    public void registrarAdministrativo(Administrativo administrativo) {
        administrativos.add(administrativo);
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public List<Docente> getDocentes() {
        return docentes;
    }

    public List<Administrativo> getAdministrativos() {
        return administrativos;
    }

    public void listarAlumnos() {
        for (Alumno alumno : alumnos) {
            System.out.println(alumno);
        }
    }

    public void listarDocentes() {
        for (Docente docente : docentes) {
            System.out.println(docente);
        }
    }

    public void listarAdministrativos() {
        for (Administrativo administrativo : administrativos) {
            System.out.println(administrativo);
        }
    }
}

