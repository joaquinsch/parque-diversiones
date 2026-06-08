package com.hackacode.parque_diversiones.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class VentaTests {

    @Test
    public void deberiaCrearseConLaEntradaAsociada() {
        Venta venta = new Venta();
        venta.setId_venta(1L);
        Assertions.assertEquals(1L, venta.getId_venta());
    }
}
