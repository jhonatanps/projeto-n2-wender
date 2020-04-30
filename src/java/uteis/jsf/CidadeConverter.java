/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uteis.jsf;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import entidades.Cidade;
import sessionbean.CidadeSBean;


/**
 *
 * @author Cirim
 */
@FacesConverter("cidadeConverter")
public class CidadeConverter implements Converter{

    private CidadeSBean cidadeSBean;
    private Cidade cidade = null;  
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value != null && value.trim().length() > 0){
            Long id = Long.parseLong(value);
            cidade = cidadeSBean.pesquisar(id);
        }
        return cidade;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
        
        if(value != null){
            cidade = (Cidade) value;
            return cidade.getId().toString();
        }
    return null;
    }

    public CidadeSBean getCidadeSBean() {
        return cidadeSBean;
    }

    public void setCidadeSBean(CidadeSBean cidadeSBean) {
        this.cidadeSBean = cidadeSBean;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }
 
}
