
package com.m2i.tp.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour euroToFranc complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="euroToFranc">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="montantEuro" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "euroToFranc", propOrder = {
    "montantEuro"
})
public class EuroToFranc {

    protected double montantEuro;

    /**
     * Obtient la valeur de la propriété montantEuro.
     * 
     */
    public double getMontantEuro() {
        return montantEuro;
    }

    /**
     * Définit la valeur de la propriété montantEuro.
     * 
     */
    public void setMontantEuro(double value) {
        this.montantEuro = value;
    }

}
