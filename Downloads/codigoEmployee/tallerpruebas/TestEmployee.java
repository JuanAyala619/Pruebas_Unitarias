package tallerpruebas;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

public class TestEmployee {
	
    private static final float RMU = 386.0f;

    // ---- Helpers ----
    private float decimoBimestral() { return RMU / 12f * 2f; }  
    private boolean esMesPar() { return LocalDate.now().getMonthValue() % 2 == 0; }

    //Worker 
    @Test
    @DisplayName("Worker | USD | mes PAR → sin décimo")
    void worker_usd_par_sin_decimo() {
        assumeTrue(esMesPar(), "Este test corre solo si el mes actual es PAR");
        Employee e = new Employee(1000f, "USD", 0f, EmployeeType.Worker);
        assertEquals(1000f, e.cs(), 0.001f);
    }

    @Test
    @DisplayName("Worker | USD | mes IMPAR → con décimo")
    void worker_usd_impar_con_decimo() {
        assumeTrue(!esMesPar(), "Este test corre solo si el mes actual es IMPAR");
        Employee e = new Employee(1000f, "USD", 0f, EmployeeType.Worker);
        assertEquals(1000f + decimoBimestral(), e.cs(), 0.001f);
    }

    @Test
    @DisplayName("Worker | EUR (≠USD) | mes PAR → 0.95*salario")
    void worker_no_usd_par() {
        assumeTrue(esMesPar(), "Solo mes PAR");
        Employee e = new Employee(1000f, "EUR", 0f, EmployeeType.Worker);
        assertEquals(1000f * 0.95f, e.cs(), 0.001f);
    }

    @Test
    @DisplayName("Worker | EUR (≠USD) | mes IMPAR → 0.95*salario + décimo")
    void worker_no_usd_impar() {
        assumeTrue(!esMesPar(), "Solo mes IMPAR");
        Employee e = new Employee(1000f, "EUR", 0f, EmployeeType.Worker);
        assertEquals(1000f * 0.95f + decimoBimestral(), e.cs(), 0.001f);
    }

    // Supervisor
    @ParameterizedTest(name = "Supervisor | USD | bonus={0} | mes PAR → 1000 + 0.35*bonus")
    @CsvSource({"0", "100", "250"})
    void supervisor_usd_par(float bonus) {
        assumeTrue(esMesPar(), "Solo mes PAR");
        Employee e = new Employee(1000f, "USD", bonus, EmployeeType.Supervisor);
        assertEquals(1000f + 0.35f * bonus, e.cs(), 0.001f);
    }

    @ParameterizedTest(name = "Supervisor | USD | bonus={0} | mes IMPAR → 1000 + 0.35*bonus + décimo")
    @CsvSource({"0", "100", "250"})
    void supervisor_usd_impar(float bonus) {
        assumeTrue(!esMesPar(), "Solo mes IMPAR");
        Employee e = new Employee(1000f, "USD", bonus, EmployeeType.Supervisor);
        assertEquals(1000f + 0.35f * bonus + decimoBimestral(), e.cs(), 0.001f);
    }

    @Test
    @DisplayName("Supervisor | EUR | mes PAR → 0.95*salario + 0.35*bonus")
    void supervisor_no_usd_par() {
        assumeTrue(esMesPar(), "Solo mes PAR");
        Employee e = new Employee(1200f, "EUR", 100f, EmployeeType.Supervisor);
        assertEquals(1200f * 0.95f + 0.35f * 100f, e.cs(), 0.001f);
    }

    @Test
    @DisplayName("Supervisor | EUR | mes IMPAR → 0.95*salario + 0.35*bonus + décimo")
    void supervisor_no_usd_impar() {
        assumeTrue(!esMesPar(), "Solo mes IMPAR");
        Employee e = new Employee(1200f, "EUR", 100f, EmployeeType.Supervisor);
        assertEquals(1200f * 0.95f + 0.35f * 100f + decimoBimestral(), e.cs(), 0.001f);
    }

    //  Manager 
    @ParameterizedTest(name = "Manager | USD | bonus={0} | mes PAR → 1500 + 0.7*bonus")
    @CsvSource({"0", "50", "300"})
    void manager_usd_par(float bonus) {
        assumeTrue(esMesPar(), "Solo mes PAR");
        Employee e = new Employee(1500f, "USD", bonus, EmployeeType.Manager);
        assertEquals(1500f + 0.7f * bonus, e.cs(), 0.001f);
    }

    @ParameterizedTest(name = "Manager | USD | bonus={0} | mes IMPAR → 1500 + 0.7*bonus + décimo")
    @CsvSource({"0", "50", "300"})
    void manager_usd_impar(float bonus) {
        assumeTrue(!esMesPar(), "Solo mes IMPAR");
        Employee e = new Employee(1500f, "USD", bonus, EmployeeType.Manager);
        assertEquals(1500f + 0.7f * bonus + decimoBimestral(), e.cs(), 0.001f);
    }

    @Test
    @DisplayName("Manager | EUR | mes PAR → 0.95*salario + 0.7*bonus")
    void manager_no_usd_par() {
        assumeTrue(esMesPar(), "Solo mes PAR");
        Employee e = new Employee(1500f, "EUR", 200f, EmployeeType.Manager);
        assertEquals(1500f * 0.95f + 0.7f * 200f, e.cs(), 0.001f);
    }

    @Test
    @DisplayName("Manager | EUR | mes IMPAR → 0.95*salario + 0.7*bonus + décimo")
    void manager_no_usd_impar() {
        assumeTrue(!esMesPar(), "Solo mes IMPAR");
        Employee e = new Employee(1500f, "EUR", 200f, EmployeeType.Manager);
        assertEquals(1500f * 0.95f + 0.7f * 200f + decimoBimestral(), e.cs(), 0.001f);
    }

    // Test independiente del mes 
    @Test
    @DisplayName("Supervisor | EUR → válido en PAR o IMPAR (sin assumptions)")
    void supervisor_no_usd_independiente_del_mes() {
        Employee e = new Employee(1200f, "EUR", 100f, EmployeeType.Supervisor);

        float base = 1200f * 0.95f;
        float conBono = base + 0.35f * 100f;
        float sinDecimo = conBono;
        float conDecimo = conBono + decimoBimestral();

        float real = e.cs();
        assertTrue(real == sinDecimo || real == conDecimo,
                "Debe coincidir con mes PAR (sin décimo) o IMPAR (con décimo)");
    }
	
	
}

