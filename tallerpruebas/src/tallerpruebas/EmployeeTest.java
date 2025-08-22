package tallerpruebas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import java.time.LocalDate;
import java.time.Month;

import org.junit.Test;
public class EmployeeTest {
	@Test
	public void CalculateYearBonusTestWorker() {
	    Employee emp = new Employee(1200f, "USD", 0f, EmployeeType.Worker);
	    assertEquals((float)386.0, emp.CalculateYearBonus(),0.001);
	}
	@Test
	public void CalculateYearBonusTestSupervisorUSD() {
	    Employee emp = new Employee(1500f, "USD", 0f, EmployeeType.Supervisor);
	    float expected = 1500f +(float)386.0 * 0.5F;
	    assertEquals(expected, emp.CalculateYearBonus(), 0.001);
	}
	@Test
	public void CalculateYearBonusTestSupervisorNoUSD() {
	    Employee emp = new Employee(1500f, "EUR", 0f, EmployeeType.Supervisor); 
	    float expected = 1500f * 0.95f + (float)386.0 * 0.5F;
	    assertEquals(expected, emp.CalculateYearBonus(), 0.001);
	}
	@Test
	public void CalculateYearBonusTestManagerUSD() {
	    Employee emp = new Employee(2000f, "USD", 0f, EmployeeType.Manager);
	    float expected = 2000f + (float)386.0;
	    assertEquals(expected, emp.CalculateYearBonus(), 0.001);
	}
	@Test
	public void alculateYearBonusTestManagerNoUSD() {
		Employee emp = new Employee(2000f, "EUR", 0f, EmployeeType.Manager);
		  float expected = 2000f * 0.95f + (float)386.0;
		  assertEquals(expected, emp.CalculateYearBonus(), 0.001);
	}
}
