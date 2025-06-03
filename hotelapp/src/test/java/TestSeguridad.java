/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.ande.luxury.hotelapp.utilsdb.Seguridad;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bryanvislaochavez
 */
public class TestSeguridad {

    public TestSeguridad() {
    }

    @Test
    public void testEncryptAndDecryptSuccess() {
        String plainPassword = "123456";

        Seguridad seguridad = new Seguridad();
        // Encriptar
        String hashed = seguridad.encrypt(plainPassword);
        System.out.print(hashed);
        assertNotNull(hashed, "La contraseña encriptada no debe ser null");

        // Verificar
        boolean isMatch = Seguridad.decrypt(plainPassword, hashed);
        assertTrue(isMatch, "La contraseña original debe coincidir con el hash");
    }

    @Test
    public void testDecryptFailure() {
        String plainPassword = "123456";
        String wrongPassword = "1234567";

        String hashed = Seguridad.encrypt(plainPassword);
        System.out.print(hashed);
        boolean isMatch = Seguridad.decrypt(wrongPassword, hashed);

        assertFalse(isMatch, "Una contraseña incorrecta no debe coincidir con el hash");
    }
    
      @Test
    public void testDecryptOk() {
        String plainPassword = "123456";
        String hash = "$2a$12$IsiWmqBOj7y7zfdDK1x1XeIIVas4OkfTsivEK0q6ePbWEcG1h28fC";
        boolean isMatch = Seguridad.decrypt(plainPassword, hash);

        assertTrue(isMatch, "La contraseña coincide");
    }


    @Test
    public void testEncryptNull() {
        String hashed = Seguridad.encrypt(null);
        assertNull(hashed, "Si se pasa null, debe devolver null");
    }

    @Test
    public void testDecryptWithInvalidHash() {
        String plainPassword = "clave";
        String invalidHash = "hash_no_valido";

        boolean result = Seguridad.decrypt(plainPassword, invalidHash);
        assertFalse(result, "No debe coincidir con un hash inválido");
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
