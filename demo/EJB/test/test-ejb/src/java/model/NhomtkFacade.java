/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import emtities.Nhomtk;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AA
 */
@Stateless
public class NhomtkFacade extends AbstractFacade<Nhomtk> {
    @PersistenceContext(unitName = "test-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NhomtkFacade() {
        super(Nhomtk.class);
    }
    
}
