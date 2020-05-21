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
import entidades.Grupo;
import sessionbean.GrupoSBean;


/**
 *
 * @author Cirim
 */
@FacesConverter("grupoConverter")
public class GrupoConverter implements Converter{

    private GrupoSBean grupoSBean;
    private Grupo grupo = null;  
    

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value != null && value.trim().length() > 0){
            Long id = Long.parseLong(value);
            grupo = grupoSBean.pesquisar(id);
        }
        return grupo;
    }

    @Override
    public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
        
        if(value != null){
            grupo = (Grupo) value;
            return grupo.getId().toString();
        }
    return null;
    }

    public GrupoSBean getGrupoSBean() {
        return grupoSBean;
    }

    public void setGrupoSBean(GrupoSBean grupoSBean) {
        this.grupoSBean = grupoSBean;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

   
   
 
}
