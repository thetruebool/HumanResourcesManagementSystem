package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingService {

	Result add(JobPosting jobPosting);
	
	DataResult<List<JobPosting>> getByTitle(String title);
	
	DataResult<List<JobPosting>> getAll();
	
	DataResult<List<JobPosting>> getAllSortedByStreamDate();
	DataResult<List<JobPosting>> getByEmployer_CompanyName(String companyName);
}
