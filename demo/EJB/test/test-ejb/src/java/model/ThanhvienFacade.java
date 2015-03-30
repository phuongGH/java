/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import emtities.Thanhvien;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author AA
 */
@Stateless
public class ThanhvienFacade extends AbstractFacade<Thanhvien> {
    @PersistenceContext(unitName = "test-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ThanhvienFacade() {
        super(Thanhvien.class);
    }
    
}
