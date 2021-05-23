package week6day1assignRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		dryRun= false,
		features= {"src/test/java/week6day1assignfeatures/leads.feature","src/test/java/week6day1assignfeatures/duplicateLead.feature"},
		glue= {"week6.day1.assign.Steps"},
		monochrome=	true
		)
public 	class LeadsRunners extends AbstractTestNGCucumberTests{
		}

