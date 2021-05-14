package occ.ues.edu.sv.ingenieria.mongo_springboot.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;

@Document("gasto")
public class Gasto {
    @Id
    private String id;

    @Field(name="nombre")
    @Indexed(unique = true)
    private String nombreGasto;

    @Field(name= "categoria")
    private GastoCategoria gastoCategoria;

    @Field(name="total")
    private BigDecimal totalGasto;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreGasto() {
        return nombreGasto;
    }

    public void setNombreGasto(String nombreGasto) {
        this.nombreGasto = nombreGasto;
    }

    public GastoCategoria getGastoCategoria() {
        return gastoCategoria;
    }

    public void setGastoCategoria(GastoCategoria gastoCategoria) {
        this.gastoCategoria = gastoCategoria;
    }

    public BigDecimal getTotalGasto() {
        return totalGasto;
    }

    public void setTotalGasto(BigDecimal totalGasto) {
        this.totalGasto = totalGasto;
    }
}
