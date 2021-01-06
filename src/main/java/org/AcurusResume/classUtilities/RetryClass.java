package org.AcurusResume.classUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryClass implements IRetryAnalyzer{
	int Failedcount=0;
	int Limit=3;
	
	public boolean retry(ITestResult retry) {

		if(Failedcount<Limit)
		{
			Failedcount++;
			return true;
		}
		return false;
	}

}
