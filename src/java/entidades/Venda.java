/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Cirim
 */
@Entity
@Table(name = "venda", schema = "sigebootstrap")
@NamedQueries({
@NamedQuery(
          name = "Venda.findByCliente",
            query = "SELECT v FROM Venda v WHERE v.cliente LIKE :cliente"
    ),
    @NamedQuery(
          name = "Venda.findByDataVenda",
            query = "SELECT v FROM Venda v WHERE v.dataVenda = :dataVenda"
    )
})


public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_venda")
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @Column(name = "valor_total")
    private Double valorTotal;
    
    @OneToMany
    private List<ItemVenda> itens;
    
    public void addItenVenda(ItemVenda itemVenda){
        this.itens.add(itemVenda);
    }
    
    public void venda(){
        this.itens = new ArrayList<>();
    }
    
    public void removerItemVenda(ItemVenda itemVenda){
        this.itens.add(itemVenda);
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Venda[ id=" + id + " ]";
    }
    
}
