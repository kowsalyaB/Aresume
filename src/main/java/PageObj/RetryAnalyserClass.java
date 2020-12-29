package PageObj;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyserClass implements IRetryAnalyzer{

	int initial=1;
	int totalcount=4; 
	@Override
	public boolean retry(ITestResult result) {
		if(initial<totalcount)
		{
			initial++;
			return true;
		}
		return false;
	}

}
