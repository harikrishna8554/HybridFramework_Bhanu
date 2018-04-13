package excelTutorial.excellTest;

import java.io.IOException;

import org.testng.annotations.Test;

import excelTutorial.UpdateSeleniumTestReportInExcelSheetJavaCode_1;

public class ExcellTest1 {
	
	@Test
	public void testExcellTest1() throws Exception
	{
		String excellocation="C:\\Users\\Harikrishna\\Desktop\\excellTutorial\\excellTutorial.xlsx";
		System.out.println(excellocation);
		UpdateSeleniumTestReportInExcelSheetJavaCode_1.updateResult(excellocation, "TestReport", "Login", "Pass");
		UpdateSeleniumTestReportInExcelSheetJavaCode_1.updateResult(excellocation, "TestReport", "Registration", "Pass");
		UpdateSeleniumTestReportInExcelSheetJavaCode_1.updateResult(excellocation, "TestReport", "Payment", "Pass");
		UpdateSeleniumTestReportInExcelSheetJavaCode_1.updateResult(excellocation, "TestReport", "Withdrall", "Pass");
	}

}
