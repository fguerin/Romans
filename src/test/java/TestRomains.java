import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class TestRomains {

    private Romains romains;

    @Before
    public void setUp() {
        romains = new Romains();
    }

    @Test
    public void leChiffreRomainIDevraitDonner1() {
        int nombre = romains.enNombreArabe("I");

        assertThat(nombre).isEqualTo(1);
    }

    @Test
    public void leChiffreRomainIIDevraitDonner2() {
        int nombre = romains.enNombreArabe("II");

        assertThat(nombre).isEqualTo(2);
    }

    @Test
    public void leChiffreRomainVDevraitDonner5() {
        int nombre = romains.enNombreArabe("V");

        assertThat(nombre).isEqualTo(5);
    }

    @Test
    public void leChiffreRomainXDevraitDonner10() {
        int nombre = romains.enNombreArabe("X");

        assertThat(nombre).isEqualTo(10);
    }

    @Test
    public void leChiffreRomainVIDevraitDonner6() {
        int nombre = romains.enNombreArabe("VI");

        assertThat(nombre).isEqualTo(6);
    }

    @Test
    public void leChiffreRomainIVDevraitDonner4() {
        int nombre = romains.enNombreArabe("IV");

        assertThat(nombre).isEqualTo(4);
    }

    @Test
    public void leChiffreRomainXLIXDevraitDonner49() {
        int nombre = romains.enNombreArabe("XLIX");

        assertThat(nombre).isEqualTo(49);
    }

    @Test
    public void leChiffreRomainCCCXLVIDevraitDonner346() {
        int nombre = romains.enNombreArabe("CCCXLVI");

        assertThat(nombre).isEqualTo(346);
    }

    @Test
    public void leChiffreRomainCCCXCIXDevraitDonner399() {
        int nombre = romains.enNombreArabe("CCCXCIX");

        assertThat(nombre).isEqualTo(399);
    }

    @Test
    public void leChiffreRomainXCIXDevraitDonner99() {
        int nombre = romains.enNombreArabe("XCIX");

        assertThat(nombre).isEqualTo(99);
    }

    @Test
    public void leChiffreRomainMMMMDCCCLXXXVIIIDevraitDonner4888() {
        int nombre = romains.enNombreArabe("MMMMDCCCLXXXVIII");

        assertThat(nombre).isEqualTo(4888);
    }

    @Test(expected = IllegalArgumentException.class)
    public void leChiffreRomainICDevraitDonnerUneException() {
        romains.enNombreArabe("IC");
        romains.enNombreArabe("ID");
        romains.enNombreArabe("IM");
        romains.enNombreArabe("XD");
        romains.enNombreArabe("XM");
    }
}
