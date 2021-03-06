package ar.com.ada.api.questionados.entities;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="pregunta")
public class Pregunta {
    
    @Id
    @Column(name="pregunta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer preguntaId;

    private String enunciado;

    @ManyToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "categoria_id")
    @JsonIgnore
    private Categoria categoria;

    @OneToMany(mappedBy = "pregunta", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Respuesta> opciones= new ArrayList<>();

    public void agregarRespuesta(Respuesta respuesta){
        this.opciones.add(respuesta);
    } 

    public List<Respuesta> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Respuesta> opciones) {
        this.opciones = opciones;
    }

    public Integer getPreguntaId() {
        return preguntaId;
    }

    public void setPreguntaId(Integer preguntaId) {
        this.preguntaId = preguntaId;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
        this.categoria.agregarPregunta(this);
    }

}
